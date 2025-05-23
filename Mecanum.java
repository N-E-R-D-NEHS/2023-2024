/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

// import hardware defenitions
import org.firstinspires.ftc.teamcode.Hardware;


/*
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When a selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

@TeleOp(name="Mecanum", group="Hinsins")

public class Mecanum extends LinearOpMode {
    
    @Override
    public void runOpMode() {
        Hardware robot = new Hardware(this);
        robot.init();
        
        double driveForwardBackwards = 0.0;
        double driveRightLeft        = 0.0;
        double rotateRightLeft       = 0.0;
        
        double armWristAngle = 0.0;
        
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            double initialFingerAngle = robot.getArmWristAngle();
            
            // get input from controller
            driveForwardBackwards = -gamepad1.left_stick_y;
            driveRightLeft = gamepad1.left_stick_x;
            rotateRightLeft = gamepad1.right_stick_x;
            
            double finalFingerAngle = 0.0;

            if (gamepad1.a == true) {
                armWristAngle = armWristAngle + 0.1;

            }
            if (gamepad1.b == true) {
                armWristAngle = armWristAngle - 0.1;
                
            }
            
            if (armWristAngle > 1) {
                armWristAngle = 1;
            }
            
            if (armWristAngle < 0) {
                armWristAngle = 0;
            }
            
            robot.setArmWristAngle(armWristAngle);
            robot.driveRobot(driveForwardBackwards, driveRightLeft, rotateRightLeft);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Motors", "DriveForwardBackwards (%.2f)", driveForwardBackwards);
            telemetry.addData("Arm Shoulder (%.2f)", robot.getArmShoulderAngle());
            telemetry.addData("Arm Elbow (%.2f)", robot.getArmElbowAngle());
            telemetry.addData("Arm Wrist (%.2f)", robot.getArmWristAngle());
            telemetry.addData("Arm Finger (%.2f)", robot.getArmFingerAngle());
            telemetry.update();
            sleep(50);
        }
    }
}
