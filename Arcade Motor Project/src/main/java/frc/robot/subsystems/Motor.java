// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.ObjectInputFilter.Config;

import org.littletonrobotics.junction.Logger;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.MotorConstants;

public class Motor extends SubsystemBase {

  private SparkMax m_motor = new SparkMax(MotorConstants.kDeviceID, MotorType.kBrushless);
  private SparkMaxConfig configMotor = new SparkMaxConfig();

  /** Creates a new Motor. */
  public Motor(int deviceId) {
      configMotor.idleMode(IdleMode.kBrake);
      m_motor.configure(configMotor, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
    Logger.recordOutput("speed", getSpeed());
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed) {
      m_motor.set(speed);
    }
  public void setVoltage(double voltage) {
      m_motor.set(voltage);
    }
  public double getSpeed() {
    return m_motor.get();
  }
}
