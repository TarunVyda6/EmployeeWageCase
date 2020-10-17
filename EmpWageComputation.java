import java.util.*;

interface ComputeEmployeeWageInterface
{
	public void addCompanyEmployeeWage ( String company, int wagePerHour, int numberOfWorkingDays, int numberOfWorkingHours );
	public void computeEmployeeWage ();
	public int getTotalWage(String company);
}

public class EmpWageComputation implements ComputeEmployeeWageInterface
{
	// Constants
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	private ArrayList< CompanyEmployeeWage > companyEmployeeWageList;
	private Map< String, CompanyEmployeeWage > companyToEmployeeWageMap;
	
	public static void main(String[] args) 
	{
		ComputeEmployeeWageInterface allCompanies = new EmpWageComputation();
       		allCompanies.addCompanyEmployeeWage ( "MICROSOFT" , 20, 20, 100 );
		allCompanies.addCompanyEmployeeWage ( "GOOGLE" , 40, 40, 100 );
		allCompanies.computeEmployeeWage ();
		System.out.println( "total emp wage for Google is " + allCompanies.getTotalWage ( "GOOGLE" ) );
	}

	public EmpWageComputation ()
	{
		 companyEmployeeWageList = new ArrayList<>();
		 companyToEmployeeWageMap = new HashMap<>();
	}

	public void addCompanyEmployeeWage( String company, int wagePerHour, int numberOfWorkingDays, int numberOfWorkingHours )
	{
		CompanyEmployeeWage companyEmployeeWage=new CompanyEmployeeWage( company, wagePerHour, numberOfWorkingDays, numberOfWorkingHours);
		companyEmployeeWageList.add ( companyEmployeeWage );
		companyToEmployeeWageMap.put(company, companyEmployeeWage);
	}
	public void computeEmployeeWage ()
	{
		for( int i = 0; i < companyEmployeeWageList.size(); i++ )
		{
			companyEmployeeWage companyEmployeeWage = companyEmployeeWageList.get ( i );
			companyEmployeeWage.setTotalEmployeeWage ( this.wageCalculation ( companyEmployeeWage ) );
			System.out.println( companyEmployeeWage );
		}
	}

	@Override
	public int getTotalWage ( String company )
	{
		return companyToEmployeeWageMap.get( company ).totalEmployeeWage;
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
				default	  		: empHours = 0;
			}
			workingHours =  workingHours + empHours;
			day++;
			dailyEmployeeWage = empHours * companyEmployeeWage.wagePerHour;
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
	public int dailyEmployeeWage;
	public CompanyEmployeeWage ( String company, int wagePerHour, int numberOfWorkingDays, int numberOfWorkingHours )
	{
		this.company = company;
		this.wagePerHour = wagePerHour;
		this.numberOfWorkingDays = numberOfWorkingDays;
		this.numberOfWorkingHours = numberOfWorkingHours;
	}
	public void setTotalEmployeeWage ( int totalEmployeeWage )
	{
		this.totalEmployeeWage = totalEmployeeWage;
	}
	public void setDailyEmployeeWage ( int dailyEmployeeWage )
	{
		this.dailyEmployeeWage = dailyEmployeeWage;
	}
	@Override
	public String toString()
	{
		return "total emp wage for " + company + " is : " + totalEmployeeWage;
	}
}

