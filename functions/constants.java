package org.firstinspires.ftc.teamcode.functions;

public class constants {
    public static final float clawMinPos = 0.55f,
                              clawMaxPos = 1f,
                              armMinPos = 0f,
                              armMaxPos = 1f;

    public static final double driveMotorTickCount = 538; // goBILDA chassis motor ticks ~ 537.7 PPR ((((1 + (46 / 17))) * (1 + (46 / 11))) * 28)
    public static final double driveWheelDiameter = 9.6; // goBILDA mecanum wheel diameter
    public static final double driveWheelCircumference = 3.14 * driveWheelDiameter; // goBILDA wheel circumference (pi * diameter)
}
