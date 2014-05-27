package instructions;

import component.Label;
import component.Register;
import formats.JFormat;
import simulator.Simulator;

/**
 * Created by mohamed on 5/22/14.
 * package instructions
 * project mips-simulator
 */
public class jal extends JFormat {


    public jal(String label) throws Exception {
        super(label);
    }

    @Override
    public void execute() throws Exception {
        int address = Label.getLabelInstance().getLabelAddress(getLabel());
        writeBack("$ra", Simulator.getSimulator().getPc() + 1);
        Simulator.getSimulator().jumpTo(address);
    }

    @Override
    public void writeBack(String rs, int result) throws Exception {
        Register.getRegister().writeRegister("$ra", result);
    }
}
