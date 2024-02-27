package Ch21;

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
import java.util.Date;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUI extends JFrame implements ActionListener,KeyListener{
	JButton btn1;
	JButton btn2;
	JTextField txt1;
	JTextField txt2;
	JTextArea area1;
	JScrollPane scroll1;
	GUI(){
		//Frame
		super("프레임창입니다");
		setBounds(100,100,350,400);
		
		//Panel
		JPanel panel = new JPanel();		//패널생성
		panel.setLayout(null);
		
		//Component
		btn1 = new JButton("저장하기");
		btn2 = new JButton("불러오기");
		txt1=new JTextField();
		txt2=new JTextField();
		area1=new JTextArea();
		//area1.setBounds(10,90,210,300);
		scroll1=new JScrollPane(area1);
		
		
		//Positioning
		txt1.setBounds(10,270,210,30);
		btn1.setBounds(230,10,90,30);
		btn2.setBounds(230,50,90,30);
		scroll1.setBounds(10,10,210,250);
		
		
		//Event처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		txt1.addKeyListener(this);
		area1.setEditable(false);

		
		//Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
		panel.add(txt2);
//		panel.add(area1);
		panel.add(scroll1);
		
		//Frame
		add(panel);	//프레임에 panel추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		//System.out.println("이벤트 발생");
		if(e.getSource()==btn1) {
			System.out.println("저장하기 클릭");
			
			String context = area1.getText();
			String dirPath = "c:\\iotest\\";
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
			
			File defaultdirpath = new File("c:\\iotest\\");	//기본경로 File객체
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
		
	}



	@Override
	public void keyTyped(KeyEvent e) {	
		//키를 눌렀을때/뗏을때(UNICODE 지원)
//		System.out.println("keyTyped() : "+e.getKeyChar());
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//키를 눌렀을때
//		System.out.println("keyPressed() : "+e.getKeyChar());
//		System.out.println("keyPressed() : "+e.getKeyCode());
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
	@Override
	public void keyReleased(KeyEvent e) {
		//키를 뗏을때(UNICODE 미지원)
//		System.out.println("keyReleased() : " + e.getKeyChar());
//		System.out.println("keyReleased() : " + e.getKeyCode());

	}
	
}


public class C05SwingUI_IO {

	public static void main(String[] args) {
		new GUI();
	}
}
