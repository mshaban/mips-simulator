package instructions;

import exceptions.InvalidArgumentException;
import formats.RFormat;

/**
 * Created by EslaMaged on 5/23/14.
 */
public class slt extends RFormat{

    public slt(String rs, String rt, String rd) throws InvalidArgumentException {

        super(rs,rt,rd);
    }

    @Override
    public void execute() {

    }
}
