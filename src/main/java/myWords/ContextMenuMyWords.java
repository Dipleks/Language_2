package myWords;

import control.ClearDisplay;
import control.MenuBarEngRus;
import db.CreateDB;
import interfaceRoot.ArgumentsMyWords;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

import java.sql.ResultSet;
import java.sql.SQLException;

class ContextMenuMyWords implements ArgumentsMyWords
{
    private MenuItem menuDeleteWord = new MenuItem("Удалить");
    private SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
    private EventsColorMenuWords event = new EventsColorMenuWords();

    ContextMenu subMenuMyWords(int finalI){
        ContextMenu contextMenuMyWords = new ContextMenu();
        menuDelete(finalI);
//        getMenuContainerColor();
        event.getEvents(finalI);

        contextMenuMyWords.getItems().addAll(menuDeleteWord, separatorMenuItem, KNOW_ON_ONE, KNOW_ON_TWO, KNOW_ON_THREE, KNOW_ON_FOUR, KNOW_ON_FIVE);
        return contextMenuMyWords;
    }

    // Контестное меню "цветовых панелей"
//    private void getMenuContainerColor(){
//        String pref = "-fx-pref-width: 30;";
//
//        KNOW_ON_ONE.setStyle("-fx-background-color: KNOW_ON_ONE;" + pref);
//        KNOW_ON_TWO.setStyle("-fx-background-color: KNOW_ON_TWO;" + pref);
//        KNOW_ON_THREE.setStyle("-fx-background-color: KNOW_ON_THREE;" + pref);
//        KNOW_ON_FOUR.setStyle("-fx-background-color: KNOW_ON_FOUR;" + pref);
//        KNOW_ON_FIVE.setStyle("-fx-background-color: KNOW_ON_FIVE;" + pref);
//    }

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
