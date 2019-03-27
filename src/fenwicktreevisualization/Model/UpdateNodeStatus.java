package fenwicktreevisualization.Model;

public class UpdateNodeStatus {
    private int index;
    private int newValue;
    private int currentValue;

    public UpdateNodeStatus(int index, int newValue, int currentValue) {
        this.index = index;
        this.newValue = newValue;
        this.currentValue = currentValue;

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getNewValue() {
        return newValue;
    }

    public void setNewValue(int newValue) {
        this.newValue = newValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
}
