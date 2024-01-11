// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {

  /** State variables */
  private boolean isSensingTarget = false;

  /** Simulation related variables */
  private long simNextEventTime = 0;

  private CANSparkMax motor4;
  private CANSparkMax motor5;

  /** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {
    motor4 = new CANSparkMax(4, MotorType.kBrushless);
    motor5 = new CANSparkMax(5, MotorType.kBrushless);
  }

  public void setMotorsSpeed(double speed){
    motor4.set(speed);
    motor5.set(speed);
  }

  public void stopMotors(){
    setMotorsSpeed(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Toggle whether the subsystem is sensing a target
   */
  private void simEvent() {
    // Toggle the sensing state
    isSensingTarget = !isSensingTarget;
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    long now = System.currentTimeMillis();

    if (now >= simNextEventTime) {
      simEvent();
      simNextEventTime = now + (1000 * 2);
    }
  }
}
