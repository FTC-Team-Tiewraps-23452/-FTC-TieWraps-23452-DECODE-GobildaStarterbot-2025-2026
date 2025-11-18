package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Storage {

    private final Servo storageServo;
    public Storage(HardwareMap hardwareMap){
        storageServo = hardwareMap.get(Servo.class, "storageServo");
        storageServo.setDirection(Servo.Direction.FORWARD);
    }

    public void moveStorage(double position){
        storageServo.setPosition(position);
    }

}