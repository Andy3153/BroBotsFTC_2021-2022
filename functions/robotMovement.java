package org.firstinspires.ftc.teamcode.functions;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

// Our code *communism*
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.functions.constants.dickSize;
import static org.firstinspires.ftc.teamcode.functions.constants.driveMotorTickCount;
import static org.firstinspires.ftc.teamcode.functions.constants.driveWheelCircumference;

public class robotMovement
{
    //region Mecanum movement
    public static void driveMove(DcMotor FL, DcMotor FR, DcMotor BL, DcMotor BR, float speed)
    {
        FL.setPower(-speed);
        FR.setPower(speed);
        BL.setPower(-speed);
        BR.setPower(speed);
    }

    public static void driveStrafe(DcMotor FL, DcMotor FR, DcMotor BL, DcMotor BR, float speed)
    {
        FL.setPower(-speed);
        FR.setPower(-speed);
        BL.setPower(speed);
        BR.setPower(speed);
    }

    public static void driveTurn(DcMotor FL, DcMotor FR, DcMotor BL, DcMotor BR, float speed)
    {
        FL.setPower(-speed);
        FR.setPower(-speed);
        BL.setPower(-speed);
        BR.setPower(-speed);
    }

    public static void driveZero(DcMotor FL, DcMotor FR, DcMotor BL, DcMotor BR)
    {
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
    }
    //endregion

    //region Autonomous

    /*
     * Steps:
     *
     * 1. Stop and reset encoders
     * 2. Set the target position
     * 3. Set the desired power
     * 4. Set motors to run to set position
     * 5. Make robot wait while motors are running
     * 6. Stop and reset encoders again
     *
     * TIPS:
     * - you can get position with motor.getTargetPosition;
     */

    public static void autoDriveMovev2(DcMotorEx FL, DcMotorEx FR, DcMotorEx BL, DcMotorEx BR, double speed, int howManyCm)
    {
        //region reset tick count to 0
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //endregion

        //region calculate how many ticks are needed for the amount of centimeters given
        double rotationsNeeded = howManyCm / driveWheelCircumference;
        int encoderDrivingTarget = (int)(howManyCm / dickSize);
        //endregion

        //region make some motors go backwards if needed
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        //endregion

        //region tell the motors they should go where they need to
        FL.setTargetPosition(encoderDrivingTarget);
        FR.setTargetPosition(encoderDrivingTarget);
        BL.setTargetPosition(encoderDrivingTarget);
        BR.setTargetPosition(encoderDrivingTarget);
        //endregion

        //region set the given power to the motors
        FL.setPower(speed);
        FR.setPower(speed);
        BL.setPower(speed);
        BR.setPower(speed);
        //endregion

        //region tell the motors to go to the set position
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //endregion

        //region make code do random funny shit while motors are busy
        while (FL.isBusy() && FR.isBusy() && BL.isBusy() && BR.isBusy())
        {
            int sugipula=69;
            int bagpulainrobotica = 420;
            sugipula += bagpulainrobotica;
        }
        //endregion

        //region set the motors power to 0 since we are done
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
        //endregion

        //region reset tick count to 0 again
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //endregion
    }

    public static void autoDriveStrafev2(DcMotorEx FL, DcMotorEx FR, DcMotorEx BL, DcMotorEx BR, double speed, int howManyCm)
    {
        //region reset tick count to 0
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //endregion

        //region calculate how many ticks are needed for the amount of centimeters given
        double rotationsNeeded = howManyCm / driveWheelCircumference;
        int encoderDrivingTarget = (int)(rotationsNeeded * driveMotorTickCount);
        //endregion

        //region make some motors go backwards if needed
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        //endregion

        //region tell the motors they should go where they need to
        FL.setTargetPosition(encoderDrivingTarget);
        FR.setTargetPosition(encoderDrivingTarget);
        BL.setTargetPosition(encoderDrivingTarget);
        BR.setTargetPosition(encoderDrivingTarget);
        //endregion

        //region set the given power to the motors
        FL.setPower(speed);
        FR.setPower(speed);
        BL.setPower(speed);
        BR.setPower(speed);
        //endregion

        //region tell the motors to go to the set position
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //endregion

        //region make code do random funny shit while motors are busy
        while (FL.isBusy() && FR.isBusy() && BL.isBusy() && BR.isBusy())
        {
            int sugipula=69;
            int bagpulainrobotica = 420;
            sugipula += bagpulainrobotica;
        }
        //endregion

        //region set the motors power to 0 since we are done
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
        //endregion

        //region reset tick count to 0 again
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //endregion
    }

    public static void autoDriveTurnv2(DcMotorEx FL, DcMotorEx FR, DcMotorEx BL, DcMotorEx BR, double speed, int howManyCm)
    {
        //region reset tick count to 0
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //endregion

        //region calculate how many ticks are needed for the amount of centimeters given
        double rotationsNeeded = howManyCm / driveWheelCircumference;
        int encoderDrivingTarget = (int)(rotationsNeeded * driveMotorTickCount);
        //endregion

        //region make some motors go backwards if needed
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        //endregion

        //region tell the motors they should go where they need to
        FL.setTargetPosition(encoderDrivingTarget);
        FR.setTargetPosition(encoderDrivingTarget);
        BL.setTargetPosition(encoderDrivingTarget);
        BR.setTargetPosition(encoderDrivingTarget);
        //endregion

        //region set the given power to the motors
        FL.setPower(speed);
        FR.setPower(speed);
        BL.setPower(speed);
        BR.setPower(speed);
        //endregion

        //region tell the motors to go to the set position
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //endregion

        //region make code do random funny shit while motors are busy
        while (FL.isBusy() && FR.isBusy() && BL.isBusy() && BR.isBusy())
        {
            int sugipula=69;
            int bagpulainrobotica = 420;
            sugipula += bagpulainrobotica;
        }
        //endregion

        //region set the motors power to 0 since we are done
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
        //endregion

        //region reset tick count to 0 again
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //endregion
    }

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

        while (FL.isBusy() && FR.isBusy() && BL.isBusy() && BR.isBusy())
        {
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