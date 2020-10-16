import java.util.Random;

public class EmpWageComputation 
{
	// Constants
		public static final int IS_FULL_TIME = 1;
		public static final int IS_PART_TIME = 2;
	public static void main(String[] args) 
	{
		System.out.print("emp wage for abc company is ");
		WageCalculation(20,20,100);
		System.out.print("emp wage for xyz company is ");
		WageCalculation(45,20,100);

	}
	
	public static void wageCalculation ( int wagePerHour, int numberOfWorkingDays, int numberOfWorkingHours )
	{
		Random random = new Random ();
		// Variables
			int totalEmployeeWage = 0;
			int day = 0;
			int workingHours = 0;
		// Computation
			while ( day < numberOfWorkingDays && workingHours < numberOfWorkingHours )
			{
				int empHours = 0;
				int dailyEmployeeWage = 0;
				int empStatus = random.nextInt (3);
				switch( empStatus )
				{
				case IS_FULL_TIME	: empHours = 8;
							break;
				case IS_PART_TIME	: empHours = 4;
							break;
				default			: empHours = 0;
				}
				workingHours =  workingHours + empHours;
				day++;
				dailyEmployeeWage = empHours * wagePerHour;
				System.out.println( "Daily Employee Wage is : " + dailyEmployeeWage );
				totalEmployeeWage = totalEmployeeWage + dailyEmployeeWage;
			}
			
			System.out.println( "Total Employee wage is : " + totalEmployeeWage );
	}
	
}
