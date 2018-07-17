package texts;

import db.TableDB;
import interfaceRoot.ArgumentsTexts;
import interfaceRoot.EffectColor;
import interfaceRoot.EffectFont;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

import java.sql.*;

public class CallText implements ArgumentsTexts, TableDB
{
    private ContextMenuTexts contextMenuTexts = new ContextMenuTexts();

    protected void setText(String s){
        text.setText(s);
        text.setFont(EffectFont.getFontTextLevel());
        text.setWrapText(true);
        text.setPadding(new Insets(10, 0, 0, 20));
        text.setPrefWidth(scrollPane.getPrefWidth()/1.055);
        text.setOnContextMenuRequested(event ->
                contextMenuTexts.menuTexts().show(text, event.getScreenX(), event.getScreenY()));
        scrollPane.setContent(text);
    }


}
