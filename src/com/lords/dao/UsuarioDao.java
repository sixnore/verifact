package com.lords.dao;

import java.sql.ResultSet;

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
					"select usuario.username, usuario.password,rolusuario.rol from usuario inner join rolusuario on rolusuario.idUsuario=usuario.idUsuario where usuario.username=? and password=?");
			ps.setString(1, usuarioModelo.getUsername());
			ps.setString(2, usuarioModelo.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usuarioModelo.setUsername(rs.getString(1));
				usuarioModelo.setPassword(rs.getString(2));
				usuarioModelo.setRol(rs.getString(3));
				return mensaje = "Encontrado " + usuarioModelo.getUsername() + " " + usuarioModelo.getPassword() + " "
						+ usuarioModelo.getRol();
			}else{
				mensaje="No existe usuario";
			}
		} catch (Exception e) {
			mensaje="Error con la base "+e;
		}
		return mensaje;
	}

}
