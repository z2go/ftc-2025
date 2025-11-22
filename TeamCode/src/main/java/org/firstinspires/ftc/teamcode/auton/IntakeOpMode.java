package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="IntakeOpMode", group="Iterative Opmode")
public class IntakeOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Intake shooter = new Intake(hardwareMap);

        waitForStart();

        Actions.runBlocking(shooter.spinUp());
    }
}
