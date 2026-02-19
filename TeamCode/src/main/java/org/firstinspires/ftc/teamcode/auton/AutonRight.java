package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;



import androidx.annotation.NonNull;

// RR-specific imports

import com.acmerobotics.roadrunner.Action;


import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name="JohnAuto", group="Autonomous")
public class AutonRight extends LinearOpMode {
    private Servo helper;
    private DcMotor outtake1;
    private DcMotor outtake2;
    private DcMotor midtake;
    private DcMotor ballSucker;

    private boolean helped;
    Pose2d beginPose;
    MecanumDrive drive;
    @Override
    public void runOpMode() {
        Pose2d beginPose = new Pose2d(0,0,0);
        MecanumDrive drive = new MecanumDrive(hardwareMap,beginPose);


        helper = hardwareMap.get(Servo.class, "helper");

        ballSucker = hardwareMap.get(DcMotor.class, "ballsucker");
        outtake1 =hardwareMap.get(DcMotor.class, "push");
        outtake2 =hardwareMap.get(DcMotor.class, "pushSmallWheels");
        midtake = hardwareMap.get(DcMotor.class, "midtake");

        ballSucker.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        midtake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        outtake1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        outtake2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        midtake.setDirection(DcMotor.Direction.REVERSE); // SPINS COUNTER CLOCKWISE
        outtake1.setDirection(DcMotor.Direction.FORWARD); //not fully sure about direction yet
        outtake2.setDirection(DcMotor.Direction.REVERSE); //not fully sure about direction yet either

        waitForStart();


        //TODO PUT YOUR AUTO CODE BELOW THIS LINE

        Action driveAway = drive.actionBuilder(beginPose)
                .lineToX(25)
                //.waitSeconds(1)
                .turn(Math.PI+0.3)
                .afterTime(0.0, Throw())
                .afterTime(3.0, Helper())
                .waitSeconds(3)
                .build();


        Actions.runBlocking(
                new SequentialAction(
                        //put the lift and claw stuff in between action 1 and 2
                        driveAway
                )
        );



    }
    public class Throw implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
           outtake1.setPower(1);
           outtake2.setPower(1);
           //packet.put("Status", "Motors Running");
           return false;
        }
    }
    public Action Throw() {
        return new Throw();

    }
    public class helper implements Action {
        public boolean run (@NonNull TelemetryPacket packet) {
            helper.setPosition(0);  as
            //packet.put("Status", "Servo Running");
            return false;
        }
    }
    public Action Helper(){
        return new helper();
    }


}
