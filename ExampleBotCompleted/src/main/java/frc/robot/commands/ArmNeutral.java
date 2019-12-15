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

public class ArmNeutral extends CommandBase {
  Arm m_arm;

  public ArmNeutral(Arm arm) {
    m_arm = arm;

    addRequirements(m_arm);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void initialize() {
    m_arm.setSetpoint(0.0);
    m_arm.enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }
}
