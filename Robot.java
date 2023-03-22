// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.motorcontrol.Spark;
//import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  private WPI_TalonFX leftMaster = new WPI_TalonFX(0);
  private WPI_TalonFX rightMaster = new WPI_TalonFX(01);
  private WPI_TalonFX leftSlave = new WPI_TalonFX(02);
  private WPI_TalonFX rightSlave = new WPI_TalonFX(03);
  private DifferentialDrive drive =new DifferentialDrive(leftMaster, rightMaster);

  private Joystick joy1 = new Joystick(0);
  @Override
  public void robotInit() {
    leftMaster.setInverted(true);
    rightMaster.setInverted(true );
    
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);

    leftSlave.setInverted(TalonFXInvertType.FollowMaster);
    rightSlave.setInverted(TalonFXInvertType.FollowMaster);

    drive.setDeadband(.05);
    
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    double speed = -joy1.getRawAxis(1); 
    double turn = joy1.getRawAxis(4);
    
    drive.arcadeDrive(speed * 6, turn* .4);

    //leftMaster.set(left);
    //leftMotor2.set (left);
    //rightMaster.set (-right);
    //rightMotor2.set (-right);

  }
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
