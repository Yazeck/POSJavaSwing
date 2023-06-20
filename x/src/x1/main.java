package x1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Window;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class main extends JFrame {


	public static void main(String[] args) {
		Conexion conexion= new Conexion();
		conexion.Conectar();
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Inventario VentanaInventario=new Inventario();
					VentanaInventario.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}


