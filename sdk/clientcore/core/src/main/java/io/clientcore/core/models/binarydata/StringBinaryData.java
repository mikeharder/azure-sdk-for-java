// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.clientcore.core.models.binarydata;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonWriter;
import io.clientcore.core.serialization.ObjectSerializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * A {@link BinaryData} implementation backed by a String.
 */
@Metadata(properties = MetadataProperties.IMMUTABLE)
public final class StringBinaryData extends BinaryData {
    private final String content;

    private volatile byte[] bytes;
    private static final AtomicReferenceFieldUpdater<StringBinaryData, byte[]> BYTES_UPDATER
        = AtomicReferenceFieldUpdater.newUpdater(StringBinaryData.class, byte[].class, "bytes");

    /**
     * Creates a new instance of {@link StringBinaryData}.
     *
     * @param content The string content.
     * @throws NullPointerException if {@code content} is null.
     */
    public StringBinaryData(String content) {
        this.content = Objects.requireNonNull(content, "'content' cannot be null.");
    }

    @Override
    public Long getLength() {
        return (long) toBytes().length;
    }

    @Override
    public String toString() {
        return this.content;
    }

    @Override
    public byte[] toBytes() {
        return BYTES_UPDATER.updateAndGet(this, bytes -> bytes == null ? getBytes() : bytes);
    }

    @Override
    public <T> T toObject(Type type, ObjectSerializer serializer) throws IOException {
        return serializer.deserializeFromBytes(toBytes(), type);
    }

    @Override
    public InputStream toStream() {
        return new ByteArrayInputStream(toBytes());
    }

    @Override
    public ByteBuffer toByteBuffer() {
        return ByteBuffer.wrap(toBytes()).asReadOnlyBuffer();
    }

    @Override
    public void writeTo(JsonWriter jsonWriter) throws IOException {
        Objects.requireNonNull(jsonWriter, "'jsonWriter' cannot be null");

        jsonWriter.writeString(toString());
    }

    @Override
    public boolean isReplayable() {
        return true;
    }

    @Override
    public BinaryData toReplayableBinaryData() {
        return this;
    }

    private byte[] getBytes() {
        return this.content.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public void close() throws IOException {
        // no-op
    }
}
