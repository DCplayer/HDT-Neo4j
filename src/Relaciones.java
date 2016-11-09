import org.graphstream.algorithm.Dijkstra;
import org.graphstream.algorithm.Dijkstra.*;
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
    public Graph grafo = new SingleGraph("SeccionA");
    public int contador = 0;
    public Connect conexion = new Connect();
    public Graph grafoMinimo;

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
    
    void pageRank(){
        pageRank.setVerbose(true);
        pageRank.init(graph);
        for (int i=0;i<=13;i++){
            double rank = pageRank.getRank(nodos[i]);
            nodos[i].addAttribute("ui.size", 5 + Math.sqrt(graph.getNodeCount() * rank * 20));
            nodos[i].addAttribute("ui.label", String.format("%.2f%%", rank * 100)+" "+nombres[i]);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * seccionA: Metodo que grafica los nodos del texto recibido y sus aristas
     */
    public void seccionA(){
        conexion.delete();



        for (int i = 0; i <= 13; i++){
            String dato = "" + lista.get(0).get(i);
            String nuevoDato = dato.replace(" ", "");
            conexion.insert(nuevoDato, nuevoDato);
            grafo.addNode(nuevoDato).addAttribute("ui.label", nuevoDato);

        }

        for (int i = 1; i <= 13; i++){
            for (int j = 1; j <= 13; j++){
                int numero = Integer.parseInt(""+lista.get(i).get(j));
                if(numero > 0){
                    String envia = ""+lista.get(0).get(j-1);
                    String enviador = envia.replace(" ", "");
                    String recibe = ""+lista.get(0).get(i-1);
                    String recibidor = recibe.replace(" " ,"");

                    edges[contador] = grafo.addEdge(enviador + recibidor,enviador ,recibidor);
                    edges[contador].addAttribute("length", numero);
                    edges[contador].addAttribute("label",""+edges[contador].getNumber("length"));
                    conexion.relate(recibidor,enviador, ""+numero );
                    contador =+ 1;
                }

            }
        }
        grafo.display(true);
    }


    /**
     * seccionf: Metodo para encontrar la distancia mas corta, en correos, entre 2 usuairos
     * @param A Usuario de origen, el que envia los correos
     * @param B Usuario de llegada, el que recibe los correos
     * @return el numero de correos minimo que llevo desde A hasta B
     *
     * Codigo Derivado de http://graphstream-project.org/doc/Algorithms/Shortest-path/Dijkstra/1.0/
     */
    public double seccionf(String A, String B){
        Dijkstra algoritmo = new Dijkstra(Dijkstra.Element.EDGE, null, "length");
        algoritmo.init(grafoMinimo);
        algoritmo.setSource(grafo.getNode(A));
        algoritmo.compute();
        return algoritmo.getPathLength(grafo.getNode(B));
    }
    /**
     * Metodo que devuelve matriz de relaciones del .txt ingresado
     * @return ArrayList con matriz de relaciones
     */
    public ArrayList<ArrayList> getLista() {
        return lista;
    }
}
