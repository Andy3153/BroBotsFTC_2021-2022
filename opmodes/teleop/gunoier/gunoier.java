package org.firstinspires.ftc.teamcode.opmodes.teleop.gunoier;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

// Our code *communism*
import static org.firstinspires.ftc.teamcode.functions.robotMovement.driveMove;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.driveStrafe;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.driveTurn;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.driveZero;

//import static org.firstinspires.ftc.teamcode.functions.robotServos.armPos;
//import static org.firstinspires.ftc.teamcode.functions.robotServos.clawPos;

import static org.firstinspires.ftc.teamcode.functions.robotServos.useArm;
import static org.firstinspires.ftc.teamcode.functions.robotServos.useClaw;

import static org.firstinspires.ftc.teamcode.functions.constants.armMinPos;
import static org.firstinspires.ftc.teamcode.functions.constants.armMaxPos;
import static org.firstinspires.ftc.teamcode.functions.constants.clawMinPos;
import static org.firstinspires.ftc.teamcode.functions.constants.clawMaxPos;
import static org.firstinspires.ftc.teamcode.functions.robotServos.useServos;

@TeleOp(name="gunoier", group="TeleOp")
public class gunoier extends LinearOpMode {
    public void runOpMode() {
        //region Declaring variables
        float driveMoveSpeed, driveStrafeSpeed, driveTurnSpeed;
        float rotator_position = (float) 0.2, arm1_pos = (float) 0.2, arm3_pos = 0, speed = (float) 0.6;
        boolean okAndy = false;
        //endregion

        //region Declaring motors
        DcMotorEx H1Motor0_FL = hardwareMap.get(DcMotorEx.class, "H1Motor0_FL");
        DcMotorEx H2Motor0_FR = hardwareMap.get(DcMotorEx.class, "H2Motor0_FR");
        DcMotorEx H1Motor1_BL = hardwareMap.get(DcMotorEx.class, "H1Motor1_BL");
        DcMotorEx H2Motor1_BR = hardwareMap.get(DcMotorEx.class, "H2Motor1_BR");
        DcMotorEx H2Motor2_Duck = hardwareMap.get(DcMotorEx.class, "H2Motor2_Duck");

        Servo H1Servo0_Rotator = hardwareMap.get(Servo.class, "H1Servo0_Rotator");
        Servo H1Servo1_Coi1 = hardwareMap.get(Servo.class, "H1Servo1_Coi1");
        Servo H1Servo2_Coi2 = hardwareMap.get(Servo.class, "H1Servo2_Coi2");
        Servo H1Servo3_Shaft = hardwareMap.get(Servo.class, "H1Servo3_Shaft");
        Servo H1Servo4_Tip = hardwareMap.get(Servo.class, "H1Servo4_Tip");
        //endregion

        //region Initial positions
//        driveZero(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR);
        //endregion

        H1Servo0_Rotator.setPosition(0.5);
        H1Servo1_Coi1.setPosition(0.2);
        H1Servo2_Coi2.setPosition(1 - 0.2);
        H1Servo3_Shaft.setPosition(0.8);
        H1Servo4_Tip.setPosition(1);

        waitForStart();

        while (opModeIsActive()) {
            //region Driving
            if (gamepad1.right_bumper) {
                speed = (float) 0.25;
            }
            if (gamepad1.left_bumper) {
                speed = (float) 0.6;
            }
            if (gamepad1.left_stick_x <= 0.5 && gamepad1.left_stick_x >= -0.5 && gamepad1.left_stick_y <= -0.3)
                driveMove(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, (float) speed);
            else if (gamepad1.left_stick_x <= 0.5 && gamepad1.left_stick_x >= -0.5 && gamepad1.left_stick_y >= 0.3)
                driveMove(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, (float) -speed);
            else
                driveZero(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR);

            if (gamepad1.left_stick_x >= 0.2 && gamepad1.left_stick_y <= 0.5 && gamepad1.left_stick_y >= -0.5)
                driveStrafe(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, (float) (speed + 0.1));
            else if (gamepad1.left_stick_x <= -0.2 && gamepad1.left_stick_y <= 0.5 && gamepad1.left_stick_y >= -0.5)
                driveStrafe(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, (float) -(speed + 0.1));
            else
                driveZero(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR);

            if (gamepad1.right_stick_y <= 0.5 && gamepad1.right_stick_x >= 0.2)
                driveTurn(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, (float) (speed + 0.1));
            else if (gamepad1.right_stick_y >= -0.5 && gamepad1.right_stick_y <= 0.5 && gamepad1.right_stick_x <= -0.2)
                driveTurn(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, (float) -(speed +0.1));
            else
                driveZero(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR);
            //endregion

            //region Servos
            if (gamepad2.dpad_left) {
                H1Servo0_Rotator.setPosition(rotator_position);
            }
            if (gamepad2.dpad_right) {
                H1Servo0_Rotator.setPosition(rotator_position + 0.3);
            }
            if (gamepad2.dpad_up) {
                H1Servo1_Coi1.setPosition(0.55);
                H1Servo2_Coi2.setPosition(1 - 0.55);
                H1Servo3_Shaft.setPosition(arm3_pos + 0.65);
                driveZero(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR);
                sleep(500);
                H1Servo3_Shaft.setPosition(arm3_pos + 0.3);
            }
            if (gamepad2.x) {
                H1Servo1_Coi1.setPosition(0.65);
                H1Servo2_Coi2.setPosition(1 - 0.65);
                H1Servo3_Shaft.setPosition(arm3_pos + 0.25);
            }
            if (gamepad2.dpad_down) {
                H1Servo3_Shaft.setPosition(arm3_pos);
                H1Servo1_Coi1.setPosition(0.7);
                H1Servo2_Coi2.setPosition(1 - 0.7);
                driveZero(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR);
                sleep(300);

                H1Servo1_Coi1.setPosition(0.75);
                H1Servo2_Coi2.setPosition(1 - 0.75);
                driveZero(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR);
                sleep(200);

                H1Servo1_Coi1.setPosition(0.82);
                H1Servo2_Coi2.setPosition(1 - 0.82);

            }
            if (gamepad2.a)
            {
                H1Servo4_Tip.setPosition(1);
            }
            if (gamepad2.b)
            {
                H1Servo4_Tip.setPosition(0.5);
            }
            //endregion

            if(gamepad2.right_trigger > 0)
                H2Motor2_Duck.setPower(gamepad2.right_trigger >= 0.65 ? 0.65 : gamepad2.right_trigger);

//            if (gamepad2.right_trigger != 0)
//            {
//                H2Motor2_Duck.setPower(0.7);
//            }

            H2Motor2_Duck.setPower(0);
        }
    }
}
