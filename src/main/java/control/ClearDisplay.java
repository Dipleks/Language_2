package control;

import interfaceRoot.*;

public class ClearDisplay implements ArgumentsExam, ArgumentsExercise, ArgumentsMyWords, ArgumentsTexts
{
    // Очистка колонок упражнений:
    public static void clearColumn() {
        columnExam.getChildren().clear();
        rightColumn.getChildren().clear();
        leftColumn.getChildren().clear();
        ROOT.getChildren().clear();
        MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
        menuBarEngRus.getMenu();
        ROOT.getChildren().addAll(groupRadBut);
    }
    // Полная зачистка главного окна:
    public static void clearMethod() {
        leftC.getChildren().clear();
        rightC.getChildren().clear();
        groupMy.getChildren().clear();
        addElement.getChildren().clear();
        addTextAndButton.getChildren().clear();
        columnExam.getChildren().clear();
        rightColumn.getChildren().clear();
        leftColumn.getChildren().clear();
        groupRadBut.getChildren().clear();
        groupExam.getChildren().clear();
        iprColumn.getChildren().clear();
        numberColumn.getChildren().clear();
        improveV.getChildren().clear();
        counterVB.getChildren().clear();
        stackPaneText.getChildren().clear();
        list.clear();
//        buttonsTransfer.getChildren().clear();
        ROOT.getChildren().clear();

        ClockDisplay.clock();
    }
}
