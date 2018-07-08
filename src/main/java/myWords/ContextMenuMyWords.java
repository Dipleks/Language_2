package myWords;

import control.ClearDisplay;
import control.MenuBarEngRus;
import db.CreateDB;
import interfaceRoot.ArgumentsMyWords;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

import java.sql.ResultSet;
import java.sql.SQLException;

class ContextMenuMyWords implements ArgumentsMyWords
{
    private MenuItem menuDeleteWord = new MenuItem("Удалить");

    ContextMenu subMenuMyWords(int finalI){
        ContextMenu contextMenuMyWords = new ContextMenu();
        menuDelete(finalI);

        contextMenuMyWords.getItems().addAll(menuDeleteWord);
        return contextMenuMyWords;
    }

    private MenuItem menuDelete(int finalI) {
        menuDeleteWord.setOnAction(e -> {
            try {
                CreateDB.connection().executeUpdate("DELETE FROM my_words WHERE word_en = '"
                        + my_word_en[finalI].getText() + "';");
                ResultSet r = CreateDB.connection().executeQuery("SELECT word_en FROM my_words");
                for (int j = 0; r.next(); j++) {
                    leftC.getChildren().remove(my_word_en[j]);
                    rightC.getChildren().remove(my_word_ru[j]);
                }
                r.close();
                ClearDisplay.clearMethod();
                MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
                menuBarEngRus.getMenu();
                MyWords fillingColumns = new MyWords();
                fillingColumns.getMyWordsList();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        return menuDeleteWord;
    }
}
