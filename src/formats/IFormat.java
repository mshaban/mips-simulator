package formats;

import exceptions.InvalidArgumentException;
import exceptions.OutOfRangeException;

/**
 * Created by mohamed on 5/22/14.
 * package formats
 * project mips-simulator
 */
public abstract class IFormat {

    String rs, rt;
    int constant;

    public IFormat(String rs, String rt, int constant) throws Exception {
        if (!rs.startsWith("$") || !rt.startsWith("$"))
            throw new InvalidArgumentException();
        if (constant > (1 << 15) - 1 || constant < -1 * (1 << 15))
            throw new OutOfRangeException();
        this.rs = rs;
        this.rt = rt;
        this.constant = constant;
    }

    public abstract void execute();
}

