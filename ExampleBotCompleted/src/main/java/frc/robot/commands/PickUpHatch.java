package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Hook;
import frc.robot.subsystems.Slider;

public class PickUpHatch extends SequentialCommandGroup {

  public PickUpHatch(Hook hook, Slider slider) {
    addRequirements(hook, slider);

    addCommands(
      new InstantCommand(hook::openHook, hook),
      new InstantCommand(slider::extendSlider, slider),
      new WaitCommand(0.5),
      new InstantCommand(hook::closeHook, hook),
      new WaitCommand(0.1),
      new InstantCommand(slider::retractSlider, slider)
    );
  }
}
