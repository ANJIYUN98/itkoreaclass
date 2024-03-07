package Ch10_1;

import java.util.Arrays;

public class C02ArrayMain {

	public static void main(String[] args) {
		
		
		//얕은 복사(주소 복사)
		int arr1[] = {10,20,30};  
		int arr2[];
		arr2 = arr1;
		arr1[0] = 100; //arr1의 0번째 값을 100으로 값을 바꿈
		
		for(int val : arr2) {
			System.out.print(val + " ");
		}
		System.out.println();
		
		
		
		//깊은 복사(값 복사)
		int arr3[] = new int[3];
		for(int i=0; i<arr3.length; i++) {
			arr3[i] = arr1[i];
		}
		int arr4[] = Arrays.copyOf(arr1,arr1.length); //arr4에 복사하여 집어 넣음
		
		System.out.println("arr1 : " + arr1); // arr1의 메모리 주소 위치
		System.out.println("arr4 : " + arr4); // arr4의 메모리 주소 위치
		
		for(int val : arr4)
			System.out.print(val + " ");
		System.out.println();

	}

}
