package org.firstinspires.ftc.teamcode.opmodes.autonomy.pastelaura;

//region imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

// Our code *communism*
// constants for wheel info
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.functions.constants.driveMotorTickCount;
import static org.firstinspires.ftc.teamcode.functions.constants.driveWheelDiameter;
import static org.firstinspires.ftc.teamcode.functions.constants.driveWheelCircumference;

// autonomy functions
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveMovev2;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveStrafev2;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveTurnv2;
//endregion

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.opencv.core.Mat;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvWebcam;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvViewport;
import org.openftc.easyopencv.OpenCvTracker;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;
import org.opencv.core.Point;



abstract class pipeline extends OpenCvPipeline
{
    public Mat processFrame(Mat input)
    {
        return input;
    }
}

@Autonomous(name="PasteLaura", group="Autonomous")
//@Disabled
public class pastelaura extends LinearOpMode
{
    public void runOpMode()
    {
        //region Declaring variables
//        float driveMoveSpeed, driveStrafeSpeed, driveTurnSpeed;
//        float rotator_position = 0, arm1_pos = (float)0.2, arm3_pos = 0;
        //endregion

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

        int width = 320;
        int height = 240;

        //region camera

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        WebcamName webcam = hardwareMap.get(WebcamName.class, "milcamerezi");

        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(webcam, cameraMonitorViewId);


        camera.openCameraDevice();

        pipeline Pipe = new pipeline() {
            @Override
            public Mat processFrame(Mat input) {
                Mat mat = new Mat();
                mat = input;

//                Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2HSV);
//
//                Scalar lowHSV1 = new Scalar(170,50,10);
//                Scalar highHSV1 = new Scalar(180,200,100);

//                Core.inRange(mat, lowHSV1, highHSV1, mat);

                Point region1_a = new Point(50,480);

                return super.processFrame(mat);
            }
        };

        camera.setPipeline(Pipe);

        camera.startStreaming(640, 480, OpenCvCameraRotation.UPRIGHT);
        //endregion



        waitForStart();

        while (opModeIsActive())
        {
            camera.closeCameraDevice();
//            H1Servo3_Shaft.setPosition(0);
//            sleep(300);

//            H1Servo1_Coi1.setPosition(0.6);
//            H1Servo2_Coi2.setPosition(1 - 0.6);
//
//            sleep(1000);
//
//            H1Servo1_Coi1.setPosition(0.7);
//            H1Servo2_Coi2.setPosition(1 - 0.7);
//
//            sleep(300);
//
//            H1Servo1_Coi1.setPosition(0.75);
//            H1Servo2_Coi2.setPosition(1 - 0.75);
//
//            sleep(200);
//
//            H1Servo1_Coi1.setPosition(0.8);
//            H1Servo2_Coi2.setPosition(1 - 0.8);

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
