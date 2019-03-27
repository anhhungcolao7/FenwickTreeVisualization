package fenwicktreevisualization.Visualization;

import PseudoCodeDescriptionContainerX.ViewController.PseudoCodeDescriptionContainerViewController;
import fenwicktreevisualization.Common.PsudoInterface;
import fenwicktreevisualization.Controller.Control;
import fenwicktreevisualization.Model.Layout;
import fenwicktreevisualization.Model.GetNodeStatus;
import fenwicktreevisualization.Model.GraphModel;
import javafx.application.Platform;

import java.util.List;

public class GetVisualizationTask extends Thread {
    private GraphModel graphModel;
    private Layout layout;
    private PseudoCodeDescriptionContainerViewController pseudoCodeDescriptionContainerViewController;
    private int index;
    private Control control;
    public GetVisualizationTask(GraphModel graphModel, Layout layout, PseudoCodeDescriptionContainerViewController pseudoCodeDescriptionContainerViewController, Control control, int index) {
        super();
        this.graphModel = graphModel;
        this.layout = layout;
        this.pseudoCodeDescriptionContainerViewController = pseudoCodeDescriptionContainerViewController;
        this.index = index;
        this.control = control;
    }
    @Override
    public void run() {
        layout.resetColor();
        int lastIndex = -1;
        String s = "";
        String s1 = "";
        List<GetNodeStatus> list = graphModel.getFenWickTree().getGetStepList(index);
        for(GetNodeStatus getNodeStatus:list) {
            int index = getNodeStatus.getIndex();
            int sum = getNodeStatus.getCurrentSum();
            int value = getNodeStatus.getCurrentValue();
            int newIndex = index - (index & -index);
            List<Integer> childs = graphModel.getFenWickTree().getAllChild(getNodeStatus.getIndex());
            s += ((!s.equals("")) ? " + " : "") + "BIT[" + index + "]";
            s1 += ((!s1.equals("")) ? " + " : "") + value;
            String s2 = s;
            String s3 = s1;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pseudoCodeDescriptionContainerViewController.settModel("sum = " + s2 + " = " + s3 + " = " + sum,
                    "index = " + index + " - (" + index + " & -" + index + ") = " + newIndex + ((newIndex <=0) ? (" <= 0" + ". Stop! ") : ""), PsudoInterface.GET_SUM_UPDATE);

                }
            });
            layout.doGetAnimation(getNodeStatus.getIndex(), getNodeStatus.getCurrentSum(), childs);
            lastIndex = getNodeStatus.getIndex();
        }
        control.onTaskDone();
    }
}
