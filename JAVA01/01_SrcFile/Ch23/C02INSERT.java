package Ch23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C02INSERT {

	public static void main(String[] args) {
		//DB연결정보 저장용 변수
		String id="root";
		String pw="1234";
		String url="jdbc:mysql://192.168.2.254:3306/tmpdb";
		
		//JDBC참조변수	
		Connection conn=null;			// DB연결용 참조변수
		PreparedStatement pstmt = null;	// SQL쿼리 전송용 참조변수
		ResultSet rs = null;			// SQL쿼리 결과(SELECT결과) 수신용 참조변수
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");	//드라이브 적재
			System.out.println("Driver Loading Success..");
			conn=DriverManager.getConnection(url,id,pw);
			System.out.println("DB Connected..");
			pstmt = conn.prepareStatement("insert into tbl_students values(?,?,?)");
			pstmt.setString(1, "아무무");
			pstmt.setString(2, "이집트");
			pstmt.setString(3, "010-222-3333");
			int result=pstmt.executeUpdate();
			if(result>0) {
				System.out.println("INSERT성공!");
			}else {
				System.out.println("INSERT실패!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{ pstmt.close(); }catch(Exception e) { }
			try{ conn.close(); }catch(Exception e) { }
		}
		

	}

}
