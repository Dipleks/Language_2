package texts;

import control.ClearDisplay;
import control.MenuBarEngRus;
import interfaceRoot.ArgumentsTexts;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class TextsParts implements ArgumentsTexts
{
    private Button[] buttonTexts = new Button[3];
    private HBox menuButtTexts = new HBox();

    public void getMenuButtonTexts(){
        for (int i = 0; i < 3; i++) {
            buttonTexts[i] = new Button();
            buttonTexts[i].setText("Уровень: " + (i + 1));
            buttonTexts[i].setPrefWidth(widthSize-widthSize/1.06);
            buttonTexts[i].setPrefHeight(widthSize-widthSize/1.03);
            buttonTexts[i].setStyle("-fx-focus-color: DARKGREEN;");
        }
        buttonTexts[0].setOnAction(event -> {
            try {
                ClearDisplay.clearMethod();
                MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
                menuBarEngRus.getMenu();
                TextPanels textPanels = new TextPanels();
                textPanels.call();
            } catch (Exception e){
                System.out.println("ошибка повторного нажатия меню Уровень 1");
            }
        });
        buttonTexts[1].setOnAction(event -> {
            System.out.println("в разработке");
        });
        buttonTexts[2].setOnAction(event -> {
            System.out.println("в разработке");
        });
        menuButtTexts.setLayoutX(widthSize/3);
        menuButtTexts.setLayoutY(heightSize/3);
        menuButtTexts.setSpacing(widthSize/30);
        menuButtTexts.getChildren().addAll(buttonTexts);
        ROOT.getChildren().addAll(menuButtTexts);
    }
}
