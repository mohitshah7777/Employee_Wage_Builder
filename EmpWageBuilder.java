class CompanyEmpWage
{
	public final String company;
	public final int EMP_RATE_PER_HOUR;
	public final int NUM_OF_WORKING_DAYS;
	public final int MAX_HRS_IN_MONTH;
	public int totalEmpWage;


public CompanyEmpWage(String company,int EMP_RATE_PER_HOUR, int NUM_OF_WORKING_DAYS,int MAX_HRS_IN_MONTH)
{
	this.company=company;
	this.EMP_RATE_PER_HOUR=EMP_RATE_PER_HOUR;
	this.NUM_OF_WORKING_DAYS=NUM_OF_WORKING_DAYS;
	this.MAX_HRS_IN_MONTH=MAX_HRS_IN_MONTH;
}
public void setTotalEmpWage(int totalEmpWage)
{
	this.totalEmpWage=totalEmpWage;
}

@Override
public String toString()
{
	return "Total Employee wage for company = "+company+" is = "+totalEmpWage;
}

}

public class EmpWageBuilder {
	public static final int IS_FULL_TIME =1;
	public static final int IS_PART_TIME =2;

	private int numberOfCompany=0;
	private CompanyEmpWage[] companyEmpWageArray;

	public EmpWageBuilder()
	{
		companyEmpWageArray=new CompanyEmpWage[5];
	}

	private void addCompanyEmpWage(String company,int EMP_RATE_PER_HOUR, int NUM_OF_WORKING_DAYS,int MAX_HRS_IN_MONTH)
	{
		companyEmpWageArray[numberOfCompany]=new CompanyEmpWage(company, EMP_RATE_PER_HOUR, NUM_OF_WORKING_DAYS, MAX_HRS_IN_MONTH);
		numberOfCompany++;
	}

	private void computeEmpWage()
	{
		for (int i=0;i<numberOfCompany;i++)
		{
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}
	private int computeEmpWage(CompanyEmpWage companyEmpWage)
	{
		int empHrs=0;
		int totalEmpHrs=0;
		int totalWorkingDays=0;

		while(totalEmpHrs<=companyEmpWage.MAX_HRS_IN_MONTH && totalWorkingDays<companyEmpWage.NUM_OF_WORKING_DAYS)
		{
			totalWorkingDays++;
			int empCheck = (int)Math.floor(Math.random() * 10)% 3;
			switch (empCheck)
			{
				case IS_FULL_TIME :
					System.out.println("Employee is Present");
					empHrs=8;
					break;
				case IS_PART_TIME :
					System.out.println("Part time Employee Present");
					empHrs=4;
					break;
				default:
					System.out.println("Employee is Absent");
					empHrs=0;
					break;
			}
			totalEmpHrs+=empHrs;
			System.out.println("Day = " +totalWorkingDays+ " Employee Hour = " +empHrs);
		}

		return totalEmpHrs*companyEmpWage.EMP_RATE_PER_HOUR;
	}

	public static void main(String[] args) {

		EmpWageBuilder empWageBuilder=new EmpWageBuilder();
		empWageBuilder.addCompanyEmpWage("Dmart", 20, 20, 100);
		empWageBuilder.addCompanyEmpWage("Mahindra", 40, 10, 200);
		empWageBuilder.addCompanyEmpWage("Accenture", 20, 100, 500);
		empWageBuilder.computeEmpWage();
	}
}
