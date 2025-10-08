package edu.ijse;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

            try {
                ServerSocket serverSocket = new ServerSocket(2003);
                System.out.println("Server started and listening on port 2003");
                Socket localSocket=serverSocket.accept();
                System.out.println("Client connected");
                DataInputStream dataInputStream=new DataInputStream(localSocket.getInputStream());
                String msg=dataInputStream.readUTF();//read unicode string
                System.out.println("Message from client: "+msg);
                localSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


}
