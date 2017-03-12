package com.date.me.api.net.socket;

import com.date.me.api.constant.Constant;
import com.date.me.api.net.SocketCallback;

import java.io.*;
import java.net.Socket;

/**
 * Created by shj on 17-3-9.
 */
public class SocketLisner extends Thread{
    private Integer userid;
    private SocketCallback socketCallback;
    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private boolean flag;
    private int nullReadCount = 0;
    private boolean isNullId;

    public void socketInit(Socket socket)throws Exception{
        if(socket==null) throw new NullPointerException();
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.flag=true;
        this.isNullId = true;
    }

    public SocketLisner(SocketCallback socketCallback) {
        this.socketCallback = socketCallback;
    }

    public void run() {
//        System.out.println("socket_start");
        while (flag){
            try {
                String msg = this.bufferedReader.readLine();
//                System.out.println(msg);
                if(msg==null){
                    if(nullReadCount++> Constant.MAX_WAIT_COUNT){
                        this.socketClear();

                        break;
                    }
                }else {
//                    System.out.println("msg_callBack");
                    nullReadCount=0;
                    this.socketCallback.msgCallBack(msg,this.userid,this.isNullId);
                }
            }catch (Exception e){
//                e.printStackTrace();
        }


        }
    }
    public void socketClear(){
        try {
            this.flag=false;
//            this.bufferedReader.close();
//            this.bufferedWriter.close();
            this.socket.close();
        }catch (Exception e){

        }finally {
            this.bufferedReader=null;
            this.bufferedWriter=null;
            this.socket = null;
//            System.out.println("userId"+this.getUserid());
            this.socketCallback.callBack(this);
        }

    }

    public void writeStr (String str)throws IOException{
        this.bufferedWriter.write(str);
        this.bufferedWriter.newLine();
        this.bufferedWriter.flush();

    }



    public boolean isNullId() {
        return isNullId;
    }

    public void idStateChange(){
        if(this.isNullId){
            this.isNullId = false;
        }
    }




    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Socket getSocket() {
        return socket;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}
