package texts;

import db.TableDB;
import interfaceRoot.ArgumentsSettings;
import interfaceRoot.EffectColor;
import interfaceRoot.EffectFont;
import interfaceRoot.EffectShadow;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.sql.*;

class TextPanels extends CallText implements TableDB, ArgumentsSettings
{
    private ListNameText listNameText = new ListNameText();

    void call(){
        getScroll();
    }

    private ScrollPane getScroll() {

        HBox buttonsTransfer = new HBox();
        buttonsTransfer.setLayoutX(widthSize/2.5);
        buttonsTransfer.setLayoutY(heightSize/14);
        buttonsTransfer.setSpacing(20);
        buttonsTransfer.getChildren().addAll(translation, add_my_test);
        ButtonsTransfer buttons = new ButtonsTransfer();

        scrollPane.setPrefSize(widthSize/1.5, heightSize/1.5);
        scrollPane.setLayoutX(widthSize/6);
        scrollPane.setLayoutY(heightSize/8);
        String colorStr = Integer.toHexString(sceneColorL.getValue().hashCode()).substring(0, 6).toUpperCase();
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: #"
                + colorStr +";");
        scrollPane.setEffect(EffectShadow.getShadow());

        ROOT.getChildren().remove(buttonsTransfer);
        ROOT.getChildren().add(buttonsTransfer);
        buttons.getTransfer();
        buttons.addMyText();
        setText(textENG());

        TITLE.setLayoutX(widthSize/4.5);
        TITLE.setLayoutY(heightSize/14);
        TITLE.setEffect(EffectShadow.getShadow());
        TITLE.setFont(EffectFont.getFontTITLE());
//                TITLE.setTextFill(EffectColor.getColorTextTITLE());
        TITLE.setText(getNameTitle());
//        getColorTitle();
        ColorTitle colorTitle = new ColorTitle();
        colorTitle.getColorTitle();

        ROOT.getChildren().addAll(scrollPane, listNameText.getListName(), TITLE);
        return scrollPane;
    }

    // Получаем название текста
    private static String getNameTitle(){
        Statement statement;
        Connection connection;
        String str = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT title_text FROM my_text " +
                    "WHERE id = 1;");
            while (resultSet.next()) {
                str = resultSet.getString("title_text");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return str;
    }

    private String textENG(){
        ResultSet resultSet;
        String str = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT text_eng FROM my_text " +
                    "WHERE id = 1;");
            resultSet.next();
            str = resultSet.getString("text_eng");

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return str;
    }
}
