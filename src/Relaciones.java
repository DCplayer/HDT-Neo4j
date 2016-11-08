import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by DiegoC on 06/11/2016.
 */
public class Relaciones {

    public ArrayList<ArrayList> lista = new ArrayList();
    public Edge[] edges = new Edge[64];
    public int contador = 0;
    public Connect conexion = new Connect();

    /**
     * CrunchifyCSVtoArrayList: Metodo que convierte documentos csv a la matriz de datos
     */

    public void Pruebas(){
        BufferedReader crunchifyBuffer = null;

        try {
            String crunchifyLine;
            crunchifyBuffer = new BufferedReader(new FileReader("C:\\Users\\Christian12\\Desktop\\Cuarto Semestre\\Algoritmos y Estructura de Datos\\HDT-Neo4j\\src\\datos.txt"));

            // How to read file in java line by line?
            while ((crunchifyLine = crunchifyBuffer.readLine()) != null) {

                lista.add(crunchifyCSVtoArrayList(crunchifyLine));



            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (crunchifyBuffer != null) crunchifyBuffer.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    // Utility which converts CSV to ArrayList using Split Operation
    public static ArrayList<String> crunchifyCSVtoArrayList(String crunchifyCSV) {
        ArrayList<String> crunchifyResult = new ArrayList<String>();

        if (crunchifyCSV != null) {
            String[] splitData = crunchifyCSV.split("\\s*;\\s*");
            for (int i = 0; i < splitData.length; i++) {
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    crunchifyResult.add(splitData[i].trim());
                }
            }
        }

        return crunchifyResult;
    }

    public void seccionA(){
        conexion.delete();


        Graph grafo = new SingleGraph("SeccionA");
        for (int i = 0; i <= 13; i++){
            String dato = "" + lista.get(0).get(i);
            conexion.insert(dato.replace(" ", ""), dato);
            grafo.addNode(dato).addAttribute("ui.label", "" + lista.get(0).get(i));

        }

        for (int i = 1; i <= 13; i++){
            for (int j = 1; j <= 13; j++){
                int numero = Integer.parseInt(""+lista.get(i).get(j));
                if(numero > 0){
                    String envia = ""+lista.get(0).get(j-1);
                    String recibe = ""+lista.get(0).get(i-1);

                    edges[contador] = grafo.addEdge(envia.replace(" ", "") + recibe.replace(" ",  ""),envia,recibe);
                    edges[contador].addAttribute("length", numero);
                    edges[contador].addAttribute("label",""+edges[contador].getNumber("length"));
                    conexion.relate(envia, recibe , ""+numero );
                    contador =+ 1;
                }

            }
        }
        grafo.display();
    }

    public ArrayList<ArrayList> getLista() {
        return lista;
    }
}
