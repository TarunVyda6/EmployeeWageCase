import java.util.Random;

public class EmpWageComputation 
{
	// Constants
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	private int numberOfCompanies = 0;
	private CompanyEmployeeWage[] companyEmployeeWageArray;
	public static void main(String[] args) 
	{
		EmpWageComputation allCompanies = new EmpWageComputation();
		allCompanies.addCompanyEmpWage ( "MICROSOFT" , 20, 20, 100 );
		allCompanies.addCompanyEmpWage ( "GOOGLE", 40, 40, 100 );
		allCompanies.computeEmployeeWage ();
	}


	public EmpWageComputation ()
	{
		companyEmployeeWageArray = new CompanyEmployeeWage [ 5 ];
	}

	private void addCompanyEmpWage( String company, int wagePerHour, int numberOfWorkingDays, int numberOfWorkingHours )
	{
		companyEmployeeWageArray [ numberOfCompanies ] = new CompanyEmployeeWage ( company, wagePerHour, numberOfWorkingDays, numberOfWorkingHours );
		numberOfCompanies++;
	}
	private void computeEmployeeWage ()
	{
		for( int i = 0; i < numberOfCompanies; i++ )
		{
			companyEmployeeWageArray[ i ].setTotalEmployeeWage( this.wageCalculation( companyEmployeeWageArray [ i ] ) );
			System.out.println ( companyEmployeeWageArray [ i ] );
		}
	}



	public int wageCalculation ( CompanyEmployeeWage companyEmployeeWage)
	{
		Random random = new Random ();
		// Variables
		int day = 0;
		int workingHours = 0;

		int dailyEmployeeWage = 0;
		// Computation
		while ( day < companyEmployeeWage.numberOfWorkingDays && workingHours < companyEmployeeWage.numberOfWorkingHours )
		{
			int empHours = 0;
			int empStatus = random.nextInt (3);
			switch( empStatus )
			{
				case IS_FULL_TIME	: empHours = 8;
				break;
				case IS_PART_TIME	: empHours = 4;
				break;
				default				: empHours = 0;
			}
			workingHours =  workingHours + empHours;
			day++;
			dailyEmployeeWage = empHours * companyEmployeeWage.wagePerHour;
			System.out.println( "Daily Employee Wage for " + companyEmployeeWage.company + "is : " + dailyEmployeeWage );
			companyEmployeeWage.totalEmployeeWage = companyEmployeeWage.totalEmployeeWage + dailyEmployeeWage;

		}
		return companyEmployeeWage.totalEmployeeWage;
	}

}


class CompanyEmployeeWage
{

	public final int wagePerHour;
	public final int numberOfWorkingDays;
	public final int numberOfWorkingHours;
	public final String company;
	public int totalEmployeeWage;

	public CompanyEmployeeWage(String company,int wagePerHour, int numberOfWorkingDays,int numberOfWorkingHours)
	{
		this.company = company;
		this.wagePerHour = wagePerHour;
		this.numberOfWorkingDays = numberOfWorkingDays;
		this.numberOfWorkingHours = numberOfWorkingHours;
	}
	public void setTotalEmployeeWage (int totalEmployeeWage)
	{
		this.totalEmployeeWage = totalEmployeeWage;
	}
	@Override
	public String toString()
	{
		return "total emp wage for " + company + " is : " + totalEmployeeWage;
	}
}




