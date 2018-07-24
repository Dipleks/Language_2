package exam;

import interfaceRoot.EffectColor;
import interfaceRoot.EffectShadow;
import interfaceRoot.PanelTips;
import interfaceRoot.StyleButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import static interfaceRoot.ArgumentsExam.*;
import static interfaceRoot.Root.ROOT;
import static interfaceRoot.Root.heightSize;
import static interfaceRoot.Root.widthSize;

class MergingPanels
{
    void addPaneExam(Label[] number, Label[] correctly, Label[] arrayOfOffersExam){
        //          numberColumn.setStyle("-fx-border-color: RED");
        numberColumn.setSpacing(heightSize/40);
        numberColumn.setPadding(new Insets(0, 0, 0, 0));
        numberColumn.setPrefSize(widthSize/25, heightSize/1.25);
        numberColumn.getChildren().addAll(number);

//          iprColumn.setStyle("-fx-border-color: RED");
        iprColumn.setSpacing(heightSize/40);
        iprColumn.setPadding(new Insets(0, 0, 0, 0));
        iprColumn.setPrefSize(widthSize/11, heightSize/1.25);
        iprColumn.getChildren().addAll(correctly);

//          columnExam.setStyle("-fx-border-color: RED");
        columnExam.setSpacing(heightSize/40);
        columnExam.setPadding(new Insets(0, 0, 0, 0));
        columnExam.setPrefSize(widthSize/2.5, heightSize/1.25);
        columnExam.getChildren().addAll(arrayOfOffersExam);

        groupExam.setSpacing(heightSize-heightSize/1.009);
        groupExam.getChildren().addAll(numberColumn, columnExam, iprColumn);

        examPane.setContent(groupExam);
//        examPane.setStyle("-fx-background-color: transparent; -fx-background: #FFFFFF;");
        examPane.setLayoutX(widthSize/4.3);
        examPane.setLayoutY(heightSize/6.5);
        examPane.setEffect(EffectShadow.getShadow());
        examPane.setPrefSize(widthSize / 1.8, heightSize / 1.5);

        HBox hBox = new HBox();
        Button button = new Button("?");
        button.setEffect(EffectShadow.getShadow());
        button.setOnAction(e -> PanelTips.panes(str));
        button.setStyle(StyleButton.getStyleButton());
        improve.setPrefWidth(widthSize/3);
        improve.setEffect(EffectShadow.getShadow());
        hBox.setSpacing(10);
        exitInMenu.setStyle(StyleButton.getStyleButton());
        hBox.getChildren().addAll(button, improve, exitInMenu, nameExam);
        improveClick1.setAlignment(Pos.CENTER);
        improveClick1.setTextFill(EffectColor.getColorTextClickPERU());
        improveClick1.setEffect(EffectShadow.getShadow());
        improveV.getChildren().addAll(improveClick1, hBox);
        improveV.setSpacing(heightSize-heightSize/1.009);
        improveV.setLayoutX(widthSize-widthSize/1.4);
        improveV.setLayoutY(heightSize-heightSize/1.05);

        ROOT.getChildren().addAll(examPane, improveV);
    }
}
