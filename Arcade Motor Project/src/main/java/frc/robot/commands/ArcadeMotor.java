// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.MotorConstants;
import frc.robot.subsystems.Motor;
/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ArcadeMotor extends Command {
  /** Creates a new ArcadeMotor. */
  private XboxController m_xBoxController;
  private double m_speed;
  private Motor m_motor;

  public ArcadeMotor(Motor motor, XboxController controller) {
    m_motor = motor;
    m_xBoxController = controller;
    addRequirements(m_motor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      m_speed = m_xBoxController.getRawAxis(MotorConstants.kAxisID);
      m_speed = m_speed * MotorConstants.kMultiplier;
      m_motor.setSpeed(m_speed);
  }

  @Override
  public void end(boolean interrupted) {
        m_motor.setSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
