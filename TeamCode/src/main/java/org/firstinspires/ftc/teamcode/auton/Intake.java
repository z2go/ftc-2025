package org.firstinspires.ftc.teamcode.auton;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.*;

class Intake {
    private DcMotor motor;

    public Intake(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, "intake");
        motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public Action spinUp() {
        return new Action() {

            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    motor.setPower(0.8);
                    initialized = true;
                }

                return true;
            }
        };
    }
}
