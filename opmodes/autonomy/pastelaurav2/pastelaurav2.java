package org.firstinspires.ftc.teamcode.opmodes.autonomy.pastelaurav2;

//region imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;


import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;



import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;




import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;




import static com.sun.tools.doclint.HtmlTag.BR;



// Our code *communism*
// constants for wheel info
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.functions.constants.driveMotorTickCount;
import static org.firstinspires.ftc.teamcode.functions.constants.driveWheelDiameter;
import static org.firstinspires.ftc.teamcode.functions.constants.driveWheelCircumference;
import static org.firstinspires.ftc.teamcode.functions.vuforiaKey.vuforiaKey;

// autonomy functions
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveMovev2;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveStrafev2;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveTurnv2;
//endregion

@Autonomous(name="PasteLauraV2", group="Autonomous")
public class pastelaurav2 extends LinearOpMode
{

    private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Quad";
    private static final String LABEL_SECOND_ELEMENT = "Single";


    /*
     * IMPORTANT: You need to obtain your own license key to use Vuforia. The string below with which
     * 'parameters.vuforiaLicenseKey' is initialized is for illustration only, and will not function.
     * A Vuforia 'Development' license key, can be obtained free of charge from the Vuforia developer
     * web site at https://developer.vuforia.com/license-manager.
     *
     * Vuforia license keys are always 380 characters long, and look as if they contain mostly
     * random data. As an example, here is a example of a fragment of a valid key:
     *      ... yIgIzTqZ4mWjk9wd3cZO9T1axEqzuhxoGlfOOI2dRzKS4T0hQ8kT ...
     * Once you've obtained a license key, copy the string from the Vuforia web site
     * and paste it in to your code on the next line, between the double quotes.
     */
    private static final String VUFORIA_KEY = vuforiaKey;

    /**
     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
     * localization engine.
     */
    private VuforiaLocalizer vuforia;

    /**
     * {@link #tfod} is the variable we will use to store our instance of the TensorFlow Object
     * Detection engine.
     */
    private TFObjectDetector tfod;


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

        //region Vuforia shit
        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        // first.
//        initVuforia();
//        initTfod();

        /**
         * Activate TensorFlow Object Detection before we wait for the start command.
         * Do it here so that the Camera Stream window will have the TensorFlow annotations visible.
         **/
        if (tfod != null) {
            tfod.activate();

            // The TensorFlow software will scale the input images from the camera to a lower resolution.
            // This can result in lower detection accuracy at longer distances (> 55cm or 22").
            // If your target is at distance greater than 50 cm (20") you can adjust the magnification value
            // to artificially zoom in to the center of image.  For best results, the "aspectRatio" argument
            // should be set to the value of the images used to create the TensorFlow Object Detection model
            // (typically 16/9).
            tfod.setZoom(3.5, 16.0 / 9.0);
        }

        /** Wait for the game to begin */
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.update();

        //endregion

        waitForStart();

        while (opModeIsActive())
        {
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

            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, -65);
            sleep(200);
            H1Servo0_Rotator.setPosition(0.4);
            sleep(200);
            H1Servo0_Rotator.setPosition(0.3);
            sleep(100);
            H1Servo0_Rotator.setPosition(0.25);
            sleep(100);
            autoDriveStrafev2(H1Motor0_FL,H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, -68); // ajunge la hub si lasa cub
            H1Servo4_Tip.setPosition(0.5);
            sleep(500);
            autoDriveStrafev2(H1Motor0_FL,H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 25);
            sleep(200);
            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, -110);
            H1Servo0_Rotator.setPosition(0.4);
            sleep(200);
            H1Servo0_Rotator.setPosition(0.45);
            sleep(100);
            H1Servo0_Rotator.setPosition(0.5);
            sleep(500);
            autoDriveStrafev2(H1Motor0_FL,H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 22);
//            autoDriveStrafev2(H1Motor0_FL,H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 45);// ajunge la carusel
            H2Motor2_Duck.setPower(0.4);
            sleep(3500);
            H2Motor2_Duck.setPower(0); // a cazut rata
            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 100);
            sleep(100);
            autoDriveStrafev2(H1Motor0_FL,H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 20);
            sleep(100);
            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 160);
            H1Servo1_Coi1.setPosition(0.2);
            H1Servo2_Coi2.setPosition(1 - 0.2);
            H1Servo3_Shaft.setPosition(0.8);
            sleep(2000);

            //ZIUA LU ANDI E PE 2 IUNIE

            break; //stop robot milsugi
        }
    }
}
