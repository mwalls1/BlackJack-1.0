package translateGUI;
import javax.swing.*;

import com.temboo.core.TembooException;

import translate.translateChange;

import java.awt.*;
import java.awt.event.*;

public class GUItran extends JFrame
{
	private static final String TITLE="Translator";
	private static final int WIDTH=400;
	private static final int HEIGHT=300;
	
	private Container content;
	private JTextField player1;
	private JTextField player2;
	private JButton play;
	private JLabel player1Label;
	private JLabel player2Label;
	private JLabel result;
	private PlayButtonHandler pbHandler;
	
	public GUItran()
	{
		//Necessary initialization code
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Get content pane
		content=getContentPane();
		content.setBackground(Color.blue.darker().darker());
		
		//Set layout
		content.setLayout(new GridLayout(3,2));

		//Create labels
		player1Label=new JLabel("Enter text to translate", SwingConstants.CENTER);
		player1Label.setForeground(Color.white);
		player2Label=new JLabel("Enter a language to translate to:");
		player2Label.setForeground(Color.white);
		result=new JLabel("RESULT:", SwingConstants.CENTER);
		result.setForeground(Color.white);
						
		//Create text fields
		player1=new JTextField("");
		player2=new JTextField("");

		//Create button and handler
		play=new JButton("Translate");
		pbHandler=new PlayButtonHandler();
		play.addActionListener(pbHandler);
				
		//Add elements to the grid content pane
		content.add(player1Label);
		content.add(player2Label);
		content.add(player1);
		content.add(player2);
		content.add(play);
		content.add(result);
		
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		//Create RockPaperScissors object
		GUItran gui=new GUItran();
		
		//set layout
		//gui.setLayout();	
		
	}
	
	private class PlayButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Get input plays
			String p1=player1.getText();
			String p2=player2.getText();
			translateChange trans = new translateChange(p1,p2);
			try {
				trans.translate();
			} catch (TembooException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			result.setText(trans.getTrans());
			
			setVisible(true);
		}
	}
}
