package instructions;

import component.ALU;
import component.Register;
import formats.IFormat;

/**
 * Created by mohamed on 5/22/14.
 * package instructions
 * project mips-simulator
 */
public class ori extends IFormat {

    public ori(String rs, String rt, int constant) throws Exception {
        super(rs, rt, constant);
    }

    @Override
    public void execute() throws Exception {
        int v1 = Register.getRegister().readRegister(getRt());
        int v2 = getConstant();
        int result = ALU.executeInstruction("ori", v1, v2);
        Register.getRegister().writeRegister(getRs(), result);
    }
}
