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
                System.out.println("Raw CSV data: " + crunchifyLine);
                System.out.println("Converted ArrayList data: " + crunchifyCSVtoArrayList(crunchifyLine) + "\n");
                lista.add(crunchifyCSVtoArrayList(crunchifyLine));
                System.out.println(lista);


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






}
