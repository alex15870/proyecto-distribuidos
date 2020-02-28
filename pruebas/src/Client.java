
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import socket.server.Message;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) throws IOException {
        // need host and port, we want to connect to the ServerSocket at port 7777
        System.out.println("Cliente");
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected!");
        
        Alumno alum1 = new Alumno(21,"Miguel","322");

        // get the output stream from the socket.
        OutputStream outputStream = socket.getOutputStream();
        // create an object output stream from the output stream so we can send an object through it
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);


        List<Alumno> alumosL = new ArrayList<>();
        alumosL.add(alum1);
        alumosL.add(new Alumno(22, "Cecilia", "1313"));
        
        
        System.out.println("Sending messages to the ServerSocket");
        objectOutputStream.writeObject(alumosL);

        System.out.println("Closing socket and terminating program.");
        socket.close();
    }
}