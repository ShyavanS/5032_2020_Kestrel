/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //Assign victors
  private WPI_VictorSPX rearLeft = new WPI_VictorSPX(0);
  private WPI_VictorSPX frontLeft = new WPI_VictorSPX(1);
  private WPI_VictorSPX rearRight = new WPI_VictorSPX(2);
  private WPI_VictorSPX frontRight = new WPI_VictorSPX(3);

  //Create speed controllers
  private SpeedControllerGroup leftDrive = new SpeedControllerGroup(rearLeft, frontLeft);
  private SpeedControllerGroup rightDrive = new SpeedControllerGroup(rearRight, frontRight);

  //Create drivetrain
  private DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);

  //Assign joystick
  private Joystick stick = new Joystick(0);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }
  
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    //Drive according to joystick inputs
    if (stick.getRawButton(1)) {
      drive.arcadeDrive(-stick.getRawAxis(0) * 0.5, stick.getRawAxis(1) * 0.5);
    } else {
      drive.arcadeDrive(-stick.getRawAxis(0), stick.getRawAxis(1));
    }
  }
}
