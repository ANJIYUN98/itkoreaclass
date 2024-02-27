package Ch33Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class C01Basic {
	public static void main(String[] args) throws Exception {
	     // 클래스 이름으로부터 Class 객체 얻기
        Class<?> clazz = Class.forName("Ch33Reflect.TEST");

        // 클래스의 필드 정보 얻기
        Field field = clazz.getDeclaredField("myField");
        field.setAccessible(true); 	//private 도 사용가능
        
         
        // 필드 값 읽기
        Object value = field.get(new TEST());
        System.out.println("Field's Value : "+ value);
        
        // 필드 값 설정
        field.set(new TEST(), "newValue");
        System.out.println("Field's Value : "+ value);
        
        
        // 클래스의 메서드 정보 얻기
        Method method = clazz.getDeclaredMethod("TestFunc1",null);	//두번째는 전달인자(null은 인자없음)
        System.out.println("METHOD : "+method);
        
        // 메서드 호출
        Object result = method.invoke(new TEST(), null);	//두번째는 전달인자(null은 인자없음)
        

        // 클래스의 생성자 정보 얻기
        //getConstructor는 특정 매개변수클래스를 받는 생성자를  가져온다
        Constructor<?> constructor = clazz.getConstructor(String.class);
        System.out.println("CONSTRUCTOR : " +constructor );
//
//        // 생성자를 통한 객체 인스턴스화
       Object instance = constructor.newInstance("constructorArg");
       System.out.println("INSTANCE : " + instance);
	}
}
