package CrossKnots;

import javax.swing.JButton;

public final class Tester {

	public static void main(String[] args) 
	{
	TicTacToe tt=new TicTacToe();
	JButton jbsp[]=tt.getButtons();
    jbsp[0].setText("O");
    jbsp[3].setText("O");
    jbsp[6].setText("O");
    System.out.println(tt.winner());
	}

}
