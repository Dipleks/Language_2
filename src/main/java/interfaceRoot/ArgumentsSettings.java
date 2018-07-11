package interfaceRoot;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public interface ArgumentsSettings extends Root
{
    Button reset = new Button("Заводские настройки");
    Button color = new Button("Внешний вид");

    VBox panelSetting = new VBox();
    Label textWarning = new Label("При сбросе всех настроек будут удалены все Ваши тексты и слова!");
    Button resetSettings = new Button("Сбросить до зоводских настроек");

    VBox settingColor = new VBox();
    HBox one = new HBox();
    HBox two = new HBox();
    HBox three = new HBox();
    HBox four = new HBox();
    HBox five = new HBox();
    HBox six = new HBox();
    HBox seven = new HBox();
    HBox eight = new HBox();

    Label examColorOne = new Label("Контрольные и задания до перевода");
    Label examColorTwo = new Label("Перевод контрольых по нажатию на номер");
    Label exerciseColorOne = new Label("Контрольные и Задания перевод");
    Label exerciseColorTwo = new Label("Контрольные и Задания не верный перевод");
    Label counterColor = new Label("Значения счетчика");
    Label sectionColor = new Label("Разделы заданий");
    Label sceneColor = new Label("Цвет основного фона");
    Label timeColor = new Label("Цвет часов");

    ColorPicker examColorOneL = new ColorPicker();
    ColorPicker examColorTwoL = new ColorPicker();
    ColorPicker exerciseColorOneL = new ColorPicker();
    ColorPicker exerciseColorTwoL = new ColorPicker();
    ColorPicker counterColorL = new ColorPicker();
    ColorPicker sectionColorL = new ColorPicker();
    ColorPicker sceneColorL = new ColorPicker();
    ColorPicker timeColorL = new ColorPicker();
}
