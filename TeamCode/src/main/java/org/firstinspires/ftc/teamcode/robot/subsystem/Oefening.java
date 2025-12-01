package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Oefening {

//    private final DcMotor testmotor;
    private final ColorSensor colorSensor;

    public Oefening(HardwareMap hardwareMap) {
//        testmotor = hardwareMap.get(DcMotor.class,"motor");
        colorSensor = hardwareMap.get(ColorSensor.class, "colorsensor" );
//        testmotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

//    public void turnmotor(double speed) {
//        testmotor.setPower(speed);
//    }
//
//    public double data() {
//        return testmotor.getCurrentPosition();
//    }

    public double[] dataColorSensor(){
        return new double[]{colorSensor.red(), colorSensor.green(), colorSensor.blue(), colorSensor.alpha(), colorSensor.argb()};
    }
}