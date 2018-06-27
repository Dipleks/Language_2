package texts;

import db.CreateDB;
import interfaceRoot.ArgumentsTexts;
import interfaceRoot.EffectFont;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ButtonsTransfer implements ArgumentsTexts, Texts
{
    private Stage panelAddText = new Stage();

    Button getTransfer(String rusText, String engText) {
        translation.setOnAction(e -> {
            if (text.getText().equals(engText)) {
                text.setPrefWidth(scrollPane.getPrefWidth()/1.055);
                textRU.setPrefWidth(0);
                textRU.setText("");
                text.setText(rusText);
            } else if (text.getText().equals(rusText)) {
                text.setPrefWidth(scrollPane.getPrefWidth()/1.055);
                textRU.setPrefWidth(0);
                textRU.setText("");
                text.setText(engText);
            }
        });
        return translation;
    }

    Button addMyText() {
        origin_translation.setOnAction(e -> {

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
        return origin_translation;
    }
    private void getNewText() {
        addNewText.setOnAction(event -> {

            if(!nameText.getText().equals("") & !textEng.getText().equals("") & !textRus.getText().equals("")) {
                try {
                    // TODO добавить авто замену одинарных ковычик на опостроф при получении текста из TextArea
                    // TODO и обратную замену при выводе на экран
                    CreateDB.connection().executeUpdate("INSERT INTO my_text (title_text, text_eng, text_rus) " +
                            "VALUES ('" + nameText.getText() + " ', '" + textEng.getText() + "', '" + textRus.getText() + "');");
                    nameText.clear();
                    textRus.clear();
                    textEng.clear();
                    panelAddText.close();
                    CreateDB.connection().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Заполните все поля!");
            }

        });
    }

    // TODO создать методы удаления текста (с обновлением счетчика ALTER SEQUENCE my_text_id_seq RESTART WITH 1;)
    // TODO и метод оглавления
}