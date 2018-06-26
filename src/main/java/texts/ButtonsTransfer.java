package texts;

import interfaceRoot.ArgumentsTexts;
import interfaceRoot.EffectFont;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

class ButtonsTransfer implements ArgumentsTexts, Texts
{

    Button getTransfer(String rusText, String engText) {
        translation.setOnAction(e -> {
            if (text.getText().equals(engText)) {
                text.setPrefWidth(scrollPane.getPrefWidth()/1.055);
                textRU.setPrefWidth(0);
                textRU.setText("");
                text.setText(rusText);
            } else if (text.getText().equals(rusText)) {
                text.setPrefWidth(scrollPane.getPrefWidth()/1.055);
                textRU.setPrefWidth(0);
                textRU.setText("");
                text.setText(engText);
            }
        });
        return translation;
    }

    Button getOriginTranslation (String ru) {
        origin_translation.setOnAction(e -> {

            text.setPrefWidth(scrollPane.getPrefWidth()*0.45);
            textRU.setPrefWidth(scrollPane.getPrefWidth()*0.45);
            textRU.setText(ru);

        });
        return origin_translation;
    }
}
