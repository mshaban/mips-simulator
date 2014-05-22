package formats;

import exceptions.OutOfRangeException;

/**
 * Created by mohamed on 5/22/14.
 * package formats
 * project mips-simulator
 */
public class JFormat {

    int address;

    public JFormat(int address) throws Exception {
        if (address > (1 << 26))
            throw new OutOfRangeException();
        this.address = address;
    }
}
