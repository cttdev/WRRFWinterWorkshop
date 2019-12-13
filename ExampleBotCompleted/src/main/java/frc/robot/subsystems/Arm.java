/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class Arm extends PIDSubsystem {
  private final WPI_TalonSRX m_leftMotor = new WPI_TalonSRX(2);
  private final WPI_TalonSRX m_rightMotor = new WPI_TalonSRX(3); 

  private double m_setpoint;

  public Arm() {
    super(new PIDController(0.0004, 0, 0.00025));
    m_rightMotor.follow(m_leftMotor);
    m_rightMotor.setInverted(true);

    m_rightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    addChild("LeftMotor", m_leftMotor);
    addChild("RightMotor", m_rightMotor);
  }

  @Override
  public void useOutput(double output) {
    m_leftMotor.set(output);
  }

  @Override
  public double getSetpoint() {
    return m_setpoint;
  }

  @Override
  public double getMeasurement() {
    return m_rightMotor.getSelectedSensorPosition(0);
  }

  public void setSetpoint(double setpoint) {
    m_setpoint = setpoint;
  }
}

