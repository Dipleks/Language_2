package texts;

import control.ClearDisplay;
import control.MenuBarEngRus;
import db.TableDB;
import interfaceRoot.ArgumentsTexts;
import interfaceRoot.EffectFont;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

class ContextMenuTexts implements ArgumentsTexts, TableDB
{
    private MenuItem menuEditTexts = new MenuItem("Редактировать");
    private SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
//    private MenuItem KNOW_ON_ONE = new MenuItem();
//    private MenuItem KNOW_ON_TWO = new MenuItem();
//    private MenuItem KNOW_ON_THREE = new MenuItem();
//    private MenuItem KNOW_ON_FOUR = new MenuItem();
//    private MenuItem KNOW_ON_FIVE = new MenuItem();
    private Stage panelEditTexts = new Stage();
    private EventsColorMenuTexts events = new EventsColorMenuTexts();

    // Контекстное меню "Текстов"
    ContextMenu menuTexts(){
        ContextMenu contextMenuTexts = new ContextMenu();
        menuEdit();
        getMenuContainerColor();
        events.getEvents();

        contextMenuTexts.getItems().addAll(menuEditTexts, separatorMenuItem, yellow, red, green, blue, purple, black);
        return contextMenuTexts;
    }

    // Контестное меню "цветовых панелей"
    private void getMenuContainerColor(){
        String pref = "-fx-pref-width: 30;";

        yellow.setStyle("-fx-background-color: yellow;" + pref);
        red.setStyle("-fx-background-color: red;" + pref);
        green.setStyle("-fx-background-color: green;" + pref);
        blue.setStyle("-fx-background-color: blue;" + pref);
        purple.setStyle("-fx-background-color: purple;" + pref);
        black.setStyle("-fx-background-color: black;" + pref);
    }

    // Действие контекстного меню текстов "Редактирование"
    private void menuEdit() {
        menuEditTexts.setOnAction(e -> {

            VBox vBox = new VBox();

            textEdit.setText(getTextEN());
            textEditRU.setText(getTextRu());
            textEdit.setPrefSize(widthSize/2.5, heightSize/2);
            textEditRU.setPrefSize(widthSize/2.5, heightSize/2);
            textEdit.setWrapText(true);
            textEditRU.setWrapText(true);

            saveEdit();

            HBox groupLabelAndText = new HBox();
            groupLabelAndText.setSpacing(10);
            groupLabelAndText.getChildren().addAll(editNameText, editName);
            editName.setText(getTextName());
            editNameText.setFont(EffectFont.getFontText());

            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(10);
            vBox.setPadding(new Insets(10, 10, 10, 10));
            vBox.getChildren().addAll(groupLabelAndText, textEdit, textEditRU, editText);

            Scene scene = new Scene(vBox, widthSize/1.5, heightSize/1.9);
            panelEditTexts.setScene(scene);
            panelEditTexts.setTitle("Редактирование текста");
            panelEditTexts.show();
        });
    }

    // Действие кнопки "Сохранить изменения"
    private void saveEdit(){
        editText.setOnAction(event -> {
            VBox vBox = new VBox();
            HBox hBox = new HBox();
            Label label = new Label("Вы уверны?");
            Scene scene = new Scene(vBox, widthSize/5, heightSize/7);

            ok_cancel();

            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(20);
            hBox.getChildren().addAll(OK, CANCEL);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(20);
            vBox.getChildren().addAll(label, hBox);

            SAVE_EDIT.setTitle("Сохранить?");
            SAVE_EDIT.setScene(scene);
            SAVE_EDIT.show();
        });
    }

    // Действие кнопок OK и CANCEL:
    private void ok_cancel(){
        OK.setOnAction(event -> {
            Statement statement;
            Connection connection;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE my_text SET title_text = '" + editName.getText()
                        + "', text_eng = '"+ textEdit.getText()+"', text_rus = '"+ textEditRU.getText()
                        + "' WHERE id = "+ pagination.getCurrentPageIndex()+"+1;");
                statement.close();
                connection.close();

                nameText.clear();
                textRus.clear();
                textEng.clear();

                ClearDisplay.clearMethod();
                MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
                menuBarEngRus.getMenu();
                TextPanels textPanels = new TextPanels();
                textPanels.call();

                SAVE_EDIT.close();
                panelEditTexts.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        });
        CANCEL.setOnAction(event -> {
            SAVE_EDIT.close();
        });
    }

    private String getTextEN(){
        String s = null;
        Statement statement;
        Connection connection;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT text_eng FROM my_text WHERE id = "
                    + (pagination.getCurrentPageIndex()+1) + ";");
            resultSet.next();
            s = resultSet.getString("text_eng");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
    private String getTextRu(){
        String s = null;
        Statement statement;
        Connection connection;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT text_rus FROM my_text WHERE id = "
                    + (pagination.getCurrentPageIndex()+1) + ";");
            resultSet.next();
            s = resultSet.getString("text_rus");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }
    private String getTextName(){
        String s = null;
        Statement statement;
        Connection connection;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT title_text FROM my_text WHERE id = "
                    + (pagination.getCurrentPageIndex()+1) + ";");
            resultSet.next();
            s = resultSet.getString("title_text");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }

    /*
DELETE FROM my_text
WHERE id = 7;
INSERT INTO my_text (title_text, text_eng, text_rus)
VALUES ('hello', 'hELLO', 'ПРИВЕТ');
ALTER SEQUENCE my_text_id_seq
RESTART WITH 1;
SELECT * FROM my_text;
*/
}
