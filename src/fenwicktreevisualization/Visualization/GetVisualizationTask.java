package fenwicktreevisualization.Visualization;

import fenwicktreevisualization.Controller.Control;
import fenwicktreevisualization.Model.Layout;
import fenwicktreevisualization.Model.GetNodeStatus;
import fenwicktreevisualization.Model.GraphModel;

import java.util.List;

public class GetVisualizationTask extends Thread {
    private GraphModel graphModel;
    private Layout layout;
    private int index;
    private Control control;
    public GetVisualizationTask(GraphModel graphModel, Layout layout, Control control, int index) {
        super();
        this.graphModel = graphModel;
        this.layout = layout;
        this.index = index;
        this.control = control;
    }
    @Override
    public void run() {
        layout.resetColor();
        int lastIndex = -1;
        List<GetNodeStatus> list = graphModel.getFenWickTree().getGetStepList(index);
        for(GetNodeStatus updateNodeStatus:list) {
            List<Integer> childs = graphModel.getFenWickTree().getAllChild(updateNodeStatus.getIndex());
            layout.doGetAnimation(updateNodeStatus.getIndex(), updateNodeStatus.getCurrentSum(), childs);
            lastIndex = updateNodeStatus.getIndex();
        }
        control.onTaskDone();
    }
}
