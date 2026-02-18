package org.firstinspires.ftc.teamcode.auton;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shoot {
    private DcMotor outtake1;
    private DcMotor outtake2;

    public Shoot(HardwareMap hardwareMap) {
        outtake1 = hardwareMap.get(DcMotor.class, "push");
        outtake2 = hardwareMap.get(DcMotor.class, "pushSmallWheels");

        outtake1.setDirection(DcMotorSimple.Direction.FORWARD);
        outtake2.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public Action shoot() {
        return new Action() {

            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    outtake1.setPower(0.85);
                    outtake2.setPower(0.85);
                    initialized = true;
                }
                return true;
            }
        };
    }
    public Action stop() {
        return new Action() {

            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    outtake1.setPower(0);
                    outtake2.setPower(0);
                    initialized = true;
                }
                return true;
            }
        };
    }
}
