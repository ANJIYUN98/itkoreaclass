package Ch02;

public class C06실수오차범위확인 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Float : " + (0.44444444444F)); //FLOAT형 접미사
		System.out.println("Float : " + (0.77777777777F)); //FLOAT형 접미사
		System.out.println("Float : " + (0.999999999999999999999F)); //FLOAT형 접미사
		System.out.println("Double : " + (0.7777777777777777777777777777777777777777777)); //사이즈 제한 있어서 끊어짐, 반올림 됨 
		System.out.println("Double : " + (0.9999999999999999999999999999999999999999999)); 
		System.out.println("Double : " + (0.2222222222222222222222222222222222222222222)); 
		//오차범위 줄이기 위해 실수를 정수로 바꿔서 하면 좋음
		
	
							

	}

}
