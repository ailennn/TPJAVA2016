package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import agencia.Agencia;

public class UIPrincipal {

	private JFrame frmAgenciaDeViajes;
	private JTextField tfVelocidad;
	private JTextField tfModifPatente;
	private JTextField tfModifVelocidad;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	
	private Agencia A;

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
		frmAgenciaDeViajes.setPreferredSize(new Dimension(600, 600));
		frmAgenciaDeViajes.setIconImage(Toolkit.getDefaultToolkit().getImage(UIPrincipal.class.getResource("/ico/365-200.png")));
		frmAgenciaDeViajes.setMinimumSize(new Dimension(600, 600));
		frmAgenciaDeViajes.setMaximumSize(new Dimension(600, 600));
		frmAgenciaDeViajes.setResizable(false);
		frmAgenciaDeViajes.setTitle("Agencia de Viajes");
		frmAgenciaDeViajes.setBounds(100, 100, 450, 300);
		frmAgenciaDeViajes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgenciaDeViajes.getContentPane().setLayout(null);
		
		JTabbedPane panelGeneral = new JTabbedPane(JTabbedPane.TOP);
		panelGeneral.setPreferredSize(new Dimension(598, 598));
		panelGeneral.setMinimumSize(new Dimension(598, 598));
		panelGeneral.setMaximumSize(new Dimension(598, 598));
		panelGeneral.setBounds(0, 0, 594, 571);
		frmAgenciaDeViajes.getContentPane().add(panelGeneral);
		
		JPanel inicio = new JPanel();
		inicio.setPreferredSize(new Dimension(598, 598));
		inicio.setMinimumSize(new Dimension(598, 598));
		inicio.setMaximumSize(new Dimension(598, 598));
		ImageIcon iconInicio = new ImageIcon (UIPrincipal.class.getResource("/ico/inicioIco.png"));
		panelGeneral.addTab("Inicio", iconInicio, inicio, null);
		inicio.setLayout(null);
		
		JList<String> listaPendientes = new JList<String>();
		listaPendientes.setBorder(new MatteBorder(1, 1, 1, 1, (Color) UIManager.getColor("ToolBar.shadow")));
		listaPendientes.setBounds(10, 67, 140, 358);
		inicio.add(listaPendientes);
		
		JList<String> listaFinalizados = new JList<String>();
		listaFinalizados.setBorder(new MatteBorder(1, 1, 1, 1, (Color) UIManager.getColor("ToolBar.shadow")));
		listaFinalizados.setBounds(439, 67, 140, 358);
		inicio.add(listaFinalizados);
		
		JTextPane tpInformacion = new JTextPane();
		tpInformacion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tpInformacion.setBackground(UIManager.getColor("ToolTip.background"));
		tpInformacion.setBounds(160, 67, 269, 358);
		inicio.add(tpInformacion);
		
		JLabel lblViajesPendientes = new JLabel("Viajes Pendientes");
		lblViajesPendientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblViajesPendientes.setFont(new Font("Calibri", Font.ITALIC, 15));
		lblViajesPendientes.setBounds(10, 42, 140, 14);
		inicio.add(lblViajesPendientes);
		
		JLabel lblInformacin = new JLabel("Informaci\u00F3n");
		lblInformacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacin.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblInformacin.setBounds(160, 42, 269, 14);
		inicio.add(lblInformacin);
		
		JLabel lblViajesFinalizados = new JLabel("Viajes Finalizados");
		lblViajesFinalizados.setHorizontalAlignment(SwingConstants.CENTER);
		lblViajesFinalizados.setFont(new Font("Calibri", Font.ITALIC, 15));
		lblViajesFinalizados.setBounds(439, 42, 140, 14);
		inicio.add(lblViajesFinalizados);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		btnIniciar.setBounds(182, 479, 120, 30);
		inicio.add(btnIniciar);
		
		JButton btnDetener = new JButton("Detener");
		btnDetener.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/Cancela.png")));
		btnDetener.setBounds(338, 479, 120, 30);
		inicio.add(btnDetener);
		
		JTabbedPane adminVehiculo = new JTabbedPane(JTabbedPane.TOP);
		ImageIcon iconAdmin = new ImageIcon (UIPrincipal.class.getResource("/ico/administrarIco.png"));
		panelGeneral.addTab("Administrar", iconAdmin, adminVehiculo, null);
			
		JTabbedPane Reportes = new JTabbedPane(JTabbedPane.TOP);
		ImageIcon iconReporte = new ImageIcon (UIPrincipal.class.getResource("/ico/reporteIco.png"));
		panelGeneral.addTab("Reportes", iconReporte, Reportes, null);
		
		JPanel reporteRecaudacion = new JPanel();
		ImageIcon iconRecaudacion = new ImageIcon (UIPrincipal.class.getResource("/ico/recaudacionIco.png"));
		Reportes.addTab("Recaudación", iconRecaudacion, reporteRecaudacion, null);
		reporteRecaudacion.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		ImageIcon iconRanking = new ImageIcon(UIPrincipal.class.getResource("/ico/rankingIco.png"));
		Reportes.addTab("Ranking", iconRanking, panel_1, null);
		
		JTabbedPane adminVehic = new JTabbedPane(JTabbedPane.TOP);
		ImageIcon iconVehiculo = new ImageIcon (UIPrincipal.class.getResource("/ico/transporteIco.png"));
		adminVehiculo.addTab("Vehículo", iconVehiculo, adminVehic, null);
		
		JPanel vehiculoAlta = new JPanel();
		ImageIcon iconAltaVehic = new ImageIcon (UIPrincipal.class.getResource("/ico/altaIco.png"));
		adminVehic.addTab("Alta", iconAltaVehic, vehiculoAlta, null);
		vehiculoAlta.setLayout(null);
		
		JLabel lblEnEstaSeccin = new JLabel("En esta secci\u00F3n se podr\u00E1 dar de alta un nuevo veh\u00EDculo.");
		lblEnEstaSeccin.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblEnEstaSeccin.setBounds(10, 11, 385, 14);
		vehiculoAlta.add(lblEnEstaSeccin);
		
		JLabel lblPatente = new JLabel("Patente");
		lblPatente.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPatente.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblPatente.setBounds(112, 70, 102, 14);
		vehiculoAlta.add(lblPatente);
		
		JLabel lblTipoDeVehculo = new JLabel("Tipo de veh\u00EDculo");
		lblTipoDeVehculo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTipoDeVehculo.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblTipoDeVehculo.setBounds(112, 140, 102, 14);
		vehiculoAlta.add(lblTipoDeVehculo);
		
		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVelocidad.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblVelocidad.setBounds(112, 210, 102, 14);
		vehiculoAlta.add(lblVelocidad);
		
		JTextField tfPatente = new JTextField();
		tfPatente.setBounds(new Rectangle(0, 0, 165, 20));
		tfPatente.setBounds(260, 70, 165, 20);
		vehiculoAlta.add(tfPatente);
		tfPatente.setColumns(10);
		
		tfVelocidad = new JTextField();
		tfVelocidad.setBounds(new Rectangle(0, 0, 165, 20));
		tfVelocidad.setBounds(260, 210, 165, 20);
		vehiculoAlta.add(tfVelocidad);
		tfVelocidad.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		btnAgregar.setBounds(220, 420, 120, 30);
		vehiculoAlta.add(btnAgregar);
		
		JComboBox<String> cbTipoVehiculo = new JComboBox<String>();
		cbTipoVehiculo.setBounds(260, 137, 165, 20);
		vehiculoAlta.add(cbTipoVehiculo);
		
		JPanel vehiculoModif = new JPanel();
		ImageIcon iconModifVehic = new ImageIcon (UIPrincipal.class.getResource("/ico/modificarIco.png"));
		adminVehic.addTab("Modificación", iconModifVehic, vehiculoModif, null);
		vehiculoModif.setLayout(null);
		
		JLabel lblEnEstaSeccin_1 = new JLabel("En esta secci\u00F3n podr\u00E1 modificar los veh\u00EDculos existentes.");
		lblEnEstaSeccin_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblEnEstaSeccin_1.setBounds(10, 11, 329, 14);
		vehiculoModif.add(lblEnEstaSeccin_1);
		
		JList<String> listaVehiculosDispo = new JList<String>();
		listaVehiculosDispo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listaVehiculosDispo.setBounds(46, 101, 150, 200);
		vehiculoModif.add(listaVehiculosDispo);
		
		JLabel lblVehculosDisponibles = new JLabel("Veh\u00EDculos disponibles");
		lblVehculosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblVehculosDisponibles.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblVehculosDisponibles.setBounds(46, 74, 150, 14);
		vehiculoModif.add(lblVehculosDisponibles);
		
		JLabel lblPatente_1 = new JLabel("Patente");
		lblPatente_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPatente_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblPatente_1.setBounds(264, 104, 92, 14);
		vehiculoModif.add(lblPatente_1);
		
		tfModifPatente = new JTextField();
		tfModifPatente.setBounds(374, 101, 125, 20);
		vehiculoModif.add(tfModifPatente);
		tfModifPatente.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTipo.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblTipo.setBounds(264, 191, 92, 14);
		vehiculoModif.add(lblTipo);
		
		JSpinner sModifTipo = new JSpinner();
		sModifTipo.setModel(new SpinnerListModel(new String[] {"Auto", "Combi", "Semi Cama", "Cama"}));
		sModifTipo.setBounds(374, 191, 125, 20);
		vehiculoModif.add(sModifTipo);
		
		tfModifVelocidad = new JTextField();
		tfModifVelocidad.setBounds(374, 281, 123, 20);
		vehiculoModif.add(tfModifVelocidad);
		tfModifVelocidad.setColumns(10);
		
		JLabel lblVelocidad_1 = new JLabel("Velocidad");
		lblVelocidad_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVelocidad_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblVelocidad_1.setBounds(264, 284, 92, 14);
		vehiculoModif.add(lblVelocidad_1);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		btnModificar.setBounds(208, 404, 120, 30);
		vehiculoModif.add(btnModificar);
		
		JPanel vehiculoBaja = new JPanel();
		ImageIcon iconBajaVehic = new ImageIcon (UIPrincipal.class.getResource("/ico/bajaIco.png"));
		adminVehic.addTab("Baja", iconBajaVehic, vehiculoBaja, null);
		vehiculoBaja.setLayout(null);
		
		JList<String> list_2 = new JList<String>();
		list_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list_2.setBounds(46, 85, 150, 200);
		vehiculoBaja.add(list_2);
		
		JLabel label = new JLabel("Veh\u00EDculos disponibles");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 13));
		label.setBounds(46, 58, 150, 14);
		vehiculoBaja.add(label);
		
		JLabel lblEnEstaSeccin_2 = new JLabel("En esta secci\u00F3n se podr\u00E1 eliminar alguno de los veh\u00EDculos existentes.");
		lblEnEstaSeccin_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblEnEstaSeccin_2.setBounds(10, 11, 329, 14);
		vehiculoBaja.add(lblEnEstaSeccin_2);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/Cancela.png")));
		btnEliminar.setBounds(210, 386, 120, 30);
		vehiculoBaja.add(btnEliminar);
		
		JPanel vehiculoConsulta = new JPanel();
		ImageIcon iconConsultaVehic = new ImageIcon (UIPrincipal.class.getResource("/ico/consultaIco.png"));
		adminVehic.addTab("Consulta", iconConsultaVehic, vehiculoConsulta, null);
		vehiculoConsulta.setLayout(null);
		
		JLabel lblEnEstaSeccin_3 = new JLabel("En esta secci\u00F3n se podr\u00E1 consultar los datos de los veh\u00EDculos registrados");
		lblEnEstaSeccin_3.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblEnEstaSeccin_3.setBounds(10, 11, 444, 14);
		vehiculoConsulta.add(lblEnEstaSeccin_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(208, 51, 127, 20);
		vehiculoConsulta.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPatente_2 = new JLabel("Patente");
		lblPatente_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPatente_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblPatente_2.setBounds(112, 54, 86, 14);
		vehiculoConsulta.add(lblPatente_2);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(208, 97, 127, 23);
		btnConsultar.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/consultaIco.png")));
		vehiculoConsulta.add(btnConsultar);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPane_1.setBounds(130, 162, 313, 218);
		vehiculoConsulta.add(textPane_1);
		
		JTabbedPane adminResponsable = new JTabbedPane(JTabbedPane.TOP);
		ImageIcon iconResponsable = new ImageIcon (UIPrincipal.class.getResource("/ico/responsableIco.png"));
		adminVehiculo.addTab("Responsable", iconResponsable, adminResponsable, null);
		
		JPanel responsableAlta = new JPanel();
		ImageIcon iconAltaResp = new ImageIcon (UIPrincipal.class.getResource("/ico/altaIco.png"));
		adminResponsable.addTab("Alta", iconAltaResp, responsableAlta, null);
		responsableAlta.setLayout(null);
		
		JLabel lblEnEstaSeccin_4 = new JLabel("En esta secci\u00F3n se podr\u00E1 dar de alta un nuevo responsable.");
		lblEnEstaSeccin_4.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblEnEstaSeccin_4.setBounds(10, 11, 393, 14);
		responsableAlta.add(lblEnEstaSeccin_4);
		
		JLabel lblNewLabel = new JLabel("Nombre completo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNewLabel.setBounds(112, 70, 122, 14);
		responsableAlta.add(lblNewLabel);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDni.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblDni.setBounds(112, 140, 122, 14);
		responsableAlta.add(lblDni);
		
		JLabel lblSueldoFijo = new JLabel("Sueldo Fijo");
		lblSueldoFijo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSueldoFijo.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblSueldoFijo.setBounds(112, 210, 122, 14);
		responsableAlta.add(lblSueldoFijo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(new Rectangle(0, 0, 165, 20));
		textField_4.setBounds(260, 70, 165, 20);
		responsableAlta.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(new Rectangle(0, 0, 165, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(260, 140, 165, 20);
		responsableAlta.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(new Rectangle(0, 0, 165, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(260, 210, 165, 20);
		responsableAlta.add(textField_6);
		
		JButton button = new JButton("Agregar");
		button.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		button.setBounds(220, 420, 120, 30);
		responsableAlta.add(button);
		
		JPanel responsableModif = new JPanel();
		ImageIcon iconModifResp = new ImageIcon (UIPrincipal.class.getResource("/ico/modificarIco.png"));
		adminResponsable.addTab("Modificación", iconModifResp, responsableModif, null);
		responsableModif.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 579, 479);
		responsableModif.add(panel);
		
		JLabel label_1 = new JLabel("En esta secci\u00F3n podr\u00E1 modificar los responsables existentes.");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_1.setBounds(10, 11, 346, 14);
		panel.add(label_1);
		
		JList<String> modifResponsable = new JList<String>();
		modifResponsable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		modifResponsable.setBounds(46, 101, 150, 200);
		panel.add(modifResponsable);
		
		JLabel lblResponsablesDisponibles = new JLabel("Responsables disponibles");
		lblResponsablesDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsablesDisponibles.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblResponsablesDisponibles.setBounds(46, 74, 150, 14);
		panel.add(lblResponsablesDisponibles);
		
		JLabel lblNombreCompleto = new JLabel("Nombre completo");
		lblNombreCompleto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreCompleto.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNombreCompleto.setBounds(231, 104, 125, 14);
		panel.add(lblNombreCompleto);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(374, 101, 125, 20);
		panel.add(textField_7);
		
		JLabel lblDni_1 = new JLabel("DNI");
		lblDni_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDni_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblDni_1.setBounds(264, 191, 92, 14);
		panel.add(lblDni_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(374, 281, 123, 20);
		panel.add(textField_8);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSueldo.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblSueldo.setBounds(264, 281, 92, 14);
		panel.add(lblSueldo);
		
		JButton button_1 = new JButton("Modificar");
		button_1.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		button_1.setBounds(208, 404, 120, 30);
		panel.add(button_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(374, 191, 125, 20);
		panel.add(textField_9);
		
		JPanel responsableBaja = new JPanel();
		ImageIcon iconBajaResp = new ImageIcon (UIPrincipal.class.getResource("/ico/bajaIco.png"));
		adminResponsable.addTab("Baja", iconBajaResp, responsableBaja, null);
		responsableBaja.setLayout(null);
		
		JLabel lblEnEstaSeccin_5 = new JLabel("En esta secci\u00F3n se podr\u00E1 eliminar alguno de los responsables existentes.");
		lblEnEstaSeccin_5.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblEnEstaSeccin_5.setBounds(10, 11, 329, 14);
		responsableBaja.add(lblEnEstaSeccin_5);
		
		JLabel lblResponsablesDisponibles_1 = new JLabel("Responsables disponibles");
		lblResponsablesDisponibles_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsablesDisponibles_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblResponsablesDisponibles_1.setBounds(46, 58, 150, 14);
		responsableBaja.add(lblResponsablesDisponibles_1);
		
		JList list_4 = new JList();
		list_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list_4.setBounds(46, 85, 150, 200);
		responsableBaja.add(list_4);
		
		JButton button_2 = new JButton("Eliminar");
		button_2.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/Cancela.png")));
		button_2.setBounds(210, 386, 120, 30);
		responsableBaja.add(button_2);
		
		JPanel responsableConsulta = new JPanel();
		ImageIcon iconConsultaResp = new ImageIcon (UIPrincipal.class.getResource("/ico/consultaIco.png"));
		adminResponsable.addTab("Consulta", iconConsultaResp, responsableConsulta, null);
		responsableConsulta.setLayout(null);
		
		JLabel label_2 = new JLabel("En esta secci\u00F3n se podr\u00E1 consultar los datos de los responsables registrados");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_2.setBounds(10, 11, 444, 14);
		responsableConsulta.add(label_2);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(208, 51, 127, 20);
		responsableConsulta.add(textField_10);
		
		JLabel lblDni_2 = new JLabel("DNI");
		lblDni_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDni_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblDni_2.setBounds(112, 54, 86, 14);
		responsableConsulta.add(lblDni_2);
		
		JButton button_3 = new JButton("Consultar");
		button_3.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/consultaIco.png")));
		button_3.setBounds(208, 97, 127, 23);
		responsableConsulta.add(button_3);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPane_2.setBounds(130, 162, 313, 218);
		responsableConsulta.add(textPane_2);
		
		JTabbedPane adminCrearViaje = new JTabbedPane(JTabbedPane.TOP);
		ImageIcon iconCrearViaje = new ImageIcon (UIPrincipal.class.getResource("/ico/crearViajeIco.png"));
		adminVehiculo.addTab("Crear Viaje", iconCrearViaje, adminCrearViaje, null);
		
		JPanel cortaDistancia = new JPanel();
		ImageIcon iconCortaDistancia = new ImageIcon (UIPrincipal.class.getResource("/ico/cortaDistanciaIcon.png"));
		adminCrearViaje.addTab("Corta Distancia", iconCortaDistancia, cortaDistancia, null);
		cortaDistancia.setLayout(null);
		
		JLabel lblEnEstaSeccin_6 = new JLabel("En esta secci\u00F3n se podr\u00E1n crear viajes de corta distancia (menos de 100 kil\u00F3metros).");
		lblEnEstaSeccin_6.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblEnEstaSeccin_6.setBounds(10, 11, 559, 14);
		cortaDistancia.add(lblEnEstaSeccin_6);
		
		JLabel lblSeleccioneUnDestino = new JLabel("Seleccione un destino");
		lblSeleccioneUnDestino.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSeleccioneUnDestino.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblSeleccioneUnDestino.setBounds(112, 78, 146, 14);
		cortaDistancia.add(lblSeleccioneUnDestino);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(280, 208, 134, 20);
		cortaDistancia.add(spinner_2);
		
		JLabel lblCantidadDePasajeros = new JLabel("Cantidad de pasajeros");
		lblCantidadDePasajeros.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCantidadDePasajeros.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblCantidadDePasajeros.setBounds(112, 208, 146, 14);
		cortaDistancia.add(lblCantidadDePasajeros);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(280, 143, 134, 20);
		cortaDistancia.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(280, 78, 134, 20);
		cortaDistancia.add(comboBox_1);
		
		JLabel lblSeleccioneUnVehculo = new JLabel("Seleccione un Veh\u00EDculo");
		lblSeleccioneUnVehculo.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblSeleccioneUnVehculo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSeleccioneUnVehculo.setBounds(112, 143, 146, 14);
		cortaDistancia.add(lblSeleccioneUnVehculo);
		
		JLabel lblValorDelViaje = new JLabel("Valor del Viaje");
		lblValorDelViaje.setHorizontalAlignment(SwingConstants.TRAILING);
		lblValorDelViaje.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblValorDelViaje.setBounds(112, 278, 146, 14);
		cortaDistancia.add(lblValorDelViaje);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(280, 278, 134, 20);
		cortaDistancia.add(textPane_3);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		btnCrear.setBounds(239, 393, 120, 30);
		cortaDistancia.add(btnCrear);
		
		JPanel largaDistancia = new JPanel();
		ImageIcon iconLargaDistancia = new ImageIcon (UIPrincipal.class.getResource("/ico/largaDistanciaIco.png"));
		adminCrearViaje.addTab("Larga Distancia", iconLargaDistancia, largaDistancia, null);
		largaDistancia.setLayout(null);
		
		JLabel lblEnEstaSeccin_7 = new JLabel("En esta secci\u00F3n se podr\u00E1n crear viajes de larga distancia (m\u00E1s de 100 kil\u00F3metros).");
		lblEnEstaSeccin_7.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblEnEstaSeccin_7.setBounds(10, 11, 559, 14);
		largaDistancia.add(lblEnEstaSeccin_7);
		
		JLabel label_4 = new JLabel("Seleccione un destino");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_4.setBounds(112, 52, 146, 14);
		largaDistancia.add(label_4);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(280, 52, 134, 20);
		largaDistancia.add(comboBox_3);
		
		JLabel label_5 = new JLabel("Seleccione un Veh\u00EDculo");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_5.setBounds(112, 106, 146, 14);
		largaDistancia.add(label_5);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(280, 106, 134, 20);
		largaDistancia.add(comboBox_4);
		
		JLabel label_6 = new JLabel("Cantidad de pasajeros");
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_6.setBounds(112, 160, 146, 14);
		largaDistancia.add(label_6);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(280, 160, 134, 20);
		largaDistancia.add(spinner_1);
		
		JLabel label_7 = new JLabel("Valor del Viaje");
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		label_7.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_7.setBounds(112, 322, 146, 14);
		largaDistancia.add(label_7);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(280, 322, 134, 20);
		largaDistancia.add(textPane_4);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(280, 214, 134, 20);
		largaDistancia.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(280, 268, 134, 20);
		largaDistancia.add(spinner_4);
		
		JLabel lblAsientosSemiCama = new JLabel("Asientos Semi Cama");
		lblAsientosSemiCama.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAsientosSemiCama.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblAsientosSemiCama.setBounds(112, 214, 146, 14);
		largaDistancia.add(lblAsientosSemiCama);
		
		JLabel lblAsientosCama = new JLabel("Asientos Cama");
		lblAsientosCama.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAsientosCama.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblAsientosCama.setBounds(112, 268, 146, 14);
		largaDistancia.add(lblAsientosCama);
		
		JButton button_4 = new JButton("Crear");
		button_4.setBounds(239, 393, 120, 30);
		largaDistancia.add(button_4);
		
	}
}
