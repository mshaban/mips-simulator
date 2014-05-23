package instructions;

import component.ALU;
import component.Register;
import exceptions.InvalidArgumentException;
import formats.RFormat;

/**
 * Created by EslaMaged on 5/23/14.
 */
public class add extends RFormat {

    public add(String rs, String rt, String rd) throws InvalidArgumentException {
        super(rs, rt, rd);
    }

    @Override
    public void execute() throws Exception {

        int r1 = Register.getRegister().readRegister(this.getRt());
        int r2 = Register.getRegister().readRegister(this.getRd());
        int result = ALU.executeInstruction("add", r1, r2);
        Register.getRegister().writeRegister(getRs(), result);
    }

}
