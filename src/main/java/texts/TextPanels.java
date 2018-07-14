package texts;

import db.CreateDB;
import db.TableDB;
import interfaceRoot.EffectFont;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

import java.sql.*;

public class TextPanels extends CallText implements TableDB
{
    private ListNameText listNameText = new ListNameText();
    private NumberOfLines numberOfLines = new NumberOfLines();

    public void call(){
        getPagination();
    }

    private Pagination getPagination () {

        pagination.setPageFactory(this::getScroll);
        pagination.setPageCount(numberOfLines.numberOfLines());
        pagination.setMaxPageIndicatorCount(10);
        pagination.setCurrentPageIndex(0);
//        pagination.setLayoutX(widthSize/6);
//        pagination.setLayoutY(heightSize/8);
        pagination.setPrefSize(widthSize/1.5, heightSize/1.5);

        stackPaneText.getChildren().addAll(pagination);
        stackPaneText.setLayoutX(widthSize/6);
        stackPaneText.setLayoutY(heightSize/8);

        ROOT.getChildren().addAll(stackPaneText, listNameText.getListName());
        ROOT.getChildren().addAll(TITLE);

        return pagination;
    }

    private ScrollPane getScroll(Integer s) {
        HBox buttonsTransfer = new HBox();
        buttonsTransfer.setLayoutX(widthSize/2.5);
        buttonsTransfer.setLayoutY(heightSize/14);
        buttonsTransfer.setSpacing(20);
        buttonsTransfer.getChildren().addAll(translation, add_my_test);
        ButtonsTransfer buttons = new ButtonsTransfer();

        for (int i = 0; i < numberOfLines.numberOfLines(); i++) {
            if (s.byteValue()==i){

                ROOT.getChildren().remove(buttonsTransfer);
                ROOT.getChildren().add(buttonsTransfer);
                buttons.getTransfer(textRUS(i), textENG(i));
                buttons.addMyText();
                setText(textENG(i));

                TITLE.setLayoutX(widthSize/4.5);
                TITLE.setLayoutY(heightSize/14);
                TITLE.setFont(EffectFont.getFontTITLE());
//                TITLE.setTextFill(EffectColor.getColorTextTITLE());
                TITLE.setText(getNameTitle(pagination.getCurrentPageIndex()+1));

            }
        }

        return scrollPane;
    }

    // Получаем название текста
    private static String getNameTitle(int n){
        Statement statement;
        Connection connection;
        String str = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT title_text FROM my_text WHERE id ="+ n +";");
            resultSet.next();
            str = resultSet.getString("title_text");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
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
