package texts;

import db.TableDB;
import interfaceRoot.ArgumentsTexts;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import java.sql.*;
import static texts.MaxCountText.getCountTable;

class ListNameText implements ArgumentsTexts, TableDB
{

    ChoiceBox<NameText> getListName() {

//        ROOT.getChildren().remove(listName);
        listName.setLayoutX(widthSize/1.5);
        listName.setLayoutY(heightSize/14);
        listName.setItems(listName());
        listName.setOnAction(event -> pagination.setCurrentPageIndex(getNumberText()-1));
        return listName;
    }

    // Получаем список названий текстов:
    private ObservableList<NameText> listName() {
        NameText[] title = new NameText[1000];

        Statement statement;
        Connection connection;
        String str;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT title_text FROM my_text;");

            for (int i = 0; i < getCountTable(); i++) {
                resultSet.next();
                str = resultSet.getString("title_text");
                title[i] = new NameText(str);
                list.add(title[i]);
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

    // Получаем номер текста
    int getNumberText(){

        Statement statement;
        Connection connection;
        int number = 0;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL + db, USER, PASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM my_text WHERE title_text = '"+ listName.getValue() +"';");
            while (resultSet.next()){
                number = resultSet.getInt("id");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return number;
    }
}
