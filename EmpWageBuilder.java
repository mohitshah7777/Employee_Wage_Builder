public class EmpWageBuilder {
	
	public static final int IS_FULL_TIME =1;
	public static final int IS_PART_TIME =2;
	public static final int EMP_RATE_PER_HOUR = 20;
	public static final int NUM_OF_WORKING_DAYS = 20;
	public static final int MAX_HRS_IN_MONTH = 100;
	
	public static int computeEmpWAGE()
	{
		int empHrs=0;
		int empWage=0;
		int totalEmpHrs=0;
		int totalWorkingDays=0;
		//int totalMonthlyEmpWage=0;
		while(totalEmpHrs<=MAX_HRS_IN_MONTH && totalWorkingDays<NUM_OF_WORKING_DAYS)
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
			empWage=empHrs*EMP_RATE_PER_HOUR;
			//totalMonthlyEmpWage+=empWage;
			System.out.println("Day = " +totalWorkingDays+ " Employee Hour = " +empHrs);
		}
		int totalEmpWage=totalEmpHrs*EMP_RATE_PER_HOUR;
		System.out.println("Total Employee wage = " +totalEmpWage);
		//System.out.println("Total Monthly Wage = " +totalMonthlyEmpWage);
		return totalEmpWage;
	}

	public static void main(String[] args) {

		computeEmpWAGE();
	}
}
