import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

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
            Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost", "neo4j", "Monito96");
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("MATCH (n:User) RETURN n.name");
                while (rs.next()) {
                    System.out.println(rs.getString("n.name"));
                }
            }

            Graph graph = new SingleGraph("Pruebas");
            Node[] nodos = new Node [14];
            String[] names = {"Goff", "Golden", "Tracey", "Emma", "Billy", "Jason", "Ryan", "Carl", "Wizzi", "Old", "Carol", "Cesar", "Ricardo", "Richard"};

            for(int i = 0; i < 14; i++){
                graph.addNode(names[i]);
            }
            graph.display();

            con.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}

