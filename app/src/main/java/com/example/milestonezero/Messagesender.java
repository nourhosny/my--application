package com.example.milestonezero;

import android.os.AsyncTask;
import android.os.StrictMode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class Messagesender extends AsyncTask<String, Void, Void> {

    Socket s;
    DataOutputStream dos;
    PrintWriter pw;
    DataInputStream din;

    @Override
    protected Void doInBackground(String... voids) {
        /*
            try
            {
                s = new Socket("192.168.1.13", 7800);
                DataInputStream din= null;
                din = new DataInputStream(s.getInputStream());
                DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

                String str="",str2="";
                while(!str.equals("close"))
                {
                    str=br.readLine();
                    dout.writeUTF(str);
                    dout.flush();
                    str2=din.readUTF();
                    System.out.println("Server says: "+str2);
                }

                dout.close();
                s.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return null;
        }
*/

        String messasge = voids[0];
        try {
            StrictMode.ThreadPolicy Policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(Policy);
            s = new Socket("172.20.10.2", 7810);
            pw = new PrintWriter(s.getOutputStream());
            pw.write(messasge);
            pw.flush();
            pw.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("hey");
        }
        return null;


    }
}
