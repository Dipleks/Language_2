package interfaceRoot;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import myWords.CategoryWords;

public interface ArgumentsMyWords extends Root
{
    // Menu_my_words
    VBox leftC = new VBox();
    VBox rightC = new VBox();
    HBox groupMy = new HBox();
    VBox addElement = new VBox();
    HBox addTextAndButton = new HBox();
    ScrollPane textMy = new ScrollPane();
    TextField textEn = new TextField();
    TextField textRu = new TextField();
    TextField textSearch = new TextField();
    Label[] my_word_en = new Label[2000];
    Label[] my_word_ru = new Label[2000];
    Button searchWords = new Button("Поиск");
    Button addWords = new Button("Добавить");
    Button addCategory = new Button("Выбрать категорию");

    MenuItem KNOW_ON_ONE = new MenuItem("Знаю на 1");
    MenuItem KNOW_ON_TWO = new MenuItem("Знаю на 2");
    MenuItem KNOW_ON_THREE = new MenuItem("Знаю на 3");
    MenuItem KNOW_ON_FOUR = new MenuItem("Знаю на 4");
    MenuItem KNOW_ON_FIVE = new MenuItem("Знаю на 5");
}
