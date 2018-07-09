package texts;

import db.TableDB;
import interfaceRoot.ArgumentsTexts;
import interfaceRoot.EffectColor;
import interfaceRoot.EffectFont;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

import java.sql.*;

public class CallText implements ArgumentsTexts, TableDB
{
    private ContextMenuTexts contextMenuTexts = new ContextMenuTexts();

    protected void setText(String s){
        HBox hBox = new HBox();

        checkTable();

        scrollPane.setPrefWidth(pagination.getPrefWidth());
        text.setText(s);
        text.setFont(EffectFont.getFontTextLevel());
        text.setWrapText(true);
        text.setPadding(new Insets(10, 0, 0, 20));
        text.setPrefWidth(scrollPane.getPrefWidth()/1.055);
        text.setOnContextMenuRequested(event ->
                contextMenuTexts.menuTexts().show(text, event.getScreenX(), event.getScreenY()));

        textRU.setFont(EffectFont.getFontTextLevel());
        textRU.setWrapText(true);
        textRU.setPadding(new Insets(0, 0, 0, 0));
        textRU.setPrefWidth(0);

        hBox.setSpacing(scrollPane.getPrefWidth()*0.05);
        hBox.getChildren().addAll(text, textRU);
        scrollPane.setContent(hBox);
    }

    // Изменяем цвет названия текстов
    private void checkTable(){
        Statement statement;
        Connection connection;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT color FROM my_text WHERE id = "
                    + pagination.getCurrentPageIndex()+"+1;");
            while (resultSet.next()){
                switch (resultSet.getString("color")) {
                    case "KNOW_ON_ONE":
                        TITLE.setTextFill(EffectColor.getColorYellow());
                        break;
                    case "KNOW_ON_TWO":
                        TITLE.setTextFill(EffectColor.getColorRed());
                        break;
                    case "KNOW_ON_THREE":
                        TITLE.setTextFill(EffectColor.getColorGreen());
                        break;
                    case "KNOW_ON_FOUR":
                        TITLE.setTextFill(EffectColor.getColorBlue());
                        break;
                    case "KNOW_ON_FIVE":
                        TITLE.setTextFill(EffectColor.getColorPurple());
                        break;
                    case "black":
                        TITLE.setTextFill(EffectColor.getColorBlack());
                        break;
                }
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
