
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonnathan on 08/11/2016.
 * tomdao como referencias > https://github.com/Chromz/HDT10-ALG/blob/master/src/main/java/DatabaseManager.java
 */
private class MatrixToDb implements Runnable{
private ArrayList<String[]> matrix;

private MatrixToDb(ArrayList<String[]> matrix){
        this.matrix = matrix;
        }

@Override
public void run() {
        try {
        Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost", "neo4j", "neo4j1");
        Statement statement = con.createStatement();
        String[] titles = matrix.get(0); // Obtener los titulos
        List<String> query = new ArrayList<>();

        for (int i = 0; i < titles.length; i++){
        String name = titles[i];
        if (!name.equals("")){
        query.add(String.format("MERGE (%s:User {name: '%s'})",
        name.replaceAll("\\s+", ""), name));
        }
        }
        statement.executeQuery(String.join("\n", query));
        for (int i = 1; i < matrix.size(); i++){
        String senderName = matrix.get(i)[0];
        for (int j = 1; j < matrix.get(i).length; j++){
        String edgeValue = matrix.get(i)[j];
        String destinataryName = titles[j];
        if (!edgeValue.equals("0")){
        query.add(String.format("MERGE (%s)-[:SEND {quantity: %s}]->(%s)",
        senderName.replaceAll("\\s+", ""), edgeValue,
        destinataryName.replaceAll("\\s+", "")));
        }
        }
        }
        statement.executeQuery(String.join("\n", query));
        SwingUtilities.invokeLater( () -> {
        });
        statement.close();
        con.close();
        }catch (SQLException ex){
        ex.printStackTrace();
        }

        }
}