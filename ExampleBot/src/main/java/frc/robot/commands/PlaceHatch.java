package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Hook;
import frc.robot.subsystems.Slider;

public class PlaceHatch extends SequentialCommandGroup {

  public PlaceHatch(Hook hook, Slider slider) {
    addRequirements(hook, slider);

    addCommands(
    );
  }
}
