package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private final DcMotor IntakeMotor;

    public Intake(HardwareMap hardwareMap){
        IntakeMotor = hardwareMap.get(DcMotor.class, "IntakeMotor");

        IntakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        IntakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        IntakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    public void moveIntake(double speed) {IntakeMotor.setPower(speed);
    }
}
