import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Window extends JFrame {

	/**
	 * Launch the application.
	 */
	protected final static int ROWS = 7;
	protected final static int COLS = 16;
	protected final static List<JToggleButton> list = new ArrayList<JToggleButton>();
	protected static List<JToggleButton> chosen = new ArrayList<JToggleButton>();
	protected static int sum=0;
	protected static JLabel label1;
	protected static JLabel label2;
	protected static JLabel label3;
	protected static JLabel label4;
	protected static JLabel label5;
	protected static JTextArea textArea;
	protected static List<JToggleButton> sel1 = new ArrayList<JToggleButton>();
	protected static List<JToggleButton> sel2 = new ArrayList<JToggleButton>();
	protected static List<JToggleButton> sel3 = new ArrayList<JToggleButton>();
	protected static List<JToggleButton> sel4 = new ArrayList<JToggleButton>();
	protected static List<JToggleButton> sel5 = new ArrayList<JToggleButton>();
	Data data = new Data();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.pack();
					frame.setSize(1280,720);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		Border border_darkGray = BorderFactory.createLineBorder(Color.darkGray, 3);
		Border border_crem = BorderFactory.createLineBorder(new Color(219,176,102), 3);
		
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		getContentPane().setLayout(null);
		
		JLabel lblPrices = new JLabel("Prices (RON)");
		lblPrices.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrices.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrices.setBounds(0, 0, 150, 50);
		lblPrices.setBorder(border_darkGray);
		getContentPane().add(lblPrices);
		
		JLabel lblScena = new JLabel("Stage");
		lblScena.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblScena.setForeground(new Color(255, 255, 255));
		lblScena.setBackground(new Color(153, 51, 0));
		lblScena.setHorizontalAlignment(SwingConstants.CENTER);
		lblScena.setBounds(150, 0, 980, 50);
		lblScena.setBorder(border_crem);
		lblScena.setOpaque(true);
		getContentPane().add(lblScena);
		
		JPanel panel = new JPanel();
		panel=createGridPanel();
		panel.setBounds(150, 50, 980, 400);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(ROWS, COLS, 0, 0));
		
		JPanel panel_left = new JPanel();
		panel_left.setBackground(new Color(255, 255, 255));
		panel_left.setBounds(0, 0, 150, 691);
		panel_left.setBorder(border_darkGray);
		getContentPane().add(panel_left);
		panel_left.setLayout(null);
		
		JPanel panel_right = new JPanel();
		panel_right.setBounds(1130, 0, 144, 691);
		panel_right.setBackground(new Color(255, 255, 255));
		panel_right.setBorder(border_darkGray);
		getContentPane().add(panel_right);
		panel_right.setLayout(null);
		
		Window.textArea = new JTextArea();
		textArea.setBounds(10, 475, 124, 50);
		panel_right.add(textArea);
		textArea.setBackground(new Color(255, 255, 204));
		textArea.setOpaque(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		Window.textArea.setText("Total sum: \n"+Integer.toString(sum)+" RON");
		
		JButton btnCheckout = new JButton("To Checkout\r\n  >");
		btnCheckout.setBounds(3, 560, 138, 48);
		panel_right.add(btnCheckout);
		btnCheckout.setBackground(new Color(0, 153, 0));
		btnCheckout.setForeground(new Color(255, 255, 255));
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCheckout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				for(int k=0;k<chosen.size();k++)
					if(chosen.get(k).getBackground()==label1.getBackground())
						sel1.add(chosen.get(k));
					else
						if(chosen.get(k).getBackground()==label2.getBackground())
							sel2.add(chosen.get(k));
						else
							if(chosen.get(k).getBackground()==label3.getBackground())
								sel3.add(chosen.get(k));
							else
								if(chosen.get(k).getBackground()==label4.getBackground())
									sel4.add(chosen.get(k));
								else
									if(chosen.get(k).getBackground()==label5.getBackground())
										sel5.add(chosen.get(k));
				data.write();
			}
		
		});
		btnCheckout.setOpaque(true);
		
		Window.label1 = new JLabel("");
		label1.setBackground(new Color(102, 0, 153));
		label1.setBounds(50, 60, 50, 50);
		label1.setOpaque(true);
		panel_left.add(label1);
		
		JLabel lblPrice1 = new JLabel("");
		lblPrice1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice1.setBounds(50, 110, 50, 15);
		if(Data.prices[0]>0)
			lblPrice1.setText(Integer.toString(Data.prices[0]));
		panel_left.add(lblPrice1);
		
		Window.label2 = new JLabel("");
		label2.setBackground(new Color(204, 0, 255));
		label2.setBounds(50, 140, 50, 50);
		label2.setOpaque(true);
		panel_left.add(label2);
		
		JLabel lblPrice2 = new JLabel("");
		lblPrice2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice2.setBounds(50, 190, 50, 15);
		if(Data.prices[1]>0)
			lblPrice2.setText(Integer.toString(Data.prices[1]));
		panel_left.add(lblPrice2);
		
		Window.label3 = new JLabel("");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBackground(new Color(51, 204, 255));
		label3.setBounds(50, 220, 50, 50);
		label3.setOpaque(true);
		panel_left.add(label3);
		
		JLabel lblPrice3 = new JLabel("");
		lblPrice3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice3.setBounds(50, 270, 50, 15);
		if(Data.prices[2]>0)
			lblPrice3.setText(Integer.toString(Data.prices[2]));
		panel_left.add(lblPrice3);
		
		Window.label4 = new JLabel("");
		label4.setBackground(new Color(51, 153, 153));
		label4.setBounds(50, 300, 50, 50);
		label4.setOpaque(true);
		panel_left.add(label4);
		
		JLabel lblPrice4 = new JLabel("");
		lblPrice4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice4.setBounds(50, 350, 50, 15);
		if(Data.prices[3]>0)
			lblPrice4.setText(Integer.toString(Data.prices[3]));
		panel_left.add(lblPrice4);
		
		Window.label5 = new JLabel("");
		label5.setBackground(new Color(0, 204, 0));
		label5.setBounds(50, 380, 50, 50);
		label5.setOpaque(true);
		panel_left.add(label5);
		
		JLabel lblPrice5 = new JLabel("");
		lblPrice5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice5.setBounds(50, 430, 50, 15);
		if(Data.prices[4]>0)
			lblPrice5.setText(Integer.toString(Data.prices[4]));
		panel_left.add(lblPrice5);
		
		JLabel labelRed = new JLabel("");
		labelRed.setBackground(Color.red);
		labelRed.setOpaque(true);
		labelRed.setBounds(50, 530, 50, 50);
		panel_left.add(labelRed);
		
		JLabel lblOccupied = new JLabel("This seat is occupied");
		lblOccupied.setHorizontalAlignment(SwingConstants.CENTER);
		lblOccupied.setBounds(10, 580, 130, 15);
		panel_left.add(lblOccupied);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(3, 3, 138, 48);
		panel_right.add(btnReset);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBackground(new Color(219,176,102));
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
		                for(int i=0;i<ROWS;i++)
		                	for(int j=0;j<COLS;j++)
		                	{
		                		JToggleButton b = new JToggleButton();
		                		b=getGridButton(i,j);
		                		if(b.isSelected()==true)
		                			b.setSelected(false);
		                		if(Data.seats[i*COLS+j]==0)
		        					b.setBackground(label1.getBackground());
		        				else
		        					if(Data.seats[i*COLS+j]==1)
		        						b.setBackground(label2.getBackground());
		        					else
		        						if(Data.seats[i*COLS+j]==2)
		        							b.setBackground(label3.getBackground());
		        						else
		        							if(Data.seats[i*COLS+j]==3)
		        								b.setBackground(label4.getBackground());
		        							else
		        								if(Data.seats[i*COLS+j]==4)
		        									b.setBackground(label5.getBackground());
		        								else
		        									if(Data.seats[i*COLS+j]==-1)
		        									{
		        										b.setBackground(Color.red);
		        										b.setEnabled(false);
		        									}
		                	}
		                	Window.textArea.setText("Total sum: \n0 RON");
		                	sum=0;
		                	chosen.clear();
		                	sel1.clear();
		                	sel2.clear();
		                	sel3.clear();
		                	sel4.clear();
		                	sel5.clear();
					} 
				});
		
		
		JToggleButton b = new JToggleButton();
		for(int i=0;i<ROWS;i++)
			for(int j=0; j<COLS; j++)
			{
				b=getGridButton(i,j);
				if(Data.seats[i*COLS+j]==0)
					b.setBackground(label1.getBackground());
				else
					if(Data.seats[i*COLS+j]==1)
						b.setBackground(label2.getBackground());
					else
						if(Data.seats[i*COLS+j]==2)
							b.setBackground(label3.getBackground());
						else
							if(Data.seats[i*COLS+j]==3)
								b.setBackground(label4.getBackground());
							else
								if(Data.seats[i*COLS+j]==4)
									b.setBackground(label5.getBackground());
								else
									if(Data.seats[i*COLS+j]==-1)
									{
										b.setBackground(Color.red);
										b.setEnabled(false);
									}
			}
	}
	
	private JToggleButton getGridButton(int r, int c) {
        int index = r * COLS + c;
        return list.get(index);
    }

    private JToggleButton createGridButton(final int row, final int col) {
        final JToggleButton b = new JToggleButton();
        b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                JToggleButton gb = getGridButton(row, col);
                if(gb.isSelected()==true)
                	chosen.add(gb);
                else
                	chosen.remove(gb);
                sum=0;
                for(int k=0; k<chosen.size();k++)
                {
                	if(chosen.get(k).getBackground()==Window.label1.getBackground())
                		sum+=Data.prices[0];
                	else
                		if(chosen.get(k).getBackground()==Window.label2.getBackground())
                    		sum+=Data.prices[1];
                		else
                    		if(chosen.get(k).getBackground()==Window.label3.getBackground())
                        		sum+=Data.prices[2];
                    		else
                        		if(chosen.get(k).getBackground()==Window.label4.getBackground())
                            		sum+=Data.prices[3];
                        		else
                            		if(chosen.get(k).getBackground()==Window.label5.getBackground())
                                		sum+=Data.prices[4];
                }
                Window.textArea.setText("Total sum: \n"+Integer.toString(sum)+" RON");
            }
        });
        return b;
    }

    JPanel createGridPanel() {
        JPanel p_buttons = new JPanel(new GridLayout(ROWS, COLS));
        char c='A';
        for(int i=0;i<ROWS;i++) 
        {
        	for(int j=0;j<COLS;j++){
	            JToggleButton gb = createGridButton(i, j);
	            gb.setOpaque(true);
	            gb.setText(c+Integer.toString(j));
	            list.add(gb);
	            p_buttons.add(gb);
	        }
        	c++;
        }
        return p_buttons;
    }
}
