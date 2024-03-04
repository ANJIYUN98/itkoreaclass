package Ch99;

import java.util.Scanner;

public class star_test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i=0; //행 증가
		int j=0; // 공백
		int k=0; // 별
		int n = sc.nextInt(); //높이 입력 받기
		
		while(i<n) {
			
			//공백찍기
			j=0; //0으로 초기화
			while(j<=(n-2)-i) {
				System.out.print(" "); //공백 출력
				j++; //1씩 증가
			}
			
			//별찍기
			k=0; //0으로 초기화
			while(k<=2*i) {
				System.out.print("*"); //별 출력
				k++; //1씩 증가
			}
			
			System.out.println("");
			i++;
		}

	}

}
