package Ch11;

import java.util.Arrays;
import java.util.Scanner;

public class C01ArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] arr1 = new int[4];	//idx 0,1,2,3
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		arr1[3] = 40;
		System.out.println("길이 : " + arr1.length);
		//old한 코드
		for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		System.out.println();
		//개량된 for문
		for(int el:arr1) {
			System.out.println(el);
		}
		System.out.println();
		//Stream 메서드를 이용한 방식
		Arrays.stream(arr1).forEach(el->System.out.println(el));
		System.out.println();
		
		double arr2[];	//배열형 참조변수
		arr2=new double[5];	//배열형 참조변수에 배열객체 연결
		
		//5개의 정수값을 입력받아 int형 배열에 저장하고
		//최대값,최소값,전체합을 출력합니다.
		
		System.out.println(Arrays.stream(arr1).max().getAsInt());
		System.out.println(Arrays.stream(arr1).min().getAsInt());
		System.out.println(Arrays.stream(arr1).average().getAsDouble());
	}

}
