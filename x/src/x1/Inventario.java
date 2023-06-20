package x1;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JScrollBar;

public class Inventario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldDescr;
	private JTextField textFieldComp;
	private JTextField textFieldVenta;
	private JTextField textFieldCantidad;
	 DefaultListModel <Producto> listaModelo= new DefaultListModel<Producto>();
	 DefaultListModel <Producto> listaModelo2= new DefaultListModel<Producto>();
	Producto productoActual;
	
	String url = "jdbc:mysql://localhost:3306/Productos";
	String usuario = "root";
	String contraseña = "2wsx2wsx2wsX.";
	Connection cn = (Connection) DriverManager.getConnection(url, usuario, contraseña);
	Statement stm=(Statement)
			cn.createStatement();
	ResultSet rs=null;
	private JTextField textFieldCantidadVenta;

	public void limpiarNota() {
		listaModelo2.removeAllElements();
	}
	public Inventario() throws SQLException {
		
		//JFrame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 100, 609, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		  // Crear un JScrollPane y agregar el JList
      
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setBounds(38, 401, 61, 16);
		contentPane.add(lblNota);
		
		JLabel lblNewLabelCatalogo = new JLabel("Catalogo:");
		lblNewLabelCatalogo.setBounds(40, 197, 61, 16);
		contentPane.add(lblNewLabelCatalogo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(27, 39, 61, 16);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Descripción:");
		lblNewLabel.setBounds(9, 70, 79, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Compra:");
		lblNewLabel_1.setBounds(19, 98, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Venta:");
		lblNewLabel_2.setBounds(29, 126, 45, 16);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(40, 418, 262, 154);
		contentPane.add(scrollPane_2);
		
		JTextArea NotaImpresa = new JTextArea();
		scrollPane_2.setViewportView(NotaImpresa);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(97, 34, 100, 26);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
	    textFieldDescr = new JTextField();
		textFieldDescr.setBounds(97, 65, 100, 26);
		contentPane.add(textFieldDescr);
		textFieldDescr.setColumns(10);
		
		textFieldComp = new JTextField();
		textFieldComp.setBounds(97, 93, 100, 26);
		contentPane.add(textFieldComp);
		textFieldComp.setColumns(10);
		
		textFieldVenta = new JTextField();
		textFieldVenta.setBounds(97, 121, 100, 26);
		contentPane.add(textFieldVenta);
		textFieldVenta.setColumns(10);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(97, 149, 100, 26);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);

		JLabel lblCantidadPrincipal = new JLabel("Cantidad:");
		lblCantidadPrincipal.setBounds(18, 154, 61, 16);
		contentPane.add(lblCantidadPrincipal);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 212, 262, 172);
		contentPane.add(scrollPane);
		
		
		JList<Producto> Lista = new JList<Producto>();
		scrollPane.setViewportView(Lista);
		Lista.setModel(listaModelo);
		Lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		  // Crear un JScrollPane y agregar el JList
     
		// Ejecutar la consulta SQL y procesar el resultado
		cn = (Connection) DriverManager.getConnection(url, usuario, contraseña);
		cn.createStatement();
		String consulta = "SELECT nombre, descripcion, precioCompra, precioVenta, existencias FROM Productos";
		rs = stm.executeQuery(consulta);
		
		while (rs.next()) {
		    // Obtener los datos del resultado y crear un objeto Producto
		    String nombre = rs.getString("nombre");
		    String descripcion = rs.getString("descripcion");
		    double precioCompra = rs.getDouble("precioCompra");
		    double precioVenta = rs.getDouble("precioVenta");
		    int existencias = rs.getInt("existencias");

		    Producto producto1 = new Producto(nombre, descripcion, precioCompra, precioVenta, existencias);

		    // Agregar el producto al modelo de lista
		    listaModelo.addElement(producto1);
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(314, 212, 236, 172);
		contentPane.add(scrollPane_1);
		
		
		JList<Producto> Nota = new JList<Producto>();
		scrollPane_1.setViewportView(Nota);
		Nota.setModel(listaModelo2);
		Nota.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	


		
		//botones con metodos:
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(227, 65, 117, 29);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
listaModelo.removeElement(productoActual);

			}
			
			
		});
		
		JButton btnAgregarANota = new JButton("Agregar a Nota");
		btnAgregarANota.setBounds(348, 467, 178, 29);
		contentPane.add(btnAgregarANota);
		btnAgregarANota.addActionListener(new ActionListener() {
			
            public void actionPerformed(ActionEvent e) {
                // Obtener el elemento seleccionado de la lista 1
                Producto seleccionado = Lista.getSelectedValue();
                
                if (seleccionado != null) {
                	System.out.println("Elemento seleccionado: " + seleccionado);
                	System.out.println("Cantidad de elementos en listaModelo2 antes de agregar: " + listaModelo2.getSize());
                	listaModelo2.addElement(seleccionado);
                	System.out.println("Cantidad de elementos en listaModelo2 después de agregar: " + listaModelo2.getSize());
                }
                
            }
        });
		
		JButton btnCobrar = new JButton("Cobrar");
		btnCobrar.setBounds(348, 519, 178, 29);
		contentPane.add(btnCobrar);
		btnCobrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Crear un StringBuilder para construir la cadena de texto con la lista de productos
		        StringBuilder sb = new StringBuilder();
		        // Recorrer la lista de productos
		        double total = 0;
		        for (int i = 0; i < listaModelo2.getSize(); i++) {
		            Producto producto = listaModelo2.getElementAt(i);
		            sb.append(producto.getNombre())
		              .append("\t")
		              .append(producto.getPrecioVenta())
		              .append("\n");
		            total += producto.getPrecioVenta();
		        }
		        // Agregar el total al final de la cadena de texto
		        sb.append("Total:\t").append(total);
		        // Agregar la cadena de texto al JTextArea
		        NotaImpresa.setText(sb.toString());
		    }

//metodo sql
		    
		});
		
		
		
		JButton btnLimpiarNotas = new JButton("Limpiar");
		btnLimpiarNotas.setBounds(348, 543, 178, 29);
		contentPane.add(btnLimpiarNotas);
		btnLimpiarNotas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			Nota.removeAll();
				NotaImpresa.setText("");
				limpiarNota();
			}});
		
		JButton btnEliminarElementoDeNota = new JButton("Eliminar Elemento");
		btnEliminarElementoDeNota.setBounds(348, 492, 178, 29);
		contentPane.add(btnEliminarElementoDeNota);
		btnEliminarElementoDeNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Producto seleccionado = Nota.getSelectedValue();
		        
		        if (seleccionado != null) {
		            // Eliminar el elemento seleccionado de la lista
		            listaModelo2.removeElement(seleccionado);
		            System.out.println("Elemento eliminado correctamente.");
		        } else {
		            System.out.println("No se ha seleccionado ningún elemento.");
		        }
		    }
		});
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(227, 34, 117, 29);
		contentPane.add(btnGuardar);
		
		
		//LOGO
		ImageIcon icono = new ImageIcon("/Users/ericknungaray/git/PuntoDeVentaSwing/x/img/CONSTRUCCIONTEC.png");

        // Obtener la imagen del icono
        Image imagen = icono.getImage();

        // Redimensionar la imagen al tamaño deseado
        Image imagenRedimensionada = imagen.getScaledInstance(153, 125, Image.SCALE_SMOOTH);

        // Crear una nueva instancia de ImageIcon con la imagen redimensionada
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

        // Crear una instancia de JLabel y asignar el icono redimensionado
        JLabel labelImagen = new JLabel(iconoRedimensionado);
		labelImagen.setBounds(373, 39, 153, 125);
		contentPane.add(labelImagen);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(287, 213, 15, 171);
		contentPane.add(scrollBar);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad");
		lblNewLabel_3.setBounds(357, 439, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		textFieldCantidadVenta = new JTextField();
		textFieldCantidadVenta.setText("1");
		textFieldCantidadVenta.setBounds(430, 434, 73, 26);
		contentPane.add(textFieldCantidadVenta);
		textFieldCantidadVenta.setColumns(10);
		
		
		btnGuardar.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
				productoActual=new Producto("","",0,0,0);
		        // Asignar los valores de los JTextField al objeto Producto actual
		        productoActual.setNombre(textFieldNombre.getText());
		        productoActual.setDescripcion(textFieldDescr.getText());
		        productoActual.setPrecioCompra(Float.parseFloat(textFieldComp.getText()));
		        productoActual.setPrecioVenta(Float.parseFloat(textFieldVenta.getText()));
		        productoActual.setExistencias(Integer.parseInt(textFieldCantidad.getText()));

		        // Imprimir la información del producto actual
		        System.out.println(productoActual);
		      listaModelo.addElement(productoActual);

		            // Crear la consulta SQL parametrizada para insertar los datos en la base de datos
		           
		            String consulta = "INSERT INTO Productos (nombre, descripcion, precioCompra, precioVenta, existencias) "+
		            		 "VALUES ('"+productoActual.getNombre()+"','"+productoActual.getDescripcion()+"','"+productoActual.getPrecioCompra()+"','"+productoActual.getPrecioVenta()+"','"+productoActual.getExistencias()+"')";
		    		try {
						stm.executeUpdate(consulta);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		   
		  
		    }
		      
		    

			
		});
		
		
		
		
	}
}
