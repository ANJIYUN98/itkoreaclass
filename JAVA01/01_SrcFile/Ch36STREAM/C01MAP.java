package Ch36STREAM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C01MAP {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> evenNumbers = numbers.stream()
		                                   .filter(n -> n % 2 == 0)	//짝수필터링
		                                   .collect(Collectors.toList());	//collect로 Collection의 list로 객체 재생성
									
		System.out.println(evenNumbers); // 출력: [2, 4]


	}

}
