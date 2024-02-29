package Ch07;

import java.util.Scanner;
public class C00While_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//N-M 까지의 합을 구합니다.(N<M)
		
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		
//		if(n>m) {
//			int tmp=n;
//			n=m;
//			m= tmp;
//			
//		}
//		int i = n;
//		int sum = 0;
//		
//		while(i<=m) {
//			System.out.println("i : "+i);
//			sum = sum + i;
//			i++;
//		}
//		System.out.println("sum : "+sum);
//		sc.close();
		
		
		
		
		//01 1 -N 까지 수중에 짝수 /혹수의 합을 각각 출력
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		int i =1;
//		int sum=0;
//		int odd=0;
//		int even=0;
//		
//		while(i<=n) {
//			System.out.println("i : "+i);
//			sum += i;
//			if(i%2==0) {
//				even += i;
//			}else {
//				odd += i;
//			}
//			i++;
//		}
//		System.out.println("sum : "+sum);
//		System.out.println("짝수합 : "+even);
//		System.out.println("홀수합 : "+odd);
		
		
		
		//1-N 까지의 수중에 3의 배수만 출력하고 그합도 출력
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		int i =1;
//		int sum=0;
//		
//		while(i<=n) {
//			if(i%3==0) {
//				System.out.println("i : "+i);
//				sum += i;
//			}
//			i++;
//		}
//		System.out.println("sum : "+sum);
		
		//1-N까지 수중에 4의 배수를 출력하고 4의 배수가 아닌 나머지의 합을 구하세요
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		int i =1;
//		int sum = 0;
//		
//		while(i<=n) {
//			if(i%4==0) {
//				System.out.println("i : "+i);		
//			}else {
//				sum += i;
//			}
//			i++;
//		}
//		System.out.println("sum : "+sum);
		
		
		
		//구구단 N 단 역순출력(N<=9)
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		int i =9;
//		
//		while(i>=1) {
//			System.out.println(n + "x" + i + "=" + n*i);
//			i--;
//		}
		
		
		
		//양의 정수를 입력받아서 소수인지 아닌지를 판별하는 코드를 작성하세요
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		boolean a= true;
//		
//		for(int i = 2; i<=n/2; i++) {
//			if(n%i==0) {
//				a = false;
//				break;
//			}
//		}
//		System.out.println(a ? "소수입니다" : "소수가 아닙니다.");
		
		//or
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("수를 입력하세요 : ");
//		int num = sc.nextInt();
//		if(num<=1) {
//			System.out.println(num+" 는 소수가 아닙니다.");
//		}
//		int i=2;
//		int cnt=0;
//		while(1<num) {
//			
//			if(num%i==0)
//				cnt++;
//				
//			i++;
//		}
//		if(cnt>0)
//			System.out.println(num+" 는 소수가 아닙니다.");
//		else
//			System.out.println(num+" 는 소수입니다.");
//		
		
		
		//자연수 n을 입력받아 "출력 예"와 같이 n x n크기에 공백으로 구분하여 출력되는 프로그램을 작성하시오. 
				//10 미만의 홀수만 출력하시오.
				// 주의! 숫자는 공백으로 구분하되 줄사이에 빈줄은 없다.
				//입력 : 3
				//출력 :
				//1 3 5
				//7 9 1
				//3 5 7
				
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		
		
		
		
		
				//숫자를 입력받아 해당 수를 거꾸로 저장해서 출력해보세요
				//정수값을 입력받아서 처리합니다
				//입력 : 1234
				//출력 : 4321
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("입력 : ");
//		int num = sc.nextInt();
//		int result = 0;
//		
//		//자릿수 구하는 작업
//		int digit=0;
//		int tmp = num;
//		while(tmp!=0) {
//			digit++;
//			tmp=tmp/10;
//		}
////		System.out.println("자리수 : "+digit);
//		
//		while(num!=0) {
////			System.out.println("num : "+num);
//			
////			System.out.print(num%10);
//			
//			result += (int)((num%10)*(Math.pow(10, digit-1)));
//			digit--;
//			num =num/10;
//		}
//		System.out.println("출력 : "+ result);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 : ");
		int num = sc.nextInt();
		String num_2 = num+"";
		String tmp="";
		for(int i=num_2.length()-1; i>=0; i--);
		
		
		
		
		
	}

}
