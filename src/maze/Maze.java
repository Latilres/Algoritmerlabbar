import java.util.List;
import java.util.Observable;
import java.util.Random;

public class Maze extends Board {
    // associated med DisjointSets och Pair (kan navigera från maze till de andra)
    // inherits från Board
    private int rows, cols;
    private Random random;
    private ExtendedGraph extendedGraph;
  		
    public Maze( int rows, int cols ) {
    	super(rows,cols);
    	this.rows = rows;
    	this.cols = cols;
    }
    
    public void create() {
        DisjointSets checkUnionSet = new DisjointSets(maxCell); //använd för att kolla om väggar ska slås ut eller inte, genom att kontrollera ifall de tillhör samma mängd
        int totCells = maxCell;  //antal celler, som måste sloss ihop
        random = new Random();
        extendedGraph = new ExtendedGraph();
        Point.Direction dir = Point.Direction.ERROR;

        while (totCells > 1) {

            for (int i = 0; i < 17; i++) {
                int randRow = random.nextInt(rows);
                int randCol = random.nextInt(cols);
                Point randCell = new Point(randRow, randCol);
                Point closeCell = new Point(randRow, randCol);

                // randomize direction
                int randDir = random.nextInt(4);
                if (randDir == 0)
                    dir = Point.Direction.UP;
                else if (randDir == 1)
                    dir = Point.Direction.RIGHT;
                else if (randDir == 2)
                    dir = Point.Direction.DOWN;
                else if (randDir == 3)
                    dir = Point.Direction.LEFT;

                closeCell.move(dir);
                //System.out.println("randrow: " + randRow +". randcol: " + randCol + ". dir: " + dir);

                if (isValid(closeCell)) {

                    int cellID1 = getCellId(randCell);
                    int cellID2 = getCellId(closeCell);

                    int unionID1 = checkUnionSet.find(cellID1);
                    int unionID2 = checkUnionSet.find(cellID2);

                    if (unionID1 != unionID2) {
                        checkUnionSet.union(unionID1, unionID2);
                        setChanged();
                        notifyObservers(new Pair<>(cellID1, dir));
                        //System.out.print(totCells);
                        totCells--;

                    }
                }
            }
        }

        // The ingress and egress the maze
        Pair<Integer, Point.Direction> firstCell = new Pair<>(0, Point.Direction.LEFT);
        setChanged();
        notifyObservers(firstCell);
        Pair<Integer, Point.Direction> secondCell = new Pair<>(maxCell - 1, Point.Direction.RIGHT);
        setChanged();
        notifyObservers(secondCell);
    }
    
    public void search() {
        List<Integer> thePath = extendedGraph.getPath(maxCell-1);
    }
    
//    ...
}
