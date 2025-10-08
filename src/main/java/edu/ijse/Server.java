package edu.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
                Scanner scanner=new Scanner(System.in);
                System.out.print("Type your reply: ");
                String reply=scanner.nextLine();
                System.out.println("Reply sent to client: "+reply);
                DataOutputStream dataOutputStream=new DataOutputStream(localSocket.getOutputStream());
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
                localSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


}
