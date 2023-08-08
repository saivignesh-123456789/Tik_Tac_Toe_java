import javax.swing.*;
import javax.swing.border.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;

public class Rotation {
	public static void main(String[] arsg) {
		new Intro01();
	}
}
class Rotation1 extends JPanel {
	Image ball ;
	int ballx = 300;
	int bally = 50;
	int pad1score = 0;
	int pad2score = 0;
	Random rand = new Random();
	JTextField[] field = new JTextField[2];
	JFrame frame = new JFrame("Ping pong Game");
	JPanel paddle1 = new JPanel();
	JPanel paddle2 = new JPanel();
	int ballxspeed = 9;
	int ballyspeed = 5;
	Rotation1() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setTitle("Ping pong game");
		frame.setResizable(false);
		frame.setSize(750,750);
		frame.add(this);
		frame.addKeyListener(new KeyListener() {
			
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyChar()) {
					case 'w':
					paddle1.setLocation(paddle1.getX(),paddle1.getY()-15);
					break;
					case 's':
					paddle1.setLocation(paddle1.getX(),paddle1.getY()+15);
					break;
					case 'i':
					paddle2.setLocation(paddle2.getX(),paddle2.getY()-15);
					break;
					case 'k':
					paddle2.setLocation(paddle2.getX(),paddle2.getY()+15);
					break;
				}
			}
			public void keyTyped(KeyEvent e) {
				
			}
			public void keyReleased(KeyEvent e) {
				
			}
		});
		ball = new ImageIcon("ball.png").getImage();
		
		this.setBounds(0,0,750,750);
		this.setLayout(null);
		this.setBackground(Color.black);
		
		paddle1.setBounds(0,0,54,150);
		paddle1.setBackground(Color.green);
		paddle2.setBounds(680,0,50,150);
		paddle2.setBackground(Color.green);
		this.add(paddle1);
		this.add(paddle2);
		
		mainFunction();
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.white);
		g2.drawLine(375,0,375,750);
		g2.drawImage(ball,ballx,bally,null);
	}
	public void mainFunction() {
		
		while(true) {
			ballx = ballx + ballxspeed ;
			try {
				Thread.sleep(30);
			} catch(InterruptedException e) {
				e.printStackTrace(); // ||
			}
			bally = bally + ballyspeed ;
			if(ballx < 0 || ballx > 688) {
				ballxspeed = ballxspeed * -1;
			} else if(bally < 0 || bally > 630) {
				ballyspeed = ballyspeed * -1;
			}
			
			if(ballx <= paddle1.getX()+50 && bally >= paddle1.getY()-10 && bally <= paddle1.getY()+150+10){
				if(ballxspeed == -9 && ballyspeed == -5) {
					ballyspeed = 5;
				} else if(ballxspeed == -9 && ballyspeed == 5) {
					ballyspeed = -5;
				}
				ballxspeed = ballxspeed * -1;
				ballyspeed = ballyspeed * -1;
			}
			else if(ballx + ball.getWidth(null) >= paddle2.getX() && bally >= paddle2.getY()-50 && bally <= paddle2.getY()+150+50) {			
				if(ballxspeed == 9 && ballyspeed == 5) {
					ballyspeed = -5;
				} else if(ballxspeed == 9 && ballyspeed == -5) {
					ballyspeed = 5;
				}
				ballxspeed = ballxspeed * -1;
				ballyspeed = ballyspeed * -1;
			}
			
			repaint();
		}
	}
}
class Intro01 {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JProgressBar bar = new JProgressBar();
	JTextField field = new JTextField();
	Intro01() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(600,600);
		frame.setResizable(false);
		frame.add(panel);
		
		panel.setBackground(Color.green);
		panel.setBounds(0,0,600,600);
		panel.setLayout(null);
		panel.add(field);
		panel.add(bar);
		
		field.setBounds(0,0,600,100);
		field.setBackground(Color.green);
		field.setForeground(Color.red);
		field.setFont(new Font("Calibri",Font.BOLD,67));
		field.setText("    Ping Pong Game");
		field.setEditable(false);
		field.setBorder(new LineBorder(Color.green,3));
		progressbarfunction();
	}
	public void progressbarfunction() {
		bar.setBounds(0,500,600,75);
		bar.setStringPainted(true);
		bar.setFont(new Font("Calibri",Font.BOLD,30));
		bar.setValue(0);
		bar.setBackground(Color.blue);
		bar.setForeground(Color.red);
		int i = 0;
		while(i <= 100) {
			bar.setValue(i);
			bar.setString(Integer.toString(i)+"%");
			try {
				Thread.sleep(100);
			} catch(Exception e) {
				e.printStackTrace();
			}
			i = i + 1;
		}
		frame.dispose();
		new Intro02();
	}
}
class Intro02 {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	int frame_width = 500;
	int frame_height = frame_width;
	int panel_width = frame_width;
	int panel_height = frame_height;
	JPasswordField pass = new JPasswordField();
	JTextField field = new JTextField();
	
	Intro02() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setSize(frame_width,frame_height);
		frame.add(panel);
		
		panel.setBounds(0,0,panel_width,panel_height);
		panel.setLayout(null);
		panel.setBackground(Color.blue);
		panel.add(field);
		panel.add(pass);
		
		fieldInitiation();
		passwordInitiation();
	}
	public void fieldInitiation() {
		field.setBounds(0,0,500,90);
		field.setFont(new Font("MV Boli",Font.BOLD,30));
		field.setBackground(Color.blue);
		field.setBorder(new LineBorder(Color.blue,4));
		field.setForeground(Color.red);
		field.setEditable(false);
		field.setText("Enter Password to play Game");
	}
	public void passwordInitiation() {
		pass.setBounds(0,250,500,80);
		pass.setBackground(Color.green);
		pass.setFont(new Font("Calibri",Font.BOLD,40));
	
		while(true) {
			try {
				Thread.sleep(50);
			} catch(Exception e) {
				e.printStackTrace();
			}
			if(pass.getText().equals("Saivignesh")) {
				frame.dispose();
				new Rotation1();
				break;
			}
		}
	}
}