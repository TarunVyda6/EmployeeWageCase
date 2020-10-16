import java.util.Random;

public class EmpWageComputation 
{
	// Constants
		public static final int IS_FULL_TIME = 1;
		public static final int IS_PART_TIME = 2;
		private final int wagePerHour;
		private final int numberOfWorkingDays;
		private final int numberOfWorkingHours;
		private final String company;
		private int totalEmployeeWage;
		
		public static void main(String[] args) 
		{
			EmpWageComputation microSoft = new EmpWageComputation ( "MICROSOFT", 20, 20, 100 );
			microSoft.wageCalculation();
			EmpWageComputation google = new EmpWageComputation ( "GOOGLE", 45, 20, 100 );
			google.wageCalculation ();
			System.out.println(microSoft);
			System.out.println( google );
		}
		

		public EmpWageComputation( String company, int wagePerHour, int numberOfWorkingDays, int numberOfWorkingHours)
	    {
	            this.company=company;
	            this.wagePerHour=wagePerHour;
	            this.numberOfWorkingDays=numberOfWorkingDays;
	            this.numberOfWorkingHours=numberOfWorkingHours;
	    }
		
		public void wageCalculation ()
		{
			Random random = new Random ();
			// Variables
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
					System.out.println( "Daily Employee Wage for " + company + "is : " + dailyEmployeeWage );
					totalEmployeeWage = totalEmployeeWage + dailyEmployeeWage;
				}
				
		}
		public String toString()
		{
			return "total employee wage for " + company + " is : " + totalEmployeeWage;
		}
	
}
