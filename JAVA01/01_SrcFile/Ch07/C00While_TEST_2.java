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
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		while(n>9) {
		
			System.out.println("다시입력하세요.");
			n = sc.nextInt();
		}
		
		int dan=2;
		int i;
		
		
		while(dan<=n) {
			i=1;
			
			while(i<=9) {
				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
				i++;
			}
			System.out.println();
			dan++;
		}
		
	}

}
