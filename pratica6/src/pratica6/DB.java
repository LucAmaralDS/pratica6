package pratica6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	private Connection conexao;
	public DB(Connection conexao){
        this.conexao = conexao;
    }
	
	public boolean adicionarPais(int id_pais, String nome_pais) {
		try {
			Statement statement = this.conexao.createStatement();
			statement.executeUpdate("INSERT INTO País VALUES("+id_pais+","+nome_pais+")");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}				
	}
	
	public boolean adicionarCidade(int id_cidade, String nome_cidade) {
		try {
			Statement statement = this.conexao.createStatement();
			statement.executeUpdate("INSERT INTO Cidade VALUES("+id_cidade+", "+nome_cidade+")");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
   }
	
	public boolean deletarPais(int id_pais) {
		try {
			Statement statement = this.conexao.createStatement();
			statement.executeUpdate("DELETE FROM País WHERE id_pais = "+id_pais+"");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
   }
	
	public boolean deletarCidade(int id_cidade) {
		try {
			Statement statement = this.conexao.createStatement();
			statement.executeUpdate("DELETE FROM Cidade WHERE id_cidade = "+id_cidade+"");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
   }
	
	public boolean atualizarPais(int id_pais, String nome_paisNovo){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE País SET nome_pais ='"+nome_paisNovo+"' WHERE id_pais ="+id_pais);          
            return true;
        }catch(SQLException e){
            return false;
        }
    }
	public boolean atualizarCidade(int id_cidade, String nome_cidadeNovo){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE Cidade SET nome_cidade ='"+nome_cidadeNovo+"' WHERE id_pais ="+id_cidade);          
            return true;
        }catch(SQLException e){
            return false;
        }
    }
	
	public boolean lerPais(int id_pais){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM País WHERE id_pais = "+id_pais);
            
            while (rs.next()) {
                Integer id = rs.getInt("id_pais");
                String nome = rs.getString("'nome_pais'");

                System.out.println( id +" - " + nome);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
	public boolean lerCidade(int id_cidade){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM País WHERE id_pais = "+id_cidade);
            
            while (rs.next()) {
                Integer id = rs.getInt("id_cidade");
                String nome = rs.getString("nome_cidade");

                System.out.println( id +" - " + nome);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
	
	private DB[] paises = new DB[5];
	public boolean adicionarArrayPais(int novoIdPais, String novoNomePais) {
		try {
			Statement statement = this.conexao.createStatement();
			for(int i = 0; i < paises.length; i++ ) {
			    statement.executeUpdate("INSERT INTO País VALUES("+novoIdPais+", "+novoNomePais+")");	
			}			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}				
	}

	public boolean procuraLike(String nome, String indentificador){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * From País, Cidade WHERE "+nome+" LIKE '%"+indentificador+"%'");
            
            while (rs.next()){
                Integer id_pais = rs.getInt("id_pais");
                Integer id_cidade = rs.getInt("id_pais");
                String nome_pais = rs.getString("nome_pais");
                String nome_cidade = rs.getString("nome_cidade");
                     
                
                System.out.println(id_pais + " - " + nome_pais + " - " + id_cidade + " - " + nome_cidade);
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }








}