package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends CommandBase {
  private DriveTrain m_drivetrain;
  private DoubleSupplier m_leftPower;
  private DoubleSupplier m_rightPower;

  public TankDrive(DoubleSupplier leftPower, DoubleSupplier rightPower, DriveTrain drivetrain) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    m_drivetrain = drivetrain;
    m_leftPower = leftPower;
    m_rightPower = rightPower;
    addRequirements(m_drivetrain);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    m_drivetrain.drive(m_leftPower.getAsDouble(), m_rightPower.getAsDouble());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.drive(0.0, 0.0);
  }
}
