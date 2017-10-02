import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AdminIndView implements ActionListener {
	private String Empno;
	private JFrame frameAIV;
	private JPanel PanelAIV; 
	private JButton Back;
	private JButton Name,Labname,LabPhone,LabZone,LabPass,Phone,Zone,LabJob,Jobtitle,Pass;
	//private JLabel Name,Phone,Zone;
	//private JButton Labname,LabPhone,LabZone;
	//private Vector<String> tab;
	private String firstname;
	private String lastname;
	private String Phoneno;
	private String ZoneNo;
	private String Job;
	private String Password;
	
	public void AdminViewInd(String selectedEmp) {
		// TODO Auto-generated method stub
		Empno=selectedEmp;
		frameAIV = new JFrame(Empno);
		frameAIV.setSize(700, 700);
		frameAIV.setLocation(600, 150);
		frameAIV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Sqldetails();
		frameAIV.setContentPane(new JLabel(new ImageIcon("E://hydePark/hyde8.jpg")));
		
		Labname = new JButton("Name");
		Labname.setBounds(1, 1,150, 20);
		
		LabPhone = new JButton("   Phone");
		LabPhone.setBounds(150, 1, 150, 20);
		
		LabZone = new JButton("   Zone");
		LabZone.setBounds(300, 1, 100, 20);
		
		LabJob = new JButton("   Job");
		LabJob.setBounds(400, 1, 150, 20);
		
		LabPass = new JButton("Password");
		LabPass.setBounds(550, 1, 150, 20);
		
		Name = new JButton("\t"+firstname+" "+lastname);
		Name.setBounds(1, 20, 150, 20);
		
		Phone = new JButton(Phoneno);
		Phone.setBounds(150, 20, 150, 20);
		
		Zone = new JButton(ZoneNo);
		Zone.setBounds(300, 20, 100, 20);
		
		Jobtitle = new JButton(Job);
		Jobtitle.setBounds(400,20,150,20);
		
		Pass = new JButton(Password);
		Pass.setBounds(550, 20, 150, 20);
		
		PanelAIV = new JPanel();
		frameAIV.setContentPane(new JLabel(new ImageIcon("E://hyde_employee/"+Empno+".jpg")));
		
		Back = new JButton("Back");
		Back.setBounds(250,600, 200, 40);
		
		frameAIV.add(Labname);
		frameAIV.add(LabPhone);
		frameAIV.add(LabZone);
		frameAIV.add(LabJob);
		frameAIV.add(LabPass);

		frameAIV.add(Name);
		frameAIV.add(Phone);
		frameAIV.add(Zone);
		frameAIV.add(Jobtitle);
		frameAIV.add(Pass);
		
		frameAIV.add(Back);
		frameAIV.add(PanelAIV);
		
		Back.setActionCommand("Back");
		Back.addActionListener(this);
		frameAIV.setVisible(true);
	}
//	public static void main(String[] args){
//		AdminIndView a = new AdminIndView();
//		a.AdminViewInd("g1111");
//	}

	private void Sqldetails() {
		// TODO Auto-generated method stub
		Connection Mycon;
		try {
			Mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false","root","suneeth");
			Statement Mystmt = Mycon.createStatement();
			String sql = "Select first_name,last_name,phone,zone,job,password from employee where emp_id='"+Empno+"'";
			ResultSet res = Mystmt.executeQuery(sql);
			res.next();
			firstname=res.getString(1);
			lastname=res.getString(2);
			Phoneno=res.getString(3);
			ZoneNo = res.getString(4);
			Job = res.getString(5);
			Password=res.getString(6);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Back"){
			frameAIV.setVisible(false);
			AdminViewEmp ADE = new AdminViewEmp();
			ADE.AdminEmpView();
			
		}
		
	}

	

}
