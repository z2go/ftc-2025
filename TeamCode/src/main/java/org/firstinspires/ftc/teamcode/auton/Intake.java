package org.firstinspires.ftc.teamcode.auton;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.*;

class Intake {
    private DcMotor intake;
    private DcMotor midtake;

    public Intake(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotor.class, "ballsucker");
        midtake = hardwareMap.get(DcMotor.class, "midtake");

        intake.setDirection(DcMotorSimple.Direction.REVERSE);
        midtake.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public Action spinUp() {
        return new Action() {

            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    intake.setPower(1);
                    midtake.setPower(1);
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
                    intake.setPower(0);
                    midtake.setPower(0);
                    initialized = true;
                }
                return true;
            }
        };
    }
}
