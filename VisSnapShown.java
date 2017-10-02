import javax.swing.*;

import org.apache.log4j.Logger;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class VisSnapShown implements ActionListener {
	private JFrame frameVSS;
	private JPanel PanelVSS;
	private JButton Close;
	String Emp;
	private JButton Name,Labname,LabPhone,LabZone,Phone,Zone,LabJob,Jobtitle;
	private String firstname;
	private String lastname;
	private String Phoneno;
	private String ZoneNo;
	private String Job;
	static final Logger log = Logger.getLogger(VisSnapShown.class);
	public VisSnapShown() {
		// TODO Auto-generated constructor stub
	}
	
	public void SnapShown(String User) {
		// TODO Auto-generated method stub
		Emp=User;
		frameVSS = new JFrame(Emp);
		frameVSS.setSize(700,700);
		frameVSS.setLocation(600, 150);
		frameVSS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameVSS.setContentPane(new JLabel(new ImageIcon("E://hyde_employee/"+Emp+".jpg")));
		frameVSS.setResizable(false);
		
		DatabaseFetch();
		
		PanelVSS = new JPanel();
		Labname = new JButton("Name");
		Labname.setBounds(1, 1,250, 20);
		
		LabPhone = new JButton("   Phone");
		LabPhone.setBounds(250, 1, 150, 20);
		
		LabZone = new JButton("   Zone");
		LabZone.setBounds(400, 1, 150, 20);
		
		LabJob = new JButton("   Job");
		LabJob.setBounds(550, 1, 150, 20);
		
		Name = new JButton("\t"+firstname+" "+lastname);
		Name.setBounds(1, 20, 250, 20);
		
		Phone = new JButton(Phoneno);
		Phone.setBounds(250, 20, 150, 20);
		
		Zone = new JButton(ZoneNo);
		Zone.setBounds(400, 20, 150, 20);
		
		Jobtitle = new JButton(Job);
		Jobtitle.setBounds(550,20,150,20);
		
		Close = new JButton("CLOSE");
		Close.setBounds(250, 620, 150, 40);
		
		frameVSS.add(Labname);
		frameVSS.add(LabPhone);
		frameVSS.add(LabZone);
		frameVSS.add(LabJob);

		frameVSS.add(Name);
		frameVSS.add(Phone);
		frameVSS.add(Zone);
		frameVSS.add(Jobtitle);
		
		frameVSS.add(Close);
		frameVSS.add(PanelVSS);
		
		Close.setActionCommand("CLOSE");
		Close.addActionListener(this);
		frameVSS.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="CLOSE"){
			frameVSS.setVisible(false);
			log.info("Back to Contact Guard Menu");
			VisContactGuard VCG = new VisContactGuard();
			VCG.ContactGuard();
		}
		
	}
	public void DatabaseFetch(){
		Connection Mycon;
		try {
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement Mystmt = Mycon.createStatement();
			String sql = "Select first_name,last_name,phone,zone,job from employee where emp_id='"+Emp+"'";
			ResultSet res = Mystmt.executeQuery(sql);
			res.next();
			
			firstname = res.getString(1);
			lastname = res.getString(2);
			Phoneno = res.getString(3);
			ZoneNo = res.getString(4);
			Job = res.getString(5);
			
			System.out.println(firstname+" "+lastname+" "+Phoneno+" "+ZoneNo+" "+Job);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
