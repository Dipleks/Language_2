package settings;

import interfaceRoot.ArgumentsSettings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class Settings implements ArgumentsSettings
{
    private HBox GROUP_SETTINGS = new HBox();
    private Scene SCENE_SETTINGS = new Scene(GROUP_SETTINGS, widthSize/1.7, heightSize/1.2);
    private FactorySettings factorySettings = new FactorySettings();
    private TheAppearanceOf theAppearanceOf = new TheAppearanceOf();

    public void getSetting(){
        MENU_SETTINGS.setStyle("-fx-border-color: RED");
        AREA_SETTINGS.setStyle("-fx-border-color: RED");

        factorySettings.resetSettings();
        theAppearanceOf.changeColor();
        MENU_SETTINGS.getChildren().addAll(reset, color);

        MENU_SETTINGS.setSpacing(5);
        MENU_SETTINGS.setPadding(new Insets(10, 0, 10, 10));
        MENU_SETTINGS.setPrefSize(SCENE_SETTINGS.getWidth()/3, SCENE_SETTINGS.getHeight()/1.1);
        AREA_SETTINGS.setPrefSize(SCENE_SETTINGS.getWidth()/1.55, SCENE_SETTINGS.getHeight()/1.1);

        GROUP_SETTINGS.getChildren().addAll(MENU_SETTINGS, AREA_SETTINGS);
        GROUP_SETTINGS.setSpacing(15);
        GROUP_SETTINGS.setStyle("-fx-background-color: #ffffff;");

        SETTINGS.setScene(SCENE_SETTINGS);
        SETTINGS.setTitle("Настройки");
        SETTINGS.show();
    }

    public Scene getSCENE_SETTINGS() {
        return SCENE_SETTINGS;
    }
}
