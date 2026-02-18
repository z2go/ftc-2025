package org.firstinspires.ftc.teamcode.auton;

import android.app.Notification;

import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MyActions {
    public static Action shooterShoot(HardwareMap h){
        return new Shoot(h).shoot();
    }
    public static Action shooterStop(HardwareMap h){
        return new Shoot(h).stop();
    }
}
