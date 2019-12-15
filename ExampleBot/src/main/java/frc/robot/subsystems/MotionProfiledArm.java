package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile.State;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import frc.robot.wrappers.TalonEncoder;

public class MotionProfiledArm extends ProfiledPIDSubsystem {
  private final WPI_TalonSRX m_leftMotor = new WPI_TalonSRX(2);
  private final WPI_TalonSRX m_rightMotor = new WPI_TalonSRX(3); 

  private final ArmFeedforward m_feedforward = new ArmFeedforward(0, -0.701, 0.0216, 0.00256);

  private final TalonEncoder m_encoder;

  private double m_setpoint;

  public MotionProfiledArm() {
    super(new ProfiledPIDController(0.007, 0, 0.0001,
        new TrapezoidProfile.Constraints(6000, 2000), 0.03));

    m_leftMotor.setInverted(true);
    m_rightMotor.set(ControlMode.Follower, 2);

    getController().setTolerance(300);

    m_encoder = new TalonEncoder(m_rightMotor);

    m_encoder.setDistancePerPulse(1.0);
  }

  @Override
  public void useOutput(double output, State setpoint) {
    m_leftMotor.setVoltage(output + m_feedforward.calculate(setpoint.position * (360.0 / 10240.0), setpoint.velocity * (360.0 / 10240.0)));
  }

  @Override
  public State getGoal() {
    return new State(m_setpoint, 0.0);
  }

  @Override
  public double getMeasurement() {
    return m_encoder.getDistance();
  }

  public void setSetpoint(double setpoint) {
    m_setpoint = setpoint;
  }
}

