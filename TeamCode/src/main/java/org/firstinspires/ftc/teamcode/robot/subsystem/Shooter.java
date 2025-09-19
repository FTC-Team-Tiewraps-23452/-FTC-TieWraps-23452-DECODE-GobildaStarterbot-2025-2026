package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {

    private final DcMotor shooterMotor;

    public Shooter(HardwareMap hardwareMap){
        shooterMotor = hardwareMap.get(DcMotor.class, "shooterMotor");

        shooterMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shooterMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void moveShooter(double speed) {
        shooterMotor.setPower(speed);
    }

    /**
    *  Vraagt data van de shooterMotor op.
     **/
    public double[] dataShooterMotor(){
        return new double[]{shooterMotor.getPower(), shooterMotor.getCurrentPosition()};
    }
}