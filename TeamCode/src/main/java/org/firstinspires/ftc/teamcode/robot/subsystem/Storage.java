package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Storage {

    private final Servo storageServo;
    private ColorSensor colorSensor;

    private int paarseBalTeller;

    private int groeneBallTeller;

    private boolean groenToggle;
    private boolean paarsToggle;

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

    public int paarseBalSensor(){
        if (colorSensor.blue()>55 & !paarsToggle){
             paarseBalTeller = paarseBalTeller + 1;
             paarsToggle = true;
        } else if (colorSensor.blue()>55){

        } else {
            paarsToggle = false;
        }
        return paarseBalTeller;
    }
  
    public int groeneBalSensor(){
        if (colorSensor.green()>55 & !groenToggle){
            groeneBallTeller = groeneBallTeller + 1;
            groenToggle = true;
        } else if (colorSensor.green()>55) {
        } else {
            groenToggle = false;
        }
        return groeneBallTeller;
    }
  
    public double[] dataColorSensor(){
        return new double[]{colorSensor.red(), colorSensor.green(), colorSensor.blue(), colorSensor.alpha(), colorSensor.argb()};
    }


    public boolean huidigeKleurgroen(){

        if (colorSensor.green()>55){
            return true;
        } else {
            return false;
        }
    }

    public boolean huidigeKleurpaars(){

        if ((colorSensor.blue()>55)){
            return true;
        } else {
            return false;
        }
    }
}


