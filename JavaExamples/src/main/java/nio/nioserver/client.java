package nio.nioserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream, true);
        out.println("这是client向server发送的消息");
        out.flush();
        socket.shutdownOutput();
        Scanner in = new Scanner(inputStream);
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
            sb.append(line);
        }
        String response = sb.toString();
        System.out.println("已接收到来自server的回复消息：" + response);

        socket.close();
        in.close();
    }
}