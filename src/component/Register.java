package component;

import exceptions.CannotWriteException;
import exceptions.InvalidRegisterNameException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Created by mohamed on 5/23/14.
 * package component
 * project mips-simulator
 */
public class Register {

    private HashMap<String, Integer> registers;
    private static final String readOnlyRegister = "$zero";

    public Register() {
        registers = new HashMap<String, Integer>();
        String line;

        try {
            BufferedReader bf = new BufferedReader(new FileReader("registers.in"));
            while ((line = bf.readLine()) != null)
                registers.put(line, 0);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Integer> getRegisters() {
        return registers;
    }

    public void setRegisters(HashMap<String, Integer> registers) {
        this.registers = registers;
    }

    /**
     * @param registerName
     * @param value
     * @throws Exception
     */
    public void writeRegister(String registerName, int value) throws Exception {
        registerName = registerName.toLowerCase();
        if (registerName.equals(readOnlyRegister)) {
            throw new CannotWriteException();
        }
        if (!registers.containsKey(registerName)) {
            throw new InvalidRegisterNameException();
        }
        registers.put(registerName, value);
    }

    public int readRegister(String registerName, int value) throws Exception {
        registerName = registerName.toLowerCase();
        if (!registers.containsKey(registerName)) {
            throw new InvalidRegisterNameException();
        }
        return registers.get(registerName);
    }
}