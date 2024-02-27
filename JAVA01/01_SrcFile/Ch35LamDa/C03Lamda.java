package Ch35LamDa;

import java.util.ArrayList;
import java.util.List;

//Person 객체 정의
class Person {
 private String name;
 private int age;

 public Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }
}


public class C03Lamda {
	public static void main(String[] args) {

		//Person 리스트 생성
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("John", 25));
		personList.add(new Person("Alice", 30));
		personList.add(new Person("Bob", 20));

		//람다 표현식을 사용하여 리스트를 나이순으로 정렬
		personList.sort((person1, person2) -> person1.getAge() - person2.getAge());

		//정렬된 리스트 출력
		for (Person person : personList) {
		 System.out.println(person.getName() + " - " + person.getAge());
		}
	}
}
