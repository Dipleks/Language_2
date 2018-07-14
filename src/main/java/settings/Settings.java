package settings;

import interfaceRoot.ArgumentsSettings;
import interfaceRoot.EffectFont;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Settings implements ArgumentsSettings
{
    private VBox MENU_SETTINGS = new VBox();
    private FactorySettings factorySettings = new FactorySettings();
    private TheAppearanceOf theAppearanceOf = new TheAppearanceOf();
    private Label setting = new Label("Настройки");

    public void getSetting(){
        MENU_SETTINGS.setStyle("-fx-border-color: RED");

        factorySettings.resetSettings();
        theAppearanceOf.changeColor();
        MENU_SETTINGS.getChildren().addAll(reset, color);

        setting.setLayoutX(widthSize/4);
        setting.setLayoutY(heightSize/18);
        setting.setFont(EffectFont.getFontTITLE());
        MENU_SETTINGS.setSpacing(5);
        MENU_SETTINGS.setLayoutX(widthSize/4);
        MENU_SETTINGS.setLayoutY(heightSize/11);
        MENU_SETTINGS.setPadding(new Insets(10, 0, 10, 10));
        MENU_SETTINGS.setPrefSize(widthSize/7, heightSize/1.4);

        ROOT.getChildren().addAll(MENU_SETTINGS, setting);
    }
}
