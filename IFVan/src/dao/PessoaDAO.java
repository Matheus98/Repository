package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import entidades.Pessoa;

public class PessoaDAO implements GenericDAO<String, Pessoa>{

	static ConnectionFactory banco;

	public Connection connection;

	private static PessoaDAO instance;

	public static PessoaDAO getInstance() {

		banco = ConnectionFactory.getInstance();

		instance = new PessoaDAO(banco);

		return instance;
	}

	public PessoaDAO(ConnectionFactory banco) {

		this.connection = (Connection) banco.getConnection();

	}
	@Override
	public int insert(Pessoa pessoa) throws SQLException {

		Integer id = BancoUtil.IDVAZIO;

		try {

			// Considerar a tabela tb_pessoa composta dos campos: id_pessoa (int), nm_pessoa (varchar) e nm_endereco (varchar).
			String sql = "INSERT INTO tb_pessoa ("
					+ " NOME, "
					+ " SENHA,"
					+ " ENDERECO,"
					+ " TIPOPASS,"
					+ " PRECO)"
					+ " VALUES (?,?,?,?,?)";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getSenha());
			stmt.setString(3, pessoa.getEndereco());
			stmt.setString(4, pessoa.getTipoPassagem());
			stmt.setDouble(5, pessoa.getPrecoPassagem());

			stmt.execute();

			// Cadastra e recuperar identificação da Pessoa.
			id = BancoUtil.getGenerateKey(stmt);

		} catch (SQLException e) {

			System.out.println(e);

		} finally {

			connection.close();
		}

		return id;
	}

	@Override
	public Pessoa getById(String nome) throws SQLException {
		Pessoa pessoa = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			// Considerar a tabela tb_pessoa composta dos campos: id (int) e nome (varchar).
			String sql = "SELECT pessoa.ID,"
					+ " pessoa.NOME,"
					+ " pessoa.SENHA,"
					+ " pessoa.ENDERECO,"
					+ " pessoa.TIPOPASS,"
					+ " pessoa.PRECO"
					+ " FROM tb_pessoa AS pessoa"
					+ " WHERE pessoa.NOME = " 
					+ nome;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Pessoa> pessoas = convertToList(rs);

			if (!pessoas.isEmpty())
				pessoa = pessoas.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return pessoa;
	}

	private List<Pessoa> convertToList(ResultSet rs) throws SQLException {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {

			while (rs.next()) {

				// Pessoa
				Pessoa pessoa = new Pessoa();

				pessoa.setNome(rs.getString("pessoa.NOME"));
				pessoa.setEndereco(rs.getString("pessoa.ENDERECO"));
				pessoa.setTipoPassagem(rs.getString("TIPOPASS"));
				pessoa.setPrecoPassagem(rs.getDouble("pessoa.PRECO"));

				pessoas.add(pessoa);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return pessoas;
	}

	public boolean authenticateLogin(String nome, String senha) throws SQLException{

		boolean isValid = false;

		try {			

			String sql = "SELECT pessoa.NOME,"
					+ " pessoa.SENHA"
					+ "	FROM tb_pessoa AS pessoa"
					+ " WHERE pessoa.NOME = ?"
					+ " and pessoa.SENHA = ?";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, nome);
			stmt.setString(2, senha);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {

				isValid = true; 

			}

		} catch(SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return isValid;
	}
	@Override
	public void delete(String nome) throws SQLException {
		
		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			// Considerar a tabela tb_pessoa composta dos campos: id (int) e nome (varchar).
			String sql = "DELETE pessoa.*"
					+ " FROM tb_pessoa AS pessoa"
					+ " WHERE pessoa.NOME = " 
					+ nome;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			connection.close();

		} catch (SQLException sqle) {

			throw new RuntimeException(sqle);
		}
	}		

	@Override
	public void update(Pessoa entity) throws SQLException {
		// TODO Auto-generated method stub

	}


	@Override
	public List<Pessoa> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> find(Pessoa entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
