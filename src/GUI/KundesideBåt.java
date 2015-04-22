package GUI;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import static javafx.geometry.Pos.TOP_CENTER;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBåt {

    public static Pane båtFane() {
        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100));

        Label lb = new Label();
        lb.setText("Her kommer det Informasjon");
        GridPane.setHalignment(lb, HPos.CENTER);

        grid.add(lb, 0, 0);

        return grid;
    }
}