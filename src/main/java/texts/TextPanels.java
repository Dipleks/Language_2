package texts;

import db.CreateDB;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TextPanels extends CallText
{
    public void call(){ getPagination(); }

    private Pagination getPagination () {
        pagination.setPageFactory(this::getScroll);
        pagination.setMaxPageIndicatorCount(15);
        pagination.setLayoutX(widthSize/6);
        pagination.setLayoutY(heightSize/8);
//        pagination.setMinHeight(heightSize-300);
//        pagination.setMinWidth(widthSize-180);
        pagination.setPrefSize(widthSize/1.5, heightSize/1.5);

        ROOT.getChildren().addAll(pagination);

        return pagination;
    }

    private ScrollPane getScroll(Integer s) {
        HBox buttonsTransfer = new HBox();
        buttonsTransfer.setLayoutX(widthSize/2.5);
        buttonsTransfer.setLayoutY(heightSize/14);
        buttonsTransfer.setSpacing(20);
        buttonsTransfer.getChildren().addAll(translation, origin_translation);
        ButtonsTransfer buttons = new ButtonsTransfer();

        for (int i = 0; i < NumberOfLines.numberOfLines(); i++) {
            if (s.byteValue()==i){
                ROOT.getChildren().remove(buttonsTransfer);
                ROOT.getChildren().add(buttonsTransfer);
                buttons.getTransfer(textRUS(i), textENG(i));
                buttons.addMyText();
                setText(textENG(i));
            }
        }
        return scrollPane;
    }

    private String textENG(int i){
        ResultSet resultSet = null;
        String str = null;
        try {
            resultSet = CreateDB.connection().executeQuery("SELECT text_eng FROM my_text WHERE id = "+ (i+1) +";");
            resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            str = resultSet.getString("text_eng");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }
    private String textRUS(int i){
        ResultSet resultSet = null;
        String str = null;
        try {
            resultSet = CreateDB.connection().executeQuery("SELECT text_rus FROM my_text WHERE id = "+ (i+1) +";");
            resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            str = resultSet.getString("text_rus");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }
}
