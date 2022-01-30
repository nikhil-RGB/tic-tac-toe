package CrossKnots;

import javax.swing.JButton;

public final class Tester {

	public static void main(String[] args) 
	{
	TicTacToe tt=new TicTacToe();
	JButton jbsp[]=tt.getButtons();
    jbsp[0].setText("X");
    jbsp[3].setText("X");
    jbsp[6].setText("X");
    System.out.println(tt.winner());
	}

}
