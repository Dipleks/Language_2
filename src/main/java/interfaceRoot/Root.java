package interfaceRoot;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public interface Root
{
    // Главное окно:

    Stage WINDOW = new Stage();
    Screen SCREEN = Screen.getPrimary();
    double widthSize = SCREEN.getBounds().getWidth();
    double heightSize = SCREEN.getBounds().getHeight();
    Group ROOT = new Group();
    Scene SCENE_ROOT = new Scene(ROOT, widthSize*0.95, heightSize*0.95, EffectColor.getColorScene());

    SoundClick soundClick = new SoundClick();

}
