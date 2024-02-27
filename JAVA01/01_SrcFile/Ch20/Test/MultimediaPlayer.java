package Ch20.Test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MultimediaPlayer extends JFrame implements ActionListener {

	
    private JButton playButton;
    private JButton pauseButton;
    private JButton stopButton;
    private Clip audioClip;
    private JLabel albumCoverLabel;
    
    private final String mp3FileToPlay;
    private Player jlPlayer;
    
	
    public MultimediaPlayer(String mp3FileToPlay){
    	
    	this.mp3FileToPlay = mp3FileToPlay;
    	 
    	 
        setTitle("Multimedia Player");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Play Button
        playButton = new JButton("Play");
        playButton.addActionListener(this);

        // Pause Button
        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(this);

        // Stop Button
        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);

        // Album Cover Label
        albumCoverLabel = new JLabel();
        
        
        
        try {
            BufferedImage albumCoverImage = ImageIO.read(new File("C:\\임베디드웹과정임시공유폴더\\eclipse\\LocalWorkspace\\JAVA20230523\\src\\Ch20\\Test\\그날처럼.jpg"));
            albumCoverLabel.setIcon(new ImageIcon(albumCoverImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add components to the frame
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(playButton);
        getContentPane().add(pauseButton);
        getContentPane().add(stopButton);
        getContentPane().add(albumCoverLabel);
    }
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == playButton) {
	    	playAudio(null);
        } else if (e.getSource() == pauseButton) {
        
        } else if (e.getSource() == stopButton) {
        	jlPlayer.close();
        }
		
	}
    private void playAudio(String audioFilePath) {
        
            try {
                FileInputStream fileInputStream = new FileInputStream("C:\\임베디드웹과정임시공유폴더\\eclipse\\LocalWorkspace\\JAVA20230523\\src\\Ch20\\Test\\그날처럼.mp3");
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
    
    private void pauseAudio() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
        }
    }

    private void stopAudio() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
            audioClip.setFramePosition(0);
        }
    }
    
    
    public void close() {
        if (jlPlayer != null) jlPlayer.close();
    }
    
    
	public static void main(String[] args) {
		  SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new MultimediaPlayer(null).setVisible(true);
	            }
	        });

	}
	

}
