import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Node;


/**
 * Created by Christian12 on 06/11/2016.
 */
public class Relaciones {

    public static void main(String args[]) {

        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        Graph graph = new SingleGraph("Tutorial 1");

        Node a = graph.addNode("A");
        Node b = graph.addNode("B");

        a.setAttribute("xy", 0, 0);
        a.setAttribute("xy", 1, 1);

        graph.addEdge("AB", "A", "B", true);
        graph.addEdge("BA", "B", "A", true);

        graph.display(true);
        //graph.display();
    }
}
