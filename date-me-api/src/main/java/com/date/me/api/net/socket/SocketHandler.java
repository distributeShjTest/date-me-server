package com.date.me.api.net.socket;

import com.date.me.api.common.ObjectUtil;
import com.date.me.api.constant.Constant;
import com.date.me.api.net.SocketCallback;
import com.date.me.api.net.SocketLisenerApply;
import com.date.me.api.net.SocketRequestHandler;
import com.date.me.api.net.UserMsgSent;
import com.date.me.api.protocol.ProtocolPack;
import com.date.me.api.service.MsgRecieveFromNet;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created by shj on 17-3-9.
 */
public class SocketHandler implements SocketCallback, SocketLisenerApply, SocketRequestHandler, UserMsgSent {
    //    private Queue<SocketLisner> socketLisnerPool;
    private MsgRecieveFromNet msgRecieveFromNet;
    private Integer mapId;
    private HashMap<Integer, SocketLisner> nullIdSockeMap;
    private HashMap<Integer, SocketLisner> socketLisnerMap;
    private SocketAccecpter socketAccecpter;
    private ProtocolPack protocolPack;
    Logger logger = Logger.getLogger(this.getClass());

    public SocketHandler() {


    }


    public void init() {
        this.socketLisnerMap = new HashMap<Integer, SocketLisner>();
        this.nullIdSockeMap = new HashMap();
        this.mapId = 0;
    }

    public void start() {
        this.socketAccecpter.start();
    }


    public void callBack(SocketLisner socketLisner) {
        SocketLisner socketRemove;
        if (socketLisner.isNullId()) {
            socketRemove = this.nullIdSockeMap.get(socketLisner.getUserid());
            if (ObjectUtil.isEmpty(socketRemove)) {
                this.logger.error("remove socketLisner failed," + "LisnerId is " + socketLisner.getUserid());
                this.logger.error(this.nullIdSockeMap.toString());
                return;
            }
            synchronized (this.nullIdSockeMap) {
                socketRemove = this.nullIdSockeMap.get(socketLisner.getUserid());
                if (ObjectUtil.isEmpty(socketRemove)){
                    this.nullIdSockeMap.remove(socketLisner.getUserid());
                    this.threadInterrupt(socketRemove);
                }
            }
        } else {
            if (((socketRemove = this.socketLisnerMap.get(socketLisner.getUserid())) == null)) {
                this.logger.error("remove socketLisner from socketListenerMap failed," + "LisnerId is " + socketLisner.getUserid());
                this.logger.error(this.socketLisnerMap.toString());
            } else if (!socketRemove.equals(socketLisner)) {
                this.logger.error("remove socketLisner error," + "LisnerRequestId is " + socketLisner.getUserid() + ", and SocketRemoveId is " + socketRemove.getUserid());

            } else {
                synchronized (this.socketLisnerMap) {
                    socketRemove=this.socketLisnerMap.get(socketLisner.getUserid());
                    if(ObjectUtil.isEmpty(socketRemove)){
                        this.socketLisnerMap.remove(socketLisner.getUserid());
                        this.threadInterrupt(socketLisner);
                    }

                }
            }
        }

    }


    private void threadInterrupt(SocketLisner socketLisner){
        try {
            socketLisner.interrupt();
        }catch (Exception e){
            logger.equals(e.getMessage());
        }
    }


    public void apply(Socket socket) {
        try {
            this.addNullIdList(socket);
            this.socketWrite(socket, this.protocolPack.connectionSuccess());
        } catch (Exception e){
            try {
                socket.close();
            }catch (Exception e1){
                logger.error(e.getMessage());
            }
            logger.error(e.getMessage());
        }

    }

    private synchronized void addNullIdList(Socket s) throws Exception {
        Integer id = (++this.mapId)%Constant.SOKCET_NULL_ID_MAX_NUM;
        SocketLisner socketLisner = new SocketLisner(this);
        socketLisner.setUserid(id);
        socketLisner.socketInit(s);
        socketLisner.start();
        this.nullIdSockeMap.put(id, socketLisner);
        return;
    }

    private String registerMsgGet(Socket socket) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return bufferedReader.readLine();
    }

    private void socketWrite(Socket socket) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(this.protocolPack.loginError());
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    private void socketWrite(Socket socket, String str) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(str);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public void msgCallBack(String str, int id,boolean isNullId) {
        try {
            System.out.println(str+" "+id+" "+isNullId);
            this.msgRecieveFromNet.recieve(str, id,isNullId);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    public boolean nullIdSentBack(Integer id, String str) {
        if (ObjectUtil.isEmpty(this.nullIdSockeMap.get(id)))
            return false;
        try {
            this.nullIdSockeMap.get(id).writeStr(str);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public synchronized void socketThreadHandler(Integer formerId, Integer realId) {
        try {
            SocketLisner socketLisner = this.nullIdSockeMap.get(formerId);
            if (ObjectUtil.isEmpty(socketLisner)){
                this.logger.error("remove socketLisner from socketListenerMap failed," + "LisnerId is " + socketLisner.getUserid());
                this.logger.error(this.socketLisnerMap.toString());
                return;
            }
            if (this.socketLisnerMap.size() > Constant.SOCKET_LISENER_COUNT) {
                socketLisner.writeStr(this.protocolPack.loginError());
                socketLisner.socketClear();
                return;
            }
            SocketLisner socketLisnerFormer = this.socketLisnerMap.get(realId);
            if (!ObjectUtil.isEmpty(socketLisnerFormer)) {
                socketLisnerFormer.socketClear();
            }
            socketLisner.setUserid(realId);

            this.socketLisnerMap.put(realId, socketLisner);
            this.nullIdSockeMap.remove(formerId);
            socketLisner.idStateChange();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


    }

    public boolean sentBack(Integer userId, String str,boolean isNullId) {
        try {
            SocketLisner socketLisner = null;
            if (isNullId) {
                socketLisner = this.nullIdSockeMap.get(userId);
                if (!ObjectUtil.isEmpty(socketLisner)) {
                    socketLisner.writeStr(str);
                    return true;
                }
                logger.error("socketLisner nullId missing,missing id is " + userId);
                logger.error(this.nullIdSockeMap.toString());
                return false;
            }else {
                socketLisner = this.socketLisnerMap.get(userId);
                if(!ObjectUtil.isEmpty(socketLisner)){
                    socketLisner.writeStr(str);
                    return true;
                }
                logger.error("socketLisner missing,missing id is " + userId);
                logger.error(this.nullIdSockeMap.toString());
                return false;
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public ProtocolPack getProtocolPack() {
        return protocolPack;
    }

    public void setProtocolPack(ProtocolPack protocolPack) {
        this.protocolPack = protocolPack;
    }

    public MsgRecieveFromNet getMsgRecieveFromNet() {
        return msgRecieveFromNet;
    }

    public void setMsgRecieveFromNet(MsgRecieveFromNet msgRecieveFromNet) {
        this.msgRecieveFromNet = msgRecieveFromNet;
    }

    public SocketAccecpter getSocketAccecpter() {
        return socketAccecpter;
    }

    public void setSocketAccecpter(SocketAccecpter socketAccecpter) {
        this.socketAccecpter = socketAccecpter;
    }
}
