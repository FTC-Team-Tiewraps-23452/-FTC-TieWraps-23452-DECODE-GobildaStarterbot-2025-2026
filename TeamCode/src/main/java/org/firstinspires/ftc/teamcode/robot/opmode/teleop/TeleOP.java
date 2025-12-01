package org.firstinspires.ftc.teamcode.robot.opmode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

//import org.firstinspires.ftc.teamcode.robot.subsystem.MecanumDrivetrain;
import org.firstinspires.ftc.teamcode.robot.subsystem.Oefening;
//import org.firstinspires.ftc.teamcode.robot.subsystem.Storage;


@TeleOp(name="TeleOP-IntoTheDeep-", group="Iterative Opmode")
public class TeleOP extends OpMode {
    private final ElapsedTime runtime = new ElapsedTime();

//    private MecanumDrivetrain mecanumDrivetrain;
//    private Storage storage;
    private Oefening oefening;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");

//        mecanumDrivetrain = new MecanumDrivetrain(hardwareMap);
//        storage = new Storage(hardwareMap);
        oefening = new Oefening(hardwareMap);

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
//      if (gamepad1.left_bumper){
//          double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
//          double x = gamepad1.left_stick_x;
//          double rx = -gamepad1.right_stick_x;
//          mecanumDrivetrain.mecanumDrive(x, y, rx);
//      } else {
//          double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
//          double x = gamepad1.left_stick_x;
//          double rx = -gamepad1.right_stick_x;
//          mecanumDrivetrain.mecanumDrive(x / 4,y / 4,rx / 4);
//      }
//
//      if(gamepad1.right_bumper){
//          storage.moveStorage(0.5);
//          // samen met shooter
//      } else {
//          storage.moveStorage(0);
//      }
//
//      if(gamepad1.a) {
//          oefening.turnmotor(0.5);
//      } else if (gamepad1.b) {
//          oefening.turnmotor(-0.5);
//      } else {
//          oefening.turnmotor(0);
//      }

//        telemetry.addData("current positie van testmotor", oefening.data());
        telemetry.addData("ColorSensor", "red" + oefening.dataColorSensor()[0]);
        telemetry.addData("ColorSensor", "green" + oefening.dataColorSensor()[1]);
        telemetry.addData("ColorSensor", "blue" + oefening.dataColorSensor()[2]);
        telemetry.addData("ColorSensor", "alpha" + oefening.dataColorSensor()[3]);
        telemetry.addData("ColorSensor", "argb" + oefening.dataColorSensor()[4]);

        telemetry.addData("Status", "Run Time: " + runtime.toString());
//        telemetry.addData("storageCRServo", "Power:" + storage.dataStorageCRServo());
    }

    @Override
    public void stop() {
    }

}