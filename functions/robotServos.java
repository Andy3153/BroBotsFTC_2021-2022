package org.firstinspires.ftc.teamcode.functions;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.teamcode.functions.constants.armMinPos;
import static org.firstinspires.ftc.teamcode.functions.constants.armMaxPos;
import static org.firstinspires.ftc.teamcode.functions.constants.clawMinPos;
import static org.firstinspires.ftc.teamcode.functions.constants.clawMaxPos;

public class robotServos {
    public static void useServos(Servo servo1, Servo servo2, float position)
    {
        servo1.setPosition(position);
        servo2.setPosition(1 - position);
    }

//    public static float armPos(float posIncrement, Gamepad gamepad) {
//        float clawPos = 0f;
//
//        if (gamepad.dpad_up)
//            if (clawPos > armMaxPos - posIncrement)
//                clawPos = armMaxPos;
//            else clawPos = clawPos + posIncrement;
//
//        else if (gamepad.dpad_down)
//            if (clawPos < armMinPos + posIncrement)
//                clawPos = armMinPos;
//            else clawPos = clawPos - posIncrement;
//
//        return clawPos;
//    }
//
//    public static float clawPos(float posIncrement, Gamepad gamepad)
//    {
//        float clawPos = -1f;
//
//        if(gamepad.dpad_right)
//            if(clawPos > clawMaxPos - posIncrement)
//                clawPos = clawMaxPos;
//            else clawPos = clawPos + posIncrement;
//
//        else if(gamepad.dpad_left)
//            if(clawPos < clawMinPos + posIncrement)
//                clawPos = clawMinPos;
//            else clawPos = clawPos - posIncrement;
//
//        return clawPos;
//    }

    public static void useClaw(Servo clawL, Servo clawR, Servo armL, Servo armR, Gamepad gamepad){
        if(gamepad.dpad_left)
        {
            useServos(armL, armR, armMaxPos);
            useServos(clawL, clawR, clawMinPos);
        }
        else if(gamepad.dpad_right)
        {
            useServos(armL, armR, (armMinPos + 0.05f));
            useServos(clawL, clawR, clawMaxPos);
        }
    }

    public static void useArm(Servo armL, Servo armR, Gamepad gamepad){
        if(gamepad.dpad_up)
        {
            useServos(armL, armR, armMaxPos);
        }
        else if(gamepad.dpad_down)
        {
            useServos(armL, armR, armMinPos);
        }
    }
}