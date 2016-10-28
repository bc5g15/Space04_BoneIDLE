package sc02_BoneIDLE;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;



public class Swing2 implements ActionListener {
	
	private JTextArea code;
	private JTextArea vars;
	
	public void actionPerformed(ActionEvent e)
	{
		//Respond to button presses.
		//Makes use of the superbone interpreter.
		//System.out.println(e);
		
		if(e.getActionCommand().equals("compile"))
		{
			superbone.Controller.Clear();
			if(code.getText() != null) superbone.Reader.readBigFile(code.getText());
		}
		else if(e.getActionCommand().equals("run"))
		{
			superbone.Controller.FullRun();
			superbone.Variables.PrintVars();
		}
		else if(e.getActionCommand().equals("next"))
		{
			superbone.Controller.next();
		}
		
		vars.setText(superbone.Variables.GetAllVars());
		
	}
	
	//Create and display the GUI
	public void BuildAndShow()
	{
		JFrame frame = new JFrame("Resting");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel lblCode = new JLabel("Code:");
		c.gridx = 0;
		c.gridy = 0;
		pane.add(lblCode, c);
		
		JLabel lblVars = new JLabel("Variables");
		c.gridx = 3;
		pane.add(lblVars, c);
		
		code = new JTextArea();
		code.setColumns(20);
		code.setRows(20);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 3;
		
		JScrollPane scroll1 = new JScrollPane(code);
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		pane.add(scroll1, c);
		
		vars = new JTextArea();
		vars.setColumns(20);
		vars.setRows(20);
		vars.setEditable(false);
		vars.setForeground(Color.BLACK);
		
		JScrollPane scroll2 = new JScrollPane(vars);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		c.gridx = 3;
		pane.add(scroll2, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		
		JButton b = new JButton("Compile");
		b.addActionListener(this);
		b.setActionCommand("compile");
		c.gridx = 2;
		c.gridy = 1;
		c.gridheight = 1;
		pane.add(b, c);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(this);
		btnNext.setActionCommand("next");
		c.gridx = 2;
		c.gridy = 2;
		pane.add(btnNext, c);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(this);
		btnRun.setActionCommand("run");
		c.gridx = 2;
		c.gridy = 3;
		pane.add(btnRun, c);
		
		//frame.getContentPane().add(pane, BorderLayout.CENTER);
		frame.setContentPane(pane);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}
