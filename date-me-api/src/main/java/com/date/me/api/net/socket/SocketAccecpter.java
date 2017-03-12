package com.date.me.api.net.socket;

import com.date.me.api.constant.Constant;
import com.date.me.api.net.SocketLisenerApply;
import com.mysql.fabric.Server;
import jdk.net.Sockets;
import org.apache.log4j.Logger;
import org.apache.log4j.net.SocketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by shj on 17-3-9.
 */
public class SocketAccecpter extends Thread {
//    private Queue queue;
    private ServerSocket serverSocket;
    private SocketLisenerApply socketLisenerApply;

    public static Logger logger = Logger.getLogger(SocketAccecpter.class);

    public SocketAccecpter(){
//        this.queue = new LinkedBlockingQueue();

    }
    public void init(){
        try {
            this.serverSocket = new ServerSocket(Constant.PORT);
        }catch (Exception e){
//            e.printStackTrace();
            logger.error(e.getMessage());
        }

    }

    public void run() {
        while (true){
            try {
                Socket socket = serverSocket.accept();
                this.socketLisenerApply.apply(socket);
            }catch (Exception e){
//                e.printStackTrace();
                logger.error(e.getMessage());
            }

        }
    }


    public SocketLisenerApply getSocketLisenerApply() {
        return socketLisenerApply;
    }

    public void setSocketLisenerApply(SocketLisenerApply socketLisenerApply) {
        this.socketLisenerApply = socketLisenerApply;
    }

    public void test(){}

//    public Queue getQueue() {
//        return queue;
//    }
}
