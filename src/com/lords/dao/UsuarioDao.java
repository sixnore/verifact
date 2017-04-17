package com.lords.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import com.lords.conexion.Conexion;
import com.lords.model.UsuarioModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioDao {
	Conexion conexion;

	public UsuarioDao() {
		conexion = new Conexion();
	}

	public String acceder(UsuarioModel usuarioModelo) {
		Connection accesodb = (Connection) conexion.conectandobd();

		String mensaje = "";
		try {

			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement(
					"select usuario.username, usuario.password,rollusuario.roll,usuario.enabled from usuario inner join rollusuario on rollusuario.id_usuario=usuario.id_usuario where usuario.username=? and password=?");
			ps.setString(1, usuarioModelo.getUsername());
			ps.setString(2, usuarioModelo.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				usuarioModelo.setUsername(rs.getString(1));
				usuarioModelo.setPassword(rs.getString(2));
				usuarioModelo.setRol(rs.getString(3));
				usuarioModelo.setEnabled(rs.getInt(4));
				if(usuarioModelo.getEnabled()== 0){
					return mensaje = "Cuenta desactivada";
				}else{
					return mensaje = "Bienvenido "+usuarioModelo.getRol() ;
				}
				
				
			} else {
				mensaje = "No existe usuario";
				usuarioModelo.setUsername("");

			}
		} catch (Exception e) {
			mensaje = "Error con la base " + e;
		}
		return mensaje;
	}

	public String verificarUsuario(UsuarioModel usuarioModel) {
		Connection accesodb = (Connection) conexion.conectandobd();
		String mensaje = "";
		try {
			PreparedStatement ps = (PreparedStatement) accesodb
					.prepareStatement("select usuario.username from usuario where usuario.username=?");
			ps.setString(1, usuarioModel.getUsername());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usuarioModel.setUsername(rs.getString(1));
				System.out.println(usuarioModel.getUsername());
				return mensaje = "El usuario " + usuarioModel.getUsername() + " ya existe.";
			} else {
				mensaje = "Correcto";
			}
		} catch (Exception e) {
			mensaje = "Error con la base " + e;
		}
		return mensaje;
	}

	public String ingresarUsuario(UsuarioModel usuarioModel) {
		String resultado = "";
		try {
			Connection accesodb = (Connection) conexion.conectandobd();
			String insertUser = "insert into usuario values(null,?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement(insertUser);
			ps.setString(1, usuarioModel.getNombreUsuario());
			ps.setString(2, usuarioModel.getApatUsuario());
			ps.setString(3, usuarioModel.getAmatUsuario());
			ps.setString(4, usuarioModel.getUsername());
			ps.setString(5, usuarioModel.getPassword());
			ps.setInt(6, usuarioModel.getEnabled());

			int correcto = ps.executeUpdate();
			if (correcto > 0) {
				resultado = "Registro exitoso del usuario " + usuarioModel.getUsername();
			}

		} catch (Exception e) {
			resultado = "Existio un error en la transaccion " + e;
		}
		return resultado;
	}

	public String recuperarIdUsuario(UsuarioModel usuarioModel) {
		Connection accesodb = (Connection) conexion.conectandobd();
		String mensaje = "";
		try {
			PreparedStatement ps = (PreparedStatement) accesodb
					.prepareStatement("select usuario.id_usuario from usuario where usuario.username=?");
			ps.setString(1, usuarioModel.getUsername());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usuarioModel.setIdUsuario(rs.getInt(1));
				return mensaje = "El id del usuario es " + usuarioModel.getIdUsuario();
			} else {
				mensaje = "No existe id del usuario solicitado";
			}
		} catch (Exception e) {
			mensaje = "Error con la base " + e;
		}
		return mensaje;
	}

	public String ingresarRolUsuario(UsuarioModel usuarioModel) {
		String resultado = "";
		try {
			Connection accesodb = (Connection) conexion.conectandobd();
			String insertUser = "insert into rollusuario values(null,?,?,?)";
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement(insertUser);
			ps.setInt(1, usuarioModel.getIdUsuario());
			ps.setString(2, usuarioModel.getUsername());
			ps.setString(3, usuarioModel.getRol());
			int correcto = ps.executeUpdate();
			if (correcto > 0) {
				resultado = "Registro exitoso del usuario " + usuarioModel.getUsername() + " con permisos de "
						+ usuarioModel.getRol();
			}

		} catch (Exception e) {
			resultado = "Existio un error en la transaccion " + e;
		}
		return resultado;
	}

	public List<UsuarioModel> consultaGeneral() throws SQLException {
		List<UsuarioModel> listaUsuarios = new ArrayList<UsuarioModel>();
		Connection accesodb = (Connection) conexion.conectandobd();

		try {
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement(
					"select id_usuario,concat(nombre_usuario,' ',apatUsuario,' ',amatUsuario)as nombre,username,enabled from usuario");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UsuarioModel usuarioModel = new UsuarioModel();
				usuarioModel.setIdUsuario(rs.getInt(1));
				usuarioModel.setNombreUsuario(rs.getString(2));
				usuarioModel.setUsername(rs.getString(3));
				usuarioModel.setEnabled(rs.getInt(4));
				listaUsuarios.add(usuarioModel);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return listaUsuarios;
	}

	public UsuarioModel consultaEditar(String username) throws SQLException {
		UsuarioModel usuarioModel=new UsuarioModel();
		Connection accesodb = (Connection) conexion.conectandobd();
		try {
			PreparedStatement ps = (PreparedStatement) accesodb
					.prepareStatement("select usuario.id_usuario,"
							+ "usuario.nombre_usuario,usuario.apatUsuario,"
							+ "usuario.amatUsuario,usuario.username,usuario.password,"
							+ "usuario.enabled,rollusuario.roll from usuario "
							+ "INNER JOIN rollusuario on usuario.id_usuario=usuario.id_usuario "
							+ "where usuario.username=? and rollusuario.user_name=?");
			ps.setString(1, username);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usuarioModel.setIdUsuario(rs.getInt(1));
				usuarioModel.setNombreUsuario(rs.getString(2));
				usuarioModel.setApatUsuario(rs.getString(3));
				usuarioModel.setAmatUsuario(rs.getString(4));
				usuarioModel.setUsername(rs.getString(5));
				usuarioModel.setPassword(rs.getString(6));
				usuarioModel.setEnabled(rs.getInt(7));
				usuarioModel.setRol(rs.getString(8));
			} 
		} catch (Exception e) {
			System.out.println("Existe un error en la base de datos "+ e);
			throw new SQLException("Existe un problema con la base de datos\n" + "No se pudo realizar la consulta!");
		}
		return usuarioModel;
		}

	public String eliminarUsuario(String username)throws SQLException{
		String resultado="";
		try {
			Connection accesodb = (Connection) conexion.conectandobd();
			String insertUser = "UPDATE usuario SET usuario.enabled=0 WHERE usuario.username=?";
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement(insertUser);
			ps.setString(1, username);

			int correcto = ps.executeUpdate();
			if (correcto > 0) {
				resultado = "El usuario fue dado de baja correctamente";
			}

		} catch (Exception e) {
			resultado = "Existio un error en la transaccion " + e;
			throw new SQLException("Existe un problema con la base de datos\n" + "No se pudo realizar la consulta!");
		}
		return resultado;
	}

}
