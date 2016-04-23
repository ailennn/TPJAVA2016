package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

public class CrearViajeCorto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearViajeCorto frame = new CrearViajeCorto();
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
	public CrearViajeCorto() {
		setMaximumSize(new Dimension(600, 400));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearViajeCorto.class.getResource("/ico/365-200.png")));
		setTitle("Viaje de Corta Distancia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(600, 400));
		contentPane.setSize(new Dimension(600, 400));
		contentPane.setPreferredSize(new Dimension(600, 40));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setMaximumSize(new Dimension(600, 400));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreacinDeViaje = new JLabel("Creaci\u00F3n de viaje de Corta Distancia");
		lblCreacinDeViaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCreacinDeViaje.setBounds(20, 47, 267, 14);
		contentPane.add(lblCreacinDeViaje);
		
		JLabel lblElegirTransporte = new JLabel("Seleccionar Transporte");
		lblElegirTransporte.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblElegirTransporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblElegirTransporte.setBounds(20, 114, 149, 24);
		contentPane.add(lblElegirTransporte);
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		list.setBounds(179, 117, 138, 80);
		contentPane.add(list);
		
		JLabel lblCantidadDePasajeros = new JLabel("Cantidad de Pasajeros");
		lblCantidadDePasajeros.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCantidadDePasajeros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadDePasajeros.setBounds(383, 114, 128, 14);
		contentPane.add(lblCantidadDePasajeros);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(383, 140, 128, 20);
		contentPane.add(spinner);
		
		JButton button = new JButton("Crear Viaje");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setIcon(new ImageIcon(CrearViajeCorto.class.getResource("/ico/ok.png")));
		button.setBounds(157, 274, 121, 30);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button_1.setIcon(new ImageIcon(CrearViajeCorto.class.getResource("/ico/Cancela.png")));
		button_1.setBounds(365, 274, 121, 30);
		contentPane.add(button_1);
	}
}
