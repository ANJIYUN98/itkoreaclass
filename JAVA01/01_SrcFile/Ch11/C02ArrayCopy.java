package Ch11;

import java.util.Arrays;

public class C02ArrayCopy {

	public static void main(String[] args) {
		int arr1 [] = {10,20,30};
		int arr2 [];
		arr2 = arr1; //얕은 복사(주소복사)
		
		//확인
		arr1[0]=123;
		System.out.println(arr2[0]);
		
		//깊은복사
		int arr3[] = new int[3];
		for(int i=0;i<arr1.length;i++) {
			arr3[i]=arr1[i];
		}
		
		//깊은복사
		int arr4[] = Arrays.copyOf(arr1,arr1.length);
		
		System.out.println(arr4);
		System.out.println(arr1);

	}

}
