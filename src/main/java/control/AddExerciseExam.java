package control;

import exam.ExamPS;
import exam.ExamTobe;
import exam.ExaminationParts;
import exam.Exams;
import exercise.ExercisePS;
import exercise.ExerciseParts;
import exercise.ExerciseToBe;
import exercise.Exercises;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Класс выводящий список кнопок и колонки с заданиями и контрольными.
 * Входные параметры класса: <>appPS</>, <>negPS</>, <>quesPS</>, <>examPS</>,
 * <>appToBe</>, <>negToBe</>, <>quesToBe</>, <>examToBe</>,
 * <>exercisePartsPS</>, <>controlExamPS</>, <>exercisePartsToBe</>, <>controlExamToBe</>
 */
public class AddExerciseExam
{
    /** утверждения PS */
    private Exercises[] appPS = new Exercises[7];

    /** отрицания PS */
    private Exercises[] negPS = new Exercises[4];

    /** вопросы PS */
    private Exercises[] quesPS = new Exercises[7];

    /** контрольные PS */
    private Exams[] examPS = new Exams[7];

    /** утверждения To Be */
    private Exercises[] appToBe = new Exercises[6];

    /** отрицания To Be */
    private Exercises[] negToBe = new Exercises[2];

    /** вопросы To Be */
    private Exercises[] quesToBe = new Exercises[8];

    /** контрольные To Be */
    private Exams[] examToBe = new Exams[4];

    /** кнопки выбора упражнений PS */
    private ExerciseParts exercisePartsPS = new ExerciseParts();


    /** кнопки выбора контрольных PS*/
    private ExaminationParts controlExamPS = new ExaminationParts();

    /** кнопки выбора упражнений To Be*/
    private ExerciseParts exercisePartsToBe = new ExerciseParts();

    /** кнопки выбора контрольных To Be*/
    private ExaminationParts controlExamToBe = new ExaminationParts();

    /**
     * Процедура добавления кнопок упражнений PS
     */
    public void AddMenuButtonPS(){
        getExercisePS();
    }

    /**
     * Процедура добавления кнопок контрольных PS
     */
    public void AddMenuButtonExamPS(){
        getExamPS();
    }

    /**
     * Процедура добавления кнопок упражнений To Be
     */
    public void AddMenuButtonToBe(){
        getExerciseToBe();
    }

    /**
     * Процедура добавления кнопок контрольных To Be
     */
    public void AddMenuButtonExamToBe(){
        getExamToBe();
    }


    /**
     * Процедура добавления кнопок и вызова по клику упражнений PS
     */
    private void getExercisePS(){

        appPS[0] = new Exercises(new Label[15], new Label[15],0, 15);
        appPS[1] = new Exercises(new Label[15], new Label[15],30, 45);
        appPS[2] = new Exercises(new Label[15], new Label[15], 60, 75);
        appPS[3] = new Exercises(new Label[15], new Label[15],90, 105);
        appPS[4] = new Exercises(new Label[15], new Label[15],120, 135);
        appPS[5] = new Exercises(new Label[15], new Label[15],150, 165);
        appPS[6] = new Exercises(new Label[6], new Label[7],180, 186);

        negPS[0] = new Exercises(new Label[15], new Label[15],193, 208);
        negPS[1] = new Exercises(new Label[15], new Label[15],223, 238);
        negPS[2] = new Exercises(new Label[15], new Label[15],253, 268);
        negPS[3] = new Exercises(new Label[14], new Label[15],283, 297);

        quesPS[0] = new Exercises(new Label[15], new Label[15],312, 327);
        quesPS[1] = new Exercises(new Label[15], new Label[15],342, 357);
        quesPS[2] = new Exercises(new Label[15], new Label[15],372, 387);
        quesPS[3] = new Exercises(new Label[15], new Label[15],402, 417);
        quesPS[4] = new Exercises(new Label[15], new Label[15],432, 447);
        quesPS[5] = new Exercises(new Label[15], new Label[15],462, 477);
        quesPS[6] = new Exercises(new Label[12], new Label[12],492, 504);

        exercisePartsPS.exercise(appPS, negPS, quesPS,
                new Button[7], new Button[4], new Button[7], new ExercisePS());
    }

    /**
     * Процедура добавления кнопок и вызова по клику контрольных PS
     */

    private void getExamPS(){

        examPS[0] = new Exams(0);
        examPS[1] = new Exams(100);
        examPS[2] = new Exams(200);
        examPS[3] = new Exams(300);
        examPS[4] = new Exams(400);
        examPS[5] = new Exams(500);
        examPS[6] = new Exams(600);

        controlExamPS.examMethod(examPS, new Button[7], new ExamPS());
    }

    /**
     * Процедура добавления кнопок и вызова по клику упражнений To Be
     */
    private void getExerciseToBe(){

        appToBe[0] = new Exercises(new Label[15], new Label[15],0, 15);
        appToBe[1] = new Exercises(new Label[15], new Label[15],30, 45);
        appToBe[2] = new Exercises(new Label[15], new Label[15], 60, 75);
        appToBe[3] = new Exercises(new Label[15], new Label[15],90, 105);
        appToBe[4] = new Exercises(new Label[15], new Label[15],120, 135);
        appToBe[5] = new Exercises(new Label[19], new Label[19],150, 169);

        negToBe[0] = new Exercises(new Label[15], new Label[15],188, 203);
        negToBe[1] = new Exercises(new Label[5], new Label[5],218, 223);

        quesToBe[0] = new Exercises(new Label[15], new Label[15],228, 243);
        quesToBe[1] = new Exercises(new Label[15], new Label[15],258, 273);
        quesToBe[2] = new Exercises(new Label[15], new Label[15],288, 303);
        quesToBe[3] = new Exercises(new Label[15], new Label[15],318, 333);
        quesToBe[4] = new Exercises(new Label[15], new Label[15],348, 363);
        quesToBe[5] = new Exercises(new Label[15], new Label[15],378, 393);
        quesToBe[6] = new Exercises(new Label[15], new Label[15],408, 423);
        quesToBe[7] = new Exercises(new Label[12], new Label[12],438, 450);

        exercisePartsToBe.exercise(appToBe, negToBe, quesToBe,
                new Button[6], new Button[2], new Button[8], new ExerciseToBe());
    }

    /**
     * Процедура добавления кнопок и вызова по клику контрольных To Be
     */
    private void getExamToBe(){

        examToBe[0] = new Exams(0);
        examToBe[1] = new Exams(100);
        examToBe[2] = new Exams(200);
        examToBe[3] = new Exams(300);

        controlExamToBe.examMethod(examToBe, new Button[4], new ExamTobe());
    }


}
