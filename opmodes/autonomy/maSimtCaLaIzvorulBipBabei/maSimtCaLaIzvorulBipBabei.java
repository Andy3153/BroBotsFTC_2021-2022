package org.firstinspires.ftc.teamcode.opmodes.autonomy.maSimtCaLaIzvorulBipBabei;

// Mă simt fix ca la Izvorul Pizda Babei.

//region imports
//robot stuff
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

// Our code *communism de ce ma itraiesc*
//autonomy functions
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveMovev2;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.autoDriveStrafev2;
//endregion

@Autonomous(name="Mă simt ca la Izvorul Pizda Babei.", group="Autonomous")
public class maSimtCaLaIzvorulBipBabei extends LinearOpMode {
    public void runOpMode() {
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

        waitForStart();          //waits for start button to get pressed
        while (opModeIsActive()) //this runs when the start button gets pressed
        {
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
            autoDriveStrafev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, -68); // ajunge la hub si lasa cub
            H1Servo4_Tip.setPosition(0.5);
            sleep(1000);
            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, -100);
            H1Servo0_Rotator.setPosition(0.4);
            sleep(200);
            H1Servo0_Rotator.setPosition(0.45);
            sleep(100);
            H1Servo0_Rotator.setPosition(0.5);
            sleep(500);
            autoDriveStrafev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 50);// ajunge la carusel
            H2Motor2_Duck.setPower(0.4);
            sleep(3500);
            H2Motor2_Duck.setPower(0);
            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 55);
            sleep(1000);
            autoDriveStrafev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 25);
            sleep(1000);
            autoDriveMovev2(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, 0.5, 195);
            H1Servo1_Coi1.setPosition(0.2);
            H1Servo2_Coi2.setPosition(1 - 0.2);
            H1Servo3_Shaft.setPosition(0.8);
            sleep(2000);

            //ZIUA LU ANDI E PE 2 IUNIE

            break; //stop robot milnici de glume cu milsugi nu mai am chef.
        }
    }
}