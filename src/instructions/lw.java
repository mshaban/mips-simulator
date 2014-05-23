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
        int core = Integer.parseInt(getRt().substring(getRt().indexOf('('), getRt().indexOf(')')));
        core *= 4;
        int value = DataMemory.getDataMemory().read(offset + core, offset + core)[0];
        Register.getRegister().writeRegister(getRs(), value);

    }
}
