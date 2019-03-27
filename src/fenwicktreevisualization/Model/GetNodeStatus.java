package fenwicktreevisualization.Model;

public class GetNodeStatus {
    private int index;
    private int currentSum;
    private int currentValue;

    public GetNodeStatus(int index, int currentSum, int currentValue) {
        this.index = index;
        this.currentSum = currentSum;
        this.currentValue = currentValue;
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

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
}
