public class EmpWageBuilder {
	
	public static final int IS_FULL_TIME =1;
	public static final int IS_PART_TIME =2;

	private final String company;
	private final int EMP_RATE_PER_HOUR;
	private final int NUM_OF_WORKING_DAYS;
	private final int MAX_HRS_IN_MONTH;
	private int totalEmpWage;
	
	public EmpWageBuilder(String company,int EMP_RATE_PER_HOUR, int NUM_OF_WORKING_DAYS,int MAX_HRS_IN_MONTH)
	{
		this.company=company;
		this.EMP_RATE_PER_HOUR=EMP_RATE_PER_HOUR;
		this.NUM_OF_WORKING_DAYS=NUM_OF_WORKING_DAYS;
		this.MAX_HRS_IN_MONTH=MAX_HRS_IN_MONTH;
	}
	
	public void computeEmpWAGE()
	{
		int empHrs=0;
		int totalEmpHrs=0;
		int totalWorkingDays=0;
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
			System.out.println("Day = " +totalWorkingDays+ " Employee Hour = " +empHrs);
		}
		totalEmpWage=totalEmpHrs*EMP_RATE_PER_HOUR;
	}

	@Override
	public String toString()
	{
		return "Total Employee wage for company = "+company+" is = "+totalEmpWage;
	}

	public static void main(String[] args) {

		EmpWageBuilder Dmart=new EmpWageBuilder("Dmart", 20, 20, 100);
		EmpWageBuilder Mahindra=new EmpWageBuilder("Mahindra", 40, 10, 200);
		EmpWageBuilder Accenture=new EmpWageBuilder("Accenture", 20, 100, 50);
		Dmart.computeEmpWAGE();
		System.out.println(Dmart);
		Mahindra.computeEmpWAGE();
		System.out.println(Mahindra);
		Accenture.computeEmpWAGE();
		System.out.println(Accenture);
	}
}
