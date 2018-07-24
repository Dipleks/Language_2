package myWords;

import db.CreateDB;
import db.TableDB;
import interfaceRoot.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

import java.sql.*;

class RestartTable implements ArgumentsMyWords, TableDB
{
    private ContextMenuMyWords contextMenuMyWords = new ContextMenuMyWords();
    private NewWords newWords = new NewWords();

    // Обновление таблицы my_words:
    void restartMyWordsTable(){
        // Добавление таблиц:
        try {
//            CreateDB.connection().executeUpdate(TableDB.my_words);
            ResultSet rs1 = CreateDB.connection().executeQuery("SELECT word_en FROM my_words ORDER BY id;");
            ResultSet rs2 = CreateDB.connection().executeQuery("SELECT word_ru FROM my_words ORDER BY id;");
            newWords.addNewWords();
            getWordList(rs1, rs2);
            rs1.close();
            rs2.close();
            CreateDB.connection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void getWordList(ResultSet rsEn, ResultSet rsRu) throws SQLException {
        for (int i = 0; rsEn.next(); i++) {
            rsRu.next();
            int finalI = i;
            contextMenuMyWords.subMenuMyWords(i);
            my_word_en[i] = new Label();
//                my_word_en[i].setStyle("-fx-border-color: RED");
            my_word_en[i].setFont(EffectFont.getFontTextExam());
            my_word_en[i].setTextFill(EffectColor.getColorText());
            my_word_en[i].setPrefWidth(widthSize-widthSize/2.45);
//            my_word_en[i].setEffect(EffectShadow.getShadow());
            my_word_en[i].setAlignment(Pos.BASELINE_RIGHT);
//                my_word_en[i].setWrapText(true);
//                my_word_en[i].setCursor(Cursor.HAND);
            my_word_en[i].setText(rsEn.getString("word_en"));
            my_word_en[i].setOnContextMenuRequested(e ->
                    contextMenuMyWords.subMenuMyWords(finalI).show(my_word_en[finalI], e.getScreenX(), e.getScreenY()));

            my_word_ru[i] = new Label();
//                my_word_ru[i].setStyle("-fx-border-color: RED");
            my_word_ru[i].setFont(EffectFont.getFontTextExam());
            my_word_ru[i].setTextFill(EffectColor.getColorText());
//            my_word_ru[i].setEffect(EffectShadow.getShadow());
            my_word_ru[i].setPrefWidth(widthSize-widthSize/2.45);
//                my_word_ru[i].setWrapText(true);
//                my_word_ru[i].setCursor(Cursor.HAND);
            my_word_ru[i].setText(rsRu.getString("word_ru"));
            my_word_ru[i].setOnContextMenuRequested(e ->
                    contextMenuMyWords.subMenuMyWords(finalI).show(my_word_ru[finalI], e.getScreenX(), e.getScreenY()));
            if (my_word_ru[i].getText().length()>33) {
                Tooltip tooltip = new Tooltip();
                tooltip.setWrapText(true);
                tooltip.setText(my_word_ru[i].getText());
                tooltip.setPrefWidth(widthSize/5);
                my_word_ru[i].setTooltip(tooltip);
            }
            leftC.getChildren().addAll(my_word_en[i]);
            rightC.getChildren().addAll(my_word_ru[i]);
        }
    }
}
