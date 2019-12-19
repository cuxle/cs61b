public class LeapYear{
	/** isLeapYear judeges a year is a leap year or not
		checkLeapYear
		@param int year: the year to be checkeked
	*/
	
	public static boolean isLeapYear(int year) 
	{
		if (year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String [] args) {
		for (int i = 0; i < args.length; i++) {
			if (isLeapYear(Integer.parseInt(args[0]))) {
				System.out.println(args[0] + " is a leap year");
			} else {
				System.out.println(args[0] + " is not a leap year");
			}
		}
		
	}
}