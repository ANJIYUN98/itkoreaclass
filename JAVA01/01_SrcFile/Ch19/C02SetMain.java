package Ch19;

import java.util.HashSet;
import java.util.Set;

public class C02SetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set = new HashSet();
		set.add("HTML/CSS/JS");
		set.add("React");
		set.add("Redux");	
		set.add("Redux");	//중복 발생시 나중에 저장된 것은 삭제,새로들어온것을 삽입
		set.add("Typescript");
		set.add("Mysql");
		
		System.out.println("개수 확인 : " + set.size());
		set.remove("React");
		System.out.println("개수 확인 : " + set.size());
		
		for(String el : set) {
			System.out.println(el);
		}
		
		set.clear();
		
	}

}
