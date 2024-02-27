package Ch23;

 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class GUI2 extends JFrame implements ActionListener,KeyListener{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JTextField txt1;
	
	JTextField txt2;
	JTextArea area1;
	JScrollPane scroll1;
	
	//DB INSERT FRAME_WINDOW
	JFrame Frm_Insert;
	JFrame Frm_Update;
	JFrame Frm_Delete;
	JFrame Frm_Select;
	
	// 연결정보 저장용 변수
	String id = "root";
	String pw = "1234";
	String url = "jdbc:mysql://localhost:3306/tmpdb";
			
	// JDBC 참조변수
	Connection conn = null;			// DB연결용 참조변수
	PreparedStatement pstmt = null;	// SQL 쿼리 전송용 참조변수
	ResultSet rs = null;			// SQL 쿼리 결과(Select 결과) 수신용 참조변수
	
	GUI2(){
		//Frame
		super("프레임창입니다");
		setBounds(100,100,550,400);
		
		//Panel
		JPanel panel = new JPanel();		//패널생성
		panel.setLayout(null);
		
		//Component
		btn1 = new JButton("IO_저장하기");
		btn2 = new JButton("IO_불러오기");
		btn3 = new JButton("DB_INSERT");
		btn6 = new JButton("DB_SELECT");
		txt1=new JTextField();
		txt2=new JTextField();
		area1=new JTextArea();
		//area1.setBounds(10,90,210,300);
		scroll1=new JScrollPane(area1);
		
		
		//Positioning
		txt1.setBounds(10,270,350,30);
		btn1.setBounds(370,10,120,30);
		btn2.setBounds(370,50,120,30);
		btn3.setBounds(370,90,120,30);	//DB_INSERT
		btn6.setBounds(370,130,120,30);	//DB_UPDATE
		scroll1.setBounds(10,10,350,250);
		
		
		//Event처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		btn3.addActionListener(this); //DB
		btn6.addActionListener(this); //DB
		txt1.addKeyListener(this);
		area1.setEditable(false);

		
		
		//Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn6);
		panel.add(txt1);
		panel.add(txt2);
//		panel.add(area1);
		panel.add(scroll1);
		
		//Frame
		add(panel);	//프레임에 panel추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");		// 드라이버 적제
			System.out.println("Driver Loading Success");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB Connected");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		//System.out.println("이벤트 발생");
		if(e.getSource()==btn1) {
			System.out.println("저장하기 클릭");
			
			String context = area1.getText();
			String dirPath = "C:\\Users\\Administrator\\Desktop\\임베디드_이재민\\IO_TEST\\";
			String filename = UUID.randomUUID().toString();
			
			try {
				Writer out = new FileWriter(dirPath+filename+".txt");
				out.write(new Date().toString()+"\n");
				out.write(context);
				out.flush();
				out.close();
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}else if(e.getSource()==btn2) {
			System.out.println("불러오기 클릭");
			JFileChooser fileChooser = new JFileChooser();
			
			File defaultdirpath = new File("C:\\Users\\Administrator\\Desktop\\임베디드_이재민\\IO_TEST\\");	//기본경로 File객체
			fileChooser.setCurrentDirectory(defaultdirpath);//기본경로 설정
			
			int returnValue= fileChooser.showOpenDialog(null);
			String filename=null;
			if(returnValue==JFileChooser.APPROVE_OPTION)	//파일선택한경우
			{
				filename=fileChooser.getSelectedFile().toString();
			}
			System.out.println(filename);
			
			try {
				Reader in = new FileReader(filename);
				area1.setText("");
				StringBuffer buffer=new StringBuffer();
				while(true)
				{
					int data=in.read();
					if(data==-1)
						break;
					buffer.append((char)data);
				}
				in.close();
				area1.append(buffer.toString());
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==btn3)
		{
			//DB_INSERT
			System.out.println("DB_INSERT");
			if(Frm_Insert==null) {
				
				Frm_Insert = new JFrame("DB_INSERT");
				Frm_Insert.setBounds(650,100,300,400);
				
				// Panel 추가
				JPanel panel = new JPanel();
				
				// Component 객체 지정
				JTextArea area = new JTextArea();
				JScrollPane scroll = new JScrollPane(area);
				JButton btn = new JButton("INSERT");
				
				// Positioning 지정
				scroll.setBounds(17,10,250,250);
				btn.setBounds(100,270,100,30);
				
				// btn_Event처리
				btn.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent e) {
						System.out.println("INSERT_BTN");
						
						// pstmt객체 sql쿼리 저장
						try 
						{
							pstmt = conn.prepareStatement("insert into tbl_memo values(null,?,now())");
							pstmt.setString(1,area.getText());
							int result = pstmt.executeUpdate();
							if(result > 0)
							{
								JOptionPane.showMessageDialog(null,"Insert 성공", "DBCONN",JOptionPane.INFORMATION_MESSAGE);
								//프레임창을 닫는다
								Frm_Insert.setVisible(false);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Insert 실패", "DBCONN",JOptionPane.ERROR_MESSAGE);
								Frm_Insert.setVisible(false);
								// 에러창을 띄운다
							}
						} 
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						finally
						{
							// pstmt.executeUpdate() DB 저장
							// 자원정리
							try 
							{
								pstmt.close();
							} 
							catch (SQLException e1) 
							{
								e1.printStackTrace();
							}
						}
						
						
					}});
				
				// Component를 panel에 추가
				panel.add(scroll);
				panel.add(btn);
				panel.setLayout(null);
				
				// Frame에 panel 추가
				Frm_Insert.getContentPane().add(panel);
				
				//X 버튼 누를때 setVisible(false)로 설정됨
				Frm_Insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Frm_Insert.setVisible(true);	
				
				
			}else
			{
				Frm_Insert.setVisible(true);
			}

		}
		
		else if(e.getSource()==btn6) {
			//DB_SELECT
			System.out.println("DB_SELECT");

//			if(Frm_Select==null) {
				
				Frm_Select = new JFrame("DB_SELECT");
				Frm_Select.setBounds(650,100,400,400);
				
				// panel생성
				JPanel panel = new JPanel();
																
				
				// Table구조만들기
				String[] column = {"No", "Contents", "RegDate"};
				Object [][] data = {}; 
				DefaultTableModel model = new DefaultTableModel(data,column);
				
				// tbl_memo로부터 데이터 가져오기
				try 
				{
					pstmt = conn.prepareStatement("select * from tbl_memo");
					rs = pstmt.executeQuery();
					
					if(rs != null)
					{
						while(rs.next())
						{
							Object[] rowData = {rs.getInt("no"),rs.getString("contents"),rs.getString("regdate")};
							model.addRow(rowData);
							System.out.print(rs.getInt("no") + " ");
							System.out.print(rs.getString("contents") + " ");
							System.out.print(rs.getString("regdate") + "\n");
						}
					}
					
				} 
				catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				finally
				{
					try {
						rs.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						pstmt.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				
				// Component 생성
				JTable table = new JTable(model);
				JTextField txt = new JTextField("No");
				JTextArea area = new JTextArea();
				JScrollPane scroll = new JScrollPane(table);
				btn4 = new JButton("DB_UPDATE");
				btn5 = new JButton("DB_DELETE");
							
				
				// Table 열의 크기지정
				table.getColumnModel().getColumn(0).setPreferredWidth(1);
				table.getColumnModel().getColumn(1).setPreferredWidth(150);
				table.getColumnModel().getColumn(2).setPreferredWidth(20);
				
				// Positioning 지정
				scroll.setBounds(10,10,370,230);								
				txt.setBounds(10,250,50,50);
				area.setBounds(70,250,280,50);
				btn4.setBounds(20,320,150,30);	//DB_UPDATE
				btn5.setBounds(220,320,150,30);	//DB_Delete
				
				btn4.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent e) {
						System.out.println("Update_BTN");
						
						// pstmt객체 sql쿼리 저장
						try 
						{
							pstmt = conn.prepareStatement("Update tbl_memo set contents =? , regdate=now() where no = ?");
							pstmt.setString(1,area.getText());
							pstmt.setInt(2,Integer.parseInt(txt.getText()));
							
							int result = pstmt.executeUpdate();
							if(result > 0)
							{
								JOptionPane.showMessageDialog(null,"Update 성공", "DBCONN",JOptionPane.INFORMATION_MESSAGE);
								//프레임창을 닫는다
								
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Update 실패", "DBCONN",JOptionPane.ERROR_MESSAGE);
								
								// 에러창을 띄운다
							}
						} 
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						finally
						{
							// pstmt.executeUpdate() DB 저장
							// 자원정리
							try 
							{
								pstmt.close();
							} 
							catch (SQLException e1) 
							{
								e1.printStackTrace();
							}
							model.setRowCount(0); // 기존 데이터 초기화

					        // tbl_memo로부터 데이터 가져오기
					        try {
					            pstmt = conn.prepareStatement("select * from tbl_memo");
					            rs = pstmt.executeQuery();

					            if (rs != null) {
					                while (rs.next()) {
					                    Object[] rowData = { rs.getInt("no"), rs.getString("contents"), rs.getString("regdate") };
					                    model.addRow(rowData);
					                }
					            }
					        } catch (SQLException e1) {
					            e1.printStackTrace();
					        } finally {
					            // ...
					        }
					    }
					}});

				btn5.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent e) {
						System.out.println("Delete_BTN");
						
						// pstmt객체 sql쿼리 저장
						try 
						{
							pstmt = conn.prepareStatement("Delete from tbl_memo where no = ? ");
							
							pstmt.setInt(1,Integer.parseInt(txt.getText()));
							
							int result = pstmt.executeUpdate();
							if(result > 0)
							{
								JOptionPane.showMessageDialog(null,"Delete 성공", "DBCONN",JOptionPane.INFORMATION_MESSAGE);
								//프레임창을 닫는다
								
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Delete 실패", "DBCONN",JOptionPane.ERROR_MESSAGE);
							
								// 에러창을 띄운다
							}
						} 
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						finally
						{
							// pstmt.executeUpdate() DB 저장
							// 자원정리
							try 
							{
								pstmt.close();
							} 
							catch (SQLException e1) 
							{
								e1.printStackTrace();
							}
							model.setRowCount(0); // 기존 데이터 초기화

					        // tbl_memo로부터 데이터 가져오기
					        try {
					            pstmt = conn.prepareStatement("select * from tbl_memo");
					            rs = pstmt.executeQuery();

					            if (rs != null) {
					                while (rs.next()) {
					                    Object[] rowData = { rs.getInt("no"), rs.getString("contents"), rs.getString("regdate") };
					                    model.addRow(rowData);
					                }
					            }
					        } catch (SQLException e1) {
					            e1.printStackTrace();
					        } finally {
					            // ...
					        }
					    }
					}});
				
				// Component를 panel에 추가
				panel.add(btn4);
				panel.add(btn5);
				panel.add(txt);
				panel.add(area);
				panel.add(scroll);
				panel.setLayout(null);
				
				// Frame에 panel 추가
				Frm_Select.getContentPane().add(panel);
				
				//X 버튼 누를때 setVisible(false)로 설정됨
				Frm_Select.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Frm_Select.setVisible(true);	
//			}else
//			{
//				Frm_Select.setVisible(true);
//			}					
		}		
	}

	public void keyTyped(KeyEvent e) {	

		
	}

	public void keyPressed(KeyEvent e) {
		//키를 눌렀을때
		if(e.getSource()==txt1)
		{
			if(e.getKeyCode()==10)
			{
				System.out.println("txt1's Enter");
				String str= txt1.getText();
				area1.append(str+"\n");
				txt1.setText("");
			}
			
		}
	}

	public void keyReleased(KeyEvent e) {


	}
	
}


public class C07SwingUI_IO_DB_BYJAEMOIN {

	public static void main(String[] args) {
		new GUI2();
	}
}
