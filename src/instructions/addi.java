package instructions;

import formats.IFormat;

/**
 * Created by mohamed on 5/22/14.
 * package instructions
 * project mips-simulator
 */
public class addi extends IFormat {

    public addi(String rs, String rt, int constant) throws Exception {
        super(rs, rt, constant);
    }

    @Override
    public void execute() {


    }
}
