package myWords;

import db.CreateDB;
import interfaceRoot.ArgumentsMyWords;
import interfaceRoot.EffectColor;
import interfaceRoot.StyleButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

class NewWords implements ArgumentsMyWords
{
    private ListCategory listCategory = new ListCategory();
    private ListCategoryKnowledge listCategoryKnowledge = new ListCategoryKnowledge();

    // Добавление новых слов меню my_words:
    void addNewWords(){
        addWords.setStyle(StyleButton.getStyleButton());
        addCategory.setStyle(StyleButton.getStyleButton());

        addWords.setOnAction(e -> {
            if (!textEn.getText().equals("") & !textRu.getText().equals("")) {
                Stage stage = new Stage();
                VBox vBox = new VBox();
                Scene scene = new Scene(vBox, widthSize/4, heightSize/4);
                addCategory.setOnAction(event -> {
                    try {
                        CreateDB.connection().executeUpdate("INSERT INTO my_words (word_en, word_ru, category, color) VALUES ('" + textEn.getText()
                                + "', '" + textRu.getText() + "', '" + listCategory.getCategoryWordsChoiceBox().getValue() + "', 'black')");
                        ResultSet r = CreateDB.connection().executeQuery("SELECT word_en FROM my_words");
                        for (int i = 0; r.next(); i++) {
                            leftC.getChildren().remove(my_word_en[i]);
                            rightC.getChildren().remove(my_word_ru[i]);
                        }
                        RestartTable restartTable = new RestartTable();
                        restartTable.restartMyWordsTable();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    textEn.clear();
                    textRu.clear();

                    stage.close();
                });
                vBox.getChildren().addAll(listCategory.addCategory(), addCategory);
                vBox.setSpacing(30);
                vBox.setAlignment(Pos.CENTER);

                stage.setTitle("Добавление категории");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } else {
                // TODO добавиить модальное окно, при попытки ввести пустые данные
                System.out.println("попытка добавить пустое поле!");
            }
        });
    }
}
