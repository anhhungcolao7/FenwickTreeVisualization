package fenwicktreevisualization.Model;

import javafx.scene.Group;
import javafx.scene.text.Text;


public class ValueNode extends Group {
    private Text txtValue;
    private Node node;
    private int index;
    private int value;


    public ValueNode() {
        this(new Text(), new Node(), 0, -1);
    }

    public ValueNode(int index) {
        this(new Text(), new Node(index), 0, index);
    }

    public ValueNode(int index, int value) {
        this(new Text(value + ""), new Node(index) , value, index);
    }



    public ValueNode(Text txtValue, Node node, int value, int index) {
        super(txtValue, node);
        this.txtValue = txtValue;
        this.value = value;
        this.node = node;
        this.index = index;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
        this.txtValue.setText(this.value + "");
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        this.node.setIndex(index);
    }

    public Text getTxtValue() {
        return txtValue;
    }

    public void setTxtValue(Text txtValue) {
        this.txtValue = txtValue;
    }
}
