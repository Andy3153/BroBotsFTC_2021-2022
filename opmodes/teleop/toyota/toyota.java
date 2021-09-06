package org.firstinspires.ftc.teamcode.opmodes.teleop.toyota;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

// Our code *communism*
import static org.firstinspires.ftc.teamcode.functions.robotMovement.driveMove;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.driveStrafe;
import static org.firstinspires.ftc.teamcode.functions.robotMovement.driveTurn;

@TeleOp(name="toyota", group="TeleOp")
@Disabled
public class toyota extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {
        //region Declaring variables
        float speedX = gamepad1.left_stick_x,
              speedY = gamepad1.left_stick_y,
              speedTurn = gamepad1.right_stick_x;
        //endregion

        //region Defining motors
        //Driving Motors
        DcMotor H1Motor0_FL = hardwareMap.get(DcMotor.class, "H1Motor0_FL");
        DcMotor H2Motor0_FR = hardwareMap.get(DcMotor.class, "H2Motor0_FR");
        DcMotor H1Motor1_BL = hardwareMap.get(DcMotor.class, "H1Motor1_BL");
        DcMotor H2Motor1_BR = hardwareMap.get(DcMotor.class, "H2Motor1_BR");
        //endregion

        waitForStart();

        while (opModeIsActive()) // && !gamepad1.x)
        {

            //region Setting Motor Power
            //Driving Motors
            H1Motor0_FL.setPower(0);
            H2Motor0_FR.setPower(0);
            H1Motor1_BL.setPower(0);
            H2Motor1_BR.setPower(0);
            //endregion

            //region Driving
            driveMove(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, gamepad1.left_stick_y);
            driveStrafe(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, gamepad1.left_stick_x);
            driveTurn(H1Motor0_FL, H2Motor0_FR, H1Motor1_BL, H2Motor1_BR, gamepad1.right_stick_x);
            //endregion
        }
    }
}
