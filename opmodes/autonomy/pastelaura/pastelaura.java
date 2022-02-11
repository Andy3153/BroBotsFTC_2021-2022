package org.firstinspires.ftc.teamcode.opmodes.autonomy.pastelaura;

//region imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

// Our code *communism*
// constants for wheel info
import static org.firstinspires.ftc.teamcode.functions.constants.driveMotorTickCount;
import static org.firstinspires.ftc.teamcode.functions.constants.driveWheelDiameter;
import static org.firstinspires.ftc.teamcode.functions.constants.driveWheelCircumference;

// autonomy functions
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveMovev2;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveStrafev2;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveTurnv2;
//endregion

@Autonomous(name="PasteLaura", group="Autonomous")
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
        H1Servo0_Rotator.setPosition(0);
        H1Servo1_Coi1.setPosition(0.55);
        H1Servo2_Coi2.setPosition(1 - 0.55);
        H1Servo3_Shaft.setPosition(0.3);
        //endregion

        waitForStart();

        while (opModeIsActive())
        {
            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 10);

            break; //stop robot milsugi
        }
    }
}
