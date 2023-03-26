package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class QueryFrame implements ActionListener {
	private JFrame frame, frame1;
	private JLabel enterQuery, resultQuery;
	private JTextArea txtEnterQuery, txtResultQuery;
	private JButton btnExecute, btnClear;
	private static JTable table;
	private DefaultTableModel model;
	private Font font;

	public QueryFrame() {
		frame = new JFrame("Query Window");
		frame.setSize(900, 500);
		frame.setBounds(500, 50, 450, 350);
		frame.setVisible(true);
		frame.setLayout(null);

		enterQuery = new JLabel("Enter Query");
		enterQuery.setBounds(10, 10, 200, 40);
		font = new Font("Sans Serif", Font.BOLD, 20);
		enterQuery.setFont(font);

		txtEnterQuery = new JTextArea();
		txtEnterQuery.setBounds(10, 50, 300, 70);
		txtEnterQuery.setLineWrap(true);
		txtEnterQuery.setWrapStyleWord(true);
		JScrollPane scrollPane1 = new JScrollPane(txtEnterQuery);
		txtEnterQuery.setFont(font);

		btnExecute = new JButton("Execute");
		btnExecute.setBounds(320, 50, 80, 30);
		btnClear = new JButton("Clear");
		btnClear.setBounds(320, 90, 80, 30);

		resultQuery = new JLabel("Result");
		resultQuery.setBounds(100, 120, 200, 40);
		resultQuery.setFont(font);

		txtResultQuery = new JTextArea();
		txtResultQuery.setBounds(10, 160, 400, 100);
		txtResultQuery.setLineWrap(true);
		txtResultQuery.setWrapStyleWord(true);
		JScrollPane scrollPane2 = new JScrollPane(txtResultQuery);
		txtResultQuery.setVisible(true);

		frame.add(enterQuery);
		frame.add(resultQuery);
		frame.add(txtEnterQuery);
		frame.add(txtResultQuery);
		frame.add(btnExecute);
		frame.add(btnClear);

		btnExecute.addActionListener(this);
		btnClear.addActionListener(this);
	}

	static Connection con;

	public static String Connect(String driver, String url, String username, String password) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			return "Connected Succesfully";
		} catch (Exception e) {
			return "Connection Failed here";
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object object = e.getSource();
		if (object == btnExecute) {
			String query = txtEnterQuery.getText().toLowerCase();
			if (query.startsWith("select")) {

				try (Statement s = con.createStatement()) {
					ResultSet rs = s.executeQuery(txtEnterQuery.getText());
					ResultSetMetaData rsMeta = rs.getMetaData();

					Vector<String> columnNames = new Vector();
					int ColumnCount = rs.getMetaData().getColumnCount();
					int j = 1;
					while (j <= ColumnCount) {
						columnNames.add(rsMeta.getColumnName(j));
						j++;
					}
					DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(columnNames);
					table = new JTable();
					txtResultQuery.setVisible(false);
					JTableHeader header = table.getTableHeader();
					header.setBackground(Color.black);
					header.setForeground(Color.yellow);
					// table.setBounds(10,200,800,600);
					table.setModel(model);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table.setFillsViewportHeight(true);
					JScrollPane scroll = new JScrollPane(table);
					scroll.setBounds(10, 160, 800, 200);
					scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					// txtResultQuery.append(rsMeta.getColumnName(1) + " " + rsMeta.getColumnName(2)
					// + " "
					// + rsMeta.getColumnName(3) + " " + rsMeta.getColumnName(6) + " \n");

					Object[] row = new Object[ColumnCount];
					while (rs.next()) {

						for (int i = 0; i < ColumnCount; i++) {
							int x = i + 1;
							row[i] = rs.getObject(x);

						}
						model.addRow(row);
						// txtResultQuery.append((String.valueOf(rs.getInt(1)) + " " + rs.getString(2) +
						// " "
						// + rs.getString(3) + " " + String.valueOf(rs.getInt(6) + "\n")));
						// for(int i =0;i<ColumnCount;i++) {

						// }
						// model.setValueAt(rs.getString(1), 1, 1);
						// model.addRow(new Object[] { rs.getString(1), rs.getString(2),
						// rs.getString(3), rs.getString(6) });
					}
					frame.add(scroll);
					frame.setVisible(true);
					frame.setSize(400, 300);
				} catch (Exception ex) {
					ex.printStackTrace();

				}
			} else if (query.startsWith("insert")) {
				try (Statement s = con.createStatement()) {
					int rows = s.executeUpdate(txtEnterQuery.getText());
					txtResultQuery.setText("Rows Updated :" + rows);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			else if (query.startsWith("update")) {
				try (Statement s = con.createStatement()) {
					int rows = s.executeUpdate(txtEnterQuery.getText());
					txtResultQuery.setText("Rows Affected :" + rows);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			else if (query.startsWith("delete")) {
				try (Statement s = con.createStatement()) {
					int rows = s.executeUpdate(txtEnterQuery.getText());
					txtResultQuery.setText("Rows Affected :" + rows);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		} else if (object == btnClear) {
			txtEnterQuery.setText(null);
			txtResultQuery.setText(null);
		}

	}
}
