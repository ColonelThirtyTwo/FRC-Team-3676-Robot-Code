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
	 * Contains input device mappings (ex joysticks and gamepads)
	 */
    public static final class Input
	{
		private Input() {}

		/// Joystick port. TODO: Remove this and add gamepad
		public static final int joystick = 1;
	}

	/**
	 * Contains drive motor mappings.
	 */
	public static final class DriveMotors
	{
		private DriveMotors() {}

		/// Slot that motors are on
		public static final int slot = 4;
		/// Left motor channel
		public static final int left = 1;
		/// Right motor channel
		public static final int right = 2;
	}
}
