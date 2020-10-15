import java.util.Random;

public class EmpWageComputation 
{
	// Constants
		public static final int IS_FULL_TIME = 1;
		public static final int IS_PART_TIME = 2;
		public static final int WAGE_PER_HOUR = 20;
	
	public static void main(String[] args) 
	{
		Random random = new Random();
		// Variables
			int empHours = 0;
			int dailyEmployeeWage = 0;
		// Computation
			int empStatus = random.nextInt(3);
			
			switch( empStatus )
			{
			case IS_FULL_TIME	: empHours = 8;
				 break;
			case IS_PART_TIME	: empHours = 4;
				 break;
			default			: empHours = 0;
			}
			dailyEmployeeWage = empHours * WAGE_PER_HOUR;
			System.out.println("Daily Employee Wage is : " + dailyEmployeeWage );
	}
}
