package texts;

import control.ClearDisplay;
import control.MenuBarEngRus;
import db.CreateDB;
import db.TableDB;
import interfaceRoot.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

class ButtonsTransfer implements ArgumentsTexts, TableDB
{
    private Stage panelAddText = new Stage();

    Button getTransfer() {
        translation.setStyle(StyleButton.getStyleButton());
        translation.setEffect(EffectShadow.getShadow());
        translation.setOnAction(e -> {
            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM my_text " +
                        "WHERE title_text = '"+ listName.getValue() +"' ORDER BY id;");
                resultSet.next();
                if (text.getText().equals(resultSet.getString("text_eng"))){
                    text.setText(resultSet.getString("text_rus"));
                } else {
                    text.setText(resultSet.getString("text_eng"));
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        return translation;
    }

    Button addMyText() {
        add_my_test.setStyle(StyleButton.getStyleButton());
        add_my_test.setEffect(EffectShadow.getShadow());
        add_my_test.setOnAction(e -> {

            VBox vBox = new VBox();

            textEng.setPromptText("Вставте Английский текст");
            textRus.setPromptText("Вставте Русский текст");
            textEng.setPrefSize(widthSize/2.5, heightSize/3);
            textRus.setPrefSize(widthSize/2.5, heightSize/3);
            textEng.setWrapText(true);
            textRus.setWrapText(true);

            HBox groupLabelAndText = new HBox();
            groupLabelAndText.setSpacing(10);
            groupLabelAndText.getChildren().addAll(addNameText, nameText);
            nameText.setPromptText("Название текста");
            addNameText.setFont(EffectFont.getFontText());

            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(10);
            vBox.setPadding(new Insets(10, 10, 10, 10));
            vBox.getChildren().addAll(groupLabelAndText, textEng, textRus, addNewText);

            getNewText();

            Scene scene = new Scene(vBox, widthSize/1.5, heightSize/1.5);
            panelAddText.setScene(scene);
            panelAddText.setTitle("Добавить свой текскт");
//            panelAddText.initModality(Modality.APPLICATION_MODAL);
            panelAddText.show();
        });
        return add_my_test;
    }
    private void getNewText() {
        addNewText.setStyle(StyleButton.getStyleButton());
        addNewText.setOnAction(event -> {

            if(!nameText.getText().equals("") & !textEng.getText().equals("") & !textRus.getText().equals("")) {
                Statement statement;
                Connection connection;
                try {
                    // TODO добавить авто замену одинарных ковычик на опостроф при получении текста из TextArea
                    // TODO и обратную замену при выводе на экран

                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
                    statement = connection.createStatement();
                    statement.executeUpdate("INSERT INTO my_text (title_text, text_eng, text_rus, color) "
                            + "VALUES ('" + nameText.getText() + " ', '" + textEng.getText() + "', '"
                            + textRus.getText() + "', 'black');");
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

                    panelAddText.close();
                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println("ошибка после добавления текста");
                }
            } else {
                System.out.println("Заполните все поля!");
            }
        });
    }

    // TODO создать методы удаления текста (с обновлением счетчика ALTER SEQUENCE my_text_id_seq RESTART WITH 1;)
}
