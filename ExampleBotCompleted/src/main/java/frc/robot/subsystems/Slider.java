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

public class Slider extends SubsystemBase {
  private final DoubleSolenoid m_slider = new DoubleSolenoid(1, 5);

  public Slider() {
    super();

    addChild("Slider", m_slider);
  }

  public void retractSlider() {
    m_slider.set(Value.kReverse);
  }

  public void extendSlider() {
    m_slider.set(Value.kForward);
  }
}
