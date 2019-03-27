package fenwicktreevisualization.Controller;

import PseudoCodeDescriptionContainer.ViewController.PseudoCodeDescriptionContainerViewController;
import fenwicktreevisualization.Common.Constant;
import fenwicktreevisualization.Model.VisualizeModel;
import fenwicktreevisualization.Visualization.GetVisualizationTask;
import fenwicktreevisualization.Visualization.UpdateVisualizationTask;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


public class Control extends GridPane {
    private VisualizeModel visualizeModel;
    private PseudoCodeDescriptionContainerViewController pseudoCodeDescriptionContainerViewController;
    private Text txtNumberOfNode;
    private Text txtUpdate;
    private Text txtGet;
    private TextField tfUpdateValue;
    private ComboBox cbNumberOfNode;
    private ComboBox cbUpdateNodes;
    private ComboBox cbGetNodes;
    private Button btnUpdateNodeNums;
    private Button btnDoUpdate;
    private Button btnDoGet;
    private ObservableList<String> getOptions(int n) {
        List<String> nOptions = new ArrayList<>();
        for(int i=1;i<= n; i++) {
            nOptions.add(i + "");
        }
        ObservableList<String> options =
                FXCollections.observableArrayList(nOptions);
        return options;
    }

    private void disableAllButton () {
        this.btnUpdateNodeNums.setDisable(true);
        this.btnDoGet.setDisable(true);
        this.btnDoUpdate.setDisable(true);
    }
    private void enableAllButton () {
        this.btnUpdateNodeNums.setDisable(false);
        this.btnDoGet.setDisable(false);
        this.btnDoUpdate.setDisable(false);
    }
    public Control(VisualizeModel visualizeModel, PseudoCodeDescriptionContainerViewController pseudoCodeDescriptionContainerViewController) {
        this.visualizeModel = visualizeModel;
        this.pseudoCodeDescriptionContainerViewController = pseudoCodeDescriptionContainerViewController;
        this.txtNumberOfNode = new Text("n:");
        this.txtUpdate = new Text("Update:");
        this.txtGet = new Text("Get:");
        this.tfUpdateValue = new TextField();


        this.cbNumberOfNode = new ComboBox(getOptions(Constant.MAX_N));

        this.cbUpdateNodes = new ComboBox();
        this.cbGetNodes = new ComboBox();
        this.btnUpdateNodeNums = new Button("Update");
        this.btnDoUpdate = new Button("Update");
        this.btnDoGet = new Button("Get");
        this.btnDoGet.setDisable(true);
        this.btnDoUpdate.setDisable(true);

        this.btnUpdateNodeNums.setOnAction((event) -> {
            String s = (String) this.cbNumberOfNode.valueProperty().getValue();
            int newNumberOfNode = Integer.parseInt(s);
            this.visualizeModel.getGraphModel().update(newNumberOfNode);
            this.visualizeModel.getGraph().update();
            this.visualizeModel.getLayout().update();
            this.pseudoCodeDescriptionContainerViewController.settModel("Built Fenwick Tree with size: " + newNumberOfNode, "");

            this.cbUpdateNodes.getItems().clear();
            this.cbUpdateNodes.getItems().addAll(getOptions(newNumberOfNode));
            this.cbGetNodes.getItems().clear();
            this.cbGetNodes.getItems().addAll(getOptions(newNumberOfNode));
            enableAllButton();
        });


        tfUpdateValue.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfUpdateValue.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        this.btnDoUpdate.setOnAction(event -> {

            try {
                int index = Integer.parseInt((String)cbUpdateNodes.valueProperty().getValue());
                int value = Integer.parseInt(tfUpdateValue.getText());
                disableAllButton();
                Thread task = new Thread((new UpdateVisualizationTask(this.visualizeModel.getGraphModel(), this.visualizeModel.getLayout(), pseudoCodeDescriptionContainerViewController, this,  index, value)));
                task.start();
            } catch (Exception e) {
                //
            }

        });
        this.btnDoGet.setOnAction(event -> {
            try {
                int index = Integer.parseInt((String) cbGetNodes.valueProperty().getValue());
                disableAllButton();
                (new GetVisualizationTask(this.visualizeModel.getGraphModel(), this.visualizeModel.getLayout(), pseudoCodeDescriptionContainerViewController, this, index)).start();
            } catch (Exception e) {

            }
        });

    }

    public void onTaskDone() {
        enableAllButton();
    }
    public void initComponents () {
        this.setVgap(3);
        this.setHgap(4);
        this.setPadding(new Insets(30, 30, 30, 30));
        this.add(txtNumberOfNode, 0 , 0 );
        this.add(cbNumberOfNode, 1 , 0 );
        this.add(btnUpdateNodeNums, 2 , 0 );
        this.add(txtUpdate, 0 , 1 );
        this.add(cbUpdateNodes, 1 , 1 );
        this.add(tfUpdateValue, 2 , 1 );
        this.add(btnDoUpdate, 3, 1);
        this.add(txtGet, 0 , 2 );
        this.add(cbGetNodes, 1 , 2 );
        this.add(btnDoGet, 2 , 2 );
    }
}
