import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by DiegoC on 05/11/2016.
 */
public class Principal {
    public static void main (String [] args){
        try {
            Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost", "neo4j", "4jneo");
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("MATCH (n:User) RETURN n.name");
                while (rs.next()) {
                    System.out.println(rs.getString("n.name"));
                }
            }
            con.close();

        }catch (Exception ex){
            System.out.println("AAA");
        }
    }

}


