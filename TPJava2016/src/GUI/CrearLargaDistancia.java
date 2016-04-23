package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JSpinner;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CrearLargaDistancia extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearLargaDistancia frame = new CrearLargaDistancia();
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
	public CrearLargaDistancia() {
		setFont(new Font("Tahoma", Font.PLAIN, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearLargaDistancia.class.getResource("/ico/365-200.png")));
		setTitle("Viaje de Larga Distancia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(600, 400));
		contentPane.setMaximumSize(new Dimension(600, 400));
		contentPane.setPreferredSize(new Dimension(600, 400));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Seleccionar Transporte");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setAlignmentX(0.5f);
		label.setBounds(10, 93, 149, 24);
		contentPane.add(label);
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		list.setBounds(169, 96, 138, 80);
		contentPane.add(list);
		
		JLabel label_1 = new JLabel("Cantidad de Pasajeros");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setAlignmentX(0.5f);
		label_1.setBounds(375, 98, 128, 14);
		contentPane.add(label_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(375, 118, 128, 20);
		contentPane.add(spinner);
		
		JLabel lblCreacinDeViaje = new JLabel("Creaci\u00F3n de viaje de Larga Distancia");
		lblCreacinDeViaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCreacinDeViaje.setBounds(10, 31, 267, 24);
		contentPane.add(lblCreacinDeViaje);
		
		JLabel lblCantidadEnSemi = new JLabel("Cantidad en Semi Cama");
		lblCantidadEnSemi.setBounds(375, 149, 154, 14);
		contentPane.add(lblCantidadEnSemi);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(375, 174, 113, 20);
		contentPane.add(spinner_1);
		
		JLabel lblCantidadEnCama = new JLabel("Cantidad en Cama");
		lblCantidadEnCama.setEnabled(false);
		lblCantidadEnCama.setOpaque(true);
		lblCantidadEnCama.setBounds(375, 204, 113, 14);
		contentPane.add(lblCantidadEnCama);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setEnabled(false);
		spinner_2.setBounds(375, 229, 113, 20);
		contentPane.add(spinner_2);
		
		JButton button = new JButton("Crear Viaje");
		button.setIcon(new ImageIcon(CrearLargaDistancia.class.getResource("/ico/ok.png")));
		button.setAlignmentX(0.5f);
		button.setBounds(119, 286, 121, 30);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setIcon(new ImageIcon(CrearLargaDistancia.class.getResource("/ico/Cancela.png")));
		button_1.setAlignmentX(0.5f);
		button_1.setBounds(327, 286, 121, 30);
		contentPane.add(button_1);
	}

}
