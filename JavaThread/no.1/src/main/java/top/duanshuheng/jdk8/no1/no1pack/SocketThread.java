package top.duanshuheng.jdk8.no1.no1pack;

import java.io.*;
import java.net.Socket;

public class SocketThread implements Runnable {

    Socket socket;
    public SocketThread(Socket socketTemp) {
        this.socket=socketTemp;
    }

    @Override
    public void run() {
        System.out.println("この："+socket.getPort()+"　行きます");
        try {
            BufferedReader bufferedReader=new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    )
            );

            String clientStr=null;
            clientStr=bufferedReader.readLine();
            System.out.println("わたしわ　ここで　送ります");
            BufferedWriter bw=new BufferedWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()
                    )
            );
            bw.write("わたしわ　届きました");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
