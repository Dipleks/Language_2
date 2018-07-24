package interfaceRoot;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class EffectShadow
{
    public static DropShadow getShadow(){
        final DropShadow shadow =new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.5));
        shadow.setOffsetX(10);
        shadow.setOffsetY(10);

        return shadow;
    }
}
