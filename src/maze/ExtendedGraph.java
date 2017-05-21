import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ExtendedGraph extends Graph{

    // Båda getPath har baserat sig väldigt mycket på printPath, det är nästan rakt av, kolla på dem för att förstå

    public List<Integer> getPath(int destName) {

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

    private List<Integer> getPath(Vertex dest, List<Integer> list) {

        if (dest == null)
            return list;

        list.add(dest.name);
        return getPath(dest.prev, list);
    }

}
