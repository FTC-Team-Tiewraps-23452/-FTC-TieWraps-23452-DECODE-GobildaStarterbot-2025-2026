package org.firstinspires.ftc.teamcode.robot.opmode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.subsystem.Intake;
import org.firstinspires.ftc.teamcode.robot.subsystem.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.robot.subsystem.Shooter;
import org.firstinspires.ftc.teamcode.robot.subsystem.Storage;



@TeleOp(name="TeleOP-DECODE-", group="Iterative Opmode")
public class TeleOP extends OpMode {
    private final ElapsedTime runtime = new ElapsedTime();

    private MecanumDrivetrain mecanumDrivetrain;
    private Shooter shooter;
    private Storage storage;

    private Intake intake;

    private boolean bumperLToggle;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");

        mecanumDrivetrain = new MecanumDrivetrain(hardwareMap);
        shooter = new Shooter(hardwareMap);
        storage = new Storage(hardwareMap);
        intake = new Intake(hardwareMap);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        // Restart the timer
        runtime.reset();
    }


    @Override
    public void loop() {
        //drivetrain
      if (gamepad1.left_bumper){
          double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
          double x = gamepad1.left_stick_x;
          double rx = -gamepad1.right_stick_x;
          mecanumDrivetrain.mecanumDrive(x, y, rx);
      } else {
          double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
          double x = gamepad1.left_stick_x;
          double rx = -gamepad1.right_stick_x;
          mecanumDrivetrain.mecanumDrive(x / 4,y / 4,rx / 4);
      }

      //shooter
        if (gamepad1.right_bumper || gamepad1.right_trigger>=0.5){
            shooter.moveShooter(-1);
        } else {
            shooter.moveShooter(0);
        }
//
//        if (gamepad1.left_bumper & storage.ballSensor()) {
//                storage.moveStorage(0.35);
//        } else {
//            storage.moveStorage(0);
//        }
//
        if(gamepad1.left_bumper){
            bumperLToggle = true;
        }

        if (bumperLToggle){
            storage.moveStorage(0.35);
            if (!storage.ballSensor()){
                bumperLToggle = false;
            }
        } else {
            storage.moveStorage(0);
        }

        if (gamepad1.x) {
            intake.moveIntake(1);
        } else if (gamepad1.b) {
            intake.moveIntake(-1);
        }
        else {
            intake. moveIntake(0);
        }


        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("shooterMotor", "Power:" + shooter.dataShooterMotor()[0]);
        telemetry.addData("shooterMotor", "CurrentPosition:" + shooter.dataShooterMotor()[1]);

        telemetry.addData("ColorSensor", "red" + storage.dataColorSensor()[0]);
        telemetry.addData("ColorSensor", "green" + storage.dataColorSensor()[1]);
        telemetry.addData("ColorSensor", "blue" + storage.dataColorSensor()[2]);

        telemetry.addData("CurrentColor", "green" + storage.huidigeKleurgroen());
        telemetry.addData("CurrentColor", "purple" + storage.huidigeKleurpaars());
    }

    @Override
    public void stop() {
    }


}