package instructions;

import component.DataMemory;
import component.Register;
import formats.IFormat;

/**
 * Created by mohamed on 5/22/14.
 * package instructions
 * project mips-simulator
 */
public class sw extends IFormat {


    public sw(String rs, String rt) throws Exception {
        super(rs, rt);
    }

    @Override
    public void execute() throws Exception {
        int offset = Integer.parseInt(getRt().split("\\(")[0]);
        int core = Register.getRegister().readRegister(getRt().substring(getRt().indexOf('(') + 1, getRt().indexOf(')')));
        core *= 4;
        result = core + offset;
    }

    @Override
    public void writeBack() throws Exception {
        int[] dataArray = {Register.getRegister().readRegister(getRs())};
        DataMemory.getDataMemory().write(dataArray, result);
    }
}
