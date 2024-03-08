package Ch12_1;


class Point2D{
	int x;
	int y;
	
	Point2D(){
		System.out.println("Point2D() 생성자 호출!");
	}
	
	Point2D(int x){
		this.x =x;
		System.out.println("Point2D(int x) 생성자 호출!");
	}
	
	Point2D(int x, int y){
		this.x =x; this.y =y;
		System.out.println("Point2D(int x, int y) 생성자 호출!");
	}
	
	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}
	
	
}
class Point3D extends Point2D {
	int z;
	
	Point3D(){
		super(); // 상위클래스 Point2D 생성자 호출!, 안해도 자동으로 default로 실행됨
		System.out.println("Point3D() 생성자 호출!");
	}
	
	Point3D(int x){
		super(x); //인자 하나 받는 상위 클래스 default 생성자 호출 (Point2D(int x)를 호출)
//		this.x=x; //이렇게 해도 됨
		System.out.println("Point3D(int x) 생성자 호출!");
	} //인자 받음
	
	Point3D(int x, int y){
		super(x, y); //두개 인자 받는 생성자 호출(Point2D(int x, int y)를 호출)
		System.out.println("Point3D(int x, int y) 생성자 호출!");
	}
	
	Point3D(int x, int y, int z){
		super(x,y); //여기서는 상위 클래스에 z가 없기 때문에 x,y만 호출하고 this.z=z 를 만들어 준다.
		this.z =z;
		System.out.println("Point3D(int x, int y, int z) 생성자 호출!");
	}

	@Override
	public String toString() {
		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}
		
	
} // 상속 기본(extends Point2D)


public class C02InheritanceMain2 {

	public static void main(String[] args) {
		Point3D ob = new Point3D();
		Point3D ob2 = new Point3D(10);
		Point3D ob3 = new Point3D(10,20);
		Point3D ob4 = new Point3D(10,20,30);
		

	}

}
