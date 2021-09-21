package org.firstinspires.ftc.teamcode.functions;

import com.qualcomm.robotcore.hardware.Gamepad;

import static org.firstinspires.ftc.teamcode.functions.constants.armMinPos;
import static org.firstinspires.ftc.teamcode.functions.constants.armMaxPos;
import static org.firstinspires.ftc.teamcode.functions.constants.clawMinPos;
import static org.firstinspires.ftc.teamcode.functions.constants.clawMaxPos;

public class robotServos {
    public static float armPos(float posIncrement, Gamepad gamepad) {
        float clawPos = 0f;

        if (gamepad.dpad_up)
            if (clawPos > armMaxPos - posIncrement)
                clawPos = armMaxPos;
            else clawPos = clawPos + posIncrement;

        else if (gamepad.dpad_down)
            if (clawPos < armMinPos + posIncrement)
                clawPos = armMinPos;
            else clawPos = clawPos - posIncrement;

        return clawPos;
    }

    public static float clawPos(float posIncrement, Gamepad gamepad)
    {
        float clawPos = -1f;

        if(gamepad.dpad_right)
            if(clawPos > clawMaxPos - posIncrement)
                clawPos = clawMaxPos;
            else clawPos = clawPos + posIncrement;

        else if(gamepad.dpad_left)
            if(clawPos < clawMinPos + posIncrement)
                clawPos = clawMinPos;
            else clawPos = clawPos - posIncrement;

        return clawPos;
    }

//    public static void useClaw(Servo clawL, Servo clawR, Gamepad gamepad){
//        if(gamepad.dpad_left) {
//            clawL.setPosition(clawMinPos);
//            clawR.setPosition(1 - clawMinPos);
//        }
//        else if(gamepad.dpad_right) {
//            clawL.setPosition(clawMaxPos);
//            clawR.setPosition(1 - clawMaxPos);
//        }
//    }
//
//    public static void useArm(Servo armL, Servo armR, Gamepad gamepad){
//        if(gamepad.dpad_up) {
//            armL.setPosition(armMaxPos);
//            armR.setPosition(1 - armMaxPos);
//        }
//        else if(gamepad.dpad_down) {
//            armL.setPosition(armMinPos);
//            armR.setPosition(1 - armMinPos);
//        }
//    }
}