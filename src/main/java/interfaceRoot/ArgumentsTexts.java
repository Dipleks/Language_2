package interfaceRoot;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import texts.NameText;
import texts.NumberOfLines;

import static texts.MaxCountText.getCountTable;

public interface ArgumentsTexts extends Root
{
    Pagination pagination = new Pagination(NumberOfLines.numberOfLines(), 0);
    ScrollPane scrollPane = new ScrollPane();
    Label text = new Label();
    Label textRU = new Label();
    Button translation = new Button("Перевод");
    Button add_my_test = new Button("Добавить свой текст");

    TextArea textEng = new TextArea();
    TextArea textRus = new TextArea();

    TextArea textEdit = new TextArea();
    TextArea textEditRU = new TextArea();

    Label addNameText = new Label("Название текста: ");
    TextField nameText = new TextField();
    Button addNewText = new Button("Добавить");

    Stage SAVE_EDIT = new Stage();
    Button editText = new Button("Сохранить изменения");
    Button OK = new Button("Сохранить");
    Button CANCEL = new Button("Отменить");
    Label editNameText = new Label("Название текста: ");
    TextField editName = new TextField();

    ChoiceBox<NameText> listName = new ChoiceBox<>();
    Label TITLE = new Label();
}
