package lab15.fin;

import java.io.*;
import java.net.Socket;

public class ChatClient {

    private final BufferedReader input;

    public ChatClient() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    private String getInput(String prompt) throws IOException {
        System.out.print(prompt + ": ");
        return input.readLine();
    }

    private Buffer readSocket(InputStream in) throws IOException {

        byte[] buffer = new byte[1024];
        int count = in.read(buffer);

        return new Buffer(buffer, count);
    }

    private void writeSocket(OutputStream out, String message) throws IOException {
        out.write(message.getBytes());
        out.flush();
    }

    public void run() throws IOException {
        String name = getInput("Enter name");
        String room = getInput("Room");
        try (Socket socket = new Socket("localhost", 8080)) {
            try (OutputStream out = socket.getOutputStream()) {
                try (InputStream in = socket.getInputStream()) {

                    // The chat server will ask for name and room. This will fetch that message but not print it.
                    // Ignore the input.
                    readSocket(in);

                    // Send the name and room message
                    writeSocket(out, name + " " + room);

                    while (true) {
                        Buffer buffer = readSocket(in);

                        if (buffer.getBufferSize() < 0) {
                            break;
                        }

                        System.out.write(buffer.getBuffer(), 0, buffer.getBufferSize());

                        String input = getInput("[" + name + "@" + room + "]");

                        writeSocket(out, input);

                        if (input.equalsIgnoreCase("bye")) {
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        new ChatClient().run();
    }

    private static class Buffer {
        private final byte[] buffer;
        private final int bufferSize;

        public Buffer(byte[] buffer, int bufferSize) {
            this.buffer = buffer;
            this.bufferSize = bufferSize;
        }

        public byte[] getBuffer() {
            return buffer;
        }

        public int getBufferSize() {
            return bufferSize;
        }
    }
}
