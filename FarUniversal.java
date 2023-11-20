
// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.eventloop.opmode.Disabled;
// import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
// import org.firstinspires.ftc.vision.tfod.TfodProcessor;
// import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
// import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
// import org.firstinspires.ftc.vision.VisionPortal;
// import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
// import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.util.ElapsedTime;

// // import hardware defenitions
// import org.firstinspires.ftc.teamcode.Hardware;

// /*
//  * This file contains an example of a Linear "OpMode".
//  * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
//  * The names of OpModes appear on the menu of the FTC Driver Station.
//  * When a selection is made from the menu, the corresponding OpMode is executed.
//  *
//  * This particular OpMode illustrates driving a 4-motor Omni-Directional (or Holonomic) robot.
//  * This code will work with either a Mecanum-Drive or an X-Drive train.
//  * Both of these drives are illustrated at https://gm0.org/en/latest/docs/robot-design/drivetrains/holonomic.html
//  * Note that a Mecanum drive must display an X roller-pattern when viewed from above.
//  *
//  * Also note that it is critical to set the correct rotation direction for each motor.  See details below.
//  *
//  * Holonomic drives provide the ability for the robot to move in three axes (directions) simultaneously.
//  * Each motion axis is controlled by one Joystick axis.
//  *
//  * 1) Axial:    Driving forward and backward               Left-joystick Forward/Backward
//  * 2) Lateral:  Strafing right and left                     Left-joystick Right and Left
//  * 3) Yaw:      Rotating Clockwise and counter clockwise    Right-joystick Right and Left
//  *
//  * This code is written assuming that the right-side motors need to be reversed for the robot to drive forward.
//  * When you first test your robot, if it moves backward when you push the left stick forward, then you must flip
//  * the direction of all 4 motors (see code below).
//  *
//  * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
//  * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
//  */
//  @Autonomous(name="ParkFarUniversal", group="AprilTag")

// public class FarUniversal extends LinearOpMode {
//     @Override
//     public void runOpMode() {
        
//         Hardware robot = new Hardware(this);
//         robot.init();

//         // Wait for the game to start (driver presses PLAY)
//         telemetry.addData("Status", "Initialized");
//         telemetry.update();
        
//         //Initalize camera
//         AprilTagProcessor myATBrain;
//         myATBrain=new AprilTagProcessor.Builder()
//             .setTagLibrary(AprilTagGameDatabase.getCurrentGameTagLibrary())
//             .setDrawTagID(true)
//             .setDrawTagOutline(true)
//             .setDrawAxes(true)
//             .setDrawCubeProjection(true)
//             .build();
            
//         TfodProcessor myTfodProcessor;

//         myTfodProcessor = new TfodProcessor.Builder()
//             .setMaxNumRecognitions(10)
//             .setUseObjectTracker(true)
//             .setTrackerMaxOverlap((float) 0.2)
//             .setTrackerMinSize(16)
//             .build();
    
//         VisionPortal myATEye;
//         myATEye=new VisionPortal.Builder()
//             .setCamera(hardwareMap.get(WebcamName.class, "ATEyeball"))
//             .addProcessor(myATBrain)
//             .setCameraResolution(new Size(640,480))
//             .setStreamFormat(VisionPortal.StreamFormat.YUY2)
//             .enableCameraMonitoring(true)
//             .setAutoStopLiveView(true)
//             .build();
            
//         waitForStart();
        
        
//     }

//     float[] locate() { // Returns x, y, rotation
//         double[] radii = {0.0,0.0,0.0};
//         int[] tags = {-1,-1,-1};
//         int index = 0;
//         List<AprilTagDetection> myAprilTagDetections; //list of all detections
//         AprilTagDetection myAprilTagDetection;        //current detection in for() loop
//         int myAprilTagIdCode;                         // ID code of current detection, in for() Loop
        
//         //Get a list of AprilTag detections.
//         myAprilTagDetections = myATBrain.getDetections();
        
//         // Cycle throught the list and process each april tag.
//         for (AprilTagDetection myAprilTagDetection : myAprilTagDetections) {
            
//             if (myAprilTagDetection.metadata != null && index<3) { //This checks for non-null Metadata is not needed for reading only ID code.
//                 myAprilTagIdCode = myAprilTagDetection.id;
//                 double[] xyz = {myAprilTagDetection.ftcPose.x, myAprilTagDetection.ftcPose.y, myAprilTagDetection.ftcPose.z};
//                 double radius = Math.pow(Math.pow(xyz[0],2) + Math.pow(xyz[1],2),0.5);
//                 if(radius != 0) {
//                     radii[index] = radius;
//                     tags[index] = myAprilTagIdCode; 
//                     index++;
                    
//                 }
//             }
//         }
//         double d = 0;
//         double l = 0;
//         double h = 0;
//         for(int pass = 0; pass<3; pass++) {
//             int[] x = { 0, aprils[tags[pass][0]], aprils[tags[(pass+1)%3][0]]};
//             int[] y = { 0, aprils[tags[pass][1]], aprils[tags[(pass+1)%3][1]]};
//             int[] r = { 0, radii[pass], radii[(pass+1)%3]};
//             d = Math.sqrt(Math.pow(x[1] - x[2],2) + Math.pow(y[1] - y[2],2));
//             l = (Math.pow(r[1],2) - Math.pow(r[2],2) + Math.pow(d,2))/(2*d);
//             h = Math.sqrt(Math.pow(r[1],2) - Math.pow(l,2));
            
//             x[0] = (l/d)*(x[2] - x[1]) + (h/d)*(y[2] - y[1]) +x[1];
//             y[0] = (l/d)*(y[2] - y[1]) - (h/d)*(x[2] - x[1]) +y[1];
//             if(x[0]>field || y[0]>field || x[0]<0 || y[0]<0) {
//                 x[0] = (l/d)*(x[2] - x[1]) - (h/d)*(y[2] - y[1]) +x[1];
//                 y[0] = (l/d)*(y[2] - y[1]) + (h/d)*(x[2] - x[1]) +y[1];
//             }
            
//         }
        
//     } 
//     // todo: write your code here
// }
// /*
// https://math.stackexchange.com/questions/256100/how-can-i-find-the-points-at-which-two-circles-intersect


// */