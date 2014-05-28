package instructions;

import component.DataMemory;
import component.Register;
import formats.IFormat;

/**
 * Created by mohamed on 5/22/14.
 * package instructions
 * project mips-simulator
 */
public class lw extends IFormat {

    public lw(String rs, String rt, int constant) throws Exception {
        super(rs, rt, constant);
    }

    public lw(String rs, String rt) throws Exception {
        super(rs, rt);
    }

    @Override
    public void execute() throws Exception {
        int offset = Integer.parseInt(getRt().split("\\(")[0]);
        int core = Register.getRegister().readRegister(getRt().substring(getRt().indexOf('(') + 1, getRt().indexOf(')')));
        core *= 4;
        result = DataMemory.getDataMemory().read(offset + core, offset + core + 1)[0];
    }

    @Override
    public void writeBack() throws Exception {
        Register.getRegister().writeRegister(getRs(), result);
    }
}
