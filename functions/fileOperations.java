<<<<<<< HEAD
//package org.firstinspires.ftc.teamcode.functions;
//
//import android.content.Context;
//import android.os.Environment;
//import android.util.Log;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.telephony.TelephonyManager;
//import android.view.Menu;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//import java.io.OutputStreamWriter;
//import java.nio.charset.StandardCharsets;
//
//public class fileOperations
//{
//
//
//    public void writeToFile(String fileName, String content)
//    {
////         File path = getApplicationContext().getFilesDir;
//        File path = new File("milsugi", fileName);
//        try {
//            FileOutputStream writer = new FileOutputStream(new File (path, fileName));
//            writer.write(content.getBytes());
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//
////    public void writeToFile(String data, Context context) {
////        try {
////            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
////            outputStreamWriter.write(data);
////            outputStreamWriter.close();
////        }
////        catch (IOException e) {
////            Log.e("Exception", "File write failed: " + e.toString());
////        }
////    }
////
////    public String readFromFile(Context context) {
////
////        String ret = "";
////
////        try {
////            InputStream inputStream = context.openFileInput("config.txt");
////
////            if ( inputStream != null ) {
////                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
////                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
////                String receiveString = "";
////                StringBuilder stringBuilder = new StringBuilder();
////
////                while ( (receiveString = bufferedReader.readLine()) != null ) {
////                    stringBuilder.append("\n").append(receiveString);
////                }
////
////                inputStream.close();
////                ret = stringBuilder.toString();
////            }
////        }
////        catch (FileNotFoundException e) {
////            Log.e("login activity", "File not found: " + e.toString());
////        } catch (IOException e) {
////            Log.e("login activity", "Can not read file: " + e.toString());
////        }
////
////        return ret;
////    }
//}
=======
package org.firstinspires.ftc.teamcode.functions;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class fileOperations
{
    public static void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public static String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}
>>>>>>> 6d0feaf3f19ae484dec606f59165e10df80425a8
