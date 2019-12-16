package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Hook;
import frc.robot.subsystems.Slider;

public class PlaceHatch extends SequentialCommandGroup {
  private final Hook m_hook;
  private final Slider m_slider;

  public PlaceHatch(Hook hook, Slider slider) {
    m_hook = hook;
    m_slider = slider;

    addCommands(
      new InstantCommand(m_slider::extendSlider, m_slider),
      new WaitCommand(1),
      new InstantCommand(m_hook::openHook, m_hook),
      new WaitCommand(1),
      new InstantCommand(m_slider::retractSlider, m_slider)
    );
  }
}
