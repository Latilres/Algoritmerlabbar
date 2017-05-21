import java.util.List;
import java.util.NoSuchElementException;

public class ExtendedGraph extends Graph{

    //skall returnera en lista innehållande den senaste vägen från start- till destinationsnod som hittades med grafsökningsalgoritmen.
    public List<Integer> getPath(int destName) {

        return getPath(vertexMap.get(destName));
    }

    // Den privata metoden skall vara rekursiv och fungera självständigt utan hjälp av extra instans- eller klassvariabler.
    // Tips: i basklassen finns funktionen printPath som delvis kan användas som förebild
    private List<Integer> getPath(Vertex dest) {
        if (dest == null)
            throw new NoSuchElementException("The destination is null");
        else if (dest.dist == INFINITY)
            System.out.println(dest.name + " is unreachable");
        else {

        }
        return null;
    }

}
