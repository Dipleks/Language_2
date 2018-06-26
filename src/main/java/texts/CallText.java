package texts;

import interfaceRoot.ArgumentsTexts;
import interfaceRoot.EffectFont;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class CallText implements ArgumentsTexts, Texts
{

    protected void setText(String s){
        HBox hBox = new HBox();

        scrollPane.setPrefWidth(pagination.getPrefWidth());
        text.setText(s);
        text.setFont(EffectFont.getFontTextLevel());
        text.setWrapText(true);
        text.setPadding(new Insets(10, 0, 0, 20));
        text.setPrefWidth(scrollPane.getPrefWidth()/1.055);

        textRU.setFont(EffectFont.getFontTextLevel());
        textRU.setWrapText(true);
        textRU.setPadding(new Insets(0, 0, 0, 0));
        textRU.setPrefWidth(0);

        hBox.setSpacing(scrollPane.getPrefWidth()*0.05);
        hBox.getChildren().addAll(text, textRU);
        scrollPane.setContent(hBox);

    }
}
