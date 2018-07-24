package interfaceRoot;

import javafx.scene.effect.Reflection;

public class EffectReflection
{
    public static Reflection getReflection(){
        Reflection reflection = new Reflection();
        reflection.setBottomOpacity(0.0);
        reflection.setTopOpacity(0.5);
        reflection.setTopOffset(0.3);
        reflection.setFraction(0.7);

        return reflection;
    }
}
