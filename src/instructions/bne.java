package instructions;

import formats.IFormat;

/**
 * Created by mohamed on 5/22/14.
 * package instructions
 * project mips-simulator
 */
public class bne extends IFormat {
    public bne(String rs, String rt, int constant) throws Exception {
        super(rs, rt, constant);
    }

    public bne(String rs, String rt, String rd) throws Exception {
        super(rs, rt, rd);
    }

    @Override
    public void execute() {

    }

    @Override
    public void writeBack(String rs, int result) throws Exception {

    }
}
