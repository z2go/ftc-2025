package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.robocol.PeerDiscoveryManager;

import org.firstinspires.ftc.teamcode.MecanumDrive;



@Autonomous(name="RedAuto", group="Iterative Opmode")
public class IntakeOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {



        Pose2d beginPose = new Pose2d(0,0,0);
        MecanumDrive drive = new MecanumDrive(hardwareMap,beginPose);


        Intake intake = new Intake(hardwareMap);
        Shoot shooter = new Shoot(hardwareMap);
        Helper helper = new Helper(hardwareMap);

        Action drive1 = drive.actionBuilder(beginPose)
                .splineTo(new Vector2d(75,0),-Math.PI/4)
                .build();

        Action drive2 = drive.actionBuilder(beginPose)
                .splineTo(new Vector2d(20,5),Math.PI/4)
                .build();



        Action wait = drive.actionBuilder(beginPose)
                        .waitSeconds(0.8).build();


        waitForStart();

        Actions.runBlocking(new SequentialAction(
                new ParallelAction(shooter.shoot(), helper.deactivate(),
                new SequentialAction(drive1,
                new ParallelAction(intake.spinUp(),
                new SequentialAction(wait,helper.activate(),wait, helper.deactivate(), wait, helper.activate(),
                        new ParallelAction(shooter.stop(),intake.stop()),drive2
                            ))))




        ));

    }
}
