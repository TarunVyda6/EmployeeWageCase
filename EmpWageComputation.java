package org.empwagecomputation;

import java.util.Random;

public class EmpWageComputation 
{
	// Constants
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	public static final int WAGE_PER_HOUR = 20;
	public static final int NUMBER_OF_WORKING_DAYS = 20;
	public static final int NUMBER_OF_WORKING_HOURS = 100;
	
	public static void main(String[] args) 
	{
		wageCalculation ();
	}
	
	public static void wageCalculation ()
	{
		Random random = new Random ();
		// Variables
			int totalEmployeeWage = 0;
			int day = 0;
			int workingHours = 0;
		// Computation
			while ( day < NUMBER_OF_WORKING_DAYS && workingHours < NUMBER_OF_WORKING_HOURS)
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
				dailyEmployeeWage = empHours * WAGE_PER_HOUR;
				System.out.println( "Daily Employee Wage is : " + dailyEmployeeWage );
				totalEmployeeWage = totalEmployeeWage + dailyEmployeeWage;
			}
			
			System.out.println( "Total Employee wage is : " + totalEmployeeWage );
	}
	
}
