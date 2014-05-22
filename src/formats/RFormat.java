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
    private String rt;
    private String rd;

    /**
     * Constructor
     * @param rs String
     * @param rt String
     * @param rd String
     *
     * @author: Eslam Maged
     */
    public RFormat( String rs, String rt, String rd) throws  InvalidArgumentException {
        if((!(rs.trim().charAt(0)!='$') )||(!(rt.trim().charAt(0)!='$')))
            throw new InvalidArgumentException();
        this.rs = rs;
        this.rt = rt;
        this.rd = rd;
    }

    public abstract void execute();

}
