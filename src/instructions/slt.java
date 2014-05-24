package instructions;

import component.ALU;
import component.Register;
import exceptions.InvalidArgumentException;
import formats.RFormat;

/**
 * Created by EslaMaged on 5/23/14.
 */
public class slt extends RFormat {

    public slt(String rs, String rt, String rd) throws InvalidArgumentException {

        super(rs, rt, rd);
    }

    @Override
    public void execute() throws Exception {

        int r1 = Register.getRegister().readRegister(this.getRt());
        int r2 = Register.getRegister().readRegister(this.getRd());
        int result = ALU.executeInstruction("slt", r1, r2);
        writeBack(getRs(), result);
    }

    @Override
    public void writeBack(String rs, int result) throws Exception {
        Register.getRegister().writeRegister(getRs(), result);
    }
}
