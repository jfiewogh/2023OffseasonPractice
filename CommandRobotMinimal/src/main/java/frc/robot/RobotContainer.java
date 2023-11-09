// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.IntakeCommand;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem);

  private Joystick joystick = new Joystick(0);
  private JoystickButton[] buttons = new JoystickButton[13];

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    createButtons();

    configureBindings();
  }

  private void createButtons(){
    for(int i = 0; i < buttons.length; i++){
      buttons[i] = new JoystickButton(joystick, i);
    }
  }

  private void configureBindings() {
    buttons[0].whenPressed(intakeCommand);
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(intakeSubsystem);
  }
}
