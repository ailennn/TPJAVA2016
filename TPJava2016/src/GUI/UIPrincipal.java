package GUI;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;
public class UIPrincipal {

	private JFrame frmAgenciaDeViajes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIPrincipal window = new UIPrincipal();
					window.frmAgenciaDeViajes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UIPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		
		frmAgenciaDeViajes = new JFrame();
		
		frmAgenciaDeViajes.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frmAgenciaDeViajes.setMinimumSize(new Dimension(900, 600));
		frmAgenciaDeViajes.setIconImage(Toolkit.getDefaultToolkit().getImage(UIPrincipal.class.getResource("/ico/365-200.png")));
		frmAgenciaDeViajes.setMaximumSize(new Dimension(900, 600));
		frmAgenciaDeViajes.setTitle("Agencia de Viajes");
		frmAgenciaDeViajes.setResizable(false);
		frmAgenciaDeViajes.setBounds(100, 100, 451, 368);
		frmAgenciaDeViajes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmAgenciaDeViajes.setJMenuBar(menuBar);
		
		JMenu mnAdministrar = new JMenu("Administrar");
		menuBar.add(mnAdministrar);
		
		JMenuItem mntmTransporte = new JMenuItem("Transporte");
		mnAdministrar.add(mntmTransporte);
		
		JMenuItem mntmResponsable = new JMenuItem("Responsable");
		mnAdministrar.add(mntmResponsable);
		
		JMenuItem mntmCrearViaje = new JMenuItem("Crear Viaje");
		mntmCrearViaje.setSelectedIcon(null);
		mnAdministrar.add(mntmCrearViaje);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ranking");
		mnReportes.add(mntmNewMenuItem);
		
		JMenuItem mntmRecaudacin = new JMenuItem("Recaudaci\u00F3n");
		mnReportes.add(mntmRecaudacin);
		frmAgenciaDeViajes.getContentPane().setLayout(null);
		
		JLabel lblInformacin = new JLabel("Informaci\u00F3n");
		lblInformacin.setBounds(401, 54, 68, 16);
		frmAgenciaDeViajes.getContentPane().add(lblInformacin);
		lblInformacin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setToolTipText("");
		list.setBounds(684, 53, 160, 400);
		frmAgenciaDeViajes.getContentPane().add(list);
		
		JList list_2 = new JList();
		list_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list_2.setBounds(33, 53, 160, 400);
		frmAgenciaDeViajes.getContentPane().add(list_2);
		
		JLabel lblListadoDeViajes = new JLabel("Listado de Viajes Pendientes");
		lblListadoDeViajes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListadoDeViajes.setBounds(33, 29, 175, 14);
		frmAgenciaDeViajes.getContentPane().add(lblListadoDeViajes);
		
		JLabel lblListadoDeViajes_2 = new JLabel("Listado de Viajes Finalizados");
		lblListadoDeViajes_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListadoDeViajes_2.setBounds(684, 28, 200, 14);
		frmAgenciaDeViajes.getContentPane().add(lblListadoDeViajes_2);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Iniciar");
		tglbtnNewToggleButton.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tglbtnNewToggleButton.setActionCommand("");
		tglbtnNewToggleButton.setBounds(33, 497, 121, 30);
		frmAgenciaDeViajes.getContentPane().add(tglbtnNewToggleButton);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/Cancela.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(164, 497, 121, 30);
		frmAgenciaDeViajes.getContentPane().add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textPane.setBackground(SystemColor.info);
		textPane.setBounds(232, 77, 410, 281);
		frmAgenciaDeViajes.getContentPane().add(textPane);
		frmAgenciaDeViajes.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmAgenciaDeViajes.getContentPane(), list, list_2, menuBar, mnAdministrar, mntmTransporte, mntmResponsable, mnReportes, mntmNewMenuItem, mntmRecaudacin}));
	}
}
