package Ch11Ex;

import java.util.Arrays;
import java.util.Scanner;

public class C01Ex {

	public static void main(String[] args) {
		//5개의 정수값을 입력받아 int형 배열에 저장하고
		//최대값,최소값,전체합을 출력합니다.
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		
		System.out.println( Arrays.stream(arr).max().getAsInt() );
		System.out.println( Arrays.stream(arr).min().getAsInt() );
		System.out.println( Arrays.stream(arr).sum());
		
//		int max=arr[0];
//		int min=arr[0];
//		int sum=0;
//		for(int el : arr) {
//			if(max<el) {
//				max=el;
//			}
//			if(min>el) {
//				min=el;
//			}	
//			sum +=el;
//		}
//		System.out.printf("%d %d %d\n", max,min,sum);

	}

}
