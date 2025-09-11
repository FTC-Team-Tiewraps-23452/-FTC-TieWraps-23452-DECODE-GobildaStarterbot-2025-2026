package org.firstinspires.ftc.teamcode.robot.opmode.autonomous;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Autonomous", group="Linear OpMode")
public class Autonomous extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    private IMU imu;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initializing");

        imu = hardwareMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.LEFT, RevHubOrientationOnRobot.UsbFacingDirection.UP);
        imu.initialize(new IMU.Parameters(orientationOnRobot));

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();
    }

}