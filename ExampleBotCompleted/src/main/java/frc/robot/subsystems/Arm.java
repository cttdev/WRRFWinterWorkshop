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

  private final ArmFeedforward m_feedforward = new ArmFeedforward(3.43, 0.017, 0.0158, 0.00208);

  private double m_setpoint = 0.0;

  public Arm() {
    super(new PIDController(0.219, 0, 0.0981));

    m_leftMotor.setInverted(true);
    m_rightMotor.set(ControlMode.Follower, 2);

    m_encoder = new TalonEncoder(m_rightMotor);

    m_encoder.setDistancePerPulse((Math.PI * 2) / 10240.0);
  }

  @Override
  public void useOutput(double output) {
    System.out.println(output + m_feedforward.calculate(m_encoder.getDistance(), m_encoder.getRate()));
    m_leftMotor.setVoltage(output + m_feedforward.calculate(m_encoder.getDistance(), m_encoder.getRate()));
  }

  @Override
  public double getSetpoint() {
    return m_setpoint;
  }

  @Override
  public double getMeasurement() {
    return m_encoder.getDistance();
  }

  public void setSetpoint(double setpoint) {
    m_setpoint = setpoint;
  }
}

