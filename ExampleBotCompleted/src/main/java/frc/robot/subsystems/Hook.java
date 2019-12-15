package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hook extends SubsystemBase {
  private final DoubleSolenoid m_hook = new DoubleSolenoid(0, 4);

  public Hook() {}

  public void openHook() {
    m_hook.set(Value.kReverse);
  }

  public void closeHook() {
    m_hook.set(Value.kForward);
  }
}
