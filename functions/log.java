//package org.firstinspires.ftc.teamcode.functions;
//
//import android.os.Environment;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//
///**
// * Created by Gabriel on 2018-01-03.
// * A simple way to log data to a file.
// */
//
///*
// * This was straight up copy-pasted from the HOMAR FTC Library (https://github.com/StPaulAcademy/HOMAR-FTC-Library)
// * (so sorry guys I really needed it)
// * Link to original: https://github.com/StPaulAcademy/HOMAR-FTC-Library/blob/master/src/main/java/edu/spa/ftclib/internal/Log.java
// */
//
//public class log {
//    private static final String BASE_FOLDER_NAME = "FIRST";
//    private Writer fileWriter;
//    private String line;
//    private boolean logTime;
//    private long startTime;
//    private boolean disabled = false;
//    log(String filename, boolean logTime) {
//        if (logTime) startTime = System.nanoTime();
//        this.logTime = logTime;
//        String directoryPath = Environment.getExternalStorageDirectory().getPath()+"/"+BASE_FOLDER_NAME;
//        File directory = new File(directoryPath);
//        //noinspection ResultOfMethodCallIgnored
//        directory.mkdir();
//        try {
//            fileWriter = new FileWriter(directoryPath+"/"+filename+".csv");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public boolean isDisabled() {
//        return disabled;
//    }
//
//    public void setDisabled(boolean disabled) {
//        this.disabled = disabled;
//    }
//
//    public void close() {
//        try {
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void update() {
//        if (disabled) return;
//        try {
//            if (logTime) {
//                long timeDifference = System.nanoTime()-startTime;
//                line = timeDifference/1E9+","+line;
//            }
//            fileWriter.write(line+"\n");
//            line = "";
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void addData(String data) {
//        if (disabled) return;
//        if (!line.equals("")) line += ",";
//        line += data;
//    }
//    public void addData(Object data) {
//        addData(data.toString());
//    }
//    public void addData(boolean data) {
//        addData(String.valueOf(data));
//    }
//    public void addData(byte data) {
//        addData(String.valueOf(data));
//    }
//    public void addData(char data) {
//        addData(String.valueOf(data));
//    }
//    public void addData(short data) {
//        addData(String.valueOf(data));
//    }
//    public void addData(int data) {
//        addData(String.valueOf(data));
//    }
//    public void addData(long data) {
//        addData(String.valueOf(data));
//    }
//    public void addData(float data) {
//        addData(String.valueOf(data));
//    }
//    public void addData(double data) {
//        addData(String.valueOf(data));
//    }
//}