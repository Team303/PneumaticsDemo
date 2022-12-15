// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticsSubsystem extends SubsystemBase {

    private Compressor compressor;
    private Solenoid solenoid;

    public PneumaticsSubsystem() {
        this.compressor = new Compressor(PneumaticsModuleType.CTREPCM);
        this.solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);

        this.solenoid.setPulseDuration(1);
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean(
            "Compressor Enabled",
            this.compressor.enabled()
        );
        SmartDashboard.putBoolean(
            "Solenoid Enabled",
            !this.solenoid.isDisabled()
        );
    }

    public void toggleCompressor() {
        if (this.compressor.enabled()) {
            this.compressor.enableDigital();
        } else {
            this.compressor.disable();
        }
    }

    public void togglePulse() {
        if (this.solenoid.isDisabled()) {
            this.solenoid.startPulse();
        } else {
            this.solenoid.set(false);
        }
    }

    public void toggle() {
        this.solenoid.toggle();
    }
}
