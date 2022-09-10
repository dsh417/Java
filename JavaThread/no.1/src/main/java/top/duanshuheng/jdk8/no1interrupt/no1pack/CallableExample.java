package top.duanshuheng.jdk8.no1interrupt.no1pack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;

public class CallableExample implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "その、終われでした：SUCCESS";
    }

    public static void main(String[] args) throws IOException {
        final int DEFAULT_PORT=8080;
        ServerSocket socket=null;
        socket=new ServerSocket(DEFAULT_PORT);
        System.out.println("Threadで　始まりました、この　Port："+DEFAULT_PORT);
        while(true){
            Socket socketTemp=socket.accept();
            new Thread(new SocketThread(socketTemp)).start();
        }
    }
}
