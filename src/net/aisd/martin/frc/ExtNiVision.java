
package net.aisd.martin.frc;

import com.sun.cldc.jna.BlockingFunction;
import com.sun.cldc.jna.NativeLibrary;
import com.sun.cldc.jna.Pointer;
import com.sun.cldc.jna.TaskExecutor;
import edu.wpi.first.wpilibj.image.Image;
import edu.wpi.first.wpilibj.image.NIVision;
import edu.wpi.first.wpilibj.image.NIVisionException;

/**
 * Bunch of Java ports that the NIVision library fails to provide.
 * @author Colonel Thirty Two
 */
public class ExtNiVision
{
	private static final TaskExecutor tx = new TaskExecutor("ExtNiVisionExecutor");
	
	private static void chErr(int c) throws NIVisionException
	{
		if(c != 0) throw new NIVisionException(NIVision.getLastError());
	}
	
	private static final BlockingFunction imaqConvexHull = NativeLibrary.getDefaultInstance().getBlockingFunction("imaqConvexHull");
	static { imaqConvexHull.setTaskExecutor(tx); }
	public static void convexHull(Pointer dest, Pointer src, boolean connectivity) throws NIVisionException
	{
		chErr(imaqConvexHull.call3(dest.address().toUWord().toPrimitive(),
				src.address().toUWord().toPrimitive(),
				connectivity ? 1 : 0));
	}
	public static void convexHull(Image dest, Image src, boolean connectivity) throws NIVisionException
	{
		convexHull(dest.image, src.image, connectivity);
	}
}
