package fenwicktreevisualization.Visualization;

import PseudoCodeDescriptionContainer.ViewController.PseudoCodeDescriptionContainerViewController;
import fenwicktreevisualization.Common.PsudoInterface;
import fenwicktreevisualization.Controller.Control;
import fenwicktreevisualization.Model.Layout;
import fenwicktreevisualization.Model.GraphModel;
import fenwicktreevisualization.Model.UpdateNodeStatus;
import javafx.application.Platform;

import java.util.List;

public class UpdateVisualizationTask implements Runnable {
    private GraphModel graphModel;
    private Layout layout;
    private PseudoCodeDescriptionContainerViewController pseudoCodeDescriptionContainerViewController;
    private int index;
    private int value;
    private Control control;

    public UpdateVisualizationTask(GraphModel graphModel, Layout layout, PseudoCodeDescriptionContainerViewController pseudoCodeDescriptionContainerViewController,  Control control, int index, int value) {
        super();
        this.graphModel = graphModel;
        this.layout = layout;
        this.pseudoCodeDescriptionContainerViewController = pseudoCodeDescriptionContainerViewController;
        this.index = index;
        this.value = value;
        this.control = control;
    }
    @Override
    public void run() {
        layout.resetColor();
        List<UpdateNodeStatus> lists = graphModel.getFenWickTree().getUpdateStepList(index, value);
        int size = graphModel.getFenWickTree().getNumberOfNode();
        int lastIndex = -1;
        for(UpdateNodeStatus updateNodeStatus:lists) {
            int index = updateNodeStatus.getIndex();
            int newValue = updateNodeStatus.getNewValue();
                    int currentValue = updateNodeStatus.getCurrentValue();
                    int newIndex = index + (index & -index);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            pseudoCodeDescriptionContainerViewController.settModel("BIT[" + index + " ] = " + currentValue + " + " + value + " = " + newValue
                                    , "index = " + index + " + (" + index + " & -" + index + ") = " + newIndex + ((newIndex > size) ? (" > " + size + ". Stop! ") : "")
                                    , PsudoInterface.UPDATE_FW_TREE);
                        }
                    });

            layout.doUpdateAnimation(lastIndex, updateNodeStatus.getIndex(), value, updateNodeStatus.getNewValue());

            lastIndex = updateNodeStatus.getIndex();

        }
        control.onTaskDone();
    }
}
