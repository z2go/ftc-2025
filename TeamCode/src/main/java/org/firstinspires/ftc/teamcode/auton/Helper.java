package org.firstinspires.ftc.teamcode.auton;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Helper {
    private Servo helper;

    public Helper(HardwareMap hardwareMap) {
        helper = hardwareMap.get(Servo.class, "helper");
    }

    public Action activate() {
        return new Action() {

            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    helper.setPosition(0.0);
                    initialized = true;
                }
                return true;
            }
        };
    }
    public Action deactivate() {
        return new Action() {

            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    helper.setPosition(0.4);
                    initialized = true;
                }
                return true;
            }
        };
    }
}
