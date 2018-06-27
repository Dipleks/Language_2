package interfaceRoot;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import texts.NumberOfLines;

public interface ArgumentsTexts extends Root
{
    Pagination pagination = new Pagination(NumberOfLines.numberOfLines(), 0);
    ScrollPane scrollPane = new ScrollPane();
    Label text = new Label();
    Label textRU = new Label();
    Button translation = new Button("Перевод");
    Button origin_translation = new Button("Добавить свой текст");


    TextArea textEng = new TextArea();
    TextArea textRus = new TextArea();

    Label addNameText = new Label("Название текста: ");
    TextField nameText = new TextField();
    Button addNewText = new Button("Добавить");
}
