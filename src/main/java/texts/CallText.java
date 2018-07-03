package texts;

import db.CreateDB;
import interfaceRoot.ArgumentsTexts;
import interfaceRoot.EffectFont;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CallText implements ArgumentsTexts, Texts
{
    private ContextMenuTexts contextMenuTexts = new ContextMenuTexts();

    protected void setText(String s){
        HBox hBox = new HBox();

        scrollPane.setPrefWidth(pagination.getPrefWidth());
        text.setText(s);
        text.setFont(EffectFont.getFontTextLevel());
        text.setWrapText(true);
        text.setPadding(new Insets(10, 0, 0, 20));
        text.setPrefWidth(scrollPane.getPrefWidth()/1.055);
        text.setOnContextMenuRequested(event -> contextMenuTexts.menuTexts().show(text, event.getScreenX(), event.getScreenY()));

        textRU.setFont(EffectFont.getFontTextLevel());
        textRU.setWrapText(true);
        textRU.setPadding(new Insets(0, 0, 0, 0));
        textRU.setPrefWidth(0);

        hBox.setSpacing(scrollPane.getPrefWidth()*0.05);
        hBox.getChildren().addAll(text, textRU);
        scrollPane.setContent(hBox);

    }
}
