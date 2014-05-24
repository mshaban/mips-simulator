package instructions;

import component.Label;
import component.Register;
import formats.IFormat;
import simulator.Simulator;

/**
 * Created by mohamed on 5/22/14.
 * package instructions
 * project mips-simulator
 */
public class beq extends IFormat {

    public beq(String rs, String rt, int constant) throws Exception {
        super(rs, rt, constant);
    }

    public beq(String rs, String rt, String rd) throws Exception {
        super(rs, rt, rd);
    }

    @Override
    public void execute() throws Exception {
        int v1 = Register.getRegister().readRegister(getRs());
        int v2 = Register.getRegister().readRegister(getRt());
        if (v1 == v2) {
            int address = Label.getLabelInstance().getLabelAddress(getRd());
            Simulator.getSimulator().jumpTo(address);
        }
    }
}
