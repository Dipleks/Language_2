package interfaceRoot;

public class StyleButton
{
    public static String getStyleButton(){
        String styleButton = "-fx-color: #"+ EffectColor.getColorButton() +"; -fx-focus-color: #"+
                EffectColor.getIlluminationButton() +";";
        return styleButton;
    }
}
