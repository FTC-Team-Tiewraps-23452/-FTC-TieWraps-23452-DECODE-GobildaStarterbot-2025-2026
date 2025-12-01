//package org.firstinspires.ftc.teamcode.robot.subsystem;
//
//import com.qualcomm.robotcore.hardware.CRServo;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//public class Storage {
//    private final CRServo storageLeft;
//    private final CRServo storageRight;
//
//    public Storage(HardwareMap hardwareMap){
//        storageLeft = hardwareMap.get(CRServo.class, "storageLeft");
//        storageRight = hardwareMap.get(CRServo.class, "storageRight");
//        storageLeft.setDirection(CRServo.Direction.FORWARD);
//        storageRight.setDirection(CRServo.Direction.REVERSE);
//    }
//
//    public void moveStorage(double speed) {
//        storageLeft.setPower(speed);
//    }
//
//    public double dataStorageCRServo(){
//        return storageLeft.getPower();
//    }
//}