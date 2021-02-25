package util;

import lombok.SneakyThrows;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public final class StringUtils {

    private StringUtils() {
    }

    @SneakyThrows
    public static byte[] stringBuilderToBytes(final StringBuilder sb) {
        Charset charset = StandardCharsets.US_ASCII;
        CharsetEncoder encoder = charset.newEncoder();
        CharBuffer buffer = CharBuffer.wrap(sb);
        ByteBuffer byteBuffer = encoder.encode(buffer);

        byte[] array;
        int arrayLen = byteBuffer.limit();
        if (arrayLen == byteBuffer.capacity()) {
            array = byteBuffer.array();
        } else {
            // This will place two copies of the byte sequence in memory,
            // until byteBuffer gets garbage-collected (which should happen
            // pretty quickly once the reference to it is null'd).

            array = new byte[arrayLen];
            byteBuffer.get(array);
        }
        return array;
    }
}
