package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final WPI_VictorSPX m_frontLeft = new WPI_VictorSPX(1);
  private final WPI_VictorSPX m_middleLeft = new WPI_VictorSPX(2);
  private final WPI_VictorSPX m_rearLeft = new WPI_VictorSPX(3);
  private final WPI_VictorSPX m_frontRight = new WPI_VictorSPX(4);
  private final WPI_VictorSPX m_middleRight = new WPI_VictorSPX(5);
  private final WPI_VictorSPX m_rearRight = new WPI_VictorSPX(6);

  /**
   * Create a new drive train subsystem.
   */
  public DriveTrain() {
    m_left.setInverted(true);
    m_right.setInverted(true);
  }

}
