package myWords;

import db.CreateDB;
import interfaceRoot.ArgumentsMyWords;
import interfaceRoot.EffectColor;
import interfaceRoot.EffectShadow;
import interfaceRoot.StyleButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListCategoryKnowledge implements ArgumentsMyWords
{
    private ChoiceBox<CategoryKnowledge> categoryWordsChoiceBox = new ChoiceBox<>();
    private static CategoryKnowledge one = new CategoryKnowledge("Знаю на 1");
    private static CategoryKnowledge two = new CategoryKnowledge("Знаю на 2");
    private static CategoryKnowledge three = new CategoryKnowledge("Знаю на 3");
    private static CategoryKnowledge four = new CategoryKnowledge("Знаю на 4");
    private static CategoryKnowledge five = new CategoryKnowledge("Знаю на 5");

    private ObservableList<CategoryKnowledge> list = FXCollections.observableArrayList(one, two, three,
            four, five);

    ChoiceBox<CategoryKnowledge> addCategory(){

        categoryWordsChoiceBox.setItems(list);
        categoryWordsChoiceBox.setValue(one);

        return categoryWordsChoiceBox;
    }

    ChoiceBox<CategoryKnowledge> getCategory(){

        categoryWordsChoiceBox.setStyle(StyleButton.getStyleButton());
        categoryWordsChoiceBox.setItems(list);
        categoryWordsChoiceBox.setValue(one);
        categoryWordsChoiceBox.setEffect(EffectShadow.getShadow());
        categoryWordsChoiceBox.setOnAction(event -> {
            try {
                ResultSet r = CreateDB.connection().executeQuery("SELECT color FROM my_words");
                for (int i = 0; r.next(); i++) {
                    leftC.getChildren().remove(my_word_en[i]);
                    rightC.getChildren().remove(my_word_ru[i]);
                }
                ResultSet rs1 = CreateDB.connection().executeQuery("SELECT word_en FROM (SELECT DISTINCT id, word_en, word_ru " +
                        "FROM my_words WHERE color = '" + categoryWordsChoiceBox.getValue() + "') AS foo ORDER BY id;");
                ResultSet rs2 = CreateDB.connection().executeQuery("SELECT word_ru FROM (SELECT DISTINCT id, word_en, word_ru " +
                        "FROM my_words WHERE color = '" + categoryWordsChoiceBox.getValue() + "') AS foo ORDER BY id;");

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

    ChoiceBox<CategoryKnowledge> getCategoryWordsChoiceBox() {
        return categoryWordsChoiceBox;
    }
}
