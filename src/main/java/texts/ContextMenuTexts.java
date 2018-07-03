package texts;

import db.CreateDB;
import interfaceRoot.ArgumentsTexts;
import interfaceRoot.EffectFont;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContextMenuTexts implements ArgumentsTexts
{
    private MenuItem menuEditTexts = new MenuItem("Редактировать");
    private Stage panelEditTexts = new Stage();

    ContextMenu menuTexts(){
        ContextMenu contextMenuTexts = new ContextMenu();
        menuEdit();

        contextMenuTexts.getItems().addAll(menuEditTexts);
        return contextMenuTexts;
    }

    private MenuItem menuEdit() {
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

//            getNewText();

            Scene scene = new Scene(vBox, widthSize/1.5, heightSize/1.9);
            panelEditTexts.setScene(scene);
            panelEditTexts.setTitle("Редактирование текста");
//            panelEditTexts.initModality(Modality.APPLICATION_MODAL);
            panelEditTexts.show();


        });
        return menuEditTexts;
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
            try {
                CreateDB.connection().executeUpdate("UPDATE my_text SET title_text = '" + editName.getText() + "', text_eng = '"+ textEdit.getText()+"', text_rus = '"+ textEditRU.getText()+"' WHERE id = "+ pagination.getCurrentPageIndex()+"+1;");
                CreateDB.connection().close();
                SAVE_EDIT.close();
                panelEditTexts.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        CANCEL.setOnAction(event -> {
            SAVE_EDIT.close();
        });
    }

    private String getTextEN(){
        String s = null;
        try {
            ResultSet resultSet = CreateDB.connection().executeQuery("SELECT text_eng FROM my_text WHERE id = " + (pagination.getCurrentPageIndex()+1) + ";");
            CreateDB.connection().close();
            resultSet.next();
            s = resultSet.getString("text_eng");
            resultSet.close();
            CreateDB.connection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
    private String getTextRu(){
        String s = null;
        try {
            ResultSet resultSet = CreateDB.connection().executeQuery("SELECT text_rus FROM my_text WHERE id = " + (pagination.getCurrentPageIndex()+1) + ";");
            CreateDB.connection().close();
            resultSet.next();
            s = resultSet.getString("text_rus");
            resultSet.close();
            CreateDB.connection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
    private String getTextName(){
        String s = null;
        try {
            ResultSet resultSet = CreateDB.connection().executeQuery("SELECT title_text FROM my_text WHERE id = " + (pagination.getCurrentPageIndex()+1) + ";");
            CreateDB.connection().close();
            resultSet.next();
            s = resultSet.getString("title_text");
            resultSet.close();
            CreateDB.connection().close();
        } catch (SQLException e) {
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
