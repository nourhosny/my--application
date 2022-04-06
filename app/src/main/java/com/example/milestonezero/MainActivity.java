package com.example.milestonezero;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    Socket s ;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.editTextTextPersonName2);

    }

    public void Connect (View v) throws Exception
    {
        try
        {
            System.out.println("before policy");
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            System.out.println("beforr socket");
            s = new Socket("172.20.10.14", 12345);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.print("hey");
        }
    }

    public void send (View v) throws Exception
    {

        String message = et.getText().toString();
        try {

            System.out.println("after socket");  //does not execute
            DataOutputStream d= new DataOutputStream(s.getOutputStream());
            d.writeUTF(message);
            DataInputStream din= new DataInputStream(s.getInputStream());
            String nour=din.readUTF();
            Toast.makeText(this, nour, Toast.LENGTH_LONG).show();


        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.print("hey");
        }



    }
       /*

        /*
        Socket s;
        DataOutputStream dos;
        PrintWriter pw;
        DataInputStream din;
*/
       /* Messagesender messagesender = new Messagesender();

        messagesender.execute(et.getText().toString());
        System.out.print("hey");

        */
     /*
        try
        {
            StrictMode.ThreadPolicy Policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(Policy);
            s = new Socket("192.168.1.13", 7800);
            din = null;
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
        catch ( IOException e)
        {
            e.printStackTrace();
        }
        return null;

      */

    }

