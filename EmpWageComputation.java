import java.util.Random;

public class EmpWageComputation 
{
	// Constants
		public static final int IS_FULL_TIME = 1;
		public static final int WAGE_PER_HOUR = 20;
	
	public static void main(String[] args) 
	{
		Random random = new Random();
		// Variables
			int empHours = 0;
			int dailyEmployeeWage = 0;
		// Computation
			int empStatus = random.nextInt(2);
			if ( empStatus == IS_FULL_TIME )
			{
				empHours = 8;
			}
			else
			{
				empHours = 0;
			}
			dailyEmployeeWage = empHours * WAGE_PER_HOUR;
			System.out.println("Daily Employee Wage is : "+dailyEmployeeWage);
	}
}
