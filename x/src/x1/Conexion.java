package x1;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class Conexion {
	private static final String CONTROLADOR ="com.mysql.jdbc.Driver";
	public Connection Conectar(){
		Connection conexion=null;
		try {
			Class.forName(CONTROLADOR);
			DriverManager.getConnection("jdbc:mysql://localhost:3306/Productos","root","2wsx2wsx2wsX.");
	System.out.print("Coneccion ok");
		} catch (ClassNotFoundException e) {
			System.out.println("error al cargar el controlador");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error en la conexion");
			e.printStackTrace();
		}
		return conexion;
	}
	public static PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
