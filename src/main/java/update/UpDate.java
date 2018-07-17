package update;

import db.TableDB;
import interfaceRoot.ArgumentsUpdate;
import interfaceRoot.EffectFont;
import interfaceRoot.Run;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpDate implements ArgumentsUpdate, TableDB
{
    private Label textUp = new Label();
    private HBox gr = new HBox();
    private CheckBox checkBox = new CheckBox();
    private Label label = new Label("Если Вы уже обновлялись,то поставте галочку!");

    public UpDate() {
    }

    void getUpdate(String text){

        checkBox.setOnAction(event -> {
            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE settings SET actions = 'done' WHERE id = 11;");
                statement.close();
                connection.close();
                stage.close();
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("галочка установлена! UpDate.getUpdate");
                e.printStackTrace();
            }
        });

        gr.setLayoutX(scene.getWidth()/18);
        gr.setLayoutY(scene.getHeight()/1.15);
        gr.getChildren().addAll(checkBox, label);
        update.setLayoutX(scene.getWidth()/1.3);
        update.setLayoutY(scene.getHeight()/1.2);
        update.setPrefSize(scene.getWidth()/8, scene.getHeight()/10);

        getTextUpdate(text);

        group.getChildren().addAll(update, textUp, gr);

        stage.setScene(scene);
        WINDOW.show();
        stage.show();

    }

    private void getTextUpdate(String text){
        textUp.setText(text);
//        textUp.setStyle("-fx-border-color: RED");
        textUp.setLayoutX(scene.getWidth()/10);
        textUp.setLayoutY(scene.getHeight()/8);
        textUp.setPrefSize(scene.getWidth()/1.3, scene.getHeight()/2);
        textUp.setWrapText(true);
        textUp.setAlignment(Pos.CENTER_LEFT);
        textUp.setFont(EffectFont.getFontTextUpDate());

    }

}
