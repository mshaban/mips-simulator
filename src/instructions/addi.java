package instructions;

import component.ALU;
import component.Register;
import formats.IFormat;
import simulator.Simulator;

/**
 * Created by mohamed on 5/22/14.
 * package instructions
 * project mips-simulator
 */
public class addi extends IFormat {

    public addi(String rs, String rt, int constant) throws Exception {
        super(rs, rt, constant);
    }

    @Override
    public void execute() throws Exception {
        int v1 = Register.getRegister().readRegister(getRt());
        int v2 = getConstant();
        result = ALU.executeInstruction("add", v1, v2);
    }

    @Override
    public void writeBack() throws Exception {
        System.out.println(Simulator.getSimulator().getClkCycle());
        Register.getRegister().writeRegister(getRs(), result);
    }
}
