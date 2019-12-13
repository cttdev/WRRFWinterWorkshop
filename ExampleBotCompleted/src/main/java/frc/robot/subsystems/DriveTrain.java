/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final WPI_VictorSPX m_frontLeft = new WPI_VictorSPX(1);
  private final WPI_VictorSPX m_middleLeft = new WPI_VictorSPX(2);
  private final WPI_VictorSPX m_rearLeft = new WPI_VictorSPX(3);
  private final WPI_VictorSPX m_frontRight = new WPI_VictorSPX(4);
  private final WPI_VictorSPX m_middleRight = new WPI_VictorSPX(5);
  private final WPI_VictorSPX m_rearRight = new WPI_VictorSPX(6);

  private final SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_middleLeft, m_rearLeft);
  private final SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_middleRight, m_rearRight);

  private final DifferentialDrive m_drivetrain = new DifferentialDrive(m_left, m_right);
  /**
   * Create a new drive train subsystem.
   */
  public DriveTrain() {
    super();

    // Add drivetrain to Sendable
    addChild("Drive", m_drivetrain);
  }

  /**
   * Tank style driving for the DriveTrain.
   *
   * @param left  Speed in range [-1,1]
   * @param right Speed in range [-1,1]
   */
  public void drive(double left, double right) {
    m_drivetrain.tankDrive(left, right);
  }
}
