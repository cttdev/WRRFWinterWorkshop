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

    addCommands(
        new ArmSetpoint(m_arm, 3600),
        new WaitCommand(1),
        parallel(
            new TankDrive(() -> -0.5, () -> -0.5, m_drivetrain),
            new InstantCommand(() -> m_intake.setPower(0.5), m_intake)
        ).withTimeout(1),
        new ArmSetpoint(m_arm, -1800),
        new WaitCommand(2),
        new RunCommand(() -> m_intake.setPower(-0.5), m_intake).withTimeout(1)
    );
  }
  
}
