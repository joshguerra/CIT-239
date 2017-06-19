/**
 * @author Josh Guerra
 * Modified: 06.01.16
 */
package dictionary;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dictionary extends Application {
    Insets inset_TLB = new Insets(10, 0, 10, 10);
    Insets inset_LTR = new Insets(10, 10, 0, 10);
    Insets inset_TR = new Insets(10, 10, 0, 0);
    final int BTN_SIZE = 24;
    int indexCurrent = 0;
    boolean editTerm = false;
          
    @Override
    public void start(Stage primaryStage) {
        //////////////////////////////////////////////
        //                Main Screen               //
        //////////////////////////////////////////////
        
        BorderPane basePane = new BorderPane();
        Scene baseScene = new Scene(basePane, 600, 400);
        
        // words only (left side)
        ObservableList<Term> terms = FXCollections.observableArrayList();
        
        ListView<Term> leftPanel = new ListView<>(terms);
        leftPanel.setPlaceholder(new Text("No Words"));
        leftPanel.setPrefWidth(120);
        basePane.setLeft(leftPanel);
        
        // create nodes for center pane
        Text mainWord = new Text();
        Text mainDef = new Text();
        mainDef.setWrappingWidth(400);
        if(terms.isEmpty()) {
            mainWord.setText("Click the + button on the right to add a word "
                    + "to this Dictionary");
        }
        else {
            mainWord.setText(terms.get(indexCurrent).getWord());
            mainDef.setText(terms.get(indexCurrent).getDefinition());
        }
        
        // define center pane and add children
        VBox defPane = new VBox();
        defPane.getChildren().addAll(mainWord, mainDef);
        defPane.setMargin(mainWord, inset_LTR);
        defPane.setMargin(mainDef, inset_LTR);
        basePane.setCenter(defPane);
        
        // button images
        ImageView imgViewPlus = new ImageView();
        imgViewPlus.setImage(new Image(getClass().getResourceAsStream("plus.png")));
        imgViewPlus.setFitWidth(BTN_SIZE);
        imgViewPlus.setPreserveRatio(true);

        ImageView imgViewPencil = new ImageView();
        imgViewPencil.setImage(new Image(getClass().getResourceAsStream("pencil.png")));
        imgViewPencil.setFitWidth(BTN_SIZE);
        imgViewPencil.setPreserveRatio(true);

        ImageView imgViewBin = new ImageView();
        imgViewBin.setImage(new Image(getClass().getResourceAsStream("bin.png")));
        imgViewBin.setFitWidth(BTN_SIZE);
        imgViewBin.setPreserveRatio(true);

        // create buttons and add images
        Button btnAdd = new Button();    btnAdd.setGraphic(imgViewPlus);
        Button btnEdit = new Button();   btnEdit.setGraphic(imgViewPencil);
        Button btnDel = new Button();    btnDel.setGraphic(imgViewBin);
        
        // define right pane and add children
        VBox btnPane = new VBox();
        btnPane.getChildren().addAll(btnAdd, btnEdit, btnDel);
        btnPane.setMargin(btnAdd, inset_TR);
        btnPane.setMargin(btnEdit, inset_TR);
        btnPane.setMargin(btnDel, inset_TR);
        basePane.setRight(btnPane);
        
        //////////////////////////////////////////////
        //              Add/Edit Screen             //
        //////////////////////////////////////////////
        
        BorderPane editPane = new BorderPane();
        Scene editScene = new Scene(editPane,600, 400);
        
        VBox editTopPane = new VBox();
        FlowPane editBotPane = new FlowPane();
        
        // word and definition fields
        Text editLabelWord = new Text("Word: ");
        Text editLabelDef = new Text("Definition: ");
        TextField editFieldWord = new TextField();
        TextArea editFieldDef = new TextArea();
        
        // spacing
        editTopPane.setMargin(editLabelWord, inset_LTR);
        editTopPane.setMargin(editLabelDef, inset_LTR);
        editTopPane.setMargin(editFieldWord, inset_LTR);
        editTopPane.setMargin(editFieldDef, inset_LTR);
        
        editTopPane.getChildren().addAll(editLabelWord, editFieldWord, editLabelDef, editFieldDef);
        
        // buttons
        ImageView imgViewCancel = new ImageView();
        imgViewCancel.setImage(new Image(getClass().getResourceAsStream("cancel.png")));
        imgViewCancel.setFitWidth(BTN_SIZE);
        imgViewCancel.setPreserveRatio(true);
        

        ImageView imgViewConfirm = new ImageView();
        imgViewConfirm.setImage(new Image(getClass().getResourceAsStream("confirm.png")));
        imgViewConfirm.setFitWidth(BTN_SIZE);
        imgViewConfirm.setPreserveRatio(true);
        
        Button btnConfirm = new Button();   btnConfirm.setGraphic(imgViewConfirm);
        Button btnCancel = new Button();    btnCancel.setGraphic(imgViewCancel);
        editBotPane.getChildren().addAll(btnConfirm, btnCancel);
        
        // spacing
        editBotPane.setMargin(btnConfirm, inset_TLB);
        editBotPane.setMargin(btnCancel, inset_TLB);
        
        // attach panes
        editPane.setTop(editTopPane);
        editPane.setBottom(editBotPane);
        
        //////////////////////////////////////////////
        //               Delete Screen              //
        //////////////////////////////////////////////
        
        VBox delPane = new VBox();
        Scene delScene = new Scene(delPane,600, 400);
        
        Text delText = new Text();
        
        Button btnDelYes = new Button("Delete");
        Button btnDelNo = new Button("Do Not Delete");
        
        FlowPane delBtnPane = new FlowPane();
        delBtnPane.getChildren().addAll(btnDelYes, btnDelNo);
        delPane.getChildren().addAll(delText, delBtnPane);

        // spacing
        delPane.setMargin(delText, inset_LTR);
        delBtnPane.setMargin(btnDelYes, inset_LTR);
        delBtnPane.setMargin(btnDelNo, inset_TR);
        
        //////////////////////////////////////////////
        //           listeners / handlers           //
        //////////////////////////////////////////////
        
        // word list selection events got help from mentor and SO
        leftPanel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Term>() {
            public void changed(ObservableValue<? extends Term> observable, Term oldValue, Term newValue) {
                indexCurrent = leftPanel.getSelectionModel().getSelectedIndex();
                mainWord.setText(newValue.getWord());
                mainDef.setText(newValue.getDefinition());
            }
        });
        
        btnAdd.setOnAction((event) -> {
            editTerm = false;
            editFieldWord.setText("");
            editFieldDef.setText("");
            primaryStage.setScene(editScene);
        });
        
        btnEdit.setOnAction((event) -> {
            if (!terms.isEmpty()) {
                editTerm = true;
                Term temp = new Term(terms.get(indexCurrent).getWord(), 
                        terms.get(indexCurrent).getDefinition());
                editFieldWord.setText(temp.getWord());
                editFieldDef.setText(temp.getDefinition());
                primaryStage.setScene(editScene);
            }
        });
        
        btnDel.setOnAction((event) -> {
            if (terms.isEmpty())
                delText.setText("There are no words to delete. Click either "
                    + "button to return to the previous screen.");
            else
                delText.setText("Are you sure you want to delete " 
                    + terms.get(indexCurrent).getWord() + "? "
                    + "\nThis cannot be undone.");
            primaryStage.setScene(delScene);
        });
        
        btnDelYes.setOnAction((event) -> {
            if (!terms.isEmpty()) {
                terms.remove(indexCurrent);
                if (terms.isEmpty()) {
                    mainWord.setText("Click the + button on the right to add "
                            + "a word to this Dictionary");
                    mainDef.setText("");
                }
                else {
                    mainWord.setText("");
                    mainDef.setText("");
                }
            }
            primaryStage.setScene(baseScene);
        });
        
        btnDelNo.setOnAction((event) -> {
            primaryStage.setScene(baseScene);
        });
        
        btnCancel.setOnAction((event) -> {
           primaryStage.setScene(baseScene);
        });
        
        btnConfirm.setOnAction((event) -> {
            if (editTerm) {
                terms.get(indexCurrent).setWord(editFieldWord.getText());
                terms.get(indexCurrent).setDefinition(editFieldDef.getText());
            }
            else
                terms.add(new Term(editFieldWord.getText(), editFieldDef.getText()));
            
            mainWord.setText(terms.get(indexCurrent).getWord());
            mainDef.setText(terms.get(indexCurrent).getDefinition());
            primaryStage.setScene(baseScene);
        });
        
        primaryStage.setTitle("Dictionary");
        primaryStage.setScene(baseScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
