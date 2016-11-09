import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Interfaz {

	private JFrame frmVisualizadorDeGrafos;
	private JTextField txtNinguno;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost", "neo4j", "neo4j1");
			try (Statement stmt = con.createStatement()) {
				ResultSet rs = stmt.executeQuery("MATCH (n:User) RETURN n.name");
				while (rs.next()) {
					System.out.println(rs.getString("n.name"));
				}
			}

			/*Devolver el arraylist de datos */
			Relaciones relate = new Relaciones();
			relate.Pruebas();
			ArrayList lista = relate.getLista();

			/*Crear el grafo y agregar los nodos*/
			relate.seccionA();


			con.close();

		}catch (Exception ex){
			ex.printStackTrace();
		}




		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frmVisualizadorDeGrafos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVisualizadorDeGrafos = new JFrame();
		frmVisualizadorDeGrafos.setTitle("Visualizador de Grafos");
		frmVisualizadorDeGrafos.setBounds(100, 100, 450, 300);
		frmVisualizadorDeGrafos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVisualizadorDeGrafos.getContentPane().setLayout(null);
		
		JButton btnIncisoA = new JButton("Opcion 1");
		btnIncisoA.setBounds(10, 77, 100, 23);
		frmVisualizadorDeGrafos.getContentPane().add(btnIncisoA);
		
		JButton btnIncisoB = new JButton("Opcion 2");
		btnIncisoB.setToolTipText("");
		btnIncisoB.setBounds(10, 115, 100, 23);
		frmVisualizadorDeGrafos.getContentPane().add(btnIncisoB);
		
		JButton btnIncisoC = new JButton("Opcion 3");
		btnIncisoC.setBounds(10, 155, 100, 23);
		frmVisualizadorDeGrafos.getContentPane().add(btnIncisoC);
		
		JButton btnIncisoD = new JButton("Opcion 4");
		btnIncisoD.setBounds(120, 77, 100, 23);
		frmVisualizadorDeGrafos.getContentPane().add(btnIncisoD);
		
		JButton btnIncisoE = new JButton("Opcion 4");
		btnIncisoE.setBounds(120, 115, 100, 23);
		frmVisualizadorDeGrafos.getContentPane().add(btnIncisoE);
		
		JButton btnIncisoF = new JButton("Opcion 5");
		btnIncisoF.setBounds(120, 155, 100, 23);
		frmVisualizadorDeGrafos.getContentPane().add(btnIncisoF);
		
		JLabel lblHojaDeTrabajo = new JLabel("Hoja de Trabajo #10");
		lblHojaDeTrabajo.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblHojaDeTrabajo.setBounds(10, 11, 291, 44);
		frmVisualizadorDeGrafos.getContentPane().add(lblHojaDeTrabajo);
		
		JButton btnInstrucciones = new JButton("Instrucciones");
		btnInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Instrucciones info = new Instrucciones();
				info.setVisible(true);
			}

		});
		btnInstrucciones.setBackground(Color.LIGHT_GRAY);
		btnInstrucciones.setBounds(10, 227, 114, 23);
		frmVisualizadorDeGrafos.getContentPane().add(btnInstrucciones);
		
		JButton btnCargarArchivo = new JButton("Cargar Archivo ");
		btnCargarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnCargarArchivo.setBackground(Color.LIGHT_GRAY);
		btnCargarArchivo.setBounds(274, 190, 150, 23);
		frmVisualizadorDeGrafos.getContentPane().add(btnCargarArchivo);
		
		txtNinguno = new JTextField();
		txtNinguno.setHorizontalAlignment(SwingConstants.CENTER);
		txtNinguno.setText("NINGUNO");
		txtNinguno.setBounds(235, 227, 189, 20);
		frmVisualizadorDeGrafos.getContentPane().add(txtNinguno);
		txtNinguno.setColumns(10);
	}
}
