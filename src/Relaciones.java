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
        Graph grafo = new SingleGraph("SeccionA");
        for (int i = 0; i <= 13; i++){
            grafo.addNode("" + lista.get(0).get(i));
        }



    }

    public ArrayList<ArrayList> getLista() {
        return lista;
    }
}
