package Ch10_1;


//1차원 배열 : 해당 자료형을 요소단위로 정한다
//2차원 배열 : 1차원 배열을 요소단위로 정한다
// int arr[][] = new int[2][3]; 여기서 첫번째 []는 행이고 두번째 []은 열이다.

// arr[0][0] arr[0][1] arr[0][2]
// arr[1][0] arr[1][1] arr[1][2] 이렇게 그려지지만 실제로는 한 줄로 나타내진다.

// arr[0][0] arr[0][1] arr[0][2] arr[1][0] arr[1][1] arr[1][2] 이렇게

public class C03ArrayMain {

	public static void main(String[] args) {


		int arr[][]= {
				{10,20,30},
				{40,50,60,56},
				{70,80,90,11,98},
				{100,110,120,44,57}
		};
		System.out.println("길이 : " +arr.length); //행의 길이
		System.out.println("[0]행의 열의 길이 : " +arr[0].length); //열의 길이
		System.out.println("[0]행의 열의 길이 : " +arr[1].length); //열의 길이
		System.out.println("[0]행의 열의 길이 : " +arr[2].length); //열의 길이
		System.out.println("[0]행의 열의 길이 : " +arr[3].length); //열의 길이

	}

}
