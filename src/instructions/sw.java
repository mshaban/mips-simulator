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

    public sw(String rs, String rt, int constant) throws Exception {
        super(rs, rt, constant);
    }

    public sw(String rs, String rt) throws Exception {
        super(rs, rt);
    }

    @Override
    public void execute() throws Exception {
        int offset = Integer.parseInt(getRt().split("\\(")[0]);
        int core = Integer.parseInt(getRt().substring(getRt().indexOf('('), getRt().indexOf(')')));
        core *= 4;

        int[] dataArray = {Register.getRegister().readRegister(getRs())};
        DataMemory.getDataMemory().write(dataArray, core + offset);

    }

    @Override
    public void writeBack(String rs, int result) throws Exception {
        
    }
}
