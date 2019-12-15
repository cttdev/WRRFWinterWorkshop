package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Slider extends SubsystemBase {
  private final DoubleSolenoid m_slider = new DoubleSolenoid(1, 5);

  public Slider() {}

  public void retractSlider() {
    m_slider.set(Value.kReverse);
  }

  public void extendSlider() {
    m_slider.set(Value.kForward);
  }
}
