package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private final WPI_VictorSPX m_intake = new WPI_VictorSPX(11);

  public Intake() {}

  public void setPower(double power) {
    m_intake.set(power);
  }

}
