# Core shared library for Java

Client Core provides shared primitives, abstractions, and helpers for modern SDK client libraries. These libraries
can be easily identified by package names starting with `io.clientcore`, e.g. `io.clientcore.core` would be found within
the `/sdk/clientcore/core` directory.

Client Core allows client libraries to expose common functionality consistently, so that once you learn how to use these
APIs in one client library, you will know how to use them in other client libraries.

## Getting started

### Prerequisites

- A Java Development Kit (JDK), version 17 or later.

### Include the package

#### Include direct dependency

If you want to take dependency on a particular version of the library that is not present in the BOM,
add the direct dependency to your project as follows.

[//]: # ({x-version-update-start;io.clientcore:core;current})
```xml
<dependency>
    <groupId>io.clientcore</groupId>
    <artifactId>core</artifactId>
    <version>1.0.0-beta.11</version>
</dependency>
```
[//]: # ({x-version-update-end})

## Key concepts

The key concepts of Core (and therefore all client libraries using Core) include:

- Configuring service clients, e.g. configuring retries, logging, etc. (`HttpTrait<T>`, `ConfigurationTrait<T>`, etc.)
- Accessing HTTP response details (`Response<T>`).
- Exceptions for reporting errors from service requests consistently.
- Abstractions for representing SDK credentials.
- Operation timeouts
- JSON and XML serialization

These will be introduced by way of the examples presented below.

### JsonSerializable

`JsonSerializable` is used to define how an object is JSON serialized and deserialized using stream-style serialization
where the object itself manages the logic for how it's handled. The interface provides an instance-based `toJson` API
that handles writing the object to a `JsonWriter` and a static `fromJson` API which implementations must provide to
define how to create an object by reading from a `JsonReader`, if an implementation isn't provided
`UnsupportedOperationException` will be thrown.

### JsonToken

`JsonToken` is a basic enum that indicates the current state in a JSON stream.

### JsonReader

`JsonReader` provides both basic, reading primitive and boxed primitive types, and convenience, reading arrays, maps,
and objects, APIs for reading JSON. `JsonReader` is provided to allow for any underlying JSON parser to implement it,
such as Jackson or GSON, as long as the implementation passes the tests provided by this package's test-jar
(`JsonReaderContractTests`).

`JsonReader` doesn't progress forward in the JSON stream until `nextToken` is called, meaning that `JsonReader.getInt`
could be called indefinitely returning the same integer without error until `nextToken` progresses the JSON stream
forward.

`JsonReader` allows for type conversion between JSON types, such as trying to convert a JSON string to a number or vice
versa, and for commonly used nonstandard JSON values, such as `NaN`, `Infinity`, `+Infinity`, and `-Infinity`.

`JsonReader` doesn't take ownership of the JSON input source and therefore doesn't close any resources if the JSON is
provided using an `InputStream` or `Reader`.

#### Nesting Limits

`JsonReader`'s generic `readUntyped` API tracks how deeply nested the object being read is. If the nesting passes the
threshold of `1000`, `IllegalStateException` is thrown to prevent `StackOverflowError`.

### JsonWriter

`JsonWriter` provides both basic, writing primitives and boxed primitive types, and convenience, writing arrays, maps,
and objects, APIs for writing JSON. `JsonWriter` is provided to allow for any underlying JSON writer to implement it,
such as Jackson or GSON, as long as the implementation passes the tests provided by the package's test-jar
(`JsonWriterContractTests`).

`JsonWriter` allows for commonly used nonstandard JSON values, such as `NaN`, `Infinity`, `+Infinity`, and
`-Infinity`, to be written using `writeNumberField` or `writeRawValue`.

`JsonWriter` doesn't write null `byte[]`, `Boolean`, `Number`, or `String` values when written as a field,
`writeBinaryField`, `writeBooleanField`, `writeNumberField`, or `writeStringField`, if a null field needs to be written
use `writeNullField`.

`JsonWriter` must be periodically flushed to ensure content written to it's flushed to the underlying container type,
generally an `OutputStream` or `Writer`. Failing to flush may result in content being lost. Closing the `JsonWriter`
flushes content, so it's best practice to use `JsonWriter` in a try-with-resources block where the `JsonWriter` is
closed once it's finished being used.

`JsonWriter` doesn't take ownership of the JSON output source and therefore doesn't close any resources if the JSON is
being written to an `OutputSteam` or `Writer`.

#### JSON State Management

To ensure that the JSON being written is valid, `JsonWriter` maintains the state of the JSON using `JsonWriteContext`
and on each attempt to write it validates whether the operation is valid. The implementation of `JsonWriter` must
ensure state is tracked correctly, for example when nothing has been written the JSON state must be `ROOT` and `ROOT`
doesn't allow for JSON field names to be written.

### JsonProvider

`JsonProvider` is a service provider interface that allows for `JsonReader`s and `JsonWriter`s to be created using
implementations found on the classpath. `JsonProvider` can also create the default implementations that are provided
by this package if an implementation isn't found on the classpath.

#### JsonOptions

`JsonOptions` contains configurations that must be respected by all implementations of `JsonReader`s and `JsonWriter`s.
At this time, there's only one configuration for determining whether non-numeric numbers, `NaN`, `Infinity`, `+Infinity`,
and `-Infinity` are supported in JSON reading and writing with a default setting of `true`, that non-numeric numbers
are allowed.

### Providing an SPI implementation

`JsonReader` and `JsonWriter` are service provider interfaces used by `JsonProvider` and `JsonProviders` to enable
implementations to be loaded from the class path. The Core package provides a default implementation that is used if one
can't be found on the class path. To provide a custom implementation, implement `JsonReader`, `JsonWriter`, and
`JsonProvider` in your own package and indicate that the package provides an instance of `JsonProvider`. To ensure that
your implementations are correct, include the `test` scoped dependency of Core and extend the`JsonReaderContractTests`,
`JsonWriterContractTests`, and `JsonProviderContractTests`. These tests outline all basic contract requirements set
forth by `JsonReader`, `JsonWriter`, and `JsonProvider` and testing a few complex scenarios to provide validation of any
implementation.

## Examples

### Accessing HTTP Response Details Using `Response<T>`

_Service clients_ have methods that call Core services, we refer call these methods _service methods_.

_Service methods_ can return a shared Core type `Response<T>`. This type provides access to both the deserialized result
of the service call and to the details of the HTTP response returned from the server.

### HTTP pipelines with `HttpPipeline`

`HttpPipeline` is a construct that contains a list of `HttpPipelinePolicy` which are applied to a request
sequentially to prepare it being sent by an `HttpClient`.

### Configuring Builders

Builders are used to create service clients and some `TokenCredential` implementations. They can be configured with a 
variety of options, including `HttpPipeline` and `HttpClient` for HTTP-based clients and more general options such as 
`Configuration` and`endpoint`. To allow for simpler integration into frameworks such as Spring and to allow generic 
methods to be used for all builders `core` provides a set of interfaces that can be implemented to provide
the necessary functionality.

#### HttpTrait<T>

`HttpTrait<T>` contains methods for setting key configurations for HTTP-based clients. This interface will allow you to
configure the `HttpClient`, `HttpPipeline`, `HttpPipelinePolicy`s, `RetryOptions`, and `HttpLogOptions`.

For builders that expose `HttpTrait<T>`, if an `HttpPipeline` or `HttpClient` isn't set a default instance will be 
created based on classpath configurations. This can cause confusion if 
you're expecting specific behavior for your client, such as using a proxy that wasn't loaded from the environment. To 
avoid this, it is recommended to always set the `HttpPipeline` or `HttpClient` in all clients if you're building if your 
configurations aren't based on the environment running the application.

#### Credential Traits

Core provides different credentials for authenticating with services. Each credential type has a corresponding trait
that can be implemented to provide the credential to the client builder. The following table lists the credential traits
and the corresponding credential type.

| Credential Trait             | Credential Type                                      |
|------------------------------|------------------------------------------------------|
| `KeyCredentialTrait`         | `KeyCredential`                                      |

#### ConfigurationTrait<T>

`ConfigurationTrait<T>` allows for setting `Configuration` on service clients. `Configuration` can be used to pass a set
of runtime behaviors to the client builder such as how `ProxyOptions` are loaded from the environment, implicitly
passing credentials to some client builders that support it, and more.

#### EndpointTrait<T>

`EndpointTrait<T>` allows for setting the service endpoint on service clients.

### Operation Timeouts

Core SDKs provide a few, consistent ways to configure timeouts on API calls. Each timeout effects a different scope
of the Core SDKs and calling application.

#### HttpPipeline Timeouts

HttpPipeline timeouts are the next level of timeout handling Client Core provides. These timeouts are configured using
an `HttpPipelinePolicy` and configuring an `ExecutorService` with a timed `get(long, TimeUnit)`.

Depending on the location within the `HttpPipeline`, these timeouts may be captured by the `RetryPolicy` and retried.
If the timeout policy is `PER_RETRY` (`HttpPipelinePolicy.getPipelinePosition()`) the timeout will be captured by the
`RetryPolicy` as it will be positioned after the `RetryPolicy`, therefore in its capture scope, if it is `PER_CALL`
retrying the request will need to be handled by application logic.

## Troubleshooting

If you encounter any bugs, please file issues
via [GitHub Issues](https://github.com/Azure/azure-sdk-for-java/issues/new/choose)
or checkout [StackOverflow for Azure Java SDK](https://stackoverflow.com/questions/tagged/azure-java-sdk).

### Enabling Logging

Client Core provides a consistent logging story to help aid in troubleshooting application errors and expedite
their resolution. The logs produced will capture the flow of an application before reaching the terminal state to help
locate the root issue.

#### HTTP Request and Response Logging

HTTP request and response logging can be enabled by setting `HttpLogDetailLevel` in the `HttpLogOptions` used to create
an HTTP-based service client or by setting the environment variable or system property `HTTP_LOG_DETAIL_LEVEL`.
The following table displays the valid options for `HTTP_LOG_DETAIL_LEVEL` and the `HttpLogDetailLevel` it
correlates to (valid options are case-insensitive):

| `HTTP_LOG_DETAIL_LEVEL` value | `HttpLogDetailLevel` enum             |
|-------------------------------|---------------------------------------|
| `basic`                       | `HttpLogDetailLevel.BASIC`            |
| `headers`                     | `HttpLogDetailLevel.HEADERS`          |
| `body`                        | `HttpLogDetailLevel.BODY`             |
| `body_and_headers`            | `HttpLogDetailLevel.BODY_AND_HEADERS` |
| `bodyandheaders`              | `HttpLogDetailLevel.BODY_AND_HEADERS` |

All other values, or unsupported values, result in `HttpLogDetailLevel.NONE`, or disabled HTTP request and response
logging. Logging [must be enabled](#enabling-logging) to log HTTP requests and responses. Logging of HTTP headers
requires `verbose`
logging to be enabled. The following table explains what logging is enabled for each `HttpLogDetailLevel`:

| `HttpLogDetailLevel` value            | Logging enabled                                                                                  |
|---------------------------------------|--------------------------------------------------------------------------------------------------|
| `HttpLogDetailLevel.NONE`             | No HTTP request or response logging                                                              |
| `HttpLogDetailLevel.BASIC`            | HTTP request method, response status code, and request and response URI                          |
| `HttpLogDetailLevel.HEADERS`          | All of `HttpLogDetailLevel.BASIC` and request and response headers if the log level is `verbose` |
| `HttpLogDetailLevel.BODY`             | All of `HttpLogDetailLevel.BASIC` and request and response body if it's under 10KB in size       |
| `HttpLogDetailLevel.BODY_AND_HEADERS` | All of `HttpLogDetailLevel.HEADERS` and `HttpLogDetailLevel.BODY`                                |

## Contributing

For details on contributing to this repository, see
the [contributing guide](https://github.com/Azure/azure-sdk-for-java/blob/main/CONTRIBUTING.md).

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request
