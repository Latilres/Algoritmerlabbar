import java.util.Observable;
import java.util.Random;

public class Maze extends Board {
    // associated med DisjointSets och Pair (kan navigera från maze till de andra)
    // inherits från Board
    private int rows, cols;
    private Random random;
  		
    public Maze( int rows, int cols ) {
    	super(rows,cols);
    	this.rows = rows;
    	this.cols = cols;
    }
    
    public void create() {

        random = new Random();
        Pair<Point, Point.Direction> theCell = new Pair<>(new Point(0,0), Point.Direction.LEFT);
        setChanged();
        notifyObservers(theCell);
        Pair<Point, Point.Direction> theCell2 = new Pair<>(new Point(rows-1, cols-1), Point.Direction.RIGHT);
        setChanged();
        notifyObservers(theCell2);

        for (int i = 0; i < 17; i++) {
            int randRow = random.nextInt(rows-1);
            int randCol = random.nextInt(cols-1);
            Point randCell = new Point(randRow, randCol);
            Point closeCell = new Point(randRow, randCol);
            int randDir = random.nextInt(4);
            if (randDir == 0)
                closeCell.move(Point.Direction.UP);
            else if (randDir == 1)
                closeCell.move(Point.Direction.RIGHT);
            else if (randDir == 2)
                closeCell.move(Point.Direction.DOWN);
            else if (randDir == 3)
                closeCell.move(Point.Direction.LEFT);

            if (isValid(closeCell)) {
                Pair<Point, Point.Direction> theCell3 = new Pair<>(randCell, closeCell.getDirection(randCell));
                System.out.println(closeCell.getDirection(randCell));
                setChanged();
                notifyObservers(theCell3);
            }
        }

        // klura ut hur vi håller koll på cellerna så att vi inte får cykler

        // se till att alla celler kan nå alla andra, utan cykler








    }
    
    public void search() {
//    	 Implement this method!
    }
    
//    ...
}
