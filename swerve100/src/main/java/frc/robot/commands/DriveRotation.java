// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveDriveSubsystem;

public class DriveRotation extends CommandBase {
  /** Creates a new driveRotation. */

  SwerveDriveSubsystem m_robotDrive;
  Supplier<Double> rotSpeed;
  public DriveRotation(SwerveDriveSubsystem robotDrive, Supplier<Double> rot) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_robotDrive = robotDrive;
    rotSpeed = rot;

    addRequirements(m_robotDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double rot = rotSpeed.get();

    if(Math.abs(rot) <= 0.15){
        rot = 0;
    }
    m_robotDrive.drive(0, 0, rot, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Translation2d endTranslation2d = new Translation2d(m_robotDrive.getPose().getX(), m_robotDrive.getPose().getY());
    Pose2d endPose = new Pose2d(endTranslation2d, new Rotation2d(0) );
    m_robotDrive.resetPose(endPose);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
