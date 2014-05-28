package instructions;

import component.ALU;
import component.Register;
import exceptions.InvalidArgumentException;
import formats.RFormat;

/**
 * Created by EslaMaged on 5/23/14.
 */
public class or extends RFormat {

    public or(String rs, String rt, String rd) throws InvalidArgumentException {

        super(rs, rt, rd);
    }

    @Override
    public void execute() throws Exception {
        int r1 = Register.getRegister().readRegister(this.getRt());
        int r2 = Register.getRegister().readRegister(this.getRd());
        result = ALU.executeInstruction("or", r1, r2);
    }

    @Override
    public void writeBack() throws Exception {
        Register.getRegister().writeRegister(getRs(), result);
    }
}
