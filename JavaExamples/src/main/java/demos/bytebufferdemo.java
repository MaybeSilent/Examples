package demos;

import java.nio.ByteBuffer;

public class bytebufferdemo {
    private static ByteBuffer buffer;

    public static void main(String[] args) {
        /**
         * wrap test 
         * confirm warp connect byte array and buffer
         * output:
         * B
         * A
         */
        String str = "ByteBufferDemons";
        byte[] strByte = str.getBytes();

        buffer = ByteBuffer.wrap(strByte);
        System.out.println((char) buffer.get(0));
        strByte[0] = 'A';
        System.out.println((char) buffer.get(0));
    }
}