package Ch06;

import java.util.Scanner;

public class C06SwitchMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int menu = 0;
		while(true)
		{
			System.out.println("------------MENU------------");
			System.out.println("1 도서 조회");
			System.out.println("2 도서 등록");
			System.out.println("3 도서 수정");
			System.out.println("4 도서 삭제");
			System.out.println("5 종료");
			System.out.println("------------MENU------------");
			System.out.println("번호입력 : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("도서조회 작업");
				//도서 조회 작업(Database 연결 + 조회)
				break;
			case 2:
				System.out.println("도서등록 작업");
				//도서 등록 작업(Database 연결 + 삽입)
				break;
			case 3:
				System.out.println("도서수정 작업");
				//도서 수정 작업(Database 연결 + 조회 + 수정)
				break;
			case 4:
				System.out.println("도서삭제 작업");
				//도서 삭제 작업(Database 연결 + 조회 + 삭제)
				break;
			case 5:
				System.out.println("종료합니다.");
				//종료
				System.exit(-1);
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}

	}

}
