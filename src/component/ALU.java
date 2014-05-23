package component;

import exceptions.invalidOperationException;

/**
 * Created by mohamed on 5/23/14.
 * package component
 * project mips-simulator
 */
public class ALU {

    public static int executeInstruction(String op, int v1, int v2) throws Exception {

        op = op.toLowerCase();
        switch (op) {
            case "add":
                return v1 + v2;
            case "sub":
                return v1 - v2;
            case "and":
                return v1 & v2;
            case "or":
                return v1 | v2;
            case "nor":
                return ~(v1 | v2);
            case "slt":
                return v1 < v2 ? 1 : 0;
            default:
                throw new invalidOperationException();
        }
    }
}
