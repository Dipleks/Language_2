package myWords;

import db.CreateDB;
import interfaceRoot.ArgumentsMyWords;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import java.sql.ResultSet;
import java.sql.SQLException;

class ListCategory implements ArgumentsMyWords
{
    private ChoiceBox<CategoryWords> categoryWordsChoiceBox = new ChoiceBox<>();
    private static CategoryWords it = new CategoryWords("Программирование");
    private static CategoryWords medical = new CategoryWords("Медицина");
    private static CategoryWords architecture = new CategoryWords("Архитектура");
    private static CategoryWords biologe = new CategoryWords("Анатомия");
    private static CategoryWords geogragh = new CategoryWords("География");
    private static CategoryWords nature = new CategoryWords("Природа");
    private static CategoryWords things = new CategoryWords("Вещи");
    private static CategoryWords other = new CategoryWords("Другое");

    private ObservableList<CategoryWords> list = FXCollections.observableArrayList(it, medical, architecture,
            biologe, geogragh, nature, things, other);

    ChoiceBox<CategoryWords> addCategory(){

        categoryWordsChoiceBox.setItems(list);
        categoryWordsChoiceBox.setValue(other);

        return categoryWordsChoiceBox;
    }

    ChoiceBox<CategoryWords> getCategory(){

        categoryWordsChoiceBox.setItems(list);
        categoryWordsChoiceBox.setValue(other);
        categoryWordsChoiceBox.setOnAction(event -> {
            try {
                ResultSet r = CreateDB.connection().executeQuery("SELECT word_en FROM my_words");
                for (int i = 0; r.next(); i++) {
                    leftC.getChildren().remove(my_word_en[i]);
                    rightC.getChildren().remove(my_word_ru[i]);
                }
                ResultSet rs1 = CreateDB.connection().executeQuery("SELECT word_en FROM (SELECT DISTINCT id, word_en, word_ru " +
                        "FROM my_words WHERE category = '" + categoryWordsChoiceBox.getValue() + "') AS foo ORDER BY id;");
                ResultSet rs2 = CreateDB.connection().executeQuery("SELECT word_ru FROM (SELECT DISTINCT id, word_en, word_ru " +
                        "FROM my_words WHERE category = '" + categoryWordsChoiceBox.getValue() + "') AS foo ORDER BY id;");

                RestartTable restartTable = new RestartTable();
                restartTable.getWordList(rs1, rs2);
                rs2.close();
                rs1.close();
                r.close();
                CreateDB.connection().close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        return categoryWordsChoiceBox;
    }

    static CategoryWords getIt() {
        return it;
    }

    static CategoryWords getMedical() {
        return medical;
    }

    static CategoryWords getOther() {
        return other;
    }

    ChoiceBox<CategoryWords> getCategoryWordsChoiceBox() {
        return categoryWordsChoiceBox;
    }
}
