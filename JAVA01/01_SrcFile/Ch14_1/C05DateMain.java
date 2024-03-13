package Ch14_1;

import java.util.Calendar;
import java.util.Date;

public class C05DateMain {

	public static void main(String[] args) {
		
//		Date d1 = new Date();
//		System.out.println(d1);
//		// 현재 많이 사용하지 않아서 줄 생김
//		System.out.println(d1.getYear()); // -1900한 값
//		System.out.println(d1.getMonth()); //0부터 셈 그래서 +1 해줘야 함
//		System.out.println(d1.getDay()); // 요일 정보(0-6까지 일-토)
//		System.out.println(d1.getHours());
//		System.out.println(d1.getMinutes());
//		System.out.println(d1.getSeconds());
//		System.out.println(d1.getTime()); // 타임스탬프, 1970년도 기준

		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); //요일 (1-7까지 일-토)
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
	}

}
