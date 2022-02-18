//package org.firstinspires.ftc.teamcode.opmodes.autonomy.pastelaura;
//
//import static java.lang.Thread.sleep;
//
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.Point;
//import org.opencv.core.Rect;
//import org.opencv.core.Scalar;
//import org.opencv.imgproc.Imgproc;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//public class MyPipe extends pipeline  {
//    private int max;
//
//    @Override
//    public Mat processFrame(Mat input)
//    {
//        Mat mat = new Mat();
//
////                Mat roi = input;
//        mat = input;
//
//        Point region1_a = new Point(0,480);
//        Point region1_b = new Point(100,580);
//
//        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2HSV);
//
//        Scalar lowHSV1 = new Scalar(170,50,10);
//        Scalar highHSV1 = new Scalar(180,200,100);
//
//        Core.inRange(mat, lowHSV1, highHSV1, mat);
//
////                final Mat trash = mat;
//
////                andiregion1 = trash;
//
//        Point r1p1 = new Point(0,0);
//        Point r1p2 = new Point(mat.width()/3f,mat.height());
//        Point r2p1 = new Point(mat.width()/3f,0);
//        Point r2p2 = new Point((2*mat.width())/3f,mat.height());
//        Point r3p1 = new Point((2*mat.width())/3f,0);
//        Point r3p2 = new Point(mat.width(),mat.height());
//
//
//
//        Rect rect1 = new Rect(r1p1,r1p2);
//        Rect rect2 = new Rect(r2p1,r2p2);//
//        Rect rect3 = new Rect(r3p1,r3p2);// //            Rect rect2 = new Rect(mat.width()/2,50,mat.width() - 10,mat.height()- 10);
//
////                int region1, region2, region3;
//
//        Mat matLeft = mat.submat(rect1);
//        Mat matCenter = mat.submat(rect2);
//        Mat matRight = mat.submat(rect3);
//
//        final int region1 = Core.countNonZero(matLeft);
//        final int region2 = Core.countNonZero(matCenter);
//        final int region3 = Core.countNonZero(matRight);
//
//        if(region1 > region2)
//            if(region1 > region3)
//                max = 1;
//            else
//                max = 3;
//        else
//        if(region2 > region3)
//            max = 2;
//        else
//            max = 3;
//
//
//
//
///*                final int m = max;
//
//                andi = m;*/
////                region andi
////                max = Math.max(Math.max(region1, region2), region3);
////                andimax = max;
////                endregion
//
//
//
//
//
////               loc.setLocation(max);
////               telemetry.clear();
////               telemetry.addData("E in: ", this.max);//loc.location);
////                telemetry.update();
//
////                telemetry.addData("E in ", max);
////
////                region1 = Core.countNonZero(matLeft);
////
////                telemetry.addData("Pixeli ", region1);
////                telemetry.update();
//
//
//
//
//
//        //fuck rectangles
//        //I fucking hate racntagles andy help
//        //andy unde este tu vino save me
//        // java is retarded
//
//
////        sleep(300);
//        return super.processFrame(input);
//    }
//
//    public int getMax() {return max;}
//
//}
