package com.lords.controller;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.lords.bo.UsuarioBo;
import com.lords.model.UsuarioModel;
import com.lords.views.ControlUsuarios;
import com.lords.views.MenuAdmin;
import com.lords.views.RegistroUsuarios;

public class UsuariosController implements ActionListener, WindowListener {
	String resultado = "";

	RegistroUsuarios usuariosView = new RegistroUsuarios();
	RegistroUsuarios usuarios;

	UsuarioModel usuarioModel = new UsuarioModel();
	UsuarioBo usuarioBo = new UsuarioBo();
	ControlUsuarios usuariosControlView = new ControlUsuarios();
	ControlUsuarios usuariosControl;

	MenuAdmin vistaMenu;
	MenuAdminController controllerMenu;

	public UsuariosController(RegistroUsuarios vistaUsuarios, ControlUsuarios vistaControlUsuarios) {
		this.usuariosView = vistaUsuarios;
		this.usuariosControlView = vistaControlUsuarios;

		vistaUsuarios.btnRegistrar.addActionListener(this);
		vistaUsuarios.btnSalir.addActionListener(this);

		vistaControlUsuarios.btnAgregar.addActionListener(this);
		vistaControlUsuarios.btnBuscar.addActionListener(this);
		vistaControlUsuarios.btnSalir.addActionListener(this);
		vistaControlUsuarios.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(usuariosView.btnRegistrar)) {
			agregarUsuario();
		} else if (e.getSource().equals(usuariosView.btnSalir)) {
			usuariosControlView.setVisible(true);
			usuariosView.dispose();
			consultaGeneral();
		} else if (e.getSource().equals(usuariosControlView.btnAgregar)) {
			limpiarRegistro();
			usuariosControlView.setVisible(false);
			usuariosControlView.dispose();
			usuariosView.setLocationRelativeTo(null);
			usuariosView.setUndecorated(true);
			usuariosView.setVisible(true);
		} else if (e.getSource().equals(usuariosControlView.btnBuscar)) {
			consultaGeneral();
		} else if (e.getSource().equals(usuariosControlView.btnSalir)) {
			usuariosControlView.setVisible(false);
			usuariosControlView.dispose();
			vistaMenu = new MenuAdmin();
			vistaMenu.setLocationRelativeTo(null);
			vistaMenu.setUndecorated(true);
			vistaMenu.setVisible(true);
			controllerMenu = new MenuAdminController(vistaMenu);

		}

	}

	private void limpiarRegistro() {
		usuariosView.txtUsername.setEnabled(true);
		usuariosView.txtNombre.setText("");
		usuariosView.txtApPaterno.setText("");
		usuariosView.txtApMaterno.setText("");
		usuariosView.txtPassword.setText("");
		usuariosView.txtPassword2.setText("");
		usuariosView.txtUsername.setText("");
		usuariosView.jcbRoll.setSelectedIndex(0);
		usuariosView.lblRegistro.setText("Registro");
		usuariosView.lblRegistro.setBounds(111, 6, 115, 31);
		usuariosView.lblRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		usuariosView.btnRegistrar.setIcon(
				new ImageIcon(RegistroUsuarios.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
		usuariosView.btnRegistrar.setName("Registro");
	}

	private void consultaGeneral() {
		List<UsuarioModel> listaUsuarios = new ArrayList<UsuarioModel>();
		try {
			listaUsuarios = usuarioBo.consultaGeneral();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		Iterator<UsuarioModel> itrUsuarios = listaUsuarios.iterator();
		String[] columnNames = { "Nombre completo", "Username", "Estatus", "Modificar", "Eliminar" };

		final Class[] tiposColumnas = new Class[] { java.lang.String.class, java.lang.String.class,
				java.lang.String.class, JButton.class, JButton.class };

		usuariosControlView.table.setModel(new javax.swing.table.DefaultTableModel() {
			Class[] tipos = tiposColumnas;

			@SuppressWarnings("unchecked")
			public Class getColumnClass(int columnIndex) {
				return tipos[columnIndex];
			}

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});

		usuariosControlView.table.setDefaultRenderer(JButton.class, new TableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado,
					boolean tieneElFoco, int fila, int columna) {
				return (Component) objeto;
			}
		});
		if (usuariosControlView.table.getMouseListeners().length == 2) {

			usuariosControlView.table.addMouseListener(new MouseAdapter() {
				String nombreCompleto;
				String username;
				String estatus;
				Object boton;
				private String delete;

				public void mouseClicked(MouseEvent e) {
					int fila = usuariosControlView.table.rowAtPoint(e.getPoint());
					int columna = usuariosControlView.table.columnAtPoint(e.getPoint());

					if (usuariosControlView.table.getModel().getColumnClass(columna).equals(JButton.class)) {
						boton = usuariosControlView.table.getModel().getValueAt(fila, columna);
						StringBuilder sb = new StringBuilder();
						for (int i = 0; i < usuariosControlView.table.getModel().getColumnCount(); i++) {
							if (!usuariosControlView.table.getModel().getColumnClass(i).equals(JButton.class)) {
								sb.append("\n").append(usuariosControlView.table.getModel().getColumnName(i))
										.append(": ").append(usuariosControlView.table.getModel().getValueAt(fila, i));

								if (usuariosControlView.table.getModel().getColumnName(i) == "Nombre completo") {
									nombreCompleto = usuariosControlView.table.getModel().getValueAt(fila, i)
											.toString();
								}
								if (usuariosControlView.table.getModel().getColumnName(i) == "Username") {
									username = usuariosControlView.table.getModel().getValueAt(fila, i).toString();
								}
								if (usuariosControlView.table.getModel().getColumnName(i) == "Estatus") {
									estatus = usuariosControlView.table.getModel().getValueAt(fila, i).toString();
								}
							}
						}
						// Boton Editar--------
						if (boton.toString().contains("Modificar") == true) {
							usuariosControlView.setVisible(false);
							usuariosControlView.dispose();
							usuariosView.setLocationRelativeTo(null);
							usuariosView.setUndecorated(true);
							usuariosView.setVisible(true);
							decorarModificar();
							try {
								usuarioModel = usuarioBo.consultaEditar(username);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							usuariosView.txtNombre.setText(usuarioModel.getNombreUsuario());
							usuariosView.txtApPaterno.setText(usuarioModel.getApatUsuario());
							usuariosView.txtApMaterno.setText(usuarioModel.getAmatUsuario());
							usuariosView.txtUsername.setText(usuarioModel.getUsername());
							usuariosView.txtPassword.setText(usuarioModel.getPassword());
							usuariosView.txtPassword2.setText(usuarioModel.getPassword());
							if (usuarioModel.getEnabled() == 1) {
								usuariosView.rdbtnSi.setSelected(true);
							} else {
								usuariosView.rdbtnNo.setSelected(true);
							}
							usuariosView.jcbRoll.setSelectedItem(usuarioModel.getRol());
							return;

							// Boton Eliminar------
						} else if (boton.toString().contains("Eliminar") == true) {
							if (JOptionPane.showConfirmDialog(null,
									"Seguro de Eliminar el Usuario :" + username) == 0) {
								delete = usuarioBo.eliminarUsuario(username);
								if (delete.equals("El usuario fue eliminado correctamente!")) {
									JOptionPane.showMessageDialog(null, delete, "Eliminar usuario",
											JOptionPane.INFORMATION_MESSAGE);
								} else {
									JOptionPane.showMessageDialog(null, delete, "Eliminar usuario",
											JOptionPane.WARNING_MESSAGE);
								}
								consultaGeneral();
							}
							return;
						}
					}
				}
			});
		}

		DefaultTableModel modelo = (DefaultTableModel) usuariosControlView.table.getModel();
		modelo.setColumnIdentifiers(columnNames);
		Object[] fila = new Object[modelo.getColumnCount()];
		while (itrUsuarios.hasNext()) {
			UsuarioModel usuarioModeloitr = itrUsuarios.next();
			JButton btn = new JButton("Modificar");
			JButton btn2 = new JButton("Eliminar");
			fila[0] = usuarioModeloitr.getNombreUsuario();
			fila[1] = usuarioModeloitr.getUsername();
			fila[2] = usuarioModeloitr.getEstatus();
			fila[3] = btn;
			fila[4] = btn2;
			modelo.addRow(fila);
		}
		usuariosControlView.table.getColumnModel().getColumn(0).setPreferredWidth(300);
		usuariosControlView.table.getColumnModel().getColumn(1).setPreferredWidth(100);
		usuariosControlView.table.getColumnModel().getColumn(2).setPreferredWidth(150);
		usuariosControlView.table.getColumnModel().getColumn(3).setPreferredWidth(100);
		usuariosControlView.table.getColumnModel().getColumn(4).setPreferredWidth(100);
	}

	private void agregarUsuario() {
		String contrasena1, contrasena2;
		int estatus = 0;
		contrasena1 = usuariosView.txtPassword.getText();
		contrasena2 = usuariosView.txtPassword2.getText();
		if (usuariosView.rdbtnSi.isSelected() == true) {
			estatus = 1;
		} else if (usuariosView.rdbtnNo.isSelected() == true) {
			estatus = 0;
		}
		if (usuariosView.txtNombre.getText().isEmpty() || usuariosView.txtApPaterno.getText().isEmpty()
				|| usuariosView.txtApMaterno.getText().isEmpty() || usuariosView.txtPassword.getText().isEmpty()
				|| usuariosView.txtUsername.getText().isEmpty() || usuariosView.txtPassword.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campos vacios");

		} else if (!contrasena1.equals(contrasena2)) {
			JOptionPane.showMessageDialog(null, "Las contrase�as no coinciden");

		} else if (usuariosView.jcbRoll.getSelectedItem().equals("--Seleccione un rol--")) {
			JOptionPane.showMessageDialog(null, "Seleccione un rol por favor");

		} else {
			usuarioModel.setNombreUsuario(usuariosView.txtNombre.getText());
			usuarioModel.setApatUsuario(usuariosView.txtApPaterno.getText());
			usuarioModel.setAmatUsuario(usuariosView.txtApMaterno.getText());

			usuarioModel.setUsername(usuariosView.txtUsername.getText());
			usuarioModel.setPassword(usuariosView.txtPassword.getText());
			usuarioModel.setRol(usuariosView.jcbRoll.getSelectedItem().toString());
			usuarioModel.setEnabled(estatus);
			resultado = verificarUsuario();
			if (usuariosView.btnRegistrar.getName().equals("Registro")) {
				if (!resultado.equals("Correcto")) {
					JOptionPane.showMessageDialog(null, resultado);
					return;
				} else {
					String resultado = insertarUsuario();
					JOptionPane.showMessageDialog(null, resultado);
					String validacion = resultado.substring(0, 16);
					if (validacion.equals("Registro exitoso")) {
						limpiarContenido();
					}
				}
			} else {
				String resultado = modificarUsuario();
				JOptionPane.showMessageDialog(null, resultado);
				String validacion = resultado.substring(0, 20);
				if (validacion.equals("Modificacion exitosa")) {
					limpiarContenido();
				}
			}

		}
	}

	

	private String insertarUsuario() {
		try {
			resultado = usuarioBo.ingresarUsuario(usuarioModel);
		} catch (Exception e) {
		}
		String validacion = resultado.substring(0, 16);
		if (validacion.equals("Registro exitoso")) {
			resultado = usuarioBo.recuperarIdUsuario(usuarioModel);

			if (!resultado.equals("No existe id del usuario solicitado")) {
				resultado = usuarioBo.ingresarRolUsuario(usuarioModel);
			}
		}
		return resultado;
	}
	private String modificarUsuario() {
		try {
			resultado = usuarioBo.modificarUsuario(usuarioModel);
		} catch (Exception e) {
		}
		String validacion = resultado.substring(0, 20);
		JOptionPane.showMessageDialog(null, validacion);
		if (validacion.equals("Modificacion exitosa")) {
			resultado = usuarioBo.recuperarIdUsuario(usuarioModel);

			if (!resultado.equals("No existe id del usuario solicitado")) {
				resultado = usuarioBo.modificarRolUsuario(usuarioModel);
			}
		}
		return resultado;
	}

	private String verificarUsuario() {
		try {
			resultado = usuarioBo.verificarUsuario(usuarioModel);
		} catch (Exception e) {

		}
		return resultado;
	}

	private void limpiarContenido() {
		usuarioModel.setAmatUsuario(null);
		usuarioModel.setApatUsuario(null);
		usuarioModel.setEnabled(0);
		usuarioModel.setIdRol(0);
		usuarioModel.setNombreUsuario(null);
		usuarioModel.setPassword(null);
		usuarioModel.setRol(null);
		usuarioModel.setUsername(null);
		usuariosView.txtApMaterno.setText("");
		usuariosView.txtApPaterno.setText("");
		usuariosView.txtNombre.setText("");
		usuariosView.txtPassword.setText("");
		usuariosView.txtPassword2.setText("");
		usuariosView.txtUsername.setText("");
		usuariosView.jcbRoll.setSelectedIndex(0);
	}

	private void decorarModificar() {
		usuariosView.lblRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		usuariosView.lblRegistro.setBounds(111, 6, 150, 31);
		usuariosView.lblRegistro.setText("Modificar usuario");
		usuariosView.btnRegistrar.setIcon(
				new ImageIcon(RegistroUsuarios.class.getResource("/com/lords/resources/img/boton-CAMBIOS.png")));
		usuariosView.btnRegistrar.setName("Modificar");
		usuariosView.txtUsername.setEnabled(false);

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		consultaGeneral();
	}
}