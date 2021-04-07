
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modele {

    private static Connection Connexion(String url, String user, String password)throws SQLException {
        Connection conn=null;
        try{
            Class.forName("con.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        }
        catch (ClassNotFoundException e){
            System.out.println("Erreur lors du chargement"+e.getMessage());
        }
        return conn;
    
        
    }
    public int verifLogin(String req) throws SQLException {
        Statement stmt=null;
        Connection connexion=null;
        int nombre=0;
        try {
            String url = "jdbc:mysql://localhost:3306/bddgraph" ;
            String user= "root";
            String password ="";
            connexion = Modele.Connexion(url, user, password);
            stmt = (Statement) connexion.createStatement() ;
            ResultSet result = stmt.executeQuery(req) ;

            while (result.next()){
                    nombre = result.getInt(1);
                }
            }
            catch (SQLException e) {
System.out.println("Connection error");
            }
           return nombre;
}            
}
