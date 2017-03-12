package com.date.me.api.api;

import junit.framework.TestCase;

import java.io.*;
import java.net.Socket;

/**
 * Created by shj on 17-3-12.
 */
public class apiTestCase extends TestCase {
    public void testApi(){
        try {
            Socket socket = new Socket("127.0.0.1",9999);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String str = null;
//            bufferedWriter.write("{\"pid\":0,\"pwd\":\"123456\",\"username\":\"shj\"}");
            bufferedWriter.write("{\"pid\":1}");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            while ((str=bufferedReader.readLine())!=null){
                System.out.println(str);
            }
                System.out.println(bufferedReader.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }




    }

}
