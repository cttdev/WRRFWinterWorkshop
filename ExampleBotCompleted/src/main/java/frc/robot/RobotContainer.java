/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hook;
import frc.robot.subsystems.Slider;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final XboxController m_joystick = new XboxController(0);
  public final DriveTrain m_drivetrain = new DriveTrain();
  public final Hook m_hook = new Hook();
  public final Slider m_slider = new Slider();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    m_drivetrain.setDefaultCommand(new TankDrive(() -> m_joystick.getY(Hand.kLeft), () -> m_joystick.getY(Hand.kRight), m_drivetrain));
    m_hook.setDefaultCommand(new InstantCommand(m_hook::closeHook, m_hook));
    m_slider.setDefaultCommand(new InstantCommand(m_slider::retractSlider, m_hook));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton aButton = new JoystickButton(m_joystick, 1);
    final JoystickButton bButton = new JoystickButton(m_joystick, 2);

    aButton.toggleWhenPressed(new InstantCommand(m_hook::closeHook, m_hook));
    bButton.toggleWhenPressed(new InstantCommand(m_slider::extendSlider, m_hook));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
