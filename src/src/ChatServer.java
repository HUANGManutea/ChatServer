package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.HashSet;

/**
 * Created by Manutea on 06/05/2016.
 */
public class ChatServer {
    static int port = 8888;  // port par défaut
    public ServerSocket socket;
    public static boolean stop;
    public static HashSet<PrintWriter> clients;

    public ChatServer() throws IOException{
        socket = null;
        // Création de la socket
        socket = new ServerSocket(port);
        clients = new HashSet<PrintWriter>();
        stop = false;
    }

    public static void out(String s){
        for(PrintWriter pw : clients){
            pw.println(s);
            pw.flush();
        }
    }
}

