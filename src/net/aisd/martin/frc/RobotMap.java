package net.aisd.martin.frc;

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

		/// First joystick port
		public static final int joystick1 = 1;
		/// Second joystick port
		public static final int joystick2 = 2;
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
		public static final int left = 1;
		/// right motor channel
		public static final int right = 2;
        }
        
	/**
	 * Contains the Bridge Manipulator mappings.
	 */
	public static final class Manipulator
	{
		private Manipulator(){}

		/// Manipulator Arm Slot
		public static final int motorSlot = 1;
		/// Manipulator Arm channel
		public static final int motorChannel = 6;
		
		/// Limit Switch Slot
		public static final int limitSlot = 1;
		/// Limit Switch Channel (Digital IO)
		public static final int limitChannel = 2;
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
		public static final int topmotor = 3;
		/// Motor 2 channel
		public static final int bottommotor = 4;
		/// Piston forward channel
		public static final int piston_forward = 1;
		/// Piston backward channel
		public static final int piston_backward = 2;
	}
	
	public static final class Compressor
	{
		/// Slot for compressor and pressureSwitch
		public static final int compressor_slot = 1;
		/// Compressor channel (Relay)
		public static final int compressor = 1;
		/// Pressure Switch channel (Digital IO)
		public static final int pressure_switch = 1;
	}
}
