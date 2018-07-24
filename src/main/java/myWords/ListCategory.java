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

class ListCategory implements ArgumentsMyWords
{
    private ChoiceBox<CategoryWords> categoryWordsChoiceBox = new ChoiceBox<>();
    private static CategoryWords it = new CategoryWords("Программирование");
    private static CategoryWords profession = new CategoryWords("Профессии");
    private static CategoryWords for_communication = new CategoryWords("Для общения");
    private static CategoryWords architecture = new CategoryWords("Архитектура");
    private static CategoryWords biology = new CategoryWords("Анатомия");
    private static CategoryWords geography = new CategoryWords("География");
    private static CategoryWords nature = new CategoryWords("Природа");
    private static CategoryWords things = new CategoryWords("Вещи");
    private static CategoryWords other = new CategoryWords("Другое");
    private static CategoryWords all = new CategoryWords("Всё");

    private ObservableList<CategoryWords> list = FXCollections.observableArrayList(all, it, profession,
            for_communication, architecture, biology, geography, nature, things, other);

    ChoiceBox<CategoryWords> addCategory(){

        categoryWordsChoiceBox.setStyle(StyleButton.getStyleButton());
        categoryWordsChoiceBox.setItems(list);
        categoryWordsChoiceBox.setValue(all);
        categoryWordsChoiceBox.setEffect(EffectShadow.getShadow());

        return categoryWordsChoiceBox;
    }

    ChoiceBox<CategoryWords> getCategory(){

        categoryWordsChoiceBox.setStyle(StyleButton.getStyleButton());
        categoryWordsChoiceBox.setItems(list);
        categoryWordsChoiceBox.setValue(all);
        categoryWordsChoiceBox.setEffect(EffectShadow.getShadow());
        categoryWordsChoiceBox.setOnAction(event -> {
            try {
                ResultSet r = CreateDB.connection().executeQuery("SELECT word_en FROM my_words");
                for (int i = 0; r.next(); i++) {
                    leftC.getChildren().remove(my_word_en[i]);
                    rightC.getChildren().remove(my_word_ru[i]);
                }
                if (categoryWordsChoiceBox.getValue().getCategory().equals(all.getCategory())){
                    ResultSet rs1 = CreateDB.connection().executeQuery("SELECT word_en FROM my_words ORDER BY id;");
                    ResultSet rs2 = CreateDB.connection().executeQuery("SELECT word_ru FROM my_words ORDER BY id;");
                    RestartTable restartTable = new RestartTable();
                    restartTable.getWordList(rs1, rs2);
                    rs2.close();
                    rs1.close();
                    r.close();
                    CreateDB.connection().close();
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

    public static CategoryWords getIt() {
        return it;
    }

    public static CategoryWords getProfession() {
        return profession;
    }

    public static CategoryWords getFor_communication() {
        return for_communication;
    }

    public static CategoryWords getArchitecture() {
        return architecture;
    }

    public static CategoryWords getBiology() {
        return biology;
    }

    public static CategoryWords getGeography() {
        return geography;
    }

    public static CategoryWords getNature() {
        return nature;
    }

    public static CategoryWords getThings() {
        return things;
    }

    public static CategoryWords getOther() {
        return other;
    }

    public static CategoryWords getAll() {
        return all;
    }

    ChoiceBox<CategoryWords> getCategoryWordsChoiceBox() {
        return categoryWordsChoiceBox;
    }
}
