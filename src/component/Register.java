package component;

import exceptions.CannotWriteException;
import exceptions.InvalidRegisterNameException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohamed on 5/23/14.
 * package component
 * project mips-simulator
 */
public class Register {

    private static final String readOnlyRegister = "$zero";
    private static Register register = new Register();
    private HashMap<String, Integer> registers;

    private Register() {
        registers = new HashMap<>();
        readFile();
    }

    public static Register getRegister() {
        return register;
    }

    public static void setRegister(Register register) {
        Register.register = register;
    }

    private void readFile() {
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

    public int readRegister(String registerName) throws Exception {
        registerName = registerName.toLowerCase();
        if (!registers.containsKey(registerName)) {
            throw new InvalidRegisterNameException();
        }
        return registers.get(registerName);
    }

    public void printRegisters() {

        for (Map.Entry<String, Integer> ent : getRegisters().entrySet())
            System.out.println(ent.getKey() + "=>" + ent.getValue());
    }

    public void reset() {
        register = new Register();
    }

}
