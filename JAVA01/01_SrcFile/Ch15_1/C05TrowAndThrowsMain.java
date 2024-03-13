package Ch15_1;

public class C05TrowAndThrowsMain {

    public static void Ex1() throws NullPointerException {
        // NullPointerException이 발생할 수 있는 코드
        throw new NullPointerException("Ex1에서 발생시킨 NULL");
    }

    public static void Ex2() {
        // 예외를 던지지 않는 메서드
    }

    public static void main(String[] args) {
        System.out.println("실행코드1");
        System.out.println("실행코드2");

        try {
            Ex1();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 처리: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception 처리");
        }

        System.out.println("실행코드3");
    }

}
