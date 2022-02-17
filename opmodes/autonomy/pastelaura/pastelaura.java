package org.firstinspires.ftc.teamcode.opmodes.autonomy.pastelaura;

//region imports
//robot stuff
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

//opencv stuff
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.functions.MyApplication;
import org.opencv.core.Mat;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.opencv.core.Core;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Point;

// Our code *communism*
//autonomy functions
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveMovev2;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveStrafev2;

//file operations
import static org.firstinspires.ftc.teamcode.functions.fileOperations.writeToFile;
import static org.firstinspires.ftc.teamcode.functions.fileOperations.readFromFile;
//endregion

abstract class pipeline extends OpenCvPipeline
{
    int max;
    public Mat processFrame(Mat input)
    {
        return input;
    }
}


@Autonomous(name="PasteLaura", group="Autonomous")
public class pastelaura extends LinearOpMode
{
    public void runOpMode()
    {
        //region Declaring motors
        DcMotorEx H1Motor0_FL = hardwareMap.get(DcMotorEx.class, "H1Motor0_FL");
        DcMotorEx H2Motor0_FR = hardwareMap.get(DcMotorEx.class, "H2Motor0_FR");
        DcMotorEx H1Motor1_BL = hardwareMap.get(DcMotorEx.class, "H1Motor1_BL");
        DcMotorEx H2Motor1_BR = hardwareMap.get(DcMotorEx.class, "H2Motor1_BR");
        DcMotorEx H2Motor2_Duck = hardwareMap.get(DcMotorEx.class, "H2Motor2_Duck");

        //servos
        Servo H1Servo0_Rotator = hardwareMap.get(Servo.class, "H1Servo0_Rotator");
        Servo H1Servo1_Coi1 = hardwareMap.get(Servo.class, "H1Servo1_Coi1");
        Servo H1Servo2_Coi2 = hardwareMap.get(Servo.class, "H1Servo2_Coi2");
        Servo H1Servo3_Shaft = hardwareMap.get(Servo.class, "H1Servo3_Shaft");
        Servo H1Servo4_Tip = hardwareMap.get(Servo.class, "H1Servo4_Tip");
        //endregion

        //region initialize servo positions
        H1Servo0_Rotator.setPosition(0.5);
        H1Servo1_Coi1.setPosition(0.2);
        H1Servo2_Coi2.setPosition(1 - 0.2);
        H1Servo3_Shaft.setPosition(0.8);
        H1Servo4_Tip.setPosition(1);
        //endregion

        int width  = 320,
            height = 240;

        //region camera
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        WebcamName webcam = hardwareMap.get(WebcamName.class, "milcamerezi");
        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(webcam, cameraMonitorViewId);
        camera.openCameraDevice();

        pipeline Pipe = new pipeline()
        {
            public int max;

            @Override
            public Mat processFrame(Mat input)
            {
                Mat mat = new Mat();
                mat = input;

                Point region1_a = new Point(0,480);
                Point region1_b = new Point(100,580);

                Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2HSV);

                //lower and higher bounds for the color of our object that we need to detect
                Scalar lowHSV1 = new Scalar(170,50,10);
                Scalar highHSV1 = new Scalar(180,200,100);
                Core.inRange(mat, lowHSV1, highHSV1, mat);

                Point r1p1 = new Point(0,0);
                Point r1p2 = new Point(mat.width()/3f,mat.height());
                Point r2p1 = new Point(mat.width()/3f,0);
                Point r2p2 = new Point((2*mat.width())/3f,mat.height());
                Point r3p1 = new Point((2*mat.width())/3f,0);
                Point r3p2 = new Point(mat.width(),mat.height());

                //the imaginary rectangles created to detect the possible zones for the object
                Rect rect1 = new Rect(r1p1,r1p2);
                Rect rect2 = new Rect(r2p1,r2p2);
                Rect rect3 = new Rect(r3p1,r3p2);

                Mat matLeft = mat.submat(rect1);
                Mat matCenter = mat.submat(rect2);
                Mat matRight = mat.submat(rect3);

                //the regions used to create the value for the 'max' variable
                //these region variables contain how many pixels there are in the three zones the object can be in
                int region1 = Core.countNonZero(matLeft);
                int region2 = Core.countNonZero(matCenter);
                int region3 = Core.countNonZero(matRight);

                //get the position of the object and store it in a variable
                if(region1 > region2)
                    if(region1 > region3) max = 1;
                    else max = 3;
                else
                    if(region2 > region3) max = 2;
                    else max = 3;

                //in case Pipe.max won't work, use files plox
                writeToFile(String.valueOf(max), MyApplication.getAppContext()); //lifesaver


                //fuck rectangles
                //I fucking hate racntagles andy help
                //andy unde este tu vino save me
                // java is retarded


                sleep(300);
                return super.processFrame(input);
            }
        };

        camera.setPipeline(Pipe);
        camera.startStreaming(640, 480, OpenCvCameraRotation.UPRIGHT);
        //endregion

        waitForStart();          //waits for start button to get pressed
        while (opModeIsActive()) //this runs when the start button gets pressed
        {
            camera.closeCameraDevice(); //close camera to save resources

            if(Pipe.max == 1) telemetry.addData("poz", 1);
            else if(Pipe.max == 2) telemetry.addData("poz", 2);
            else if(Pipe.max == 3) telemetry.addData("poz", 3);

            if(readFromFile(MyApplication.getAppContext()).equals("1")) telemetry.addData("poz", 1);
            if(readFromFile(MyApplication.getAppContext()).equals("2")) telemetry.addData("poz", 2);
            if(readFromFile(MyApplication.getAppContext()).equals("3")) telemetry.addData("poz", 3);

            H1Servo1_Coi1.setPosition(0.55);
            H1Servo2_Coi2.setPosition(1 - 0.55);
            H1Servo3_Shaft.setPosition(0.3);

            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, -75);
            sleep(1000);
            H1Servo0_Rotator.setPosition(0.4);
            sleep(200);
            H1Servo0_Rotator.setPosition(0.35);
            sleep(100);
            H1Servo0_Rotator.setPosition(0.3);
            sleep(100);
            autoDriveStrafev2(H1Motor0_FL,H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, -68); // ajunge la hub si lasa cub
            H1Servo4_Tip.setPosition(0.5);
            sleep(1000);
            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, -100);
            H1Servo0_Rotator.setPosition(0.4);
            sleep(200);
            H1Servo0_Rotator.setPosition(0.45);
            sleep(100);
            H1Servo0_Rotator.setPosition(0.5);
            sleep(500);
            autoDriveStrafev2(H1Motor0_FL,H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 45);// ajunge la carusel
            H2Motor2_Duck.setPower(0.4);
            sleep(3500);
            H2Motor2_Duck.setPower(0);
            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 55);
            sleep(1000);
            autoDriveStrafev2(H1Motor0_FL,H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 25);
            sleep(1000);
            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 195);
            H1Servo1_Coi1.setPosition(0.2);
            H1Servo2_Coi2.setPosition(1 - 0.2);
            H1Servo3_Shaft.setPosition(0.8);
            sleep(2000);

            //ZIUA LU ANDI E PE 2 IUNIE

            break; //stop robot milsugi
        }
    }
}
