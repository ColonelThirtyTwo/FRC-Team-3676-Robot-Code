
package net.aisd.martin.frc;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;

/**
 * Better compressor class. Uses thread interrupts and less-crappy nested
 * classes. Mostly a drop-in replacement for Compressor, but doesn't extend it!
 * @author Colonel Thirty Two
 */
public class AISDCompressor
{
	private class CompressorThread extends Thread
	{
		public void run()
		{
			System.out.println("Compressor> Starting Thread...");
			while(true)
			{
				if(!pressureSwitch.get())
					compressorRelay.set(Relay.Value.kOn);
				else
					compressorRelay.set(Relay.Value.kOff);
				
				try
				{
					// Sleep in loop, netbeans warning, bla bla bla
					// Can't do anything about it. Not even @supresswarning
					Thread.sleep(500);
				}
				catch(InterruptedException e)
				{
					System.out.println("Compressor> Stopping Thread...");
					compressorRelay.set(Relay.Value.kOff);
					return;
				}
			}
		}
	}
	
	private DigitalInput pressureSwitch;
	private Relay compressorRelay;
	private CompressorThread thread;

	/**
	 * Creates a new compressor.
	 * @param pressureSwitch Pressure Switch Input. No pressure = low value.
	 * @param compressorRelay Compressor relay.
	 */
	public AISDCompressor(DigitalInput pressureSwitch, Relay compressorRelay)
	{
		this.pressureSwitch = pressureSwitch;
		this.compressorRelay = compressorRelay;
		thread = new CompressorThread();
	}
	
	/**
	 * Creates a new compressor.
	 * @param pressureSwitchSlot Slot that pressure switch is on.
	 * @param pressureSwitchChannel Digital IO channel that pressure switch is on.
	 * @param compresssorRelaySlot Slot that relay is on.
	 * @param compressorRelayChannel Relay Channel that compressor is on.
	 */
	public AISDCompressor(final int pressureSwitchSlot,
            final int pressureSwitchChannel,
            final int compresssorRelaySlot,
            final int compressorRelayChannel)
	{
		this(new DigitalInput(pressureSwitchSlot, pressureSwitchChannel),
		     new Relay(compresssorRelaySlot, compressorRelayChannel, Relay.Direction.kForward));
	}
	
	/**
	 * Starts the compressor thread.
	 */
	public void start()
	{
		if(!thread.isAlive())
			thread.start();
	}
	
	/**
	 * Equivalent to stop(false)
	 */
	public void stop()
	{
		this.stop(false);
	}
	
	/**
	 * Interrupts the compressor thread.
	 * @param join Whether or not to wait for the compressor thread to die.
	 */
	public void stop(boolean join)
	{
		if(thread.isAlive())
		{
			thread.interrupt();
			if(join)
				try
				{
					thread.join();
				}
				catch(InterruptedException e)
				{
					System.out.println("Some idiot decided to interrupt the main thread, ignoring.");
				}
		}
	}
	
	/**
	 * Returns true if the compressor thread is alive.
	 * @return True if compressor thread is alive.
	 */
	public boolean enabled()
	{
		return thread.isAlive();
	}
}
