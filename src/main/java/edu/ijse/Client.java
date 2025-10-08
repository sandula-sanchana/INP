package edu.ijse;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Client {
    public static void main(String[] args) {
        try {
            Socket remoteSocket=new Socket("localhost",2003);//ip,port
            System.out.println("Client started");
            DataOutputStream dataOutputStream=new DataOutputStream(remoteSocket.getOutputStream());
            Scanner scanner=new Scanner(System.in);
            String msg=scanner.nextLine();
            dataOutputStream.writeUTF("type ur msg: "+msg);//write unicode string
            dataOutputStream.flush();//save data in the stream
            remoteSocket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}