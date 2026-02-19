package org.firstinspires.ftc.teamcode.auton;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.IMU;
import static java.lang.Math.tan;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@Autonomous(name="Limelight_Test", group="Iterative Opmode")
public class AprilTagLimelightTest extends OpMode{
    private Limelight3A limelight;
    private double distanceT;
    private double alpha;

    //IN INCHES AND DEGREES
<<<<<<< HEAD
    private double LLheight = 12; //HEIGHT OF THE LIMELIGHT ON THE ROBOT
    private double TargetHeight = 29.5; //HEIGHT OF THE TARGET
=======
    private double LLheight = 20; //HEIGHT OF THE LIMELIGHT ON THE ROBOT
    private double TargetHeight = 32; //HEIGHT OF THE TARGET
>>>>>>> b0edf561cda5997b00a252cf514c42b80e1cb067
    private double LLAngle = 10; //Angle that the limelight is mounted at
    private double convertToDegrees = 3.14159/180.0;

    private IMU imu;
    @Override
    public void init(){
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        //pick the lime light pipeline needed for this alliance
<<<<<<< HEAD
        limelight.pipelineSwitch(0);
=======
        limelight.pipelineSwitch(8);
>>>>>>> b0edf561cda5997b00a252cf514c42b80e1cb067
        imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot revHubOrientationOnRobot = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
        imu.initialize(new IMU.Parameters(revHubOrientationOnRobot));

    }

    @Override
    public void start(){
        limelight.start();
    }

    @Override
    public void loop(){
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
        limelight.updateRobotOrientation(orientation.getYaw());
        LLResult llresult = limelight.getLatestResult();
        if(llresult !=null && llresult.isValid()){
            Pose3D botPose = llresult.getBotpose_MT2();
            telemetry.addData("Tx", llresult.getTx());
            telemetry.addData("Ty", llresult.getTy());
            telemetry.addData("Ta", llresult.getTa());

<<<<<<< HEAD

            double x = botPose.getPosition().x;
            double y = botPose.getPosition().y;
            telemetry.addData("x pos", x);
            telemetry.addData("y pos ", y);

            double distance = Math.hypot(x, y);

            telemetry.addData("Tag Distance", distance);
=======
            // calculating distance to the target:
            alpha = llresult.getTy();
            distanceT = (TargetHeight - LLheight)/tan((alpha + LLAngle*convertToDegrees));
            telemetry.addData("Distance to Target", distanceT);

>>>>>>> b0edf561cda5997b00a252cf514c42b80e1cb067

        }
    }

}