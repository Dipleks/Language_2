package texts;

import db.TableDB;
import interfaceRoot.ArgumentsTexts;
import interfaceRoot.EffectColor;
import interfaceRoot.EffectShadow;
import interfaceRoot.StyleButton;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import java.sql.*;
import static texts.MaxCountText.getCountTable;

class ListNameText implements ArgumentsTexts, TableDB
{

    ChoiceBox<NameText> getListName() {

        listName.setStyle(StyleButton.getStyleButton());
        listName.setEffect(EffectShadow.getShadow());
        listName.setLayoutX(widthSize/1.5);
        listName.setLayoutY(heightSize/14);
        listName.setItems(listName());
        listName.setOnAction(event -> {
            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM my_text " +
                        "WHERE title_text = '"+ listName.getValue() +"' ORDER BY id;");
                while (resultSet.next()) {
                    text.setText(resultSet.getString("text_eng"));
                    TITLE.setText(resultSet.getString("title_text"));
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            ColorTitle colorTitle = new ColorTitle();
            colorTitle.getColorTitle();
        });
        return listName;
    }

    // Получаем список названий текстов:
    private ObservableList<NameText> listName() {
        NameText[] title = new NameText[1000];
        String str;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM my_text ORDER BY id;");
            while (resultSet.next()) {
                str = resultSet.getString("title_text");
                int a = resultSet.getInt("id");
                title[(a-1)] = new NameText(str);
                list.add(title[(a-1)]);
            }
            listName.setValue(title[0]);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
