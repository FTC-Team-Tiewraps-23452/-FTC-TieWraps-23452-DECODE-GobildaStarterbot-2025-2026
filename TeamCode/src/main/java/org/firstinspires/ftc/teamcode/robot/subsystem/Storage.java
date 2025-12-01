package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Storage {

    private final Servo storageServo;
    private ColorSensor colorSensor;


    public Storage(HardwareMap hardwareMap){
        storageServo = hardwareMap.get(Servo.class, "storageServo");
        storageServo.setDirection(Servo.Direction.FORWARD);
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
    }

    public void moveStorage(double position){
        storageServo.setPosition(position);
    }

    public boolean ballSensor(){

        if ((colorSensor.red()>45)||(colorSensor.green()>45)||(colorSensor.blue()>45)){
            return true;
        }else{
            return false;
        }
    }
}