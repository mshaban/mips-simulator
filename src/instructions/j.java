package instructions;

import component.Label;
import formats.JFormat;
import simulator.Simulator;

/**
 * Created by mohamed on 5/22/14.
 * package instructions
 * project mips-simulator
 */
public class j extends JFormat {


    public j(String label) throws Exception {
        super(label);
    }

    @Override
    public void execute() {
        int address = Label.getLabelInstance().getLabelAddress(getLabel());
        Simulator.getSimulator().jumpTo(address);
    }
}
