package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Storage
{ private final Servo;

    public Lift(HardwareMap){
        liftMotor = hardwareMap.get(Dcmotor.class, "liftMotor");
    }
}
