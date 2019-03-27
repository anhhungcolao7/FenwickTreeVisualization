package fenwicktreevisualization.Model;

public class UpdateNodeStatus {
    private int index;
    private int newValue;

    public UpdateNodeStatus(int index, int newValue) {
        this.index = index;
        this.newValue = newValue;
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
}
