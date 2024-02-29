package Ch06EXEC;

import java.util.Scanner;
public class PRAC_DO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Scanner sc = new Scanner(System.in);
//		int n1 = sc.nextInt();
//		int n2 = sc.nextInt();
//		int n3 = sc.nextInt();
//		
//		int sum = n1 + n2 + n3;
//		double avg = (double)sum/3;
//		
//		System.out.printf("세 수의 합 : %d\n", sum);
//		System.out.printf("세 수의 평균 : %.2f", avg);
////		System.out.printf("합 : %d 평균 : %.2f\n", sum, avg);
		
		
		
		Scanner sc = new Scanner(System.in);
		int n4 = sc.nextInt();
		int n5 = sc.nextInt();
		int n6 = sc.nextInt();
		
		//n4가 가장 큰 경우
		if(n4>=n5&&n4>=n6) {
			System.out.println("가장 큰 수 : " +n4);
		}
		//n5가 가장 큰 경우
		if(n5>=n4&&n5>=n6) {
			System.out.println("가장 큰 수 : " +n5);
		}
		//n6가 가장 큰 경우
		if(n6>=n4&&n6>=n5) {
			System.out.println("가장 큰 수 : " +n6);
		}
		
		

		
	}

}
