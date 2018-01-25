package miniproject.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditController extends JFrame {

	private JPanel contentPane;
	static String Name;
	static String Acc;
	static String Bal;
	static String Curr;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void editController(String title,String acc,String Balance,String value) {
		
		Name=title;
		Acc=acc;
		Bal=Balance;
		Curr=value;
		System.out.println(Curr);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditController frame = new EditController();
					frame.setVisible(true);
					frame.setTitle(title);
					frame.setSize(500, 500);
					
				
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public EditController() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		NumberFormat formatter = NumberFormat.getNumberInstance();
    	formatter.setMinimumFractionDigits(2);
    	formatter.setMaximumFractionDigits(2);
    	
		JLabel lblNewLabel_3 = new JLabel("Processing..");
		lblNewLabel_3.setBounds(224, 82, 80, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel symbol = new JLabel("Symbol");
		symbol.setBounds(307, 82, 56, 16);
		contentPane.add(symbol);
		
		JLabel symbol1 = new JLabel("Symbol");
		symbol1.setBounds(348, 129, 56, 16);
		contentPane.add(symbol1);
		
		JLabel symbol2 = new JLabel("Symbol");
		symbol2.setBounds(348, 177, 56, 16);
		contentPane.add(symbol2);
		
		contentPane.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent event) {
		        // Request the focus (if don't already have it)
		        if(!hasFocus()) { 
		        	if(Curr.equals("USD"))
					{
		        		lblNewLabel_3.setText(Bal);
		        		symbol.setText("$");
		        		symbol1.setText("$");
		        		symbol2.setText("$");
					}
					else if(Curr.equals("Yuan"))
					{
						float x=Float.parseFloat(Bal);
						double yuanVal= (x*6.23);
						String output = formatter.format(yuanVal);
						lblNewLabel_3.setText(String.valueOf(output));
						symbol1.setText("¥");
						symbol.setText("¥");
						symbol2.setText("¥");
					}
					else if(Curr.equals("Euro"))
					{
						float x=Float.parseFloat(Bal);
						double EuroVal= (x*0.92);
						String output = formatter.format(EuroVal);
						lblNewLabel_3.setText(String.valueOf(output));
						symbol.setText("€");
						symbol1.setText("€");
						symbol2.setText("€");
						
					}
		        
		        }
		    }
		});
					
		JButton btnDeposite = new JButton("Deposite");
		JButton btnclose = new JButton("Dismiss");
		btnDeposite.setActionCommand("Deposite");
		btnclose.setActionCommand("Dismiss");
		
		//btnPress.addActionListener(new exitApp());
		btnDeposite.setBounds(54, 245, 97, 25);
		contentPane.add(btnDeposite);
		btnclose.setBounds(307, 245, 97, 25);
		contentPane.add(btnclose);
		
		JLabel lblNewLabel_1 = new JLabel("Account Number   :");
		lblNewLabel_1.setBounds(8, 29, 116, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Available Balance  :");
		lblNewLabel_2.setBounds(8, 82, 116, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel(Acc);
		lblNewLabel.setBounds(224, 29, 116, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnWithdraw.setBounds(186, 245, 97, 25);
		contentPane.add(btnWithdraw);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if((key>=e.VK_0&&key<=e.VK_9)||(key>=e.VK_NUMPAD0&&key<=e.VK_NUMPAD9)||(key==KeyEvent.VK_BACK_SPACE)||(key==KeyEvent.VK_PERIOD))
				{
					textField.setEditable(true);
				}
				
				else
				{
					textField.setEditable(false);
					JOptionPane.showMessageDialog(null, "Only Numbers Allowed");
				}
			}
		});
		textField.setBounds(224, 126, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		textField.setText("0.0");
		textField.setToolTipText("Enter Deposite Amount");
		
		JLabel deposite = new JLabel("Enter the Amount to Deposite :");
		deposite.setBounds(8, 129, 172, 16);
		contentPane.add(deposite);
		
		JLabel withdraw = new JLabel("Enter the Amount to Withdraw :");
		withdraw.setBounds(8, 177, 191, 16);
		contentPane.add(withdraw);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if((key>=e.VK_0&&key<=e.VK_9)||(key>=e.VK_NUMPAD0&&key<=e.VK_NUMPAD9)||(key==KeyEvent.VK_BACK_SPACE)||(key==KeyEvent.VK_PERIOD))
				{
					textField.setEditable(true);
				}
				
				else
				{
					textField.setEditable(false);
					JOptionPane.showMessageDialog(null, "Only Numbers Allowed");
				}	
			}
		});
		textField_1.setBounds(224, 174, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		textField_1.setText("0.0");
		textField_1.setToolTipText("Enter Withdraw Amount");
								
		textField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textField.setEditable(true);
                textField.setText("");
            }
        });
		
		textField_1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textField_1.setEditable(true);
                textField_1.setText("");
            }
        });		
		
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?", "Exit  Message",JOptionPane.YES_NO_OPTION);
				    if (confirmed == JOptionPane.YES_OPTION) {
				      dispose();
				    }

				
			}
		});
		
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					double intial=Float.parseFloat(lblNewLabel_3.getText());
				    double dep=Float.parseFloat(textField_1.getText());
				    double sum=intial-dep;
				    System.out.println(sum);
				
				    if(sum<0.0)
				    {
				    	JOptionPane.showMessageDialog(null, "Insufficient Fund. Withdraw amount is Greater than available Balance");
				    }
				    if(Curr.equals("USD"))
				    {
							
				        int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to Withdraw?", "Confirm Message",JOptionPane.YES_NO_OPTION);
			            if (confirmed == JOptionPane.YES_OPTION) {
			            dispose();
			            swingController sc=new swingController();
			            sc.refreshFrame((float)sum);
				    	System.out.println(Name);
						System.out.println(Acc);
						String combo="Name="+Name+": Account Number="+Acc+",Balance="+sum;
						System.out.println(combo+"%%%%%");
						databaseView dv=new databaseView();
						dv.saveList(combo,Acc);
			      		      
			    }
				    }
			            else if(Curr.equals("Yuan"))
			            {
			            	float sumYuan=(float) (sum/6.23);
			            	NumberFormat formatter = NumberFormat.getNumberInstance();
			            	formatter.setMinimumFractionDigits(2);
			            	formatter.setMaximumFractionDigits(2);
			            	String output = formatter.format(sumYuan);
			            	 int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to Withdraw?", "Confirm Message",JOptionPane.YES_NO_OPTION);
					            if (confirmed == JOptionPane.YES_OPTION) {
					            dispose();
					            swingController sc=new swingController();
					            sc.refreshFrame(Float.parseFloat(output));
						    	System.out.println(Name);
								System.out.println(Acc);
								String combo="Name="+Name+": Account Number="+Acc+",Balance="+output;
								System.out.println(combo+"%%%%%");
								databaseView dv=new databaseView();
								dv.saveList(combo,Acc);
					      		      
					    }
			            	
			            	
			            }
			            else if(Curr.equals("Euro"))
			            {
			            	float sumEuro=(float) (sum/0.92);
			            	NumberFormat formatter = NumberFormat.getNumberInstance();
			            	formatter.setMinimumFractionDigits(2);
			            	formatter.setMaximumFractionDigits(2);
			            	String output = formatter.format(sumEuro);
			            	 int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to Withdraw?", "Confirm Message",JOptionPane.YES_NO_OPTION);
					            if (confirmed == JOptionPane.YES_OPTION) {
					            dispose();
					            swingController sc=new swingController();
					            sc.refreshFrame(Float.parseFloat(output));
						    	System.out.println(Name);
								System.out.println(Acc);
								String combo="Name="+Name+": Account Number="+Acc+",Balance="+output;
								System.out.println(combo+"%%%%%");
								databaseView dv=new databaseView();
								dv.saveList(combo,Acc);
					      		      
					    }
			            }
			            
			            
			   
				}
				
				    catch (NumberFormatException e1) {
				        int sum=0;
						// It's OK to ignore "e" here because returning a default value is the documented behaviour on invalid input.
				       
				    } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 

				
			}
		});
		
		
		btnDeposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
				double intial=Float.parseFloat(lblNewLabel_3.getText());
				double dep=Float.parseFloat(textField.getText());
				double sum=intial+dep;
				System.out.println(sum);
					
				
				if(Curr.equals("USD"))
						{
				int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to deposite?", "Confirm Message",JOptionPane.YES_NO_OPTION);
			    if (confirmed == JOptionPane.YES_OPTION) {
			      dispose();
			         
			      	swingController sc=new swingController();
			            
			         sc.refreshFrame((float)sum);
			    	 System.out.println(Name);
					 System.out.println(Acc);
					 String combo="Name="+Name+": Account Number="+Acc+",Balance="+sum;
					 System.out.println(combo+"%%%%%");
					 databaseView dv=new databaseView();
					 dv.saveList(combo,Acc);
					}
				}
				
				else if(Curr.equals("Yuan"))
	            {
	            	float sumYuan=(float) (sum/6.23);
	            	NumberFormat formatter = NumberFormat.getNumberInstance();
	            	formatter.setMinimumFractionDigits(2);
	            	formatter.setMaximumFractionDigits(2);
	            	String output = formatter.format(sumYuan);
	            	 int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to Withdraw?", "Confirm Message",JOptionPane.YES_NO_OPTION);
			            if (confirmed == JOptionPane.YES_OPTION) {
			            dispose();
			            swingController sc=new swingController();
			            sc.refreshFrame(Float.parseFloat(output));
				    	System.out.println(Name);
						System.out.println(Acc);
						String combo="Name="+Name+": Account Number="+Acc+",Balance="+output;
						System.out.println(combo+"%%%%%");
						databaseView dv=new databaseView();
						dv.saveList(combo,Acc);
			      		      
			    }
	            	
	            	
	            }
	            else if(Curr.equals("Euro"))
	            {
	            	float sumEuro=(float) (sum/0.92);
	            	NumberFormat formatter = NumberFormat.getNumberInstance();
	            	formatter.setMinimumFractionDigits(2);
	            	formatter.setMaximumFractionDigits(2);
	            	String output = formatter.format(sumEuro);
	            	 int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to Withdraw?", "Confirm Message",JOptionPane.YES_NO_OPTION);
			            if (confirmed == JOptionPane.YES_OPTION) {
			            dispose();
			            swingController sc=new swingController();
			            sc.refreshFrame(Float.parseFloat(output));
				    	System.out.println(Name);
						System.out.println(Acc);
						String combo="Name="+Name+": Account Number="+Acc+",Balance="+output;
						System.out.println(combo+"%%%%%");
						databaseView dv=new databaseView();
						dv.saveList(combo,Acc);
			      		      
			    }
	            }
				}
				
				    catch (NumberFormatException e1) {
				        int sum=0;
						// It's OK to ignore "e" here because returning a default value is the documented behaviour on invalid input.
				       
				    } catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				
			}
		});
		
		
		
	}
}

