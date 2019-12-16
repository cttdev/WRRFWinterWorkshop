package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Hook;
import frc.robot.subsystems.Slider;

public class PickUpHatch extends SequentialCommandGroup {
  private final Hook m_hook;
  private final Slider m_slider;

  public PickUpHatch(Hook hook, Slider slider) {
    m_hook = hook;
    m_slider = slider;

    addCommands(
      new InstantCommand(m_hook::openHook, m_hook),
      new InstantCommand(m_slider::extendSlider, m_slider),
      new WaitCommand(0.5),
      new InstantCommand(m_hook::closeHook, m_hook),
      new WaitCommand(0.1),
      new InstantCommand(m_slider::retractSlider, m_slider)
    );
  }
}
