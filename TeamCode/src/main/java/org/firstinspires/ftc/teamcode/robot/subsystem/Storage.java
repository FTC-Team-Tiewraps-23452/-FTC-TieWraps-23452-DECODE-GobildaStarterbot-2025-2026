package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Storage {
    private final CRServo storageLeft;
    private final CRServo storageRight;

    public Storage(HardwareMap hardwareMap){
        storageLeft = hardwareMap.get(CRServo.class, "storageLeft");
        storageRight = hardwareMap.get(CRServo.class, "storageRight");
        storageLeft.setDirection(CRServo.Direction.FORWARD);
        storageRight.setDirection(CRServo.Direction.REVERSE);
    }

    private void moveStorageLeft(double speed) { storageLeft.setPower(speed);}
    private void moveStorageRight(double speed) { storageRight.setPower(speed);}
    public void moveStorage(double speed) {
        moveStorageLeft(speed);
        moveStorageRight(speed);
    }
    /**
     * Vraagt data op van storage CRServo's.
    **/
    public double dataStorageCRServoLeft(){ return storageLeft.getPower();}
    public double dataStorageCRServoRight() { return storageRight.getPower();}
}