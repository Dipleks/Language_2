package myWords;

import interfaceRoot.EffectFont;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class MyWords extends ContextMenuMyWords
{
    private ListCategory listCategory = new ListCategory();
    private ListCategoryKnowledge listCategoryKnowledge = new ListCategoryKnowledge();

    // Добавление Базы данных, меню "Мои слова":
    public void getMyWordsList(){
        getMyWordsColumnLab();
    }

    private void getMyWordsColumnLab() {
        // Обновление таблицы my_words:
        RestartTable restartTable = new RestartTable();
        restartTable.restartMyWordsTable();

        rightC.getChildren().addAll();
        rightC.setSpacing(7);
        rightC.setPrefWidth(widthSize - widthSize / 1.3);
//        rightC.setStyle("-fx-border-color: RED");
        leftC.getChildren().addAll();
        leftC.setSpacing(7);
        leftC.setPadding(new Insets(0, 30, 0, 0));
        leftC.setPrefWidth(widthSize - widthSize / 1.3);
//        leftC.setStyle("-fx-border-color: RED");
        groupMy.setSpacing(20);
        groupMy.getChildren().addAll(leftC, rightC);

//        addElement.setStyle("-fx-border-color: RED");
        addElement.setLayoutX(widthSize - widthSize / 1.25);
        addElement.setLayoutY(heightSize - heightSize / 1.16);
        addElement.setPrefSize(widthSize / 1.8, heightSize / 1.5);
        addElement.setSpacing(10);

        textMy.setStyle("-fx-background-color: transparent; -fx-background: #FFFFFF;");
        textMy.setPrefSize(widthSize / 1.8, heightSize / 1.6);
        textMy.setContent(groupMy);

        textEn.setPrefWidth(widthSize - widthSize / 1.3);
        textEn.setPromptText("English");
        textRu.setPrefWidth(widthSize - widthSize / 1.3);
        textRu.setPromptText("Русский");
        addTextAndButton.setSpacing(20);

        addTextAndButton.getChildren().addAll(textEn, textRu, addWords);

        addElement.getChildren().addAll(addTextAndButton, textMy);

        HBox hBox = new HBox();
        textSearch.setPrefWidth(widthSize/3);

        // Поиск меню my_words:
        Search search = new Search();
        search.getSearch();

        hBox.getChildren().addAll(textSearch, searchWords);
        hBox.setSpacing(heightSize-heightSize/1.009);
        hBox.setLayoutX(widthSize-widthSize/1.4);
        hBox.setLayoutY(heightSize-heightSize/1.05);

        HBox hBox1 = new HBox();
        Label label = new Label("Категории: ");
        label.setFont(EffectFont.getFontText());
        hBox1.setSpacing(heightSize-heightSize/1.009);
        hBox1.setLayoutX(widthSize/2.8);
        hBox1.setLayoutY(heightSize/10.5);
        hBox1.getChildren().addAll(label, listCategory.getCategory(), listCategoryKnowledge.getCategory());

        ROOT.getChildren().addAll(addElement, hBox1, hBox);
    }
}
