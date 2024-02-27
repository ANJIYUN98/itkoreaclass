package Ch36STREAM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C03Distinct {
	public static void main(String[] args) {
		//Distinct
		List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);
		List<Integer> distinctNumbers = numbers.stream()
		                                       .distinct()
		                                       .collect(Collectors.toList());
		System.out.println(distinctNumbers); // 출력: [1, 2, 3, 4, 5]
		


		
		
	}
}
