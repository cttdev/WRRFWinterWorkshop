package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hook;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.MotionProfiledArm;
import frc.robot.subsystems.Slider;

public class Auton extends SequentialCommandGroup {
  DriveTrain m_drivetrain;
  MotionProfiledArm m_arm;
  Slider m_slider;
  Hook m_hook;
  Intake m_intake;

  public Auton(DriveTrain drivetrain, MotionProfiledArm arm, Slider slider, Hook hook, Intake intake) {
    m_drivetrain = drivetrain;
    m_arm = arm;
    m_slider = slider;
    m_hook = hook;
    m_intake = intake;

    addRequirements(m_arm, m_slider, m_hook, m_intake);

    addCommands(
      
    );
  }
  
}
