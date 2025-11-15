package org.firstinspires.ftc.teamcode.tele;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.ArrayList;
import java.util.Arrays;

@TeleOp(name="Basic: Iterative OpMode Practice", group="Iterative Opmode")
public class AdvancedTele extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    // TODO: Declare motors and servos here
    // Example: private DcMotor frontLeft;
    private DcMotor frontLeft, frontRight, backLeft, backRight, ballSucker;

    boolean firstPressGamepadA = true;
    double ballSuckerPower = 0;

    // TODO: Set any constant values here, if necessary
    // Example: private final double MAX_POWER = 1.0;

    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");

        // TODO: Initialize motors and servos here
        // Hint: Use hardwareMap.get() method
        // Example: frontLeft = hardwareMap.get(DcMotor.class, "front_left_motor");
        frontLeft = hardwareMap.get(DcMotor.class, "fl");
        frontRight = hardwareMap.get(DcMotor.class, "fr");
        backLeft = hardwareMap.get(DcMotor.class, "bl");
        backRight = hardwareMap.get(DcMotor.class, "br");
        ballSucker = hardwareMap.get(DcMotor.class, "intake");

        // TODO: Set motor directions and modes here.
        // Hint: You'll have to reverse some motors to drive straight -- you can figure out which ones through trial and error!
        // Hint: Use motor.setDirection() and motor.setMode() methods
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ballSucker.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontRight.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        ballSucker.setDirection(DcMotor.Direction.REVERSE);

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
        double drive = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;

        // TODO: Calculate the power for each robot motor
        // Ex: To turn right, increase power to left motors and decrease to right motors
        // Ex: double leftPower = drive + turn;
        double frontLeftPower = drive - turn - strafe;
        double backLeftPower = drive - turn + strafe;
        double frontRightPower = drive + turn + strafe;
        double backRightPower = drive + turn - strafe;


        if (gamepad1.a) {
            if (firstPressGamepadA) {
                if (ballSuckerPower == 0) {
                    ballSuckerPower = 1;
                } else {
                    ballSuckerPower = 0;
                }
            }
            firstPressGamepadA = false;
        }

        if (!gamepad1.a) {
            firstPressGamepadA = true;
        }

        // TODO: Set the calculated power to the motors
        // Hint: Use setPower() method on each motor
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
        ballSucker.setPower(ballSuckerPower);

        telemetry.addData("Status", "Running for: " + runtime.toString());
        telemetry.addData("FL power", frontLeft.getPower());
        telemetry.addData("FR power", frontRight.getPower());
        telemetry.addData("BL power", backLeft.getPower());
        telemetry.addData("BR power", backRight.getPower());
        telemetry.addData("Intake power", ballSuckerPower);
        // Example: telemetry.addData("Motor Power", frontLeft.getPower());
    }

    @Override
    public void stop() {
        // TODO: Stop all motors and any additional components
        // Hint: Set all motor powers to 0
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
}