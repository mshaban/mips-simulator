package formats;

import exceptions.InvalidArgumentException;
import exceptions.OutOfRangeException;

/**
 * Created by mohamed on 5/22/14.
 * package formats
 * project mips-simulator
 */
public abstract class IFormat extends Instruction {

    private String rs, rt;
    private int constant;

    public IFormat(String rs, String rt, int constant) throws Exception {
        if (!rs.startsWith("$") || !rt.startsWith("$"))
            throw new InvalidArgumentException();
        if (constant > (1 << 15) - 1 || constant < -1 * (1 << 15))
            throw new OutOfRangeException();
        this.rs = rs;
        this.rt = rt;
        this.constant = constant;
    }

    public IFormat(String rs, String rt) throws Exception {
        if (!rs.startsWith("$"))
            throw new InvalidArgumentException();
        this.rs = rs;
        this.rt = rt;
        this.constant = 0;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public int getConstant() {
        return constant;
    }

    public void setConstant(int constant) {
        this.constant = constant;
    }

    public abstract void execute() throws Exception;

}

