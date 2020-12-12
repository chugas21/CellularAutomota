package elementaryCA.backend.grid;

import elementaryCA.backend.cell.Cell;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import java.util.List;

public class Grid1D {
    // Used by JavaFX to display the visualization
    private final GridPane GRID_PANE;
    // 8 bit string representing the behavior of the CA
    private final String BEHAVIOR;
    // Width/height of cell
    private final double CELL_SIZE;

    // Current generation of cells
    private List<Cell> currentGen;
    // Current generation (row) being shown to the screen
    private int currentGenIndex;

    private List<Cell> nextGen;

    List<Cell> ruleset = new ArrayList<>();

    //   private Cell[] ruleset = new Cell[] {0,0,0,1,1,1,1,0};



    public Grid1D(GridPane gridPane,
                  String behavior,
                  List<Cell> currentGen,
                  double cellSize) {
        this.GRID_PANE = gridPane;
        this.BEHAVIOR = behavior;
        behavior = "00011110";
        this.currentGen = currentGen;
        this.CELL_SIZE = cellSize;
        this.currentGenIndex = 0;
        // Show the initial generation to the screen
        show();
    }

    /**
     * TODO: Fill in the logic below
     * I would suggest starting off by hard coding one of the rules,
     * such as rule 30, then generalize from there.
     * This function evolves the current generation to the next generation
     * using the current rule set given by the behavior string.
     */




    private Cell rules(Cell a, Cell b, Cell c){
            if      (a == Cell.fromChar('1') && b == Cell.fromChar('1') && c == Cell.fromChar('1')) return Cell.WHITE;
            else if (a == Cell.fromChar('1') && b == Cell.fromChar('1') && c == Cell.fromChar('0')) return Cell.WHITE;
            else if (a == Cell.fromChar('1') && b == Cell.fromChar('0') && c == Cell.fromChar('1')) return Cell.WHITE;
            else if (a == Cell.fromChar('1') && b == Cell.fromChar('0') && c == Cell.fromChar('0')) return Cell.BLACK;
            else if (a == Cell.fromChar('0') && b == Cell.fromChar('1') && c == Cell.fromChar('1')) return Cell.BLACK;
            else if (a == Cell.fromChar('0') && b == Cell.fromChar('1') && c == Cell.fromChar('0')) return Cell.BLACK;
            else if (a == Cell.fromChar('0') && b == Cell.fromChar('0') && c == Cell.fromChar('1')) return Cell.BLACK;
            else if (a == Cell.fromChar('0') && b == Cell.fromChar('0') && c == Cell.fromChar('0')) return Cell.WHITE;
            return Cell.WHITE;

    }


    private void evolve() {


            String s = "00011110";

            int index = Integer.parseInt(s,2);

            System.out.println(index);

        List<Cell> cellArray = new ArrayList<>();
        Cell[] cells = new Cell[cellArray.size()];
        cellArray.toArray(cells);

        Cell[] nextGen = new Cell[cells.length];
        for (int i = 1; i < cells.length-1; i++) {
            Cell left   = cells[i-1];
            Cell me     = cells[i];
            Cell right  = cells[i+1];
            nextGen[i] = rules(left, me, right);
            System.out.println(nextGen[i]);
        }



    }
    /**
     * This function shows the current generation to the JavaFX window
     */
    private void show() {
        int colIndex = 0;
        // Create new rectangles to show for the current generation
        for (Cell cell : currentGen) {
            // Create a rectangle to represent the cell
            Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE, cell.getColor());
            // Add it to the JavaFX graph
            GRID_PANE.add(rect, colIndex, currentGenIndex);
            // Tell it where to show it on the screen
            //GridPane.setConstraints(rect, );
            // Go to the next cell
            colIndex++;
        }
        currentGenIndex++;
    }

    /**
     * This function advances the state of the class to the next generation.
     * It then shows this new generation to the Java FX window.
     */
    public void nextGeneration() {
        evolve();
        show();
    }
}
