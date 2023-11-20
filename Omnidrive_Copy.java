// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import java.util.Stack;
// import com.qualcomm.robotcore.hardware.ServoImplEx;
// import com.qualcomm.robotcore.hardware.DcMotorController;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.util.Hardware;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.util.Range;

// import org.firstinspires.ftc.teamcode.hardware.MotorHardware;
// import org.firstinspires.ftc.teamcode.hardware.ArmMotorHardware;
// import org.firstinspires.ftc.teamcode.utils.Movement;

// @TeleOp(name="Omnidrive2", group="Crimson")

// public class Omnidrive_Copy extends LinearOpMode {

//     /* Declare OpMode members. */
//     MotorHardware    robot           = new MotorHardware();              // Use a K9'shardware
//     ArmMotorHardware arms            = new ArmMotorHardware();
//     @Override
//     public void runOpMode() {
//         double rightX;
//         double rightY;
//         double leftX;
//         double leftY;
//         double speed = 1;
//         double rotation = 0.5;
//         double slow = -1;
//         int check = 0;
//         boolean factor = false;
//         double motor4runner = 0;
//         double motor5runner = 0;
//         double motor4elapsed = 0;
//         double motor5elapsed = 0;
        
        
//         robot.init(hardwareMap);

//         // Send telemetry message to signify robot waiting;
//         telemetry.addData("Say", "Hello Driver");    //
//         telemetry.update();

//         // Wait for the game to start (driver presses PLAY)
//         waitForStart();

//         // run until the end of the match (driver presses STOP)
//         while (opModeIsActive()) {

//             // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
//             rightX =  gamepad1.right_stick_x;
//             rightY = -gamepad1.right_stick_y;
//             leftX  =  gamepad1.left_stick_x;
//             leftY  = -gamepad1.left_stick_y;
            
            
            
//             if (Math.abs(rightX) > 0.05 || Math.abs(rightY) > 0.05)
//             {
//                 if (factor = true)
//                 {
//                     double[] motorPower = Movement.driveFunction(rightX, rightY);
//                     robot.motor0.setPower((motorPower[0]) * slow);
//                     robot.motor1.setPower((motorPower[1]) * slow);
//                     robot.motor2.setPower((motorPower[2]) * slow);
//                     robot.motor3.setPower((motorPower[3]) * slow);
//                 }
//                 else
//                 {
//                     double[] motorPower = Movement.driveFunction(rightX, rightY);
//                     robot.motor0.setPower((motorPower[0]) * speed);
//                     robot.motor1.setPower((motorPower[1]) * speed);
//                     robot.motor2.setPower((motorPower[2]) * speed);
//                     robot.motor3.setPower((motorPower[3]) * speed);
//                 }    
//             }
            
//             //Power the drive motors for rotating using the bumpers.
//             else if (gamepad1.dpad_left)
//             {
//                 if (factor = true)
//                 {
//                     robot.motor0.setPower(rotation * slow);
//                     robot.motor1.setPower(-rotation * slow);
//                     robot.motor2.setPower(rotation * slow);
//                     robot.motor3.setPower(-rotation * slow);
//                 }
//                 else
//                 {
//                     robot.motor0.setPower(rotation * speed);
//                     robot.motor1.setPower(-rotation * speed);
//                     robot.motor2.setPower(rotation * speed);
//                     robot.motor3.setPower(-rotation * speed);
//                 }
//             }
//             else if (gamepad1.dpad_right)
//             {
//                 if (factor = true)
//                 {
//                     robot.motor0.setPower(-rotation * slow);
//                     robot.motor1.setPower(rotation * slow);
//                     robot.motor2.setPower(-rotation * slow);
//                     robot.motor3.setPower(rotation * slow);
//                 }
//                 else
//                 {
//                     robot.motor0.setPower(-rotation * speed);
//                     robot.motor1.setPower(rotation * speed);
//                     robot.motor2.setPower(-rotation * speed);
//                     robot.motor3.setPower(rotation * speed);
//                 }
//             }
            
//             //returns all drive motor powers to 0 when not being used.
//             else
//             { 
//                 robot.motor0.setPower(0);
//                 robot.motor1.setPower(0);
//                 robot.motor2.setPower(0);
//                 robot.motor3.setPower(0);
//             }
//             if (gamepad1.dpad_up)
//             {
//                 speed = 1;
//             }
//             if (gamepad1.dpad_down)
//             {
//                 speed = 0.5;
//             }
//             if (gamepad1.x)
//             {
//                 rotation = 0.5;
//             }
//             if (gamepad1.b)
//             {
//                 rotation = 1;
//             }
//             if (gamepad1.y)
//             {
//               arms.motor4.setPower(1);
//               if (motor4runner == 0)
//               {
//                   motor4runner=System.currentTimeMillis();
//               }
//               motor4elapsed=System.currentTimeMillis()-motor4runner;
//             }
//             else
//             {
//                 motor4runner=0;
//             }
//             if (gamepad1.a)
//             {
//                 arms.motor5.setPower(1);
//                 if (motor5runner == 0)
//                 {
//                     motor5runner=System.currentTimeMillis();
//                 }
//                 motor5elapsed=System.currentTimeMillis()-motor5runner;
//             }
//             else
//             {
//                 motor5runner=0;
//             }
//             if (gamepad1.left_stick_button)
//             {
//                 slow = 0.2;
//                 check = 1;
//                 factor = true;
//             }
//             else 
//             {
//                 slow = 1;
//                 check = 0;
//                 factor = false;
//             }
//             double[] motorPower = Movement.driveFunction(rightX, rightY);
// /*            telemetry.addData("Speed", "%.2f", speed);
//             telemetry.addData("Slow", "%.2f", check);
//             telemetry.addData("motor0", "%.2f", motorPower[0]);
//             telemetry.addData("motor1", "%.2f", motorPower[1]);
//             telemetry.addData("motor2", "%.2f", motorPower[2]); 
//             telemetry.addData("motor3", "%.2f", motorPower[3]);*/
//             telemetry.addData("motor4 run time", ": %2.5f mS Elapsed", motor4elapsed);
//             telemetry.addData("motor5 run time", ": %2.5f mS Elapsed", motor5elapsed);
//             telemetry.update();

//             // Pause for 40 mS each cycle = update 25 times a second.
//             sleep(40);
//         }
//     }
// }
