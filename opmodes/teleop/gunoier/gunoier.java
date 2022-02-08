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
    @Override
    public void runOpMode() {
        //region Declaring variables
        float driveMoveSpeed, driveStrafeSpeed, driveTurnSpeed;
        //endregion

        //region Declaring motors
//        DcMotorEx H1Motor2_FL = hardwareMap.get(DcMotorEx.class, "H1Motor2_FL");
//        DcMotorEx H1Motor3_FR = hardwareMap.get(DcMotorEx.class, "H1Motor3_FR");
//        DcMotorEx H1Motor0_BL = hardwareMap.get(DcMotorEx.class, "H1Motor0_BL");
//        DcMotorEx H1Motor1_BR = hardwareMap.get(DcMotorEx.class, "H1Motor1_BR");

        //endregion

        Servo arm = hardwareMap.get(Servo.class, "Arm");
        Servo rotator = hardwareMap.get(Servo.class, "Rotator");

        //region Initial positions
        //driveZero(H1Motor2_FL, H1Motor3_FR, H1Motor0_BL, H1Motor1_BR);


        waitForStart();

        while (opModeIsActive()) {
            //region Driving
//            if (gamepad1.right_stick_x <= 0.5 && gamepad1.right_stick_x >= -0.5 && gamepad1.right_stick_y <= -0.3)
//                driveMove(H1Motor2_FL, H1Motor3_FR, H1Motor0_BL, H1Motor1_BR, (float) 0.3);
//            else if (gamepad1.right_stick_x <= 0.5 && gamepad1.right_stick_x >= -0.5 && gamepad1.right_stick_y >= 0.3)
//                driveMove(H1Motor2_FL, H1Motor3_FR, H1Motor0_BL, H1Motor1_BR,  (float) -0.3);
//            else
//                driveZero(H1Motor2_FL, H1Motor3_FR, H1Motor0_BL, H1Motor1_BR);
//
//            if(gamepad1.right_stick_x >= 0.2 && gamepad1.right_stick_y <= 0.5 && gamepad1.right_stick_y >= -0.5 )
//                driveStrafe(H1Motor2_FL, H1Motor3_FR, H1Motor0_BL, H1Motor1_BR,  (float) 0.4);
//            else if(gamepad1.right_stick_x <= -0.2 && gamepad1.right_stick_y <= 0.5 && gamepad1.right_stick_y >= -0.5 )
//                driveStrafe(H1Motor2_FL, H1Motor3_FR, H1Motor0_BL, H1Motor1_BR,  (float) -0.4);
//            else
//                driveZero(H1Motor2_FL, H1Motor3_FR, H1Motor0_BL, H1Motor1_BR);
//
//            if(gamepad1.left_stick_y >= -0.5 && gamepad1.left_stick_y <= 0.5 && gamepad1.left_stick_x >= 0.2)
//                driveTurn(H1Motor2_FL, H1Motor3_FR, H1Motor0_BL, H1Motor1_BR,  (float) 0.2);
//            else if(gamepad1.left_stick_y >= -0.5 && gamepad1.left_stick_y <= 0.5 && gamepad1.left_stick_x <= -0.2)
//                driveTurn(H1Motor2_FL, H1Motor3_FR, H1Motor0_BL, H1Motor1_BR,  (float) -0.2);
//            else
//                driveZero(H1Motor2_FL, H1Motor3_FR, H1Motor0_BL, H1Motor1_BR);
            //endregion

            //region Servos
//            if(gamepad1.dpad_up || gamepad1.dpad_down)
//            {
//                H1Servo0_ArmL.setPosition(armPos(0.05f, gamepad1));
//                H1Servo1_ArmR.setPosition(1 - armPos(0.05f, gamepad1));
//            }

//            if(gamepad1.dpad_left || gamepad1.dpad_right)
//            {
//                H1Servo2_ClawL.setPosition(clawPos(0.05f, gamepad1));
//                H1Servo3_ClawR.setPosition(1 - clawPos(0.05f, gamepad1));
//            }
            //endregion



        }
    }
}
