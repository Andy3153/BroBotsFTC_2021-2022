package org.firstinspires.ftc.teamcode.functions;

public class constants
{
    public static final float clawMinPos = 0.55f,
                              clawMaxPos = 1f,
                              armMinPos = 0.77f,
                              armMaxPos = 0.44f;

    public static final int driveMotorTickCount = 538; // goBILDA chassis motor ticks ~ 537.7 PPR ((((1 + (46 / 17))) * (1 + (46 / 11))) * 28)
    public static final double driveWheelDiameter = 9.6; // goBILDA mecanum wheel diameter
    public static final double driveWheelCircumference = Math.PI * driveWheelDiameter; // goBILDA wheel circumference (pi * diameter)
    public static final double dickSize = driveWheelCircumference / driveMotorTickCount; // cata distanta reprezitna un tick
    public static final double cmInTicks = 19; // un centimetru are atatea tikuri
}
