package Ch07;

import java.util.Scanner;
public class C00While_TEST_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//구구단 출력(2단-9단)
		
//		int i;
//		int dan =2;
//		
//		while(dan<=9) {
//			
//			i=1;
//			
//			while(i<=9) {
//				
//				System.out.printf("%d x %d = %d\n",dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			
//			dan++;
//		}
		
		
		//구구단 출력(9단-2단)
//		int i;
//		int dan=9;
//		
//		while (dan>=2) {
//			i=9;
//			
//			while(i>=2) {
//				System.out.printf("%d X %d = %d\n",dan, i, dan*i);
//				i--;
//			}
//			System.out.println();
//			dan--;
//		}
//		
		
		//구구단 출력(2단 - N단)
		//N은 Scanner로 받습니다.
		
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();
//		while(n>9) {
//		
//			System.out.println("다시입력하세요.");
//			n = sc.nextInt();
//		}
//		
//		int dan=2;
//		int i;
//		
//		
//		while(dan<=n) {
//			i=1;
//			
//			while(i<=9) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
		
		
		//4행 별찍기 -> 높이 입력 별찍기
		//****
		//****
		//****
		//****
		
		
//		int i=0; //행증가
//		int j=0; //별찍기
//		while(i<4) {
//			
//			j=0;
//			while(j<4) {
//				System.out.print("*");
//				j++;
//			}
//			
//			System.out.println();
//			i++;
//		}
		
		
		
		//4행 별찍기 -> 높이 입력받아 별찍기
		//높이 :n
		//****
		//****
	    //****
	    //****
		
//		높이 : n
//		행증가(i)		별찍기(j)
//		0		0~3
//		1		0~3
//		2		0~3
//		3		0~3
//		..
//		n-1		0~3
//		------------------------------------------
//		i=0		j=0
//		i<n		j<4
//		i++		j++
		
		
		//정사각형 만들려면 j<4를 j<n으로 바꿔주면 됨
				
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int i=0; //행증가
//		int j=0; //별찍기
//		while(i<n) {
//					
//			j=0;
//			while(j<4) {
//				System.out.print("*");
//				j++;
//			}
//					
//			System.out.println();
//			i++;
//		}
		
		
		
		//*
		//**
		//***
		//****
		
//		i		j
//		0		0-0
//		1		0-1
//		2		0-2
//		3		0-3
//		----------------------------
//		i=0		j=0
//		i<4		j<=i  j는 i의 수보다 작다가 똑같아지므로
//		i++		j++
		
//		
//		int i=0; //행증가
//		int j=0; //별찍기
//		while(i<4) {
//			
//			j=0;
//			while(j<=i) {
//				System.out.print("*");
//				j++;
//			}
//			
//			System.out.println();
//			i++;
//		}
		
		
		
//		높이 입력받아 별찍기
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i=0; //행증가
		int j=0; //별찍기
		while(i<n) {
					
			j=0;
			while(j<=i) {
				System.out.print("*");
				j++;
			}
					
			System.out.println();
			i++;
		}
		
		
		
		
		
	}

}
