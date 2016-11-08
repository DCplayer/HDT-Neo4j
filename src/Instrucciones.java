import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;

public class Instrucciones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instrucciones frame = new Instrucciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Instrucciones() {
		setTitle("INSTRUCCIONES DE USO");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInstruccionesDeUso = new JLabel("INSTRUCCIONES DE USO");
		lblInstruccionesDeUso.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruccionesDeUso.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblInstruccionesDeUso.setBounds(10, 11, 385, 82);
		contentPane.add(lblInstruccionesDeUso);
		
		JTextPane txtpnInstruccionescargarCargar = new JTextPane();
		txtpnInstruccionescargarCargar.setBackground(Color.WHITE);
		txtpnInstruccionescargarCargar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtpnInstruccionescargarCargar.setText("Instrucciones: \r\n\r\n- Cargar: Cargar datos.csv.\r\n\r\n- Opcion 1: Visualizar grafo de relaciones\r\n\r\n- Opcion 2: Visualizar relaciones que tienen mas de 6 correos.\r\n\r\n- Opcion 3: Simplificar grafo.\r\n\r\n- Opcion 4: Page-Rank.\r\n\r\n- Opcion 5: Se muestra las personas que estan masomenos comunicadas\r\n\r\n- Opcion 6:  Se muestran la minima cantidad de correos que ha enviado una persona directa e indirectamente a las personas ");
		txtpnInstruccionescargarCargar.setBounds(30, 72, 365, 347);
		contentPane.add(txtpnInstruccionescargarCargar);
	}
}
