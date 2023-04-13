import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExitBox {

    static boolean answer;


    public static boolean display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.getChildren().addAll(noButton, yesButton);
        hb.setAlignment(Pos.CENTER);

        VBox vb = new VBox(10);
        vb.getChildren().addAll(label, hb);
        vb.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vb, 300, 200);
        scene.getStylesheets().add("Style.css");
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();

        return answer;

    }

}
