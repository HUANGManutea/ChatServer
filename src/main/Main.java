package main;

import src.ChatServer;
import src.WorkerReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Manutea on 07/05/2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            ChatServer cs = new ChatServer();
            while( true ) { // Attente de connexion
                Socket s = null;
                s=cs.socket.accept();

                PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                ChatServer.clients.add(pw);

                WorkerReader wr = new WorkerReader(s);
                Thread th = new Thread(wr);
                th.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
