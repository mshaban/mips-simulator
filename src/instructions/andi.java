package instructions;

import component.ALU;
import component.Register;
import formats.IFormat;

/**
 * Created by EslaMaged on 5/23/14.
 */
public class andi extends IFormat {
    public andi(String rs, String rt, int constant) throws Exception {
        super(rs, rt, constant);
    }

    @Override
    public void execute() throws Exception {
        int v1 = Register.getRegister().readRegister(getRt());
        int v2 = getConstant();
        int result = ALU.executeInstruction("and", v1, v2);
        Register.getRegister().writeRegister(getRs(), result);
    }
}
