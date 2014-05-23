package component;

import exceptions.invalidOperationException;

/**
 * Created by mohamed on 5/23/14.
 * package component
 * project mips-simulator
 */
public class ALU {

    public static int executeInstruction(String op, int rs, int rt) throws Exception {

        op = op.toLowerCase();
        switch (op) {
            case "add":
                return rs + rt;
            case "sub":
                return rs - rt;
            case "and":
                return rs & rt;
            case "or":
                return rs | rt;
            case "nor":
                return ~(rs | rt);
            case "slt":
                return rs < rt ? 1 : 0;
            default:
                throw new invalidOperationException();
        }
    }
}
