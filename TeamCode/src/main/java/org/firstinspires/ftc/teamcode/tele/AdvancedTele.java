package org.firstinspires.ftc.teamcode.tele;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Basic: Iterative OpMode Practice", group="Iterative Opmode")
public class AdvancedTele extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    // TODO: Declare motors and servos here
    // Example: private DcMotor frontLeft;

    // TODO: Set any constant values here, if necessary
    // Example: private final double MAX_POWER = 1.0;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");

        // TODO: Initialize motors and servos here
        // Hint: Use hardwareMap.get() method
        // Example: frontLeft = hardwareMap.get(DcMotor.class, "front_left_motor");

        // TODO: Set motor directions and modes here.
        // Hint: You'll have to reverse some motors to drive straight -- you can figure out which ones through trial and error!
        // Hint: Use motor.setDirection() and motor.setMode() methods

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {
        // This is optional: Here we add any code that needs to run repeatedly during initialization
    }

    @Override
    public void start() {
        runtime.reset();
        // This is optional: Here we add code to be run once when the PLAY button is hit
    }

    @Override
    public void loop() {
        // TODO: Add code to get input from the controller
        // Hint: Use gamepad1 and gamepad2 for controls
        // Example: double drive = gamepad1.left_stick_y;

        // TODO: Calculate the power for each robot motor
        // Ex: To turn right, increase power to left motors and decrease to right motors
        // Ex: double leftPower = drive + turn;

        // TODO: Set the calculated power to the motors
        // Hint: Use setPower() method on each motor

        telemetry.addData("Status", "Running for: " + runtime.toString());
        // Example: telemetry.addData("Motor Power", frontLeft.getPower());
    }

    @Override
    public void stop() {
        // TODO: Stop all motors and any additional components
        // Hint: Set all motor powers to 0
    }
}