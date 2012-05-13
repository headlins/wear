package educar.gui.DocenteView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DocenteView extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenuDocente;
	private JButton btnActividadMenuDocente;
	private JButton btnCorregirActividad;
	private JPanel panelBienvenido;
	private JPanel panelActividadDocente;
	private JPanel panelAddActividadDocente;
	private JPanel panelDeleteActividadDocente;
	private List listaMateriaActividadDocente;
	private JTextField txtDescripcionAddActividad;
	private JTextField txtCodigoMAteriaAddActividad;
	private JButton btnGuardarAddActividad;
	private JTextField txtDescripcionDeleteActividad;
	private JTextField txtCodigoMAteriaDeleteActividad;
	private List listaActividadDocente;
	private JButton btnBorrarDeleteActividad;
	private JPanel panelCorregirDocente;
	private List listaResolucionCorregir;
	private JTextField txtDniCorregir;
	private JTextField txtCodigoActividadCorregir;
	private JTextField txtResolucionCorregir;
	private JTextField txtNotaCorregir;
	private JButton btnSubirCorregir;

	/**
	 * Create the frame.
	 */
	public DocenteView() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, d.width, d.height - 50);// Tama�o de mi ventana

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ////////////// MENU DOCENTE // ////////////////////////////

		panelMenuDocente = new JPanel();
		panelMenuDocente.setLayout(null);
		panelMenuDocente.setAutoscrolls(true);
		panelMenuDocente.setBounds(0, 0, 148, 680);
		contentPane.add(panelMenuDocente);

		btnActividadMenuDocente = new JButton("ACTIVIDAD");
		btnActividadMenuDocente.setFont(new Font("Arial", Font.BOLD, 12));
		btnActividadMenuDocente.setBounds(0, 0, 148, 340);
		panelMenuDocente.add(btnActividadMenuDocente);
		btnActividadMenuDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCorregirDocente.setVisible(false);
				panelActividadDocente.setVisible(true);
				panelBienvenido.setVisible(false);
			}
		});

		btnCorregirActividad = new JButton("CORREGIR");
		btnCorregirActividad.setFont(new Font("Arial", Font.BOLD, 11));
		btnCorregirActividad.setBounds(0, 343, 148, 340);
		panelMenuDocente.add(btnCorregirActividad);
		btnCorregirActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCorregirDocente.setVisible(true);
				panelActividadDocente.setVisible(false);
				panelBienvenido.setVisible(false);
			}
		});

		// ////// PANEL BIENVENIDO ////////////////////////////////////////

		panelBienvenido = new JPanel();
		panelBienvenido.setBackground(Color.WHITE);
		panelBienvenido.setForeground(SystemColor.desktop);
		panelBienvenido.setBounds(148, 0, 1202, 680);
		contentPane.add(panelBienvenido);
		panelBienvenido.setLayout(null);
		panelBienvenido.setVisible(true);
		
		JLabel lblFotoBiendenido = new JLabel("");
		lblFotoBiendenido.setBackground(Color.WHITE);
		lblFotoBiendenido.setIcon(new ImageIcon(DocenteView.class.getResource("/educar/gui/DocenteView/imagenIconDocente/educar2012.jpg")));
		lblFotoBiendenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoBiendenido.setFont(new Font("Arial", Font.BOLD, 23));
		lblFotoBiendenido.setBounds(0, 0, 1202, 680);
		panelBienvenido.add(lblFotoBiendenido);

		// ////////////PANEL ACTIVIDAD /////////////////////////
		panelActividadDocente = new JPanel();
		panelActividadDocente.setBackground(SystemColor.activeCaption);
		panelActividadDocente.setForeground(SystemColor.desktop);
		panelActividadDocente.setBounds(148, 0, 1202, 680);
		contentPane.add(panelActividadDocente);
		panelActividadDocente.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1202, 680);
		panelActividadDocente.add(tabbedPane);
		panelActividadDocente.setVisible(false);
		// ------------------------panel ADD actividdad -------------
		panelAddActividadDocente = new JPanel();
		panelAddActividadDocente.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("SUBIR ACTIVIDAD", new ImageIcon(DocenteView.class.getResource("/educar/gui/DocenteView/imagenIconDocente/1336865392_teacher.png")), panelAddActividadDocente,
				null);
		panelAddActividadDocente.setLayout(null);

		JLabel lblListaMaterias = new JLabel("LISTA DE MATERIA");
		lblListaMaterias.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaMaterias.setFont(new Font("Arial", Font.BOLD, 23));
		lblListaMaterias.setBounds(896, 29, 265, 42);
		panelAddActividadDocente.add(lblListaMaterias);

		JLabel lblDescripcionAddActividad = new JLabel("DESCRIPCION ACTIVIDAD");
		lblDescripcionAddActividad
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcionAddActividad.setFont(new Font("Arial", Font.BOLD, 20));
		lblDescripcionAddActividad.setBounds(61, 192, 276, 49);
		panelAddActividadDocente.add(lblDescripcionAddActividad);

		JLabel lblCodigoMAteriaAddActividad = new JLabel("CODIGO MATERIA");
		lblCodigoMAteriaAddActividad
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoMAteriaAddActividad.setFont(new Font("Arial", Font.BOLD, 20));
		lblCodigoMAteriaAddActividad.setBounds(61, 384, 276, 49);
		panelAddActividadDocente.add(lblCodigoMAteriaAddActividad);

		JLabel lblCartelAddActividad = new JLabel(
				"SELECCI\u00D3NE LA MATERIA Y INGRESE LA ACTIVIDAD A SUBIR ");
		lblCartelAddActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartelAddActividad.setFont(new Font("Arial", Font.BOLD, 26));
		lblCartelAddActividad.setBounds(0, 11, 886, 92);
		panelAddActividadDocente.add(lblCartelAddActividad);

		txtDescripcionAddActividad = new JTextField();
		txtDescripcionAddActividad.setFont(new Font("Arial", Font.BOLD, 20));
		txtDescripcionAddActividad.setBounds(384, 187, 365, 54);
		panelAddActividadDocente.add(txtDescripcionAddActividad);
		txtDescripcionAddActividad.setColumns(10);

		txtCodigoMAteriaAddActividad = new JTextField();
		txtCodigoMAteriaAddActividad.setEditable(false);
		txtCodigoMAteriaAddActividad.setFont(new Font("Arial", Font.BOLD, 20));
		txtCodigoMAteriaAddActividad.setBounds(384, 381, 365, 54);
		panelAddActividadDocente.add(txtCodigoMAteriaAddActividad);
		txtCodigoMAteriaAddActividad.setColumns(10);

		listaMateriaActividadDocente = new List();
		listaMateriaActividadDocente.setBounds(896, 77, 265, 515);
		panelAddActividadDocente.add(listaMateriaActividadDocente);

		btnGuardarAddActividad = new JButton("SUBIR");
		btnGuardarAddActividad.setFont(new Font("Arial", Font.BOLD, 20));
		btnGuardarAddActividad.setBounds(378, 515, 183, 64);
		panelAddActividadDocente.add(btnGuardarAddActividad);

		// --------------------panel DELETE atividad ---------
		panelDeleteActividadDocente = new JPanel();
		panelDeleteActividadDocente.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("BORRAR ACTIVIDAD", new ImageIcon(DocenteView.class.getResource("/educar/gui/DocenteView/imagenIconDocente/1336865392_teacher.png")),
				panelDeleteActividadDocente, null);
		panelDeleteActividadDocente.setLayout(null);

		JLabel lblListaActividades = new JLabel("LISTA DE ACTIVIDADES");
		lblListaActividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaActividades.setFont(new Font("Arial", Font.BOLD, 23));
		lblListaActividades.setBounds(896, 29, 265, 42);
		panelDeleteActividadDocente.add(lblListaActividades);

		JLabel lblDescripcionDeleteActividad = new JLabel(
				"DESCRIPCION ACTIVIDAD");
		lblDescripcionDeleteActividad
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcionDeleteActividad.setFont(new Font("Arial", Font.BOLD, 20));
		lblDescripcionDeleteActividad.setBounds(61, 192, 276, 49);
		panelDeleteActividadDocente.add(lblDescripcionDeleteActividad);

		JLabel lblCodigoMAteriaDeleteActividad = new JLabel("CODIGO MATERIA");
		lblCodigoMAteriaDeleteActividad
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoMAteriaDeleteActividad
				.setFont(new Font("Arial", Font.BOLD, 20));
		lblCodigoMAteriaDeleteActividad.setBounds(61, 384, 276, 49);
		panelDeleteActividadDocente.add(lblCodigoMAteriaDeleteActividad);

		JLabel lblCartelDeleteActividad = new JLabel(
				"SELECCI\u00D3NE LA MATERIA Y  LA ACTIVIDAD A ELIMINAR ");
		lblCartelDeleteActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartelDeleteActividad.setFont(new Font("Arial", Font.BOLD, 26));
		lblCartelDeleteActividad.setBounds(0, 11, 886, 92);
		panelDeleteActividadDocente.add(lblCartelDeleteActividad);

		txtDescripcionDeleteActividad = new JTextField();
		txtDescripcionDeleteActividad.setEditable(false);
		txtDescripcionDeleteActividad.setFont(new Font("Arial", Font.BOLD, 20));
		txtDescripcionDeleteActividad.setBounds(384, 187, 365, 54);
		panelDeleteActividadDocente.add(txtDescripcionDeleteActividad);
		txtDescripcionDeleteActividad.setColumns(10);

		txtCodigoMAteriaDeleteActividad = new JTextField();
		txtCodigoMAteriaDeleteActividad.setEditable(false);
		txtCodigoMAteriaDeleteActividad
				.setFont(new Font("Arial", Font.BOLD, 20));
		txtCodigoMAteriaDeleteActividad.setBounds(384, 381, 365, 54);
		panelDeleteActividadDocente.add(txtCodigoMAteriaDeleteActividad);
		txtCodigoMAteriaDeleteActividad.setColumns(10);

		listaActividadDocente = new List();
		listaActividadDocente.setBounds(896, 77, 265, 515);
		panelDeleteActividadDocente.add(listaActividadDocente);

		btnBorrarDeleteActividad = new JButton("BORRAR");
		btnBorrarDeleteActividad.setFont(new Font("Arial", Font.BOLD, 20));
		btnBorrarDeleteActividad.setBounds(378, 517, 183, 63);
		panelDeleteActividadDocente.add(btnBorrarDeleteActividad);

		// ////////////////// PANEL CORREGIR //////////////////

		panelCorregirDocente = new JPanel();
		panelCorregirDocente.setBackground(SystemColor.activeCaption);
		panelCorregirDocente.setForeground(SystemColor.desktop);
		panelCorregirDocente.setBounds(148, 0, 1202, 680);
		contentPane.add(panelCorregirDocente);
		panelCorregirDocente.setLayout(null);
		panelCorregirDocente.setVisible(false);

		JLabel lblDniCorregir = new JLabel("D.N.I Alumno");
		lblDniCorregir.setHorizontalAlignment(SwingConstants.CENTER);
		lblDniCorregir.setFont(new Font("Arial", Font.BOLD, 23));
		lblDniCorregir.setBounds(58, 158, 265, 54);
		panelCorregirDocente.add(lblDniCorregir);

		JLabel lblCodigoActividadCorregir = new JLabel("CODIGO ACTIVIDAD");
		lblCodigoActividadCorregir
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoActividadCorregir.setFont(new Font("Arial", Font.BOLD, 23));
		lblCodigoActividadCorregir.setBounds(58, 269, 265, 54);
		panelCorregirDocente.add(lblCodigoActividadCorregir);

		JLabel lblResolucionCorregir = new JLabel("RESOLUCION");
		lblResolucionCorregir.setHorizontalAlignment(SwingConstants.CENTER);
		lblResolucionCorregir.setFont(new Font("Arial", Font.BOLD, 23));
		lblResolucionCorregir.setBounds(58, 379, 265, 54);
		panelCorregirDocente.add(lblResolucionCorregir);

		JLabel lblNotaCorregir = new JLabel("NOTA");
		lblNotaCorregir.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotaCorregir.setFont(new Font("Arial", Font.BOLD, 23));
		lblNotaCorregir.setBounds(58, 489, 265, 54);
		panelCorregirDocente.add(lblNotaCorregir);

		JLabel lblCartelCorregir = new JLabel(
				"SELECCI\u00D3NE LA RESOLUCI�N Y INGRESE LA NOTA A SUBIR ");
		lblCartelCorregir.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartelCorregir.setFont(new Font("Arial", Font.BOLD, 24));
		lblCartelCorregir.setBounds(0, 11, 887, 92);
		panelCorregirDocente.add(lblCartelCorregir);

		JLabel lblListaResolucionesCorregir = new JLabel(
				"LISTA DE RESOLUCIONES");
		lblListaResolucionesCorregir
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaResolucionesCorregir.setFont(new Font("Arial", Font.BOLD, 23));
		lblListaResolucionesCorregir.setBounds(897, 17, 295, 54);
		panelCorregirDocente.add(lblListaResolucionesCorregir);

		listaResolucionCorregir = new List();
		listaResolucionCorregir.setBounds(893, 77, 299, 592);
		panelCorregirDocente.add(listaResolucionCorregir);

		txtDniCorregir = new JTextField();
		txtDniCorregir.setEditable(false);
		txtDniCorregir.setFont(new Font("Arial", Font.BOLD, 20));
		txtDniCorregir.setBounds(380, 158, 377, 54);
		panelCorregirDocente.add(txtDniCorregir);
		txtDniCorregir.setColumns(10);

		txtCodigoActividadCorregir = new JTextField();
		txtCodigoActividadCorregir.setEditable(false);
		txtCodigoActividadCorregir.setFont(new Font("Arial", Font.BOLD, 20));
		txtCodigoActividadCorregir.setColumns(10);
		txtCodigoActividadCorregir.setBounds(380, 269, 377, 54);
		panelCorregirDocente.add(txtCodigoActividadCorregir);

		txtResolucionCorregir = new JTextField();
		txtResolucionCorregir.setEditable(false);
		txtResolucionCorregir.setFont(new Font("Arial", Font.BOLD, 20));
		txtResolucionCorregir.setColumns(10);
		txtResolucionCorregir.setBounds(380, 380, 377, 54);
		panelCorregirDocente.add(txtResolucionCorregir);

		txtNotaCorregir = new JTextField();
		txtNotaCorregir.setFont(new Font("Arial", Font.BOLD, 20));
		txtNotaCorregir.setColumns(10);
		txtNotaCorregir.setBounds(380, 490, 377, 54);
		panelCorregirDocente.add(txtNotaCorregir);

		btnSubirCorregir = new JButton("SUBIR");
		btnSubirCorregir.setFont(new Font("Arial", Font.BOLD, 20));
		btnSubirCorregir.setBounds(504, 585, 139, 54);
		panelCorregirDocente.add(btnSubirCorregir);

	}

	// //// get y set de SUBIR Actividad ///////////////////

	public String getDescripcionAddActividad() {
		return txtDescripcionAddActividad.getText();
	}

	public void setDescripcionAddActividad(String s) {
		txtDescripcionAddActividad.setText(s);
	}

	public String getCodigoMateriaAddActividad() {
		return txtCodigoMAteriaAddActividad.getText();
	}

	public void setCodigoMateriaAddActividad(String s) {
		txtCodigoMAteriaAddActividad.setText(s);
	}

	public String getDescripcionDeleteActividad() {
		return txtDescripcionDeleteActividad.getText();
	}

	public void setDEscripcionDeleteActividad(String s) {
		txtDescripcionDeleteActividad.setText(s);
	}

	public String getCodigoMateriaDeleteActividad() {
		return txtCodigoMAteriaDeleteActividad.getText();
	}

	public void setCodigoMateriaDeleteActividad(String s) {
		txtCodigoMAteriaDeleteActividad.setText(s);
	}

	// // get y set de CORREGIR ACTIVIDAD

	public String getDniCorregir() {
		return txtDniCorregir.getText();
	}

	public String getCodigoActividadCorregir() {
		return txtCodigoActividadCorregir.getText();
	}

	public String getResolucionCorregir() {
		return txtResolucionCorregir.getText();
	}

	public String getNotaCorregir() {
		return txtNotaCorregir.getText();
	}

	public void setDniCorregir(String s) {
		txtDniCorregir.setText(s);
	}

	public void setCodigoActividadCorregir(String s) {
		txtCodigoActividadCorregir.setText(s);
	}

	public void setResolucionCorregir(String s) {
		txtResolucionCorregir.setText(s);
	}

	public void setNotaCorregir(String s) {
		txtNotaCorregir.setText(s);
	}
}