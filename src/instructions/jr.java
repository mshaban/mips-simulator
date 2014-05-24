package instructions;

import component.Register;
import formats.JFormat;
import simulator.Simulator;

/**
 * Created by mohamed on 5/22/14.
 * package instructions
 * project mips-simulator
 */
public class jr extends JFormat {


    public jr(String label) throws Exception {
        super(label);
    }

    @Override
    public void execute() throws Exception {
        int address = Register.getRegister().readRegister(getLabel());
        Simulator.getSimulator().jumpTo(address);
    }

    @Override
    public void writeBack(String rs, int result) throws Exception {

    }
}
