package org.firstinspires.ftc.teamcode.functions;

import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.teamcode.functions.constants.driveMotorTickCount;
import static org.firstinspires.ftc.teamcode.functions.constants.driveWheelCircumference;

public class robotMovement {
    //region Mecanum movement
    public static void driveMove(DcMotor FL, DcMotor FR, DcMotor BL, DcMotor BR, float speed) {
        FL.setPower(-speed);
        FR.setPower(-speed); //FR.setPower(speed);
        BL.setPower(-speed);
        BR.setPower(speed);
    }

    public static void driveStrafe(DcMotor FL, DcMotor FR, DcMotor BL, DcMotor BR, float speed) {
        FL.setPower(-speed);
        FR.setPower(speed); //FR.setPower(-speed);
        BL.setPower(speed);
        BR.setPower(speed);
    }

    public static void driveTurn(DcMotor FL, DcMotor FR, DcMotor BL, DcMotor BR, float speed) {
        FL.setPower(speed);
        FR.setPower(-speed); //FR.setPower(speed);
        BL.setPower(speed);
        BR.setPower(speed);
    }

    public static void driveZero(DcMotor FL, DcMotor FR, DcMotor BL, DcMotor BR) {
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
    }
    //endregion

    //region Autonomous
    public static void autoDriveMove(DcMotor FL, DcMotor FR, DcMotor BL, DcMotor BR, double speed, int Pixeli) //int encoderDrivingTarget) //int howManyCm)
    {
        FR.setDirection(DcMotor.Direction.REVERSE);
        BR.setDirection(DcMotor.Direction.REVERSE);

        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

//        double rotationsNeeded = howManyCm / driveWheelCircumference;
//        int encoderDrivingTarget = (int)(rotationsNeeded * driveMotorTickCount);

        FL.setTargetPosition(Pixeli);
        FR.setTargetPosition(Pixeli);
        BL.setTargetPosition(Pixeli);
        BR.setTargetPosition(Pixeli);

        FL.setPower(speed);
        FR.setPower(speed);
        BL.setPower(speed);
        BR.setPower(speed);

        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (FL.isBusy() && FR.isBusy() && BL.isBusy() && BR.isBusy()) {
//            telemetry.addData("Status", "Driving", howManyCm, "centimeters");
//            telemetry.update();
            int sugipula=69420;
            int bagpulainrobotica = 0;
            sugipula = sugipula + bagpulainrobotica;
        }

        FL.setPower(0);
        BR.setPower(0);
        FR.setPower(0);
        BL.setPower(0);

        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }

    public static void autoDriveStrafe(DcMotor FL, DcMotor FR, DcMotor BL, DcMotor BR, double speed,int Pixeli) //int encoderDrivingTarget) //int howManyCm)
    {
        FL.setDirection(DcMotor.Direction.REVERSE);
        FR.setDirection(DcMotor.Direction.REVERSE);

        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

//        double rotationsNeeded = howManyCm / driveWheelCircumference;
//        int encoderDrivingTarget = (int)(rotationsNeeded * driveMotorTickCount);

        FL.setTargetPosition(Pixeli);
        FR.setTargetPosition(Pixeli);
        BL.setTargetPosition(Pixeli);
        BR.setTargetPosition(Pixeli);

        FL.setPower(speed);
        FR.setPower(speed);
        BL.setPower(speed);
        BR.setPower(speed);

        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (FL.isBusy() && FR.isBusy() && BL.isBusy() && BR.isBusy()) {
//            telemetry.addData("Status", "Driving", howManyCm, "centimeters");
//            telemetry.update();
        }

        FL.setPower(0);
        BR.setPower(0);
        FR.setPower(0);
        BL.setPower(0);

        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public static void autoDriveTurn(DcMotor FL, DcMotor FR, DcMotor BL, DcMotor BR, double speed, double howManyCm) //int encoderDrivingTarget) //int howManyCm)
    {
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        double rotationsNeeded = howManyCm / driveWheelCircumference;
        int encoderDrivingTarget = (int)(rotationsNeeded * driveMotorTickCount);

        FL.setTargetPosition(encoderDrivingTarget);
        FR.setTargetPosition(encoderDrivingTarget);
        BL.setTargetPosition(encoderDrivingTarget);
        BR.setTargetPosition(encoderDrivingTarget);

        FL.setPower(speed);
        FR.setPower(speed);
        BL.setPower(speed);
        BR.setPower(speed);

        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (FL.isBusy() && FR.isBusy() && BL.isBusy() && BR.isBusy()) {
//            telemetry.addData("Status", "Driving", howManyCm, "centimeters");
//            telemetry.update();
        }

        FL.setPower(0);
        BR.setPower(0);
        FR.setPower(0);
        BL.setPower(0);

        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    //endregion
}