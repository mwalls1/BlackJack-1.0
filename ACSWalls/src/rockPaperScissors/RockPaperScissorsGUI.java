package rockPaperScissors;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RockPaperScissorsGUI extends JFrame
{
	private static final String TITLE="Rock Paper & Scissors";
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
	
	public RockPaperScissorsGUI()
	{
		//Necessary initialization code
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Get content pane
		content=getContentPane();
		content.setBackground(new Color(0,0,1));
		
		//Set layout
		content.setLayout(new GridLayout(3,2));

		//Create labels
		player1Label=new JLabel("PLAYER 1", SwingConstants.CENTER);
		player1Label.setForeground(Color.white);
		player2Label=new JLabel("PLAYER 2", SwingConstants.CENTER);
		player2Label.setForeground(Color.white);
		result=new JLabel("RESULT", SwingConstants.CENTER);
		result.setForeground(Color.white);
						
		//Create text fields
		player1=new JTextField("");
		player2=new JTextField("");

		//Create button and handler
		play=new JButton("PLAY!");
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
		RockPaperScissorsGUI gui=new RockPaperScissorsGUI();
		
		//set layout
		//gui.setLayout();	
		
	}
	
	private class PlayButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Get input plays
			char p1=player1.getText().charAt(0);
			char p2=player2.getText().charAt(0);
			
			//Check invalid plays
			if(p1 != 'R' && p1 != 'S' && p1 != 'P')
			{
				result.setText("Invalid play!");
			}
			else if(p2 != 'R' && p2 != 'S' && p2 != 'P')
			{
				result.setText("Invalid play!");
			}
			//Check ties
			else if(p1==p2)
			{
				result.setText("It is a tie!");
			}
			//Check other combinations
			else if(p1=='R' && p2=='S' || p1=='S' && p2=='P' || p1=='P' && p2=='R')
			{
				result.setText("Player 1 wins!");
			}
			else
			{
				result.setText("Player 2 wins!");
			}
			
			setVisible(true);
		}
	}
}