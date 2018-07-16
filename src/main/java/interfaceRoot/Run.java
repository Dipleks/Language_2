package interfaceRoot;

import control.MenuBarEngRus;
import settings.ColorSetting;

public class Run implements Root
{
    private MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
    private static ColorSetting colorSetting = new ColorSetting();

    public void runMethod() {
        colorSetting.getColorExamAndExercise();
        colorSetting.getColorExamNumber();
        colorSetting.getColorTranslation();
        colorSetting.getColorMistakesExam();
        colorSetting.getColorCounterExam();
        colorSetting.getColorSection();
        colorSetting.getColorScene();
        colorSetting.getColorTime();
        colorSetting.getColorButton();
        colorSetting.getColorIllumination();

        menuBarEngRus.getMenu();
        ClockDisplay.clock();

        ROOT.getChildren().addAll();

        WINDOW.setTitle("language_2");
        WINDOW.setMaximized(true); //устанавливаем размер окна на весь экран
        WINDOW.setScene(SCENE_ROOT);
        WINDOW.show();
    }
}
