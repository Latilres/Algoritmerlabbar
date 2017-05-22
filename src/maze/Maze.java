package maze;

import java.util.List;
import java.util.Observable;
import java.util.Random;

public class Maze extends Board {

    private int rows, cols;
    private Random random;
    private ExtendedGraph extendedGraph;
  		
    public Maze( int rows, int cols ) {
    	super(rows,cols);
    	this.rows = rows;
    	this.cols = cols;
    }
    
    public void create() {
        DisjointSets checkUnionSet = new DisjointSets(maxCell); // used to check if walls should be taken down or not, by checking if they belong to the same set
        int totCells = maxCell;
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

                if (isValid(closeCell)) {

                    int cellID1 = getCellId(randCell);
                    int cellID2 = getCellId(closeCell);

                    int unionID1 = checkUnionSet.find(cellID1);
                    int unionID2 = checkUnionSet.find(cellID2);

                    if (unionID1 != unionID2) { // Checks so that the sets are separate, in order to not create circles
                        checkUnionSet.union(unionID1, unionID2); // adds two sets together

                        // I think this adds a cost between the cells, so that vertexMap has something to go on..
                        extendedGraph.addEdge(cellID1,cellID2,1);
                        extendedGraph.addEdge(cellID2,cellID1,1);

                        setChanged();
                        notifyObservers(new Pair<>(cellID1, dir));
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

        // goes through all elements in the list and notify observer
        for (Integer theSteppes: thePath) {
            setChanged();
            notifyObservers(theSteppes);
        }
    }
}
