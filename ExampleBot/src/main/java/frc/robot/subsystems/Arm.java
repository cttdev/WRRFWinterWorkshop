package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.wrappers.TalonEncoder;

public class Arm extends PIDSubsystem {
  private final WPI_TalonSRX m_leftMotor = new WPI_TalonSRX(2);
  private final WPI_TalonSRX m_rightMotor = new WPI_TalonSRX(3); 

  private final TalonEncoder m_encoder;


  public Arm() {
    super(null);

    m_encoder = null;
  }

  @Override
  public void useOutput(double output) {
  }

  @Override
  public double getSetpoint() {
    return 0.0;
  }

  @Override
  public double getMeasurement() {
    return 0.0;
  }

}

