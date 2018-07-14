package settings;

import interfaceRoot.ArgumentsSettings;

class CleaningSettings implements ArgumentsSettings
{
    static void clear(){
        settingColor.getChildren().clear();
        one.getChildren().clear();
        two.getChildren().clear();
        three.getChildren().clear();
        four.getChildren().clear();
        five.getChildren().clear();
        six.getChildren().clear();
        seven.getChildren().clear();
        eight.getChildren().clear();
        nine.getChildren().clear();
        ten.getChildren().clear();
        panelSetting.getChildren().clear();
        ROOT.getChildren().remove(panelSetting);
        ROOT.getChildren().remove(settingColor);
        ROOT.getChildren().remove(resetColor);
        ROOT.getChildren().remove(scrollSettingsColor);
    }
}
