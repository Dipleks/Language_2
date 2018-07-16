package update;

import interfaceRoot.ArgumentsUpdate;
import interfaceRoot.Run;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

class ProgressBarUpDate implements ArgumentsUpdate
{
    private static ProgressBar progressBar = new ProgressBar(0);

    static void getProgressBar(){
        progressBar.setPrefSize(widthSize/4, heightSize/40);
        progressBar.setLayoutX(scene.getWidth()/3.8);
        progressBar.setLayoutY(scene.getHeight()/20);
        progressBar.setStyle("-fx-accent: #8d5ab5;"); // цвет бара
        group.getChildren().add(progressBar);

        // создаем анимацию прогресс бара:
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(0), new KeyValue(progressBar.progressProperty(), 0)),
                new KeyFrame(Duration.millis(7000), new KeyValue(progressBar.progressProperty(), 1))
        );
        timeline.playFromStart();

        timeline.setOnFinished(event1 -> {
            stage.close();
            Run run = new Run();
            run.runMethod();
        }); // действие после завершения работы прогресс бара
    }

}
