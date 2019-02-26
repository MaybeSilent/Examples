package nio.nioserver;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class server {

    public static void main(String[] args) throws Exception {
        //创建一个Selector实例（选择器）
        Selector selector = Selector.open();
        //创建一个在监听指定端口的Socket信道
        ServerSocketChannel listenChannel = ServerSocketChannel.open();
        //配置为异步模式
        listenChannel.configureBlocking(false);
        //把channel绑定到指定的TCP端口上，因为ServerSocketChannel没有直接提供bind()方法，所以需要借助其内部的socket对象。
        listenChannel.socket().bind(new InetSocketAddress(8888));
        //把serverChannel注册到最开始创建的选择器上面
        listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // 进入服务器循环，调用Selector.select()方法等待I/O事件
            if (selector.select(2000) == 0) {
                System.out.println("waiting for connect ...");
                continue;
            }
            // 当有新的I/O事件时，创建迭代器获取已选键集
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();

            // 遍历已选键集中的每个键进行处理
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                // SelectionKey.isAcceptable()方法用于测试键对应的channel是否准备好接受新的socket连接
                if (key.isAcceptable()) {
                    //当准备接受新的socket连接之后，就把这个channel注册到选择器上面
                    SocketChannel channel = listenChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ,
                            ByteBuffer.allocate(1024));
                }

                // SelectionKey.isReadable()方法用于测试键对应的channel是否可以进行 读 操作
                if (key.isReadable()) {
                    // 获得信道连接
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    // 重置buffer准备读取
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    buffer.clear();
                    long bytesRead = clientChannel.read(buffer);
                    if (bytesRead == -1) {
                        // 没有读取到内容，则channel关闭
                        clientChannel.close();
                    } else {
                        // 已读取到内容，则将缓冲区转换为传出状态
                        buffer.flip();
                        String receivedString = Charset.forName("UTF-8").newDecoder().decode(buffer).toString();
                        // 在控制台输出接受到的信息
                        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
                        System.out.println(currentTime+"接收到信息:" + receivedString);
                        // 返回给client的信息
                        String sendString = currentTime+ "已接收到来自client所发送的信息：" ;
                        buffer = ByteBuffer.wrap(sendString.getBytes("UTF-8"));
                        System.out.println("开始输出buffer");
                        clientChannel.write(buffer);
                        System.out.println("结束输出buffer");
                        //System.out.println(clientChannel.isBlocking());
                        // 处理完成，准备下一次的处理
                        key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    }
                }
                
                iter.remove();
            }
        }
    }
}