// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.hardware.Servo;
// import java.lang.annotation.Target;
// import com.qualcomm.robotcore.util.ElapsedTime;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import java.util.Locale;
// import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
// import com.qualcomm.robotcore.eventloop.opmode.OpMode;
// import java.util.Stack;
// import com.qualcomm.robotcore.hardware.ServoImplEx;
// import com.qualcomm.robotcore.hardware.DcMotorController;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.util.Hardware;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.util.Range;

// import org.firstinspires.ftc.teamcode.hardware.MotorHardware;
// import org.firstinspires.ftc.teamcode.hardware.SensorHardware;
// import org.firstinspires.ftc.teamcode.hardware.ArmMotorHardware;
// import org.firstinspires.ftc.teamcode.hardware.ServoHardware;
// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

// @Autonomous(name="MecanumForward", group="Crimson")

// public class MecanumForwardAuto extends LinearOpMode {
    
//     public DcMotor  FrontRight  = null;
//     public DcMotor  FrontLeft  = null;
//     public DcMotor  BackRight  = null;
//     public DcMotor  BackLeft  = null;
//     public DcMotor  Lift  = null;
    
//     public Servo Hand = null;

//     @Override
//     public void runOpMode() {
//         FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
//         FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
//         BackRight = hardwareMap.get(DcMotor.class, "BackRight");
//         BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
//         Lift = hardwareMap.get(DcMotor.class, "Lift");
        
//         Hand = hardwareMap.get(Servo.class, "Hand");
        
//         FrontRight.setPower(1.0);
//         FrontLeft.setPower(-1.0);
//         BackLeft.setPower(-1.0);
//         BackRight.setPower(1.0);
//         sleep(2000);
        
//         FrontRight.setPower(0.0);
//         FrontLeft.setPower(0.0);
//         BackLeft.setPower(0.0);
//         BackRight.setPower(0.0);
//     }
// }