/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hook extends SubsystemBase {
  private final DoubleSolenoid m_hook = new DoubleSolenoid(0, 4);

  public Hook() {
    super();

    addChild("Hook", m_hook);
    
  }

  public void openHook() {
    m_hook.set(Value.kReverse);
  }

  public void closeHook() {
    m_hook.set(Value.kForward);
  }
}
