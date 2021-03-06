/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author rchs.paulyates
 */
public class ClimbManually extends CommandBase {
    
    Joystick stick;
    
    public ClimbManually() {
        requires(climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        stick = oi.getLeftStick();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(Math.abs(stick.getY()) > .1){
            climber.setClimbingArm(stick.getAxisChannel(Joystick.AxisType.kY));
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        climber.setClimbingArm(RobotMap.STOPPED);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        climber.setClimbingArm(RobotMap.STOPPED);
    }
}
