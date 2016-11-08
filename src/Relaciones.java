import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by DiegoC on 06/11/2016.
 */
public class Relaciones {

    public int[][] matrix;
    public int contador = 0, contador2 = 1;

    /**
     * CrunchifyCSVtoArrayList: Metodo que convierte documentos csv a arraylists
     */

    public static ArrayList<String> crunchifyCSVtoArrayList(String crunchifyCSV) {
        ArrayList<String> crunchifyResult = new ArrayList<String>();

        try {

            BufferedReader crunchifyBuffer = null;
            String crunchifyLine;
            FileReader fr = new FileReader("C:\\Users\\Christian12\\Desktop\\Cuarto Semestre\\Algoritmos y Estructura de Datos\\HDT-Neo4j\\src\\datos.txt");
            crunchifyBuffer = new BufferedReader(fr);


            if (crunchifyCSV != null) {
                String[] splitData = crunchifyCSV.split("\\s*;\\s*");
                for (int i = 0; i < splitData.length; i++) {
                    if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                        crunchifyResult.add(splitData[i].trim());
                    }
                }
            }

        } catch (FileNotFoundException e) {

        }return crunchifyResult;
    }

    /**
     * Matrix: crea la matriz de las relaciones entre las personas
     */

    void Matrix(){

    }




}
