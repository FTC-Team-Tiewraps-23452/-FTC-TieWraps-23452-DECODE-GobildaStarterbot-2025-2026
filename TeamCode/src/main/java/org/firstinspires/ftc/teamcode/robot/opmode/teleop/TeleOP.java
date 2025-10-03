package org.firstinspires.ftc.teamcode.robot.opmode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.subsystem.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.robot.subsystem.Storage;


@TeleOp(name="TeleOP-IntoTheDeep-", group="Iterative Opmode")
public class TeleOP extends OpMode {
    private final ElapsedTime runtime = new ElapsedTime();

    private MecanumDrivetrain mecanumDrivetrain;
    private Storage storage;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");

        mecanumDrivetrain = new MecanumDrivetrain(hardwareMap);
        storage = new Storage(hardwareMap);

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

      if(gamepad1.right_bumper){
          storage.moveStorage(0.5);
          // samen met shooter
      } else {
          storage.moveStorage(0);
      }

        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("storageLeft", "Power:" + storage.dataStorageCRServoLeft());
        telemetry.addData("storageRight", "Power:" + storage.dataStorageCRServoRight());
    }

    @Override
    public void stop() {
    }

}