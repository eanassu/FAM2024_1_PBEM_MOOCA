package br.com.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.vemprafam.pojo.Funcionario;

public class DaoFuncionario {
	private String url="jdbc:hsqldb:hsql://localhost/";
	private String user="SA";
	private String password="";
	Connection connection;
	public DaoFuncionario() {
		super();
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void inserir( Funcionario funcionario ) {
		try {
			String sql="INSERT INTO Funcionarios VALUES(?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, funcionario.getRe());
			pstmt.setString(2, funcionario.getNome());
			pstmt.setDate(3, new java.sql.Date(funcionario.getDataAdmissao().getTime()));
			pstmt.setDouble(4, funcionario.getSalario());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Funcionario> getLista() {
		List<Funcionario> result = new ArrayList<Funcionario>();
		try {
			String sql="SELECT RE,NOME,DATAADMISSAO,SALARIO FROM FUNCIONARIOS";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ) {
				int ra = rs.getInt(1);
				String nome = rs.getString("NOME");
				Date dataNascimento = rs.getDate(3);
				double salario = rs.getDouble(4);
				result.add(new Funcionario(ra,nome,dataNascimento,salario));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	public Funcionario buscarPeloRe( int re ) {
		try {
			String sql="SELECT RE,NOME,DATAADMISSAO,SALARIO FROM FUNCIONARIOS WHERE RE=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, re);
			ResultSet rs = pstmt.executeQuery();
			if ( rs.next() ) {
				String nome = rs.getString("NOME");
				Date dataAdmissao = rs.getDate(3);
				double salario = rs.getDouble(4);
				return (new Funcionario(re,nome,dataAdmissao,salario));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public void atualizar( Funcionario funcionario ) {
		try {
			String sql="UPDATE FUNCIONARIOS SET nome=?,dataAdmissao=?,salario=? WHERE RE=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, funcionario.getNome());
			pstmt.setDate(2, new java.sql.Date(funcionario.getDataAdmissao().getTime()));
			pstmt.setDouble(3, funcionario.getSalario());
			pstmt.setInt(4, funcionario.getRe());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void excluir( Funcionario funcionario ) {
		try {
			String sql="DELETE FROM FUNCIONARIOS WHERE RE=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, funcionario.getRe());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DaoFuncionario dao = new DaoFuncionario();
		dao.atualizar(new Funcionario(111,"aaaaaa",new Date(),2222));
		//System.out.println(dao.buscarPeloRa(1));
	}
}









