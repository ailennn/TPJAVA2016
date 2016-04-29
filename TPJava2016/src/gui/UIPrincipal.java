package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
import misc.Destino;
import misc.Responsable;
import misc.Simulacion;
import misc.test;
import transporte.Auto;
import transporte.Transporte;
import viaje.Viaje;

import javax.swing.DefaultComboBoxModel;

public class UIPrincipal extends javax.swing.JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmAgenciaDeViajes;
	private JTextField tfAltaVelocidad;
	private JTextField tfModifPatente;
	private JTextField tfModifVelocidad;
	private JTextField tfConsultaTransporte;
	private JTextField tfAltaNombre;
	private JTextField tfAltaDNI;
	private JTextField tfAltaSueldo;
	private JTextField tfModifSueldo;
	private JTextField tfModifDNI;
	private JTextField tfConsultaResponsable;
	
	private Agencia A;
	private JTextField tfCantPasajCortaDistancia;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agencia Agen= new Agencia();
					UIPrincipal frame = new UIPrincipal(Agen);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public UIPrincipal(Agencia Agen){
		A=Agen;
		
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
		
		/**
		 * CODIGO TAB INICIO 
		 */
		
		JPanel inicio = new JPanel();
		inicio.setPreferredSize(new Dimension(598, 598));
		inicio.setMinimumSize(new Dimension(598, 598));
		inicio.setMaximumSize(new Dimension(598, 598));
		ImageIcon iconInicio = new ImageIcon (UIPrincipal.class.getResource("/ico/inicioIco.png"));
		panelGeneral.addTab("Inicio", iconInicio, inicio, null);
		inicio.setLayout(null);
		
		JList<String> jlistPendientes = new JList<String>();
		jlistPendientes.setBorder(new MatteBorder(1, 1, 1, 1, (Color) UIManager.getColor("ToolBar.shadow")));
		jlistPendientes.setBounds(10, 67, 140, 358);
		inicio.add(jlistPendientes);
		
		JList<String> jlistFinalizados = new JList<String>();
		jlistFinalizados.setBorder(new MatteBorder(1, 1, 1, 1, (Color) UIManager.getColor("ToolBar.shadow")));
		jlistFinalizados.setBounds(439, 67, 140, 358);
		inicio.add(jlistFinalizados);
		
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
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viaje v=null;
				long initialTime=System.currentTimeMillis();
				Simulacion.inicio(v, Agen, initialTime);
			}
		});
		btnIniciar.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		btnIniciar.setBounds(182, 479, 120, 30);
		inicio.add(btnIniciar);
		
		JButton btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viaje v=null;
				long finalTime=System.currentTimeMillis();
				Simulacion.detener(v, Agen, finalTime);
			}
		});
		btnDetener.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/Cancela.png")));
		btnDetener.setBounds(338, 479, 120, 30);
		inicio.add(btnDetener);
		
		/**
		 * CODIGO TAB REPORTES
		 */
		
			
		JTabbedPane Reportes = new JTabbedPane(JTabbedPane.TOP);
		ImageIcon iconReporte = new ImageIcon (UIPrincipal.class.getResource("/ico/reporteIco.png"));
		panelGeneral.addTab("Reportes", iconReporte, Reportes, null);
		
		JPanel reporteRecaudacion = new JPanel();
		ImageIcon iconRecaudacion = new ImageIcon (UIPrincipal.class.getResource("/ico/recaudacionIco.png"));
		Reportes.addTab("Recaudación", iconRecaudacion, reporteRecaudacion, null);
		reporteRecaudacion.setLayout(null);
		
		JPanel reporteRanking = new JPanel();
		ImageIcon iconRanking = new ImageIcon(UIPrincipal.class.getResource("/ico/rankingIco.png"));
		Reportes.addTab("Ranking", iconRanking, reporteRanking, null);
		
		/**
		 * CODIGO TAB ADMINISTRAR
		 */
		
		JTabbedPane adminVehiculo = new JTabbedPane(JTabbedPane.TOP);
		ImageIcon iconAdmin = new ImageIcon (UIPrincipal.class.getResource("/ico/administrarIco.png"));
		panelGeneral.addTab("Administrar", iconAdmin, adminVehiculo, null);
		
		/**
		 * CODIGO TAB ADMINISTRAR TRANSPORTE
		 */
		
		JTabbedPane adminVehic = new JTabbedPane(JTabbedPane.TOP);
		ImageIcon iconVehiculo = new ImageIcon (UIPrincipal.class.getResource("/ico/transporteIco.png"));
		adminVehiculo.addTab("Transporte", iconVehiculo, adminVehic, null);
		
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
		
		JTextField tfAltaPatente = new JTextField();
		tfAltaPatente.setBounds(new Rectangle(0, 0, 165, 20));
		tfAltaPatente.setBounds(260, 70, 165, 20);
		vehiculoAlta.add(tfAltaPatente);
		tfAltaPatente.setColumns(10);
		
		tfAltaVelocidad = new JTextField();
		tfAltaVelocidad.setBounds(new Rectangle(0, 0, 165, 20));
		tfAltaVelocidad.setBounds(260, 210, 165, 20);
		vehiculoAlta.add(tfAltaVelocidad);
		tfAltaVelocidad.setColumns(10);
				
		JComboBox<String> cbAltaTipoTransporte = new JComboBox<String>();
		cbAltaTipoTransporte.setBounds(260, 137, 165, 20);
		cbAltaTipoTransporte.setModel(new DefaultComboBoxModel<String>(new String[] {"Auto", "Combi", "Semi Cama", "Cama"}));
		vehiculoAlta.add(cbAltaTipoTransporte);
		
		/**
		 * CODIGO TAB ALTA TRANSPORTE 
		 */
		
		JButton btnAgregarTransporte = new JButton("Agregar");
		btnAgregarTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int btnPregunta = JOptionPane.YES_NO_CANCEL_OPTION;
				if (btnPregunta == JOptionPane.YES_OPTION){
					if(!tfAltaPatente.getText().isEmpty() && !tfAltaVelocidad.getText().isEmpty()){
						String pat = tfAltaPatente.getText();
						int vel = Integer.parseInt(tfAltaVelocidad.getText());
						String tipo = cbAltaTipoTransporte.getSelectedItem().toString();
						if (tipo=="Auto"){
							try {
								A.altaAuto(pat, vel);
							} catch (Exception e1) {
								e1.printStackTrace();
							}	
						}
						else
							if (tipo=="Combi"){
								try {
									A.altaCombi(pat, vel);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
							else
								if (tipo=="Semi Cama"){
									try {
										A.altaSemiCama(pat, vel);
									} catch (Exception e1) {
										e1.printStackTrace();
									}
								} else
									try {
										A.altaCama(pat, vel);
									} catch (Exception e1) {
										e1.printStackTrace();
									}
					}
					else
						JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios");
				}
			}
		});
		
		
		btnAgregarTransporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarTransporte.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		btnAgregarTransporte.setBounds(220, 420, 120, 30);
		vehiculoAlta.add(btnAgregarTransporte);
		
		/**
		 * CODIGO TAB MODIFICAR TRANSPORTE
		 */
		
		JPanel vehiculoModif = new JPanel();
		ImageIcon iconModifVehic = new ImageIcon (UIPrincipal.class.getResource("/ico/modificarIco.png"));
		adminVehic.addTab("Modificación", iconModifVehic, vehiculoModif, null);
		vehiculoModif.setLayout(null);
		
		JLabel lblEnEstaSeccin_1 = new JLabel("En esta secci\u00F3n podr\u00E1 modificar los veh\u00EDculos existentes.");
		lblEnEstaSeccin_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblEnEstaSeccin_1.setBounds(10, 11, 329, 14);
		vehiculoModif.add(lblEnEstaSeccin_1);
		
		/**	
		 * Se contruye un JList a partir de la Default List Model obtenida del metodo getListaTransporte de Agencia
		 */
		
		DefaultListModel<Transporte> model = new DefaultListModel<Transporte>();
		model=A.getListaTransporte();
		JList<Transporte> jlistModifTransporte = new JList<Transporte>(model);
		jlistModifTransporte.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jlistModifTransporte.setBounds(46, 101, 150, 200);
		vehiculoModif.add(jlistModifTransporte);
		
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
		
		tfModifVelocidad = new JTextField();
		tfModifVelocidad.setBounds(374, 191, 123, 20);
		vehiculoModif.add(tfModifVelocidad);
		tfModifVelocidad.setColumns(10);
		
		JLabel lblVelocidad_1 = new JLabel("Velocidad");
		lblVelocidad_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVelocidad_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblVelocidad_1.setBounds(264, 194, 92, 14);
		vehiculoModif.add(lblVelocidad_1);
		
		JButton btnModificarTransporte = new JButton("Modificar");
		btnModificarTransporte.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		btnModificarTransporte.setBounds(208, 404, 120, 30);
		vehiculoModif.add(btnModificarTransporte);
		btnModificarTransporte.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				int btnPregunta = JOptionPane.YES_NO_CANCEL_OPTION;
				if (btnPregunta == JOptionPane.YES_OPTION){
					if(!tfModifPatente.getText().isEmpty() && !tfModifVelocidad.getText().isEmpty()){
						String pat = tfModifPatente.getText();
						int vel = Integer.parseInt(tfModifVelocidad.getText());
						Transporte aux = null;
						aux=jlistModifTransporte.getSelectedValue();
						String buscaPat = aux.getPatente();
						A.modificaTransporte(buscaPat, pat, vel);
					}
					else
						JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios");
				}
			}
		});
		
		/**
		 * CODIGO TAB BAJA TRANSPORTE
		 */
		
		JPanel vehiculoBaja = new JPanel();
		ImageIcon iconBajaVehic = new ImageIcon (UIPrincipal.class.getResource("/ico/bajaIco.png"));
		adminVehic.addTab("Baja", iconBajaVehic, vehiculoBaja, null);
		vehiculoBaja.setLayout(null);
		
		JList<String> jlistBajaTransporte = new JList<String>();
		jlistBajaTransporte.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jlistBajaTransporte.setBounds(46, 85, 150, 200);
		vehiculoBaja.add(jlistBajaTransporte);
		
		JLabel label = new JLabel("Veh\u00EDculos disponibles");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 13));
		label.setBounds(46, 58, 150, 14);
		vehiculoBaja.add(label);
		
		JLabel lblEnEstaSeccin_2 = new JLabel("En esta secci\u00F3n se podr\u00E1 eliminar alguno de los veh\u00EDculos existentes.");
		lblEnEstaSeccin_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblEnEstaSeccin_2.setBounds(10, 11, 329, 14);
		vehiculoBaja.add(lblEnEstaSeccin_2);
		
		JButton btnEliminarTransporte = new JButton("Eliminar");
		btnEliminarTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int btnPregunta = JOptionPane.YES_NO_CANCEL_OPTION;
				if (btnPregunta == JOptionPane.YES_OPTION){
					String patente=jlistBajaTransporte.getSelectedValue().toString();
					try {
						A.bajaTransporte(patente);
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				}
			}
		});
		btnEliminarTransporte.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/Cancela.png")));
		btnEliminarTransporte.setBounds(210, 386, 120, 30);
		vehiculoBaja.add(btnEliminarTransporte);
		
		/**
		 * CODIGO TAB CONSULTA TRANSPORTE
		 */
		
		JPanel vehiculoConsulta = new JPanel();
		ImageIcon iconConsultaVehic = new ImageIcon (UIPrincipal.class.getResource("/ico/consultaIco.png"));
		adminVehic.addTab("Consulta", iconConsultaVehic, vehiculoConsulta, null);
		vehiculoConsulta.setLayout(null);
		
		JLabel lblEnEstaSeccin_3 = new JLabel("En esta secci\u00F3n se podr\u00E1 consultar los datos de los veh\u00EDculos registrados");
		lblEnEstaSeccin_3.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblEnEstaSeccin_3.setBounds(10, 11, 444, 14);
		vehiculoConsulta.add(lblEnEstaSeccin_3);
		
		tfConsultaTransporte = new JTextField();
		tfConsultaTransporte.setBounds(238, 52, 127, 20);
		vehiculoConsulta.add(tfConsultaTransporte);
		tfConsultaTransporte.setColumns(10);
		
		JLabel lblPatente_2 = new JLabel("Patente");
		lblPatente_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPatente_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblPatente_2.setBounds(142, 55, 86, 14);
		vehiculoConsulta.add(lblPatente_2);
		
		JButton btnConsultaTransporte = new JButton("Consultar");
		btnConsultaTransporte.setBounds(238, 98, 127, 23);
		btnConsultaTransporte.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/consultaIco.png")));
		vehiculoConsulta.add(btnConsultaTransporte);
		
		JTextPane tpConsultaTransporte = new JTextPane();
		tpConsultaTransporte.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpConsultaTransporte.setBounds(130, 162, 313, 218);
		vehiculoConsulta.add(tpConsultaTransporte);
		
		/**
		 * CODIGO TAB ADMINISTRAR RESPONSABLE
		 */
		
		JTabbedPane adminResponsable = new JTabbedPane(JTabbedPane.TOP);
		ImageIcon iconResponsable = new ImageIcon (UIPrincipal.class.getResource("/ico/responsableIco.png"));
		adminVehiculo.addTab("Responsable", iconResponsable, adminResponsable, null);
		
		/**
		 * CODIGO TAB ALTA RESPONSABLE
		 */
		
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
		
		tfAltaNombre = new JTextField();
		tfAltaNombre.setBounds(new Rectangle(0, 0, 165, 20));
		tfAltaNombre.setBounds(260, 70, 165, 20);
		responsableAlta.add(tfAltaNombre);
		tfAltaNombre.setColumns(10);
		
		tfAltaDNI = new JTextField();
		tfAltaDNI.setBounds(new Rectangle(0, 0, 165, 20));
		tfAltaDNI.setColumns(10);
		tfAltaDNI.setBounds(260, 140, 165, 20);
		responsableAlta.add(tfAltaDNI);
		
		tfAltaSueldo = new JTextField();
		tfAltaSueldo.setBounds(new Rectangle(0, 0, 165, 20));
		tfAltaSueldo.setColumns(10);
		tfAltaSueldo.setBounds(260, 210, 165, 20);
		responsableAlta.add(tfAltaSueldo);
		
		JButton btnAgregarResponsable = new JButton("Agregar");
		btnAgregarResponsable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int btnPregunta = JOptionPane.YES_NO_CANCEL_OPTION;
				if (btnPregunta == JOptionPane.YES_OPTION){
					if(!tfAltaNombre.getText().isEmpty() && !tfAltaDNI.getText().isEmpty() && !tfAltaSueldo.getText().isEmpty()){
						String nom = tfAltaNombre.getText();
						long dni = Long.parseLong(tfAltaDNI.getText());
						Double sueldo= Double.parseDouble(tfAltaSueldo.getText());
						try{
							A.altaResponsable(nom, dni, sueldo);
						} catch (Exception e1) {
							e1.printStackTrace();
						}	
					}
					else
						JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios");
				}
			}
		});
		btnAgregarResponsable.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		btnAgregarResponsable.setBounds(220, 420, 120, 30);
		responsableAlta.add(btnAgregarResponsable);
		
		/**
		 * CODIGO TAB MODIFICAR RESPONSABLE
		 */
		
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
		
		
		/**	
		 * Se contruye un JList a partir de la Default List Model obtenida del metodo getListaResponsable de Agencia
		 */
		
		DefaultListModel<Responsable> modelResp = new DefaultListModel<Responsable>();
		modelResp=A.getListaResponsable();
		JList<Responsable> jlistModifResponsable = new JList<Responsable>(modelResp);
		
		jlistModifResponsable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jlistModifResponsable.setBounds(10, 101, 244, 200);
		panel.add(jlistModifResponsable);
		
		JLabel lblResponsablesDisponibles = new JLabel("Responsables disponibles");
		lblResponsablesDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsablesDisponibles.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblResponsablesDisponibles.setBounds(10, 76, 150, 14);
		panel.add(lblResponsablesDisponibles);
		
		JLabel lblNombreCompleto = new JLabel("Nombre completo");
		lblNombreCompleto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreCompleto.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNombreCompleto.setBounds(264, 104, 125, 14);
		panel.add(lblNombreCompleto);
		
		JTextField tfModifNombre = new JTextField();
		tfModifNombre.setColumns(10);
		tfModifNombre.setBounds(407, 101, 125, 20);
		panel.add(tfModifNombre);
		
		JLabel lblDni_1 = new JLabel("DNI");
		lblDni_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDni_1.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblDni_1.setBounds(297, 191, 92, 14);
		panel.add(lblDni_1);
		
		tfModifSueldo = new JTextField();
		tfModifSueldo.setColumns(10);
		tfModifSueldo.setBounds(407, 281, 123, 20);
		panel.add(tfModifSueldo);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSueldo.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblSueldo.setBounds(297, 281, 92, 14);
		panel.add(lblSueldo);
		
		tfModifDNI = new JTextField();
		tfModifDNI.setColumns(10);
		tfModifDNI.setBounds(407, 191, 125, 20);
		panel.add(tfModifDNI);
		
		/**
		 * Al clickear el boton Modificar, se toman los valores ingresados y modifica al Responsable
		 */
		
		JButton btnModificarResponsable = new JButton("Modificar");
		btnModificarResponsable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificarResponsable.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		btnModificarResponsable.setBounds(208, 404, 120, 30);
		panel.add(btnModificarResponsable);
		btnModificarTransporte.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int btnPregunta = JOptionPane.YES_NO_OPTION;
				if (btnPregunta == JOptionPane.YES_OPTION){
					if(!tfModifNombre.getText().isEmpty() && !tfModifDNI.getText().isEmpty() && !tfModifSueldo.getText().isEmpty()){
						String nombre = tfModifNombre.getText();
						long DNI=Long.parseLong(tfModifDNI.getText());
						double Sueldo = Double.parseDouble(tfModifSueldo.getText());
						Responsable aux = null;
						aux=jlistModifResponsable.getSelectedValue();
						long dniModif=aux.getDni();
						A.modificaResponsable(dniModif, DNI, Sueldo, nombre);
					}
					else
						JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios");
				}
			}			
		});
		
		/**
		 * CODIGO TAB BAJA RESPONSABLE
		 */
		
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
		
		JList<String> jlistBajaResponsable = new JList<String>();
		jlistBajaResponsable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jlistBajaResponsable.setBounds(46, 85, 150, 200);
		responsableBaja.add(jlistBajaResponsable);
		
		JButton btnEliminarResponsable = new JButton("Eliminar");
		btnEliminarResponsable.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/Cancela.png")));
		btnEliminarResponsable.setBounds(210, 386, 120, 30);
		responsableBaja.add(btnEliminarResponsable);
		btnEliminarResponsable.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//ELIMINAR RESPONSABLE SELECCIONADO EN LISTA
				int btnPregunta = JOptionPane.YES_NO_CANCEL_OPTION;
				if (btnPregunta == JOptionPane.YES_OPTION){
					Long dni=Long.parseLong(jlistBajaResponsable.getSelectedValue().toString());
					try {
						A.bajaResponsable(dni);
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				}
			}
		});
		
		/**
		 * CODIGO TAB CONSULTA RESPONSABLE
		 */
		
		JPanel responsableConsulta = new JPanel();
		ImageIcon iconConsultaResp = new ImageIcon (UIPrincipal.class.getResource("/ico/consultaIco.png"));
		adminResponsable.addTab("Consulta", iconConsultaResp, responsableConsulta, null);
		responsableConsulta.setLayout(null);
		
		JLabel label_2 = new JLabel("En esta secci\u00F3n se podr\u00E1 consultar los datos de los responsables registrados");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_2.setBounds(10, 11, 444, 14);
		responsableConsulta.add(label_2);
		
		tfConsultaResponsable = new JTextField();
		tfConsultaResponsable.setColumns(10);
		tfConsultaResponsable.setBounds(208, 51, 127, 20);
		responsableConsulta.add(tfConsultaResponsable);
		
		JLabel lblDni_2 = new JLabel("DNI");
		lblDni_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDni_2.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblDni_2.setBounds(112, 54, 86, 14);
		responsableConsulta.add(lblDni_2);
		
		JButton btnConsultaResponsable = new JButton("Consultar");
		btnConsultaResponsable.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/consultaIco.png")));
		btnConsultaResponsable.setBounds(208, 97, 127, 23);
		responsableConsulta.add(btnConsultaResponsable);
		
		JTextPane tpConsultaResponsable = new JTextPane();
		tpConsultaResponsable.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tpConsultaResponsable.setBounds(130, 162, 313, 218);
		responsableConsulta.add(tpConsultaResponsable);
		
		/**
		 * CODIGO TAB CREAR VIAJE
		 */
		
		JTabbedPane adminCrearViaje = new JTabbedPane(JTabbedPane.TOP);
		ImageIcon iconCrearViaje = new ImageIcon (UIPrincipal.class.getResource("/ico/crearViajeIco.png"));
		adminVehiculo.addTab("Crear Viaje", iconCrearViaje, adminCrearViaje, null);
		
		/**
		 * CODIGO TAB CORTA DISTANCIA
		 */
		
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
		
		JLabel lblCantidadDePasajeros = new JLabel("Cantidad de pasajeros");
		lblCantidadDePasajeros.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCantidadDePasajeros.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblCantidadDePasajeros.setBounds(112, 208, 146, 14);
		cortaDistancia.add(lblCantidadDePasajeros);
		
		JComboBox<String> cbVehiculoCortaDistancia = new JComboBox<String>();
		cbVehiculoCortaDistancia.setModel(new DefaultComboBoxModel(new String[] {"Auto", "Combi", "Semi Cama"}));
		cbVehiculoCortaDistancia.setBounds(280, 143, 134, 20);
		//cbVehiculoCortaDistancia.setModel(modelLargaDistancia);
		cortaDistancia.add(cbVehiculoCortaDistancia);
		
		//ARMAR DEFAULT LIST MODEL PARA DESTINOS DE CORTA modelCortaDistancia
		JComboBox<String> cbDestinoCortaDistancia = new JComboBox<String>(/*modelCortaDistancia*/);
		cbDestinoCortaDistancia.setBounds(280, 78, 134, 20);
		//cbDestinoCortaDistancia.setModel(modelCortaDistancia);
		cortaDistancia.add(cbDestinoCortaDistancia);
		
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
		
		JButton btnCrearViaje = new JButton("Crear");
		btnCrearViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int btnPregunta = JOptionPane.YES_NO_CANCEL_OPTION;
				if (btnPregunta==JOptionPane.YES_OPTION){
					if (cbDestinoCortaDistancia.getSelectedIndex()!= -1 
						&& Integer.parseInt(tfCantPasajCortaDistancia.getText())>0
						&& cbVehiculoCortaDistancia.getSelectedIndex()!=-1){
						
						String destino = (String) cbDestinoCortaDistancia.getSelectedItem();
						Destino d = A.devuelveDestino(destino);
						int cantPasaj = Integer.parseInt(tfCantPasajCortaDistancia.getText());
						String transporte = (String) cbVehiculoCortaDistancia.getSelectedItem();
						Transporte t = A.devuelveTransporte(transporte);
						A.crearViaje(d, cantPasaj, t);
						}
					else
						{
						JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios");
						}
					}
				}
		});
		
		
		btnCrearViaje.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		btnCrearViaje.setBounds(239, 393, 120, 30);
		cortaDistancia.add(btnCrearViaje);
		
		JLabel precioCortaDistancia = new JLabel("$$$$");
		precioCortaDistancia.setBounds(280, 278, 46, 14);
		//precioCortaDistancia.setText(text);
		cortaDistancia.add(precioCortaDistancia);
		
		tfCantPasajCortaDistancia = new JTextField();
		tfCantPasajCortaDistancia.setBounds(280, 205, 134, 20);
		cortaDistancia.add(tfCantPasajCortaDistancia);
		tfCantPasajCortaDistancia.setColumns(10);
		
		/**
		 * CODIGO TAB LARGA DISTANCIA
		 */
		
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
		
		JComboBox<String> cbDestinoLargaDistancia = new JComboBox<String>();
		cbDestinoLargaDistancia.setBounds(280, 52, 134, 20);
		largaDistancia.add(cbDestinoLargaDistancia);
		
		JLabel label_5 = new JLabel("Seleccione un Veh\u00EDculo");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_5.setBounds(112, 106, 146, 14);
		largaDistancia.add(label_5);
		
		JComboBox<String> cbVehiculoLargaDistancia = new JComboBox<String>();
		cbVehiculoLargaDistancia.setBounds(280, 106, 134, 20);
		largaDistancia.add(cbVehiculoLargaDistancia);
		
		JLabel label_6 = new JLabel("Cantidad de pasajeros");
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_6.setBounds(112, 160, 146, 14);
		largaDistancia.add(label_6);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(280, 160, 134, 20);
		largaDistancia.add(spinner_1);
		
		JLabel label_7 = new JLabel("Valor del Viaje");
		label_7.setBounds(new Rectangle(0, 268, 0, 0));
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		label_7.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_7.setBounds(112, 322, 146, 14);
		largaDistancia.add(label_7);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(new Rectangle(0, 268, 0, 0));
		textPane_4.setBounds(280, 322, 134, 20);
		largaDistancia.add(textPane_4);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(280, 214, 134, 20);
		largaDistancia.add(spinner_4);
		
		JLabel lblAsientosCama = new JLabel("Asientos Cama");
		lblAsientosCama.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAsientosCama.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblAsientosCama.setBounds(112, 214, 146, 14);
		largaDistancia.add(lblAsientosCama);
		
		JButton button_4 = new JButton("Crear");
		button_4.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/ok.png")));
		button_4.setBounds(239, 393, 120, 30);
		largaDistancia.add(button_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(280, 268, 134, 20);
		largaDistancia.add(comboBox);
		
		JLabel lblResponsable = new JLabel("Responsable");
		lblResponsable.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblResponsable.setHorizontalAlignment(SwingConstants.TRAILING);
		lblResponsable.setBounds(112, 271, 146, 14);
		largaDistancia.add(lblResponsable);
		
		JButton btnAgregar_1 = new JButton("Agregar");
		btnAgregar_1.setIcon(new ImageIcon(UIPrincipal.class.getResource("/ico/altaIco.png")));
		btnAgregar_1.setBounds(434, 267, 108, 23);
		largaDistancia.add(btnAgregar_1);
		
		/**
		 * PREGUNTA ANTES DE SALIR DEL SISTEMA
		 */
		
        addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				if(JOptionPane.showConfirmDialog(getContentPane(), "¿Desea salir del Sistema?", "Salir", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
					dispose();
				}
			}
		});		
	}//LLAVE CIERRA CONSTRUCTOR
}//LLAVE CIERRA CLASE
