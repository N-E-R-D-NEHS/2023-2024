package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Forward", group="Crimson")

public class MecanumForward  extends LinearOpMode {
        
    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;
    private DcMotor Lift = null;
    
    // public Servo    testServo    = null;
    public Servo    forkliftServoLeft    = null;
    public Servo    forkliftServoRight    = null;
    
    private DigitalChannel limitButton =null;

    
    @Override
    public void runOpMode() 
    {
        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        leftFrontDrive  = hardwareMap.get(DcMotor.class, "FrontLeft");
        leftBackDrive  = hardwareMap.get(DcMotor.class, "BackLeft");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "FrontRight");
        rightBackDrive = hardwareMap.get(DcMotor.class, "BackRight");
        Lift = hardwareMap.get(DcMotor.class, "Lift");
        
        // testServo = hardwareMap.get(Servo.class, "TestServo");
        forkliftServoLeft = hardwareMap.get(Servo.class, "ForkliftLeft");
        forkliftServoRight = hardwareMap.get(Servo.class, "ForkliftRight");
        
        limitButton = hardwareMap.get(DigitalChannel.class, "limitSensor");
        limitButton.setMode(DigitalChannel.Mode.INPUT);
        
       // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        
        // Pick up cone
        forkliftServoLeft.setPosition(0.89);
        sleep(1000);
        
        // Lift up arm
        Lift.setPower(1.0);
        sleep(50);
        
        // Stop Lifting arm
        Lift.setPower(0.0);
        
        // Drive
        leftFrontDrive.setPower(-1.0);
        rightFrontDrive.setPower(1.0);
        leftBackDrive.setPower(-1.0);
        rightBackDrive.setPower(1.0);
        sleep(2000);
        
        // Drive backwards
        // leftFrontDrive.setPower(1.0);
        // rightFrontDrive.setPower(-1.0);
        // leftBackDrive.setPower(1.0);
        // rightBackDrive.setPower(-1.0);
        // sleep(1000);
        
        // Stop all motors
        leftFrontDrive.setPower(0.0);
        rightFrontDrive.setPower(0.0);
        leftBackDrive.setPower(0.0);
        rightBackDrive.setPower(0.0);
        
        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}