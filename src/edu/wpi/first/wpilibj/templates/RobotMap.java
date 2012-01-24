package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap
{
	
	/**
	 * Signals a value that needs to be changed. Used for code for a device that
	 * hasn't been built yet and the slot/channel for it is unknown. To find usages
	 * of this in netbeans, right click on the variable and select "Find Usage"
	 */
	public static final int INVALID = Integer.MIN_VALUE;
	
	/**
	 * Contains input device mappings (ex joysticks and gamepads)
	 */
    public static final class Input
	{
		private Input() {}

		/// Joystick port
		public static final int joystick = 1;
	}

	/**
	 * Contains drive motor mappings.
	 */
	public static final class DriveMotors
	{
		private DriveMotors() {}

		/// Slot that motors are on
		public static final int slot = 1;
		/// left motor channel
		public static final int rear_left = 1;
		/// right motor channel
		public static final int rear_right = 2;
        }
	/**
	 * Contains shooter motor mappings.
	 */
	public static final class Shooter
	{
		private Shooter() {}
		
		/// Slot that pneumatics are on
		public static final int pneumatics_slot = 1;
		/// Slot that motors are on
		public static final int motor_slot = 1;
		
		/// Motor 1 channel
		public static final int motor1 = 3;
		/// Motor 2 channel
		public static final int motor2 = 4;
		/// Piston channel
		public static final int piston = 1;
	}
}
