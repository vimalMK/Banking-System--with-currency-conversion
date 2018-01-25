package miniproject.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

public class swingController extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAcc;
	private JTextField txtBalance;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingController frame = new swingController();
					frame.setVisible(true);
					frame.setTitle("Account Management ");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public swingController() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		databaseView accountdetails=new databaseView();
		ArrayList s=accountdetails.disp();
		System.out.println("Arraylist Reached Successfully  :"+s);
		String[] array = (String[]) s.toArray(new String[s.size()]);
		JComboBox comboBox = new JComboBox(array);
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(123, 58, 285, 22);
		contentPane.add(comboBox);
		
		
		
		JButton btnSave = new JButton("Save");
		JButton btnclose = new JButton("Exit");
		btnSave.setActionCommand("Save");
		btnclose.setActionCommand("Exit");
		
		//btnPress.addActionListener(new exitApp());
		btnSave.setBounds(116, 297, 97, 25);
		contentPane.add(btnSave);
		btnclose.setBounds(266, 297, 97, 25);
		contentPane.add(btnclose);
						
		JLabel lblAccountManagementSystem = new JLabel("Account Management System");
		lblAccountManagementSystem.setBounds(188, 13, 207, 32);
		contentPane.add(lblAccountManagementSystem);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 127, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("Account Number:");
		lblNewLabel_1.setBounds(12, 181, 116, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Balance:");
		lblNewLabel_2.setBounds(12, 229, 99, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblSelectAccount = new JLabel("Select Account");
		lblSelectAccount.setBounds(12, 61, 99, 16);
		contentPane.add(lblSelectAccount);
		
		txtAcc = new JTextField();
		txtAcc.setBounds(176, 178, 116, 22);
		contentPane.add(txtAcc);
		txtAcc.setColumns(10);
		
		
		txtBalance = new JTextField();
		txtBalance.setEditable(false);
		txtBalance.setBounds(176, 226, 116, 22);
		contentPane.add(txtBalance);
		txtBalance.setColumns(10);
		
		

		txtName = new JTextField();
		txtName.setBounds(176, 124, 116, 22);
		contentPane.add(txtName);
		txtName.setColumns(30);
		
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(394, 123, 116, 25);
		contentPane.add(btnEdit);
		
		
		JButton btnYuan = new JButton("Edit in Yuan");
		btnYuan.setBounds(394, 172, 116, 25);
		contentPane.add(btnYuan);
		
		JButton btnEuro = new JButton("Edit in Euro");
		btnEuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEuro.setBounds(394, 225, 116, 25);
		contentPane.add(btnEuro);
		
		JLabel label = new JLabel("$");
		label.setBounds(293, 229, 56, 16);
		contentPane.add(label);
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditController ec=new EditController();
				ec.editController(txtName.getText(),txtAcc.getText(),txtBalance.getText(),"USD");
			}
		});
		
		comboBox.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                comboBox.setEnabled(true);
                comboBox.setToolTipText("Select Account");
            }
        });
		
		btnYuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditController ec=new EditController();
				ec.editController(txtName.getText(),txtAcc.getText(),txtBalance.getText(),"Yuan");				
			}
		});
		
		btnEuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditController ec=new EditController();
				ec.editController(txtName.getText(),txtAcc.getText(),txtBalance.getText(),"Euro");				
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
		
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String command = e.getActionCommand();
				 String Name=txtName.getText();
				 String Account=txtAcc.getText();
				 String Balance=txtBalance.getText();
				 String combo="Name="+Name+": Account Number="+Account+",Balance="+Balance;
				 System.out.println(combo+"%%%%%");
				 databaseView dv=new databaseView();
				 try {
					dv.saveList(combo,Account);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				
				
			}
		});
		
		
		comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
				JComboBox cb = (JComboBox) e.getSource();
				String s=(String) cb.getSelectedItem();
				System.out.println(s);
				contentDisplay(s);
				}
				catch(Exception e1)
				{
					
				}
				
			}
			
			public void contentDisplay(String s)
			{
				
				
				String[] splitString=s.split("(:)|(\\,)");
				String[] splitStringfurther=splitString[0].split("=");
				txtName.setText(splitStringfurther[1]);
				
				String[] splitStringfurther1=splitString[1].split("=");
				txtAcc.setText(splitStringfurther1[1]);
				
				String[] splitStringfurther2=splitString[2].split("=");
			
				txtBalance.setText(splitStringfurther2[1]);
				
			}
		});
		
		
		
		
		
		
	}
	public void refreshFrame(float sum)
	{
		
		JOptionPane.showMessageDialog(null, "Account Balance is "+sum+". This will reflect in main account in next login");
		
			
	}
}
