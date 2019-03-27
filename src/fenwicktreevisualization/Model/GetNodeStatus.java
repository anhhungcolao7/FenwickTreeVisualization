package fenwicktreevisualization.Model;

public class GetNodeStatus {
    private int index;
    private int currentSum;

    public GetNodeStatus(int index, int currentSum) {
        this.index = index;
        this.currentSum = currentSum;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCurrentSum() {
        return currentSum;
    }

    public void setCurrentSum(int currentSum) {
        this.currentSum = currentSum;
    }
}
