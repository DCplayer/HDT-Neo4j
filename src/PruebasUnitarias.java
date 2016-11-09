/**
 * Created by JosJoe on 08/11/2016.
 */
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class PruebasUnitarias {

	public static void main (String args[]){
		try {
            Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost", "neo4j","Monito96");

            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("MATCH (x)-[rel:CORREOS]->(y)\n" +
                        "RETURN rel.length, x.name, y.name");

                while (rs.next()) {
                	System.out.print(rs.getString("x.name")+"-->"+rs.getString("rel.length")+"-->"+rs.getString("y.name"));System.out.println();
                }
            }con.close();

        }catch (Exception ex){
            System.out.println("aaa");
        }
	}
}
