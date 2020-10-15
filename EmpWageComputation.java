import java.util.Random;

public class EmpWageComputation 
{
	// Constants
		public static final int IS_FULL_TIME = 1;

	public static void main(String[] args) 
	{
		Random random = new Random();

		// Computation
			int empStatus = random.nextInt(2);
			if ( empStatus == IS_FULL_TIME )
			{
				System.out.println("employee is present");
			}
			else
			{
				System.out.println("employee is absent");
			}
	}
}
