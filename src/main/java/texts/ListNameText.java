package texts;

import control.ClearDisplay;
import control.MenuBarEngRus;
import db.CreateDB;
import interfaceRoot.ArgumentsTexts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import java.sql.ResultSet;
import java.sql.SQLException;

import static texts.MaxCountText.getCountTable;

class ListNameText implements ArgumentsTexts
{

    ChoiceBox<NameText> getListName() {

        listName.setLayoutX(widthSize/1.5);
        listName.setLayoutY(heightSize/14);
        listName.setItems(listName());
        listName.setOnAction(event -> pagination.setCurrentPageIndex(getNumberText()-1));
        return listName;
    }

    // Получаем список названий текстов:
    private ObservableList<NameText> listName() {
        NameText[] title = new NameText[1000];
        ObservableList<NameText> list = FXCollections.observableArrayList();
        ResultSet resultSet;
        String str;
        try {
            resultSet = CreateDB.connection().executeQuery("SELECT title_text FROM my_text;");

            for (int i = 0; i < getCountTable(); i++) {
                resultSet.next();
                str = resultSet.getString("title_text");
                title[i] = new NameText(str);
                list.add(title[i]);
            }
            listName.setValue(title[0]);
            resultSet.close();
            CreateDB.connection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Получаем номер текста
    int getNumberText(){
        ResultSet resultSet;
        int number = 0;
        try {
            resultSet = CreateDB.connection().executeQuery("SELECT id FROM my_text WHERE title_text = '"+ listName.getValue() +"';");
            while (resultSet.next()){
                number = resultSet.getInt("id");
            }
            resultSet.close();
            CreateDB.connection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }
}
