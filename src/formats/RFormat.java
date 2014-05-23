package formats;

import exceptions.InvalidArgumentException;
import exceptions.OutOfRangeException;

/**
 * Created by mohamed on 5/22/14.
 * package formats
 * project mips-simulator
 */
public abstract class RFormat {

    private String rs;

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    private String rt;
    private String rd;

    /**
     * Constructor
     * @param rs String
     * @param rt String
     * @param rd String
     *
     * @author: EslaMaged
     */
    public RFormat( String rs, String rt, String rd) throws  InvalidArgumentException {
        if(((rs.trim().charAt(0) != '$') )||((rt.trim().charAt(0) != '$')))
            throw new InvalidArgumentException();
        this.rs = rs;
        this.rt = rt;
        this.rd = rd;
    }

    public abstract void execute() throws Exception;

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }
}
