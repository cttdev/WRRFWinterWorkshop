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

  private final ArmFeedforward m_feedforward = new ArmFeedforward(0, -0.075, 0);

  private final TalonEncoder m_encoder;

  private double m_setpoint;

  public MotionProfiledArm() {
    super(new ProfiledPIDController(0.0007, 0, 0,
        new TrapezoidProfile.Constraints(4000, 1000)));

    m_leftMotor.setInverted(true);
    m_rightMotor.set(ControlMode.Follower, 2);

    m_encoder = new TalonEncoder(m_rightMotor);

    m_encoder.setDistancePerPulse((2 * Math.PI) / 10240);
  }

  @Override
  public void useOutput(double output, State setpoint) {
    double feedforward = m_feedforward.calculate(setpoint.position, setpoint.velocity);
    m_leftMotor.set(output );
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

