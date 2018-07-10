package settings;

import interfaceRoot.ArgumentsSettings;
import javafx.scene.layout.StackPane;

public class RightPanel implements ArgumentsSettings
{
    private StackPane AREA_SETTINGS;

    public void setAREA_SETTINGS(StackPane AREA_SETTINGS) {
        AREA_SETTINGS.setStyle("-fx-border-color: RED");
        AREA_SETTINGS.setPrefSize(widthSize/3, heightSize/3);
        this.AREA_SETTINGS = AREA_SETTINGS;
    }
}
