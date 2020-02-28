/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dell
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Conversor {
    

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Recibir informacion
        //------------------------------------------------------------------------------------
        // don't need to specify a hostname, it will be the current machine
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("ServerSocket awaiting connections...");
        Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
        System.out.println("Connection from " + socket + "!");

        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        // read the list of messages from the socket
        List<Alumno> listOfAlumnos = (List<Alumno>) objectInputStream.readObject();
        System.out.println("Se recibieron [" + listOfAlumnos.size() + "] alumnos de: " + socket);
        // print out the text of every message
        System.out.println("Los alumnos:");
        listOfAlumnos.forEach((msg) -> System.out.println(msg.getNombre() + " " + msg.getEdad() + " " + msg.getSalon()));

        //System.out.println(listOfAlumnos.toString());
        System.out.println("Closing sockets.");
        ss.close();
        socket.close();
        
        //inicio de conversion        
        //------------------------------------------------------------------------------------------------------------------------------
        
        
        
        List<Profesor> listOfProfesor = new ArrayList<>();
        
        listOfAlumnos.forEach((msg) -> listOfProfesor.add(new Profesor(msg.getNombre(), msg.getEdad(), msg.getSalon())));
        
        //inicio de mandado de datos
        //------------------------------------------------------------------------------------------------------------------------------
        
        Socket socket2 = new Socket("localhost", 7777);
        System.out.println("Connected!");
        

        // get the output stream from the socket.
        OutputStream outputStream = socket2.getOutputStream();
        // create an object output stream from the output stream so we can send an object through it
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        
        System.out.println("Sending messages to the ServerSocket");
        objectOutputStream.writeObject(listOfProfesor);

        System.out.println("Closing socket and terminating program.");
        socket.close();
        
    }
}

