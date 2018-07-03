package texts;

import db.CreateDB;
import interfaceRoot.EffectColor;
import interfaceRoot.EffectFont;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TextPanels extends CallText
{
    private ListNameText listNameText = new ListNameText();

    public void call(){
        getPagination();
    }

    private Pagination getPagination () {
        pagination.setPageFactory(this::getScroll);
        pagination.setMaxPageIndicatorCount(15);
        pagination.setLayoutX(widthSize/6);
        pagination.setLayoutY(heightSize/8);
        pagination.setPrefSize(widthSize/1.5, heightSize/1.5);

        ROOT.getChildren().addAll(pagination, listNameText.getListName(), TITLE);
        return pagination;
    }

    private ScrollPane getScroll(Integer s) {
        HBox buttonsTransfer = new HBox();

        buttonsTransfer.setLayoutX(widthSize/2.5);
        buttonsTransfer.setLayoutY(heightSize/14);
        buttonsTransfer.setSpacing(20);
        buttonsTransfer.getChildren().addAll(translation, add_my_test);
        ButtonsTransfer buttons = new ButtonsTransfer();



        for (int i = 0; i < NumberOfLines.numberOfLines(); i++) {
            if (s.byteValue()==i){
                ROOT.getChildren().remove(buttonsTransfer);
                ROOT.getChildren().add(buttonsTransfer);
                buttons.getTransfer(textRUS(i), textENG(i));
                buttons.addMyText();
                setText(textENG(i));

                TITLE.setLayoutX(widthSize/4.5);
                TITLE.setLayoutY(heightSize/14);
                TITLE.setFont(EffectFont.getFontTITLE());
                TITLE.setTextFill(EffectColor.getColorTextTITLE());
                TITLE.setText(getNameTitle(pagination.getCurrentPageIndex()+1));
            }
        }


        return scrollPane;
    }

    // Получаем название текста
    private static String getNameTitle(int n){
        ResultSet resultSet;
        String str = null;
        try {
            resultSet = CreateDB.connection().executeQuery("SELECT title_text FROM my_text WHERE id ="+ n +";");
            resultSet.next();
            str = resultSet.getString("title_text");
            resultSet.close();
            CreateDB.connection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    private String textENG(int i){
        ResultSet resultSet = null;
        String str = null;
        try {
            resultSet = CreateDB.connection().executeQuery("SELECT text_eng FROM my_text " +
                    "WHERE id = "+ (i+1) +";");
            resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            assert resultSet != null;
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
            resultSet = CreateDB.connection().executeQuery("SELECT text_rus FROM my_text " +
                    "WHERE id = "+ (i+1) +";");
            resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            assert resultSet != null;
            str = resultSet.getString("text_rus");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }
}
