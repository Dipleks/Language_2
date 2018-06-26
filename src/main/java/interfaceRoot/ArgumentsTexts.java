package interfaceRoot;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;

public interface ArgumentsTexts extends Root
{
    Pagination pagination = new Pagination(3, 0);
    ScrollPane scrollPane = new ScrollPane();
    Label text = new Label();
    Label textRU = new Label();
    Button translation = new Button("Перевод");
    Button origin_translation = new Button("Перевод с оригиналом");
}
