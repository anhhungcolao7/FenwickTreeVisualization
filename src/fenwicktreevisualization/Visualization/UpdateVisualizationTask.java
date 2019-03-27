package fenwicktreevisualization.Visualization;

import fenwicktreevisualization.Controller.Control;
import fenwicktreevisualization.Model.Layout;
import fenwicktreevisualization.Model.GraphModel;
import fenwicktreevisualization.Model.UpdateNodeStatus;

import java.util.List;

public class UpdateVisualizationTask extends Thread {
    private GraphModel graphModel;
    private Layout layout;
    private int index;
    private int value;
    private Control control;

    public UpdateVisualizationTask(GraphModel graphModel, Layout layout, Control control, int index, int value) {
        super();
        this.graphModel = graphModel;
        this.layout = layout;
        this.index = index;
        this.value = value;
        this.control = control;
    }
    @Override
    public void run() {
        layout.resetColor();
        List<UpdateNodeStatus> lists = graphModel.getFenWickTree().getUpdateStepList(index, value);
        int lastIndex = -1;
        for(UpdateNodeStatus updateNodeStatus:lists) {
            layout.doUpdateAnimation(lastIndex, updateNodeStatus.getIndex(), value, updateNodeStatus.getNewValue());
            lastIndex = updateNodeStatus.getIndex();
        }
        control.onTaskDone();
    }
}
