// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.PneumaticsSubsystem;

public class Robot extends TimedRobot {

    public static final PneumaticsSubsystem pneumatics = new PneumaticsSubsystem();

    @Override
    public void robotInit() {
        SmartDashboard.putData(
            "Toggle Solenoid",
            new InstantCommand(pneumatics::toggle, pneumatics)
        );
        SmartDashboard.putData(
            "Toggle Pulse",
            new InstantCommand(pneumatics::togglePulse, pneumatics)
        );
        SmartDashboard.putData(
            "Toggle Compressor",
            new InstantCommand(pneumatics::toggleCompressor, pneumatics)
        );
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
}
