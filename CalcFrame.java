//Alex Dao


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CalcFrame extends JFrame implements KeyListener
{
	private JPanel buttonPanel;
	private JButton buttons[];
	private JTextField resultJText;
	private boolean startNumber = true;
    private String previousOp  = "="; 
    private Calc logic = new Calc(); 
    

	public CalcFrame()
	{
		super("Alex Dao's Calculator");

		Container contain = getContentPane();


		buttons = new JButton[10];


		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 4));
		ActionListener opListener = new OperationListener();
		ActionListener cListener = new ClearListener();
		ActionListener cEListener = new ClearEntryListener();
		ActionListener numberListener = new NumListener();


		JButton enterButton = new JButton("=");
		enterButton.addActionListener(opListener);
		enterButton.setFocusable(false);

	    JButton cButton = new JButton("C");
	    cButton.addActionListener(cListener);
	    cButton.setFocusable(false);

	    JButton cEButton = new JButton("CE");
	    cEButton.addActionListener(cEListener);
	    cEButton.setFocusable(false);

	    JButton multiplyButton = new JButton("*");
	    multiplyButton.addActionListener(opListener);
	    multiplyButton.setFocusable(false);

	    JButton divideButton = new JButton("/");
	    divideButton.addActionListener(opListener);
	    divideButton.setFocusable(false);
	    
	    JButton addButton = new JButton("+");
	    addButton.addActionListener(opListener);
	    addButton.setFocusable(false);

	    JButton substractButton = new JButton("-");
	    substractButton.addActionListener(opListener);
	    substractButton.setFocusable(false);
	    
	    JButton decimal = new JButton(".");
	    decimal.addActionListener(numberListener);
	    decimal.setFocusable(false);



	    JButton topdGridOps[] = new JButton[3];
	    topdGridOps[0] = multiplyButton;
	    topdGridOps[1] = divideButton;
	    topdGridOps[2] = substractButton;


	    resultJText = new JTextField();
	    resultJText.setPreferredSize(new Dimension(160, 40));
		resultJText.setBackground(Color.BLACK);
		resultJText.setEnabled(false);
		resultJText.setHorizontalAlignment(4);
		resultJText.setDisabledTextColor(Color.GREEN);
		resultJText.setText("0");

		resultJText.setFocusable(true);

		contain.add(resultJText, BorderLayout.NORTH);


		for ( int i = 0; i < buttons.length ; i++) 
		{
			buttons[i] = new JButton(""+(i));
			buttons[i].addActionListener(numberListener);
			buttons[i].setFocusable(false);
    	}

		buttonPanel.add(buttons[7]);
		buttonPanel.add(buttons[8]);
		buttonPanel.add(buttons[9]);
		buttonPanel.add(topdGridOps[0]);

		buttonPanel.add(buttons[4]);
		buttonPanel.add(buttons[5]);
		buttonPanel.add(buttons[6]);
		buttonPanel.add(topdGridOps[1]);

		buttonPanel.add(buttons[1]);
		buttonPanel.add(buttons[2]);
		buttonPanel.add(buttons[3]);
		buttonPanel.add(topdGridOps[2]);

		buttonPanel.setFocusable(true);
		buttonPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		contain.add(buttonPanel, BorderLayout.CENTER);


		JPanel bottomOps = new JPanel();
		bottomOps.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();

	    c.fill = GridBagConstraints.HORIZONTAL;
	   	c.weightx = 0;
	   	c.gridwidth = 2;
	   	c.ipady = 20; 
	    c.gridx = 0;
	    c.gridy = 0;
	    bottomOps.add(buttons[0], c);
	 
	  	c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0;
	    c.gridwidth = 1;
	    c.gridx = 2;
	    c.gridy = 0;
	    bottomOps.add(decimal, c);

	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 65;      
	    c.weightx = 0.0;
	    c.gridheight = 2;
	    c.gridx = 3;
	    c.gridy = 0;
	    bottomOps.add(addButton, c);
	 
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 20;
	    c.weightx = 0.5;
	    c.gridheight = 1;
	    c.gridx = 0;
	    c.gridy = 1;
	    bottomOps.add(cButton, c);

	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 1;
	    c.gridy = 1;
	    bottomOps.add(cEButton, c);

	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 1;
	    bottomOps.add(enterButton, c);
	    bottomOps.setFocusable(true);

	    bottomOps.setBorder(BorderFactory.createRaisedBevelBorder());

		contain.add(bottomOps, BorderLayout.SOUTH);

		buttonPanel.setBackground(Color.CYAN);
		bottomOps.setBackground(Color.CYAN);

		addKeyListener(this);
		setFocusable(true);

		setSize(300, 300);
		setVisible(true);
	}


	private void actionClear() 
	{
        startNumber = true;  
        resultJText.setText("");
        previousOp  = "=";
        logic.setTotal("0");
        setFocusable(true);
    }

    private void actionClearEntry() 
	{
        resultJText.setText("");
        setFocusable(true);
    }


	private class OperationListener implements ActionListener 
	{
        public void actionPerformed(ActionEvent e) 
        {
            if (startNumber) 
            {
                actionClear();
                resultJText.setText("Error: Please enter a number first");
            } 


            else 
            {
                startNumber = true;
                    String displayedText = resultJText.getText();
                    
                     if (previousOp.equals("=")) 
                     {
                         logic.setTotal(displayedText);
                         resultJText.setText("" + logic.getTotalString());
                     } 

                    else if (previousOp.equals("+")) 
                    {
                        logic.add(displayedText);
                        resultJText.setText("" + logic.getTotalString());
                    }

                    else if (previousOp.equals("-")) 
                    {
                        logic.subtract(displayedText);
                        resultJText.setText("" + logic.getTotalString());
                    } 

                    else if (previousOp.equals("*")) 
                    {
                        logic.multiply(displayedText);
                        resultJText.setText("" + logic.getTotalString());
                    } 

                    else if (previousOp.equals("/")) 
                    {
                    	if (displayedText.equals("0"))
                    		resultJText.setText("Cannot divide by 0");
                    	else
                    	{
	                        logic.divide(displayedText);
	                        resultJText.setText("" + logic.getTotalString());
	                    }
                    }
                    
                
                previousOp = e.getActionCommand();
            }


            setFocusable(true);

        }
    }

     private class NumListener implements ActionListener 
     {
        public void actionPerformed(ActionEvent e) 
        {
            String digit = e.getActionCommand();

            if (startNumber) 
            {
                resultJText.setText(digit);
                startNumber = false;
            }

            else 
            {
            	resultJText.setText(resultJText.getText() + digit); 	
	        }

    		setFocusable(true);

    	}
    }	



    private class ClearListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            actionClear();
            setFocusable(true);

        }
    }

    private class ClearEntryListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            actionClearEntry();
            setFocusable(true);

        }
    }


	public static void main(String args[])
	{
		CalcFrame application = new CalcFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public void keyTyped(KeyEvent e) 
	 {
	 }

    public void keyReleased(KeyEvent e) 
    {
    }
    
    public void keyPressed(KeyEvent e) 
    {
        String keyString = ""+e.getKeyChar();
        int key = e.getKeyCode();


		if (keyString.equals("0")||keyString.equals("1")||keyString.equals("2")||keyString.equals("3")||keyString.equals("4")||keyString.equals("5")||keyString.equals("6")||keyString.equals("7")||keyString.equals("8")||keyString.equals("9")||keyString.equals("."))            
        {
	        if (startNumber) 
	            {
	                resultJText.setText(keyString);
	                startNumber = false;
	            }

	        else
	        {
		        resultJText.setText(resultJText.getText()+keyString);
		    }
		 }
    


		else if (keyString.equals("=")|| keyString.equals("+")|| keyString.equals("-") || keyString.equals("*") || keyString.equals("/") || key == KeyEvent.VK_ENTER)
		{
			if (startNumber) 
		    {
		        actionClear();
		        resultJText.setText("Error: Please enter a number first");
		    } 

	    	else
	     	{
				startNumber = true;
                String displayedText = resultJText.getText();
                    
                 if (previousOp.equals("=")) 
                 {
                     logic.setTotal(displayedText);
                     resultJText.setText("" + logic.getTotalString());
                 } 

                else if (previousOp.equals("+")) 
                {
                    logic.add(displayedText);
                    resultJText.setText("" + logic.getTotalString());
                }

                else if (previousOp.equals("-")) 
                {
                    logic.subtract(displayedText);
                    resultJText.setText("" + logic.getTotalString());
                } 

                else if (previousOp.equals("*")) 
                {
                    logic.multiply(displayedText);
                    resultJText.setText("" + logic.getTotalString());
                } 

                else if (previousOp.equals("/")) 
                {
                	if (displayedText.equals("0"))
                		resultJText.setText("Error: Cannot divide by 0");
                	else
                	{
                        logic.divide(displayedText);
                        resultJText.setText("" + logic.getTotalString());
                    }
                }
                    
	  

				if (key == KeyEvent.VK_ENTER)
					previousOp = "=";
				else   
	            	previousOp = keyString;
     		 }
		}
		
		requestFocus();
	}
}
