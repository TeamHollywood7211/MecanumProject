// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

//import com.kauailabs.navx.frc.AHRS;

//import com.kauailabs.navx.frc.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


/** Add your docs here. */
public class MecanumDrivetrain extends SubsystemBase
{
    public static CANSparkMax fL1;
    public static CANSparkMax fR1;
    public static CANSparkMax bL1;
    public static CANSparkMax bR1;

    public static MecanumDrive mecDrive;
    //public static AHRS ahrs;

    public MecanumDrivetrain(){
        
        fR1 = new CANSparkMax(21, MotorType.kBrushless);
        bR1 = new CANSparkMax(22, MotorType.kBrushless);
        fL1 = new CANSparkMax(11, MotorType.kBrushless);
        bL1 = new CANSparkMax(12, MotorType.kBrushless);
        
        //ahrs = new AHRS(SPI.Port.kMXP);

        final SpeedControllerGroup frontLeft = new SpeedControllerGroup(fL1);
        frontLeft.setInverted(false);
        final SpeedControllerGroup frontRight = new SpeedControllerGroup(fR1);
        frontRight.setInverted(true);
        final SpeedControllerGroup backLeft = new SpeedControllerGroup(bL1);
        backLeft.setInverted(false);
        final SpeedControllerGroup backRight = new SpeedControllerGroup(bR1);
        backRight.setInverted(true);

        mecDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    }

    public static void driveByJoystick(){
        mecDrive.driveCartesian(returnLeftAxis(1), returnLeftAxis(0), returnRightAxis(0));
    }
    public static void driveCarte(double ySpeed, double xSpeed, double zRotation){
        mecDrive.driveCartesian(ySpeed, xSpeed, zRotation);
    }
    public static double returnLeftAxis(int leftAxis){
        double leftStick = RobotContainer.leftJoystick.getRawAxis(leftAxis);
        return leftStick;
    }
    public static double returnRightAxis(int rightAxis){
        double rightStick = RobotContainer.rightJoystick.getRawAxis(rightAxis);
        return rightStick;
    }
}