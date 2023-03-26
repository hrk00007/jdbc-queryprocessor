package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainFrame implements ActionListener, ItemListener {
	JFrame frame;
	JLabel lblDriver, lblUrl, lblUsername, lblPassword,lblTitle,prt1,prt2,db;
	JLabel lblHeading;
	Font lblFont,f1,f2,f3,f4;
	JTextField txtDriver,txtUrl, txtUsername;
	JComboBox<Object> drpDriver;
	JPasswordField txtPassword;
	JButton btnConnect, btnCancel,btnReset;

	String[] strdb = { "Select","Oracle", "MySql",  "HSQL", "Derby", "SQLite","PostGreSql","MariaDb"};
	String[] strdriver = { 
			" ",
			"oracle.jdbc.driver.OracleDriver",
			"com.mysql.jdbc.Driver" ,
			"org.hsqldb.jdbc.JDBCDriver" ,
			"org.apache.derby.jdbc.EmbeddedDriver",
			"org.sqlite.JDBC",
			"org.postgresql.Driver",
			"org.mariadb.jdbc.Driver"								
	};
	
	String[] strurl = { 
			" ",
			"jdbc:oracle:thin:@localhost:1521:xe",
			"jdbc:mysql://localhost:3306/java",
			"jdbc:hsqldb:file:C:\\hsql\\bin\\JDBC Drivers",
			"jdbc:derby:c:\\derby\\bin\\mydb",
			"jdbc:sqlite:C:\\Users\\ASUS\\chinook.db",
			"jdbc:postgresql://localhost/postgres",
			"jdbc:mariadb://localhost:3308/codeheist"
	};
	String[] strusername = { 
			" ",
			"System",
			"root",
			"SA",
			null,
			null,
			"postgres",
			"root"
	};
	
	
	public MainFrame() {
		frame = new JFrame("Connection Frame");
		frame.setSize(900, 500);
		frame.setVisible(true);
		frame.setLayout(null);
		
		f1 = new Font("Arial", Font.BOLD, 20);
		f2 = new Font("Arial", Font.BOLD, 16);
		f3 = new Font("Arial", Font.ITALIC, 14);
		f4 = new Font("Sans", Font.TYPE1_FONT, 16);

		
		lblTitle = new JLabel("Database Query Processor");
		lblTitle.setBounds(260, 5, 500, 30);
		// description.setHorizontalAlignment(description.LEFT);
		lblTitle.setFont(f1);
		lblTitle.setForeground(Color.RED);
		frame.add(lblTitle);//trying

		prt1 = new JLabel(
				"----------------------------------------   DRIVER INFO   ----------------------------------------");
		prt1.setBounds(100, 50, 600, 20);
		prt1.setHorizontalAlignment(prt1.CENTER);
		prt1.setFont(f3);
		frame.add(prt1);//trying
		
		prt2 = new JLabel(
				"-------------------------------------   AUTHENTICATION   -------------------------------------");
		prt2.setBounds(100, 255, 600, 20);
		prt2.setHorizontalAlignment(prt2.CENTER);
		prt2.setFont(f3);
		frame.add(prt2);//trying

		db = new JLabel("Database:");
		db.setBounds(300, 85, 150, 30);
		db.setFont(f2);
		frame.add(db);//trying

		lblDriver = new JLabel("Driver     :");
		lblDriver.setBounds(100, 120, 100, 30);
		lblDriver.setFont(f2);
		frame.add(lblDriver); //trying
		
		lblUrl = new JLabel("URL        :");
		lblUrl.setBounds(100, 160, 100, 30);
		lblUrl.setFont(f2);
		frame.add(lblUrl); //trying

		lblUsername = new JLabel("Username   :");
		lblUsername.setBounds(220, 290, 100, 30);
		lblUsername.setFont(f2);
		frame.add(lblUsername);//trying

		lblPassword = new JLabel("Password   :");
		lblPassword.setBounds(220, 330, 100, 30);
		lblPassword.setFont(f2);
		frame.add(lblPassword);//trying

				// TEXTFIELDS
				txtDriver = new JTextField();
				frame.add(txtDriver); //trying
				txtDriver.setFont(f2);
				txtDriver.setBounds(180, 120, 500, 30);
				

				txtUrl = new JTextField();
				frame.add(txtUrl);//trying
				txtUrl.setFont(f2);
				txtUrl.setBounds(180, 160, 500, 30);
				

				txtUsername = new JTextField();
				frame.add(txtUsername);//trying
				txtUsername.setBounds(325, 290, 250, 30);
				txtUsername.setFont(f2);
				//txtusername.setText("system");
				
				
				txtPassword = new JPasswordField();
				frame.add(txtPassword);//trying
				txtPassword.setBounds(325, 330, 250, 30);
				txtPassword.setFont(f2);
				//txtpassword.setText("2903");
				

				// BUTTONS
				btnConnect = new JButton("Connect");
				frame.add(btnConnect);//trying
				btnConnect.setFont(f2);
				btnConnect.setBounds(250, 390, 130, 40);
				btnConnect.setBackground(Color.CYAN);
				

				btnReset = new JButton("Reset");
				frame.add(btnReset);
				btnReset.setFont(f2);
				// btnreset.setBounds(360, 390,120,40);
				btnReset.setBounds(330, 200, 130, 30);
				btnReset.setBackground(Color.orange);
				

				btnCancel = new JButton("Cancel");
				frame.add(btnCancel);//trying
				btnCancel.setBounds(420, 390, 120, 40);
				btnCancel.setFont(f2);
				btnCancel.setBackground(Color.PINK);
				
				
				// ComboBox
				drpDriver = new JComboBox<Object>(strdb);
				frame.add(drpDriver);//trying
				drpDriver.setBounds(390, 85, 150, 30);
				drpDriver.setFont(f2);
				


				
		//MyLabels
		/*
		lblDriver = new JLabel("Driver");
		lblDriver.setBounds(100, 100, 180, 40);
		txtDriver = new JComboBox<String>();
		txtDriver.setBounds(200, 100, 280, 40);
		txtDriver.addItem("Select your Database Driver");
		txtDriver.addItem("oracle.jdbc.driver.OracleDriver");
		txtDriver.addItem("com.mysql.jdbc.Driver");
		txtDriver.addItem("org.hsqldb.jdbc.JDBCDriver");
		txtDriver.addItem("org.apache.derby.jdbc.EmbeddedDriver");
		txtDriver.addItem("org.sqlite.JDBC");
		txtDriver.addItem("org.postgresql.Driver");
		txtDriver.addItem("org.mariadb.jdbc.Driver");
		
		lblUrl = new JLabel("URL");
		lblUrl.setBounds(100, 150, 180, 40);
		txtUrl = new JTextField();
		txtUrl.setBounds(200, 150, 280, 40);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(100, 200, 180, 40);
		txtUsername = new JTextField();
		txtUsername.setBounds(200, 200, 280, 40);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(100, 250, 180, 40);
		txtPassword = new JPasswordField();
		txtPassword.setBounds(200, 250, 280, 40); 
		
		btnConnect = new JButton("Connect");
		btnConnect.setBounds(100, 350, 120, 40);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(250, 350, 120, 40);

		lblHeading = new JLabel("JDBC Driver Information");
		lblHeading.setBounds(230, 0, 300, 60);
		lblFont = new Font("Sans-Serif", Font.BOLD, 20);
		lblHeading.setFont(lblFont);
		
		 */

	   /*
		//frame.add(lblHeading);//trying

		*/
				
				/*
				frame.add(lblDriver);
				frame.add(txtDriver);
				frame.add(lblUrl);
				frame.add(txtUrl);
				frame.add(lblUsername);
				frame.add(txtUsername);
				frame.add(lblPassword);
				frame.add(txtPassword);
				frame.add(btnConnect);
				frame.add(btnCancel);
				//frame.add(lblHeading);
				frame.add(lblTitle);
				frame.add(prt1);
				frame.add(prt2);
				frame.add(db);
				frame.add(drpDriver);
				frame.add(btnReset);
				*/		
		
		drpDriver.addItemListener(this);
		btnConnect.addActionListener(this);
		btnCancel.addActionListener(this);
		btnReset.addActionListener(this);
	}

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent event) {
		Object object = event.getSource();
		if (object == btnConnect) {
			String txt = QueryFrame.Connect(txtDriver.getText(), txtUrl.getText(),
					txtUsername.getText(), txtPassword.getText());
			if (txt.equals("Connected Succesfully")) {
				QueryFrame qf = new QueryFrame();
				frame.dispose();
			} else {
				JOptionPane.showMessageDialog(frame, QueryFrame.Connect(txtDriver.getText(),
						txtUrl.getText(), txtUsername.getText(), txtPassword.getText()));
			}
		} 
		else if(object == btnReset){
			txtDriver.setText(null);
			txtUrl.setText(null);
			txtUsername.setText(null);
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "OK BYE");
			System.exit(0);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		Object action = e.getSource();
		if (action == drpDriver) {

			// Object dbselect = drpdriver.getSelectedItem();
			int dbindex = drpDriver.getSelectedIndex();

			txtDriver.setText(strdriver[dbindex]);
			txtUrl.setText(strurl[dbindex]);
			txtUsername.setText(strusername[dbindex]);
		}

		
		/*
		int index = drpDriver.getSelectedIndex();
		if (index==1) {
			txtUrl.setText("jdbc:oracle:thin:@localhost:1521:xe");
			txtUsername.setText("System");
		} else if(txt.equals("com.mysql.jdbc.Driver")) {
			txtDriver.setText("com.mysql.jdbc.Driver");
			txtUrl.setText("jdbc:mysql://localhost:3306/java");
			txtUsername.setText("root");
		}
		else if(txt.equals("org.hsqldb.jdbc.JDBCDriver")){
			txtUrl.setText("jdbc:hsqldb:file:E:\\Programming data\\java backend\\JDBC Drivers");
			txtUsername.setText("SA");		
		}
		else if (txt.equals("org.apache.derby.jdbc.EmbeddedDriver")) {
			txtUrl.setText("jdbc:derby:c:\\derby\\bin\\mydb");
		}
		else if(txt.equals("org.sqlite.JDBC")) {
			txtUrl.setText("jdbc:sqlite:C:\\Users\\ASUS\\chinook.db");
		}
		else if (txt.equals("org.postgresql.Driver")) {
			txtUrl.setText( "jdbc:postgresql://localhost/postgres");
			txtUsername.setText("postgres");
		}
		else if (txt.equals("org.mariadb.jdbc.Driver")) {
			txtUrl.setText( "jdbc:mysql://localhost:3308/codeheist");
			txtUsername.setText("root");
		} */
	}

}




