package pratica6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

    private Connection connection;
    public Conexao(){
        this.connection = null;
    }
    
    private void setConnection(Connection connection){
        this.connection = connection;
    }
    public Connection getConnection(){
        return this.connection;
    }
    
    public boolean abrirConexao(){
      
      try
      {
        // create a database connection
        connection = DriverManager.getConnection("jdbc:sqlite:C:\\tp6/tp3.db");
        this.setConnection(connection);        
        return true;

      }
      catch(SQLException e)
      {        
        return false;
      }
    }
      public boolean fecharConexao(){
        try
        {
          if(this.getConnection() != null)
                this.getConnection().close();
                return true;
        }
        catch(SQLException e)
        {
          return false;
        }
    }
}