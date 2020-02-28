/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // don't need to specify a hostname, it will be the current machine
        
        System.out.println("Servidor");
        ServerSocket ss = new ServerSocket(7777);
        System.out.println("ServerSocket awaiting connections...");
        Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
        System.out.println("Connection from " + socket + "!");

        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        // read the list of messages from the socket
        List<Profesor> listOfAlumnos = (List<Profesor>) objectInputStream.readObject();
        System.out.println("Se recibieron [" + listOfAlumnos.size() + "] profesores de: " + socket);
        // print out the text of every message
        System.out.println("Los profesores:");
        listOfAlumnos.forEach((msg)-> System.out.println(msg.getNombre()+" "+msg.getEdad()+" "+msg.getSalon()));
        
        //System.out.println(listOfAlumnos.toString());

        System.out.println("Closing sockets.");
        ss.close();
        socket.close();
    }
}