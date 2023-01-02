package io.github.robson.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import io.github.robson.model.UsuarioEntities;

public class UsuarioDAO implements UsuarioInterfaceDAO {
	
	ConnectionDAO dao = new ConnectionDAO();
	
	@Override
	public Boolean login(UsuarioEntities login) {
		String select = "select * from usuario where login =? and senha=?";

		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(select);
			pst.setString(1, login.getLogin());
			pst.setString(2, login.getSenha());
			ResultSet rs = pst.executeQuery();
			Boolean resultado = rs.isBeforeFirst();
			while (rs.next()) {
				login.setIduser(rs.getString(1));
				login.setNome(rs.getString(2));
			}
			con.close();
			return resultado;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
