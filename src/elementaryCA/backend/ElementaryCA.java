package elementaryCA.backend;

import elementaryCA.backend.cell.Cell;
import elementaryCA.backend.grid.Grid1D;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;



public class ElementaryCA extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("1D Cellular Automata");

        GridPane root = new GridPane();
        double width = 1200;
        double height = 1000;
        Scene scene = new Scene(root, width, height);

        primaryStage.setScene(scene);
        primaryStage.show();

        String firstGenStr = "00000000100000000";
        List<Character> chars = new ArrayList<>();

        for (char ch: firstGenStr.toCharArray()) {
            chars.add(ch);
        }
        for(int i=0;i<chars.size();i++){
            System.out.println(chars.get(i));
        }

        List<Cell> firstGen = new ArrayList<>();

        for(int i=0;i<chars.size();i++){
            firstGen.add(Cell.fromChar(chars.get(i)));
        }

        for(int i=0;i<chars.size();i++){
            System.out.println(firstGen.get(i));
        }

        // TODO: Turn the firstGen string into a list of cells
        Grid1D grid = new Grid1D(root, "00011110", firstGen, 50);
        Runner.run(grid);
    }
}
