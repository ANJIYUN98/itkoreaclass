package Ch20.Test;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javazoom.jl.player.Player;

class PlayObj{
	String realPath;
	String playName;
}

class MP3Player {
    private final String mp3FileToPlay;
    private Player jlPlayer;

    public MP3Player(String mp3FileToPlay) {
        this.mp3FileToPlay = mp3FileToPlay;
    }

    public void play() {
        try {
            FileInputStream fileInputStream = new FileInputStream(mp3FileToPlay);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            jlPlayer = new Player(bufferedInputStream);
        } catch (Exception e) {
            System.out.println("Problem playing mp3 file " + mp3FileToPlay);
            System.out.println(e.getMessage());
        }

        new Thread() {
            public void run() {
                try {
                    jlPlayer.play();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }.start();


    }
    
    public void close() {
        if (jlPlayer != null) jlPlayer.close();
    }
}


class C01GUI extends JFrame implements ActionListener,KeyListener,MouseListener
{
	//
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JTextField txt1;
	JTextArea area1;
	MP3Player player ;
	Map<String,JLabel> playlist = new HashMap<String, JLabel>();
	
	//START_PlayList가져오기
	public boolean getPlayList() {
	
		//
		String dir = "C:\\임베디드웹과정임시공유폴더\\eclipse\\LocalWorkspace\\JAVA20230523\\src\\Ch20\\Test\\Playlist";
		
		 List<File> fileList = new ArrayList<>();
	        listFiles(new File(dir), fileList);

	        for (File file : fileList) {
	            System.out.println(file.getAbsolutePath());	//절대경로
	            System.out.println(file.getPath());	//상대경로
	            JLabel tmp = new JLabel(file.getName());
	            playlist.put(file.getName(),tmp);
	            
	            area1.append(file.getName()+"\n");
	        }
		
		return false;
	}
	public static void listFiles(File folder, List<File> fileList) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, fileList); // 하위 폴더의 파일도 검색하기 위해 재귀 호출
                } else {
                    fileList.add(file);
                }
            }
        }
    }
	//END_PlayList가져오기
	
	C01GUI(){
		super(); //상위클래스 생성자 호출
		player= new MP3Player("C:\\Users\\Administrator\\Downloads\\20230525\\EDU_JAVA-main\\src\\Ch30\\그날처럼.mp3");
		
		
		
		
		setTitle("Listner적용하기");
		
		//패널 추가
		JPanel pan1 = new JPanel();
		
		//배경 색 지정
		 
	
		//컴포넌트 객체 생성
		btn1 = new JButton("입력");
		btn2 = new JButton("종료");
		btn3 = new JButton("파일로 저장");
		btn4 = new JButton("음악 재생");
		txt1 = new JTextField();
		area1 = new JTextArea();
		area1.addMouseListener(this);
		JScrollPane scroll1 = new JScrollPane(area1);
		
		
		//컴포넌트 위치 지정 
		scroll1.setBounds(50,50,190,280);
		//area1.setBounds(50,50,190,280);  // Scroll추가시 제거
		txt1.setBounds(50,350,190,30);
		btn1.setBounds(50,400,80,30);
		btn2.setBounds(160,400,80,30);
		btn3.setBounds(250,50,100,30);
		btn4.setBounds(250,90,100,30);
		
		//컴포넌트를 리스너에 등록
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		txt1.addKeyListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		
		//기타설정
		area1.setEditable(false);
		
		//패널에 컴포넌트 추가
		pan1.add(btn1);
		pan1.add(btn2);
		pan1.add(txt1);
		//pan1.add(area1);  // Scroll추가시 제거
		pan1.add(scroll1);
		pan1.add(btn3);
		pan1.add(btn4);
		
		//레이아웃 null
		pan1.setLayout(null);
		
		//패널을 프레임에 추가
		add(pan1);	
		setBounds(100,100,380,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			String tmp = txt1.getText();
			area1.append(tmp+"\n");
			txt1.setText("");
		}
		if(e.getSource()==btn2) {
			System.exit(-1);
		}
		
		if(e.getSource()==btn3) {
			try {
			System.out.println("파일로 저장 버튼 클릭!");
			Writer out = new FileWriter("C:\\abcd\\Dialog.txt",true);
			Date date = new Date(); //날짜시간 정보 출력!
			out.write(date+"\n");
			out.write(area1.getText());
			out.flush();
			out.close();
			
			
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
		//음악재생 버튼 
		if(e.getSource()==btn4) {
			System.out.println("btn4 클릭");
			player.play();
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		 
		if(e.getKeyCode()==10) //엔터키 입력 
		{
			String tmp = txt1.getText();
			area1.append(tmp+"\n");
			txt1.setText("");
			
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//마우스클릭시 이벤트 처리(클릭한 Textarea의 row값을 이용해서 클릭한 행의 Text추출하기)
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("마우스클릭됨..");
		int offset = area1.viewToModel(e.getPoint());
		int row;
		try {
			row=area1.getLineOfOffset(offset);
			int startOffset = area1.getLineStartOffset(row);
            int endOffset = area1.getLineEndOffset(row);
            String clickedText = area1.getText(startOffset, endOffset - startOffset);
            System.out.println("Clicked text: " + clickedText);

            
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

public class 음악Player {

	public static void main(String[] args) {
		
		new C01GUI().getPlayList();
	}

}
