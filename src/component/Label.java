package component;

import java.util.HashMap;

/**
 * Created by mohamed on 5/24/14.
 * package component
 * project mips-simulator
 */
public class Label {
    private HashMap<String, Integer> labels;
    private static Label labelInstance = new Label();

    public static Label getLabelInstance() {
        return labelInstance;
    }

    private Label() {
        labels = new HashMap<>();
    }


    public void addLabel(String label, int value) {
        labels.put(label, value);
    }

    public int getLabelAddress(String label) {
        return labels.get(label);
    }
}
