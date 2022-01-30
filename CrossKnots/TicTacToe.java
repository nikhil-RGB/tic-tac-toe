package CrossKnots;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Scanner;
public final class TicTacToe {
	public static final String[] winCombns={"0 1 2","3 4 5","6 7 8","0 3 6","1 4 7","2 5 8","0 4 8","2 4 6"};
    //A list of all the win combinations of positions for a player.
	private boolean chance;//indicates which player's chance it is.
	private JButton[] table;//Holds the list of buttons in the table.
	private String won;//States whether a player has won, and who the winner is.
	//Main method for the application.
	public static void main(String[] args) 
	{
	SwingUtilities.invokeLater(()->{
		JFrame jfrm=new JFrame("Tic Tac Toe");
		jfrm.setIconImage(new ImageIcon("CKSicon.png").getImage());
		jfrm.setTitle("Tic Tac Toe");
		JPanel jp=new JPanel(new GridLayout(3,3,4,4));
		jp.setBackground(Color.BLACK);
		TicTacToe obj=new TicTacToe();
		JButton jbs[]=obj.getButtons();
		for(JButton jj:jbs)
		{
			jp.add(jj);
		}
		jfrm.setContentPane(jp);
		jfrm.setSize(250,250);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setVisible(true);
		jfrm.setResizable(false);
	});
        
	}
	//Constructor for tic-tac-toe
	public TicTacToe()
	{
	 this.won="";
	 this.chance=false;
	 this.table=new JButton[9];
	 ActionListener al=(ev)->
	 {
		if(!won.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Game is already over");
		    return;	
		}
		JButton jb=(JButton)(ev.getSource());
		if(!jb.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Unit already occupied");
			return;
		}
		if(chance)
		{
			jb.setText("X");
			jb.setBackground(Color.RED);
		}
		else
		{
			jb.setText("O");
			jb.setBackground(Color.BLUE);
		}
		this.won =this.winner();
		if(!this.won.equals(""))
		{
			JOptionPane.showMessageDialog(null,this.won+" won the game!");
		}
		chance=!chance;
	 };
	 for(int i=0;i<9;++i)
	 {
		 JButton op=this.table[i]=new JButton("");
		 op.setBackground(Color.BLACK);
		 op.setBorder(BorderFactory.createLineBorder(Color.WHITE,4,true));
		 op.setForeground(Color.WHITE);
		 op.setFont(new Font("SansSerif",Font.BOLD,18));
		 op.addActionListener(al);
		 op.setActionCommand(i+"");
	 }
	}
	//this method gets the buttons associated with the board
	public JButton[] getButtons()
	{
		return this.table;
	}
	//This method returns a winner, if one has been decided.
	public String winner()
	{
		
		for(int k=0;k<TicTacToe.winCombns.length;++k)
		{
			String combn=TicTacToe.winCombns[k];
			String[] tokens=new String[] {"O","X"};
			TOKEN:
			for(String token:tokens)
			{
				Scanner sc=new Scanner(combn);
			    while(sc.hasNext())
			    {
			    	int pos=sc.nextInt();
			    	String op=this.table[pos].getText();
			    	if(!op.equals(token))
			    	{
			    	continue TOKEN;
			    	}
			    }
			    sc.close();
			    return token;
			}
		  }
		if(this.isFilled())
		{
			return "No one";
		}
		return "";
	}
	
	//This method checks whether the board is filled or not
	public boolean isFilled()
	{
		for(JButton jb:table)
		{
			if(jb.getText().isEmpty())
			{
				return false;
		    }
		}
	  return true;	
	}

}
