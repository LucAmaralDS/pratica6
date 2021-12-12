package pratica6;

import java.sql.Connection;
import java.sql.Statement;
public class Main {
	static Connection connection = null;
	Statement statement;  
	public static void main(String[] args) {
		Conexao conexao = new Conexao();
		conexao.abrirConexao();
		DB db = new DB(conexao.getConnection());
		
		//db.adicionarPais(5, "'Brasil'");
		//db.deletarPais(5);
		//db.atualizarPais(2 ,"'Brasil'");
		//db.lerPais(2);
		//db.procuraLike(null, null);
		//db.adicionarArrayPais(0, null;
		
		
		
		
		
		conexao.fecharConexao();
		

 }
}