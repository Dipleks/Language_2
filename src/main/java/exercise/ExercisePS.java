package exercise;

import control.AddExerciseExam;
import control.MenuBarEngRus;

import static control.ClearDisplay.clearMethod;

public class ExercisePS implements IExercises
{
    private ExerciseText text = new ExerciseText();

    @Override
    public String methodExercise(int a, int b, String lang){
        if (lang.equals("EN")) {
              return text.getPsFileEn().get(a + b);
        } else if (lang.equals("RU")) {
              return text.getPsFileRu().get(a + b);
        }
        return "No files";
    }

    @Override
    public void clearExercise() {
        clearMethod();
        MenuBarEngRus menuBarEngRus = new MenuBarEngRus();
        menuBarEngRus.getMenu();
        AddExerciseExam addExerciseExam = new AddExerciseExam();
        addExerciseExam.AddMenuButtonPS();
    }
}
