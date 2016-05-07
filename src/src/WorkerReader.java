package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Manutea on 06/05/2016.
 */
public class WorkerReader implements Runnable{
    Socket s;
    BufferedReader b;

    public WorkerReader(Socket soc) throws IOException {
        s = soc;
        b = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        try{
        String line;
            while ((line = b.readLine())!=null){
                    String[] received = line.split(";");
                    if(received[1].equals("EOF")){
                        s.close();
                    }else{
                        System.out.println(received[0]+": "+received[1]);
                        ChatServer.out(line);
                    }
                }
            }
        catch(IOException e){
            System.out.println("socket closed");
        }
    }
}
