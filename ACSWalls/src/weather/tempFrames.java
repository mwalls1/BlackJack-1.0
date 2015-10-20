package weather;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.temboo.core.TembooException;

public class tempFrames extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * 
	 * @throws TembooException
	 */
	private static String tempp;
	private static String adress;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static double x = 0;
	private static int y = 0;
	public static void main(String[] args) throws TembooException {
		while (true) {
			tempFrames frame = new tempFrames();
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter your address: ");
			adress = scan.nextLine();
			testTambooWeather temp = new testTambooWeather(adress);
			tempp = temp.getTemp();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame.setLocation((int)x, y);
						frame.setVisible(true);
						frame.setAlwaysOnTop(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			if((x+300) >screenSize.getWidth()){
				x=0;
				y+=200;
				System.out.println("RESET!");
			}
			else
				x+=300;
			
		}

	}

	/**
	 * Create the frame.
	 */
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(
				new Color(Integer.parseInt(tempp) * (255 / 100), 0, (Integer.parseInt(tempp) * (-255 / 100)) + 255));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(Color.WHITE);
		g2d.drawString("Address: " + adress, 40, 100);
		g2d.drawString("Temperature: " + tempp + " Fahrenheit", 40, 150);
	}

	public tempFrames() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

}
