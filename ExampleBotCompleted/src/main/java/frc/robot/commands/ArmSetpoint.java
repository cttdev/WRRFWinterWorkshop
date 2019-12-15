/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.MotionProfiledArm;

public class ArmSetpoint extends CommandBase {
  MotionProfiledArm m_arm;

  private double m_setpoint;

  public ArmSetpoint(MotionProfiledArm arm, double setpoint) {
    m_arm = arm;
    m_setpoint = setpoint;
    addRequirements(m_arm);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void initialize() {
    m_arm.setSetpoint(m_setpoint);
    m_arm.enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return m_arm.getController().atSetpoint();
  }
}
