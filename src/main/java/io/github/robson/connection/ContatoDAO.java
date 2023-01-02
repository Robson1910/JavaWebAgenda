package io.github.robson.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;

import io.github.robson.model.ContatoEntities;

public class ContatoDAO implements ContatoInterfaceDAO {

	ConnectionDAO dao = new ConnectionDAO();

	@Override
	public HashSet<ContatoEntities> List() {
		
		HashSet<ContatoEntities> contatos = new HashSet<>();
		
		String list = "select * from contatos order by nome";

		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(list);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				contatos.add(new ContatoEntities(idcon, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void insert(ContatoEntities contato) {
		
		String insert = "insert into contatos(nome,fone,email) value(?,?,?)";
		
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void select(ContatoEntities contato) {
		
		String select = "select * from contatos where idcon = ?";

		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(select);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void update(ContatoEntities contato) {
		
		String update = "update contatos set nome = ?, fone = ?, email = ? where idcon = ?";
		
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void delete(ContatoEntities contato) {
		
		String delete = "delete from contatos where idcon = ?";
		
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
