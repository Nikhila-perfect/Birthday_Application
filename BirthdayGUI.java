package it.tests;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.core.Birthday;
import it.excepts.*;

public class BirthdayGUI extends JFrame {
	private Birthday b1,b2;
	private JMenuBar mnuBar;
	private JMenu mnuFile,mnuHelp;
	private JMenuItem miSave,miExit,miAbout_This_Assignment,miCredits;
	private JLabel lblMonth,lblDate,lblYear,lblCalcDay,lblGetMonth,lblGetDay,lblGetYear;
	private JTextField txtMonth,txtDate,txtYear,txtCalcDay,txtGetMonth,txtGetDay,txtGetYear;
	private JPanel pnlOutput;
	private JPanel pnlInput;
	private JButton btnCalcDay,btnGetMonth,btnGetDay,btnGetYear;
	private Birthday b;
	private ArrayList<Birthday>al;
	void initializeComponents()
	{	
		
		mnuBar=new JMenuBar();
		mnuFile=new JMenu("File");
		mnuHelp=new JMenu("Help");
		miSave= new JMenuItem("Save");
		miExit=new JMenuItem("Exit");
		miAbout_This_Assignment=new JMenuItem("About This Assignment");
		miCredits=new JMenuItem("Credits");
		pnlOutput=new JPanel();
		pnlInput=new JPanel();
		lblMonth=new JLabel("Month: ");
		lblDate=new JLabel("Date:");
		txtMonth=new JTextField(12);
		txtDate=new JTextField(12);
		lblYear=new JLabel("Year:");
		txtYear=new JTextField(12);
		btnCalcDay=new JButton("Day");
		btnGetMonth=new JButton("Month");
		btnGetDay=new JButton("Date");
		btnGetYear=new JButton("Year");
		lblCalcDay=new JLabel();
		lblGetMonth=new JLabel();
		lblGetDay=new JLabel();
		lblGetYear=new JLabel();
		txtCalcDay=new JTextField();
		txtGetMonth=new JTextField();
		txtGetDay=new JTextField();
		txtGetYear=new JTextField();
	
		txtCalcDay.setForeground(Color.RED);
		txtGetMonth.setForeground(Color.PINK);
		txtGetDay.setForeground(Color.ORANGE);
		txtGetYear.setForeground(Color.BLUE);
		
	}
	
	private void addComponentsToFrame() {
	
		getContentPane().setBackground(Color.MAGENTA);
		mnuFile.add(miSave);
		mnuFile.add(miExit); 
		mnuHelp.add(miAbout_This_Assignment);
		mnuHelp.add(miCredits);
		mnuBar.add(mnuFile);
		mnuBar.add(mnuHelp);
		setJMenuBar(mnuBar);
		pnlInput.add(lblMonth);
		pnlInput.add(txtMonth);
		pnlInput.add(lblDate);
		pnlInput.add(txtDate);
		pnlInput.add(lblYear);
		pnlInput.add(txtYear);
		pnlInput.add(btnCalcDay);
		pnlInput.add(btnGetMonth);
		pnlInput.add(btnGetDay);
		pnlInput.add(btnGetYear);
		pnlInput.setPreferredSize(new Dimension(500,100));
		pnlInput.setBackground(Color.CYAN); 
		add(pnlInput);
		pnlOutput.setLayout(new GridLayout(4,2));
		pnlOutput.add(lblCalcDay);
		pnlOutput.add(txtCalcDay);
		pnlOutput.add(lblGetMonth);
		pnlOutput.add(txtGetMonth);
		pnlOutput.add(lblGetDay);
		pnlOutput.add(txtGetDay);
		pnlOutput.add(lblGetYear);
		pnlOutput.add(txtGetYear);
		pnlOutput.setPreferredSize(new Dimension(500,300));
		pnlOutput.setBackground(Color.YELLOW); 
		add(pnlOutput);
		setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(550,500));
		
	}
	
	 void registerComponents() {
		 
		txtMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					BirthdayGUI.this.b1.setDay(Integer.parseInt(txtMonth.getText()));
					}
					catch(Exception e)
					{
						 JOptionPane.showMessageDialog(BirthdayGUI.this,"Enter Only Integer Values");
						 txtMonth.setText("");
					}
						
				}
		});
		
		txtDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					BirthdayGUI.this.b1.setDay(Integer.parseInt(txtDate.getText()));
					}
					catch(Exception e)
					{
						 JOptionPane.showMessageDialog(BirthdayGUI.this,"Enter Only Integer Values");
						 txtDate.setText("");
					}
						
				}
		});
		
		txtYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					BirthdayGUI.this.b1.setYear(Integer.parseInt(txtYear.getText()));
					}
					catch(Exception e)
					{
						 JOptionPane.showMessageDialog(BirthdayGUI.this,"Enter Only Integer Values");
						 txtYear.setText("");
					}
						
				}
		});
		
		btnCalcDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				lblCalcDay.setText("Day of the week:");
				txtCalcDay.setText(BirthdayGUI.this.b1.calcDay(Integer.parseInt(txtMonth.getText()),Integer.parseInt(txtDate.getText()),Integer.parseInt(txtYear.getText()))+"");
				}
		});
		
		btnGetMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				lblGetMonth.setText("Month:");
			
				txtGetMonth.setText(BirthdayGUI.this.b1.calcMonth(Integer.parseInt(txtMonth.getText()))+"");
				}
		});
		
		btnGetDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				lblGetDay.setText("Day of Birth:");
				txtGetDay.setText(BirthdayGUI.this.b1.getDay(Integer.parseInt(txtDate.getText()))+"");
				}
		});
		
		btnGetYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				lblGetYear.setText("Year of Birth:");
				txtGetYear.setText(BirthdayGUI.this.b1.getYear(Integer.parseInt(txtYear.getText()))+"");
				}
		});
		
		miCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JDialog jd=new JDialog(BirthdayGUI.this,"Credits");
				JLabel name=new JLabel("Omkar");
				JLabel roll=new JLabel("1602-18-737-086");
				jd.add(name);
				jd.add(roll);
				jd.setLayout(new FlowLayout());
				jd.setVisible(true);
				jd.setSize(100, 120);
				jd.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e)
					{
						jd.dispose();
					}
					
					});
				
			}
			
		});
		
		miAbout_This_Assignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JDialog jd=new JDialog(BirthdayGUI.this,"About this Assignment.");
				JTextArea name=new JTextArea("In this Assignment, we'll try to find out the date of birth of a person, \n basically the input must be given in the form of integers\n and what this application does is nothing but it'll display the date of birth\n by mentioning the day of the week along with the name of the month,date as well as the year.\n For this, The Birthday Object is sent as an argument and the appropriate methods are invoked\n  ");
				jd.add(name);
				jd.setLayout(new FlowLayout());
				Font font1 = new Font("SnellRoundhand", Font.ITALIC, 16);
				name.setFont(font1);
				jd.setVisible(true);
				jd.setSize(1000,512);
				jd.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e)
					{
						jd.dispose();
					}
					
					});
			}
		});
		
		  miSave.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent ae) {
				  BirthdayGUI.this.al.add(BirthdayGUI.this.b1);
				  File f=new File("data.bin");
				  try {
					f.createNewFile();
				  FileOutputStream fos=new FileOutputStream(f);
				  ObjectOutputStream dos=new ObjectOutputStream(fos);
				  dos.writeObject(BirthdayGUI.this.al);
				  dos.close();
			  } catch (IOException e) {
					 JOptionPane.showMessageDialog(BirthdayGUI.this,"Something Went Wrong");
				}
			  }
		});
		 miExit.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent ae)
			  {
				  System.exit(0);
			  }
		  });
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			
			});
		
	}
	
	 BirthdayGUI(Birthday b1,ArrayList al)
	{
		this.b1=b1;
		this.al=al;
		initializeComponents();
		registerComponents();
		addComponentsToFrame();
		pack();
		setTitle("Birthday");
		setVisible(true);
	}

}


