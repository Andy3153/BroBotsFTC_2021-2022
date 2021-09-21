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

import static org.firstinspires.ftc.teamcode.functions.robotServos.armPos;
import static org.firstinspires.ftc.teamcode.functions.robotServos.clawPos;

import static org.firstinspires.ftc.teamcode.functions.constants.armMinPos;
import static org.firstinspires.ftc.teamcode.functions.constants.armMaxPos;
import static org.firstinspires.ftc.teamcode.functions.constants.clawMinPos;
import static org.firstinspires.ftc.teamcode.functions.constants.clawMaxPos;

@TeleOp(name="gunoier", group="TeleOp")
public class gunoier extends LinearOpMode
{
    @Override
    public void runOpMode()
    {
        //region Declaring variables
        float driveMoveSpeed, driveStrafeSpeed, driveTurnSpeed;
        //endregion

        //region Declaring motors
        DcMotorEx H1Motor0_FL = hardwareMap.get(DcMotorEx.class, "H1Motor0_FL");
        DcMotorEx H1Motor1_FR = hardwareMap.get(DcMotorEx.class, "H1Motor1_FR");
        DcMotorEx H1Motor2_BL = hardwareMap.get(DcMotorEx.class, "H1Motor2_BL");
        DcMotorEx H1Motor3_BR = hardwareMap.get(DcMotorEx.class, "H1Motor3_BR");

        Servo H1Servo0_ArmL = hardwareMap.get(Servo.class, "H1Servo0_ArmL");
        Servo H1Servo1_ArmR = hardwareMap.get(Servo.class, "H1Servo1_ArmR");
        Servo H1Servo2_ClawL = hardwareMap.get(Servo.class, "H1Servo2_ClawL" );
        Servo H1Servo3_ClawR = hardwareMap.get(Servo.class, "H1Servo3_ClawR");
        //endregion

        //region Initial positions
        driveZero(H1Motor0_FL, H1Motor1_FR, H1Motor2_BL, H1Motor3_BR);

        H1Servo0_ArmL.setPosition(armMaxPos);
        H1Servo1_ArmR.setPosition(1 -armMaxPos);
        H1Servo2_ClawL.setPosition(clawMinPos);
        H1Servo3_ClawR.setPosition(1 - clawMinPos);
        //endregion

        waitForStart();

        while(opModeIsActive())
        {
            //region Driving
            if((driveMoveSpeed = gamepad1.left_stick_y) != 0)
                driveMove(H1Motor0_FL, H1Motor1_FR, H1Motor2_BL, H1Motor3_BR, driveMoveSpeed);
            else
                driveZero(H1Motor0_FL, H1Motor1_FR, H1Motor2_BL, H1Motor3_BR);

            if((driveStrafeSpeed = gamepad1.left_stick_x) != 0)
                driveStrafe(H1Motor0_FL, H1Motor1_FR, H1Motor2_BL, H1Motor3_BR, -driveStrafeSpeed);
            else
                driveZero(H1Motor0_FL, H1Motor1_FR, H1Motor2_BL, H1Motor3_BR);

            if((driveTurnSpeed = gamepad1.right_stick_x) != 0)
                driveTurn(H1Motor0_FL, H1Motor1_FR, H1Motor2_BL, H1Motor3_BR, driveTurnSpeed);
            else
                driveZero(H1Motor0_FL, H1Motor1_FR, H1Motor2_BL, H1Motor3_BR);
            //endregion

            //region Servos
            if(gamepad1.dpad_up || gamepad1.dpad_down)
            {
                H1Servo0_ArmL.setPosition(armPos(0.05f, gamepad1));
                H1Servo1_ArmR.setPosition(1 - armPos(0.05f, gamepad1));
            }

            if(gamepad1.dpad_left || gamepad1.dpad_right)
            {
                H1Servo2_ClawL.setPosition(clawPos(0.05f, gamepad1));
                H1Servo3_ClawR.setPosition(1 - clawPos(0.05f, gamepad1));
            }
            //endregion
        }
    }
}
