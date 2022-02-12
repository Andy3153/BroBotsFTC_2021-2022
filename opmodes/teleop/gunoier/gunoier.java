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
        float rotator_position =(float) 0.2, arm1_pos = (float)0.2, arm3_pos = 0;
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

        waitForStart();

        while (opModeIsActive()) {
            //region Driving
            if (gamepad1.right_stick_x <= 0.5 && gamepad1.right_stick_x >= -0.5 && gamepad1.right_stick_y <= -0.3)
                driveMove(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, (float) 0.3);
            else if (gamepad1.right_stick_x <= 0.5 && gamepad1.right_stick_x >= -0.5 && gamepad1.right_stick_y >= 0.3)
                driveMove(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR,  (float) -0.3);
            else
                driveZero(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR);

            if(gamepad1.right_stick_x >= 0.2 && gamepad1.right_stick_y <= 0.5 && gamepad1.right_stick_y >= -0.5 )
                driveStrafe(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR,  (float) 0.4);
            else if(gamepad1.right_stick_x <= -0.2 && gamepad1.right_stick_y <= 0.5 && gamepad1.right_stick_y >= -0.5 )
                driveStrafe(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR,  (float) -0.4);
            else
                driveZero(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR);

            if(gamepad1.left_stick_y >= -0.5 && gamepad1.left_stick_y <= 0.5 && gamepad1.left_stick_x >= 0.2)
                driveTurn(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR,  (float) 0.2);
            else if(gamepad1.left_stick_y >= -0.5 && gamepad1.left_stick_y <= 0.5 && gamepad1.left_stick_x <= -0.2)
                driveTurn(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR,  (float) -0.2);
            else
                driveZero(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR);
            //endregion

            //region Servos
            if(gamepad2.dpad_left) {
                H1Servo0_Rotator.setPosition(rotator_position);
            }
            if(gamepad2.dpad_right){
                H1Servo0_Rotator.setPosition(rotator_position + 0.3);
            }
            if(gamepad2.dpad_up){
                H1Servo1_Coi1.setPosition(0.55);
                H1Servo2_Coi2.setPosition(1 - 0.55);
                H1Servo3_Shaft.setPosition(arm3_pos + 0.3);
            }
            if(gamepad2.dpad_down){
                H1Servo1_Coi1.setPosition(0.8);
                H1Servo2_Coi2.setPosition(1 - 0.8);
                H1Servo3_Shaft.setPosition(arm3_pos);
            }
            if(gamepad2.a){
                okAndy = !okAndy;
                sleep(300);
            }
            H1Servo4_Tip.setPosition(okAndy?1:0.5);
            //endregion

            if(gamepad2.right_trigger != 0) {
                H2Motor2_Duck.setPower(1);
            }
        telemetry.addData("Motor: ", H1Motor0_FL.getCurrentPosition());
            telemetry.update();
        }
    }
}
