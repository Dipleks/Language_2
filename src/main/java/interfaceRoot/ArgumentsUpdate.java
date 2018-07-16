package interfaceRoot;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public interface ArgumentsUpdate extends Root
{
    Stage stage = new Stage();
    Group group = new Group();
    Scene scene = new Scene(group, widthSize/2, heightSize/2);
    Button update = new Button("Обновить");

    String textUpdate_2_2_0 = "В этом обновлении: появилась возможность добавить собственный текст, " +
            "редактировние текста, назначить категорию цвета для текста, выбрать уровень знаний для" +
            "слов, отсеить слова по категориям и по уровню знаний. Появилась возможность сбросить настройки" +
            "приложения, назначить самостоятельно любой цвет элементам приложения. Улучшена работа" +
            "контрольных работ. Добавлена 1я и 2я часть контрольных работ. В моих словах есть частичто" +
            "заполненые категории слов!";



}
