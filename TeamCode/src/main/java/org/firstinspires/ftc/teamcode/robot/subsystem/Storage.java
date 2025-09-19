package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Storage {
    private final CRServo left;

    public Storage(HardwareMap hardwareMap){
        left = hardwareMap.get(CRServo.class, "leftServo");
    }
}
