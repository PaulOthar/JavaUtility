/**
 * Utility tool to read and write dates.
 * @author PaulOthar
 */
public class DateHandler {
	public static final int INDEX_DAY = 0;
	public static final int INDEX_MONTH = 1;
	public static final int INDEX_YEAR = 2;
	
	public static final int DAY_MASK = 0x1f;
	public static final int MONTH_MASK = 0x1e0;
	public static final int YEAR_MASK = 0xff_ff_fe_00;
	
	public static final int DAY_SHIFT = 0x1;
	public static final int MONTH_SHIFT = 0x20;
	public static final int YEAR_SHIFT = 0x200;
	
	/**
	 * Creates a single integer date bit structure:<br>
	 * 0bYYYYYYYY_YYYYYYYY_YYYYYYYM_MMMDDDDD<br><br>
	 * Day goes from 0 to 31<br>
	 * Month goes from 0 to 15<br>
	 * Year goes from 0 to 16777214
	 * @param day
	 * @param month
	 * @param year
	 * @return date
	 */
	public static int writeDate(int day,int month,int year) {
		return 
				((DAY_MASK/DAY_SHIFT)&day)*DAY_SHIFT+
				((MONTH_MASK/MONTH_SHIFT)&month)*MONTH_SHIFT+
				((YEAR_MASK/YEAR_SHIFT)&year)*YEAR_SHIFT;
	}
	
	/**
	 * Returns the selected data from inputted date.<br><br>
	 * Indexes:<br>
	 * 0 : Day<br>
	 * 1 : Month<br>
	 * 2 : Year<br><br>
	 * 
	 * Returns -1 if the index is invalid.
	 * @param date
	 * @param index
	 * @return data
	 */
	public static int readDate(int date,int index) {
		switch(index) {
		case DateHandler.INDEX_DAY: return (date&DAY_MASK)/DAY_SHIFT;
		case DateHandler.INDEX_MONTH: return (date&MONTH_MASK)/MONTH_SHIFT;
		case DateHandler.INDEX_YEAR: return (date&YEAR_MASK)/YEAR_SHIFT;
		default: return -1;
		}
	}
}
