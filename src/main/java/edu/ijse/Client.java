package edu.ijse;

import java.io.DataInputStream;
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
            System.out.print("Message sent to server: ");
            String msg=scanner.nextLine();
            dataOutputStream.writeUTF(msg);//write unicode string
            dataOutputStream.flush();

            DataInputStream dataInputStream=new DataInputStream(remoteSocket.getInputStream());
            String reply=dataInputStream.readUTF();
            System.out.println("Reply from server: "+reply);
            remoteSocket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}