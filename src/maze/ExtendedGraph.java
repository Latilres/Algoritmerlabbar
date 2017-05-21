import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ExtendedGraph extends Graph{

    //skall returnera en lista innehållande den senaste vägen från start- till destinationsnod som hittades med grafsökningsalgoritmen.
    public List<Integer> getPath(int destName) {

        System.out.println(vertexMap.get(0));
        unweighted(0);
        Vertex vertex = vertexMap.get(destName);

        if (vertex == null)
            throw new NoSuchElementException("The destination was not found");
        else if( vertex.dist == INFINITY )
            System.out.println( destName + " is unreachable" );
        else {
            List<Integer> l = new ArrayList<>();
            return getPath(vertex, l);
        }
        return null;
    }

    // Den privata metoden skall vara rekursiv och fungera självständigt utan hjälp av extra instans- eller klassvariabler.
    // Tips: i basklassen finns funktionen printPath som delvis kan användas som förebild
    private List<Integer> getPath(Vertex dest, List<Integer> list) {

        if (dest == null)
            return list;

        list.add(dest.name);
        return getPath(dest.prev, list);
    }

}
