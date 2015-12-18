package entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import conexao.*;


public class VolumeDAO {
	private Connection connection;

	public VolumeDAO(){
		this.connection =  (Connection) new ConnectionFactory().getConnection();
	}

	public boolean inserir(Volume volume) throws SQLException{
		try{
			Connection connection = (Connection) new ConnectionFactory().getConnection();
		}catch(RuntimeException e){
			System.out.println("Erro de Conexão");
			return false;
		}
		String sql = "insert into tb_volume " +
				"(ANO_PUBLIC,AUTOR,DESCRICAO,EDITORA,NUM_PAGE,TIPO_VOLUME,TITULO)" +
				" values (?,?,?,?,?,?,?);";

		try {


			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1,volume.getAno_public());
			stmt.setString(2,volume.getAutor());
			stmt.setString(3,volume.getDescricao());
			stmt.setString(4,volume.getEditora());
			stmt.setString(5,volume.getNum_pag());
			stmt.setString(6,volume.getTipo());
			stmt.setString(7,volume.getTitulo());


			stmt.execute();
			stmt.close();


		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	public void remove (Volume volume) throws SQLException{
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tb_volume where TITULO=?");
			stmt.setString(1, volume.getTitulo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void query(Volume volume) throws SQLException{
		
		PreparedStatement stmt = (PreparedStatement) 
				this.connection.prepareStatement("Select * from tb_volume where TITULO = ?");
		stmt.setString(1, volume.getTitulo());
		ResultSet rs = stmt.executeQuery();

		while(rs.next()){
			
			System.out.println("ANO DE PUBLICAÇÃO : "+rs.getString("ANO_PUBLIC"));
			System.out.println("AUTOR : "+rs.getString("AUTOR"));
			System.out.println("DESCRICAO : "+rs.getString("DESCRICAO"));
			System.out.println("EDITORA: "+rs.getString("EDITORA"));
			System.out.println("NUMERO DE PAGINAS: "+rs.getString("NUM_PAGE"));
			System.out.println("TIPO DE VOLUME: "+rs.getString("TIPO_VOLUME"));
			System.out.println("TITULO: "+rs.getString("TITULO"));
			System.out.println("\n");
		}

		rs.close();
		stmt.close();

	}
	public void disconnect() throws SQLException {
		this.connection.close();	
	}



}



