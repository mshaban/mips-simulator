package component;

import exceptions.OutOfRangeException;

import java.util.ArrayList;

/**
 * Created by EslaMaged on 5/23/14.
 */
public class InstructionMemory {

    ArrayList<String> instructions;
    private static InstructionMemory instructionSet = new InstructionMemory();

    public InstructionMemory() {
        instructions = new ArrayList<>();
    }

    public static InstructionMemory getInstructionSet() {
        return instructionSet;
    }

    public void addInstruction(String instruction) {
        instructions.add(instruction);
    }

    public String getInsruction(int pc) throws Exception {
        if (pc > instructions.size())
            throw new OutOfRangeException();
        System.out.println(pc + " " + instructions.size());
        return instructions.get(pc);
    }

    public void reset() {
        instructions = new ArrayList<>();
    }

    public void printInstructionMemory() {
        for (String s : instructions)
            System.out.println(s);
    }
}
