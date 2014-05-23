package instructions;

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
    public void execute() {
//        DataMemory.getDataMemory().write();

    }
}
