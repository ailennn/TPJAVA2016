package GUI;

import agencia.Agencia;
import misc.Destino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.SpinnerListModel;

public class SeleccionaDestino extends JFrame {
	
	private JPanel contentPane;
	private DefaultListModel<String> listModel;
	
	private Agencia A;
	

	/**
	 * Create the frame.
	 */
	
	public SeleccionaDestino() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SeleccionaDestino.class.getResource("/ico/365-200.png")));
		setResizable(false);
		setTitle("Selecci\u00F3n de Destino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione un Destino");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(149, 27, 132, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCrearViaje = new JButton("Crear Viaje");
		btnCrearViaje.setIcon(new ImageIcon(SeleccionaDestino.class.getResource("/ico/ok.png")));
		btnCrearViaje.setBounds(102, 198, 121, 30);
		contentPane.add(btnCrearViaje);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(SeleccionaDestino.class.getResource("/ico/Cancela.png")));
		btnCancelar.setBounds(248, 198, 121, 30);
		contentPane.add(btnCancelar);
		
		
		listModel = new DefaultListModel<String>();
		cargaDestinos();
		
		JList listDestino = new JList(listModel);
		listDestino.setModel(listModel);
		listDestino.setBounds(121, 52, 196, 125);
		contentPane.add(listDestino);
	}
	
	/**
	 * Carga los destinos en una DefaultListModel para mostrar en Jlist
	 */
	public void cargaDestinos (){
		listModel = new DefaultListModel<String>();
		ArrayList<String> aux = A.getListaDestino();
		for (int i=0; i<aux.size();i++){
			listModel.addElement(aux.get(i));
		}		
	}
}
