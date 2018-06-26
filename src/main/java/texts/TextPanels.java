package texts;

import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

public class TextPanels extends CallText
{
    public void call(){ getPagination(); }

    private Pagination getPagination () {
        pagination.setPageFactory(this::getScroll);
        pagination.setMaxPageIndicatorCount(15);
        pagination.setLayoutX(widthSize/6);
        pagination.setLayoutY(heightSize/8);
//        pagination.setMinHeight(heightSize-300);
//        pagination.setMinWidth(widthSize-180);
        pagination.setPrefSize(widthSize/1.5, heightSize/1.5);

        ROOT.getChildren().addAll(pagination);

        return pagination;
    }

    private ScrollPane getScroll(Integer s) {
        HBox buttonsTransfer = new HBox();
        buttonsTransfer.setLayoutX(widthSize/2.5);
        buttonsTransfer.setLayoutY(heightSize/14);
        buttonsTransfer.setSpacing(20);
        buttonsTransfer.getChildren().addAll(translation, origin_translation);
        ButtonsTransfer buttons = new ButtonsTransfer();

        if (s.byteValue()==0){
            ROOT.getChildren().remove(buttonsTransfer);
            ROOT.getChildren().add(buttonsTransfer);
            buttons.getTransfer(textOneRu, textOneEn);
            buttons.getOriginTranslation(textOneRu);
            setText(textOneEn);
        } else if (s.byteValue()==1){
            ROOT.getChildren().remove(buttonsTransfer);
            ROOT.getChildren().add(buttonsTransfer);
            buttons.getTransfer(textTwoRu, textTwoEn);
            buttons.getOriginTranslation(textTwoRu);
            setText(textTwoEn);
        } else if (s.byteValue()==2){
            ROOT.getChildren().remove(buttonsTransfer);
            ROOT.getChildren().add(buttonsTransfer);
            buttons.getTransfer(textThreeRu, textThreeEn);
            buttons.getOriginTranslation(textThreeRu);
            setText(textThreeEn);
        }

        return scrollPane;
    }
}
