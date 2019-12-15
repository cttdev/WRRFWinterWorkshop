package frc.robot.wrappers;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;


public class TalonEncoder implements Sendable {
  // Use TalonSRX because WPI_TalonSRX extends this
  private final TalonSRX talon;

  private double m_distancePerPulse = 360 / 10240;

  public TalonEncoder(TalonSRX talon) {
    this.talon = talon;
    
    HAL.report(tResourceType.kResourceType_Encoder, 0, 1);
    SendableRegistry.addLW(this, "Encoder", 0);
  }


  // Use quadrature output for relative
  public double getDistance() {
    return talon.getSensorCollection().getQuadraturePosition() * m_distancePerPulse;
  }

  // Use quadrature output for relative
  public void setDistancePerPulse(double distancePerPulse) {
    m_distancePerPulse = distancePerPulse;
  }
  

  // Use quadrature output for relative
  public double getRate() {
    return talon.getSensorCollection().getQuadratureVelocity();
  }
  
  @Override
  public void initSendable(SendableBuilder builder) {
    builder.setSmartDashboardType("Encoder");
    builder.addDoubleProperty("Speed", this::getRate, null);
    builder.addDoubleProperty("Distance", this::getDistance, null);
  }
}
