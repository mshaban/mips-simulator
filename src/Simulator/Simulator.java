package simulator;

import component.DataMemory;
import component.InstructionMemory;
import component.Label;
import component.Register;
import exceptions.InvalidOperationException;
import formats.Instruction;
import instructions.*;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by EslaMaged on 5/23/14.
 * package simulator
 * project mips-simulator
 */
public class Simulator {

    private int pc;
    private static Simulator simulator = new Simulator();

    private Simulator() {
        gassanMattar();
    }

    public static Simulator getSimulator() {
        return simulator;
    }

    public int getPc() {
        return pc;
    }

    private void readInstructions() {
        BufferedReader bf;
        try {
            bf = new BufferedReader(new FileReader("sample1.in"));
            String line;
            int counter = 0;
            while ((line = bf.readLine()) != null) {
                if (line.trim().endsWith(":")) {
                    Label.getLabelInstance().addLabel(line.substring(0, line.length() - 1), counter);
                } else {
                    InstructionMemory.getInstructionSet().addInstruction(line);
                    counter++;
                }
            }
        } catch (java.io.IOException | InvalidOperationException e) {
            e.printStackTrace();
        }
    }

    public void resetSimulator() {
        pc = 0;
        InstructionMemory.getInstructionSet().reset();
        DataMemory.getDataMemory().reset();
        Register.getRegister().reset();
    }

    public void run() {
        resetSimulator();
        readInstructions();
    }

    private void gassanMattar() {
        System.out.println("Welcome to our MIPS Project!");
    }

    public void instructionFetch() throws Exception {
        int old = pc;
        instructionDecode();
        pc += old == pc ? 1 : 0;
    }

    public void instructionDecode() throws Exception {
        //instruction decode
        String s = InstructionMemory.getInstructionSet().getInsruction(pc);
        Instruction instruction;
        String[] array = s.split(" ");
        String operation = array[0].trim();
        String rs = "";
        String rt = "";
        if (array.length > 2) {
            rs = array[1].trim().substring(0, array[1].length() - 1);
            rt = array[2].trim().substring(0, array[2].length() - 1);
        }
        switch (operation) {
            case "add":
                instruction = new add(rs, rt, array[3].trim());
                break;
            case "addi":
                instruction = new addi(rs, rt, Integer.parseInt(array[3].trim()));
                break;
            case "and":
                instruction = new and(rs, rt, array[3].trim());
                break;
            case "andi":
                instruction = new andi(rs, rt, Integer.parseInt(array[3].trim()));
                break;
            case "lw":
                instruction = new lw(rs, rt, 0);
                break;
            case "nor":
                instruction = new nor(rs, rt, array[3].trim());
                break;
            case "or":
                instruction = new or(rs, rt, array[3].trim());
                break;
            case "ori":
                instruction = new ori(rs, rt, Integer.parseInt(array[3].trim()));
                break;
            case "sll":
                instruction = new sll(rs, rt, array[3].trim());
                break;
            case "slt":
                instruction = new slt(rs, rt, array[3].trim());
                break;
            case "srl":
                instruction = new srl(rs, rt, array[3].trim());
                break;
            case "sub":
                instruction = new sub(rs, rt, array[3].trim());
                break;
            case "sw":
                instruction = new sw(rs, rt, 0);
                break;
            case "beq":
                instruction = new beq(rs, rt, array[3].trim());
                break;
            case "bne":
                instruction = new bne(rs, rt, array[3].trim());
                break;
            case "j":
                instruction = new j(s.split(" ")[1]);
                break;
            case "jal":
                instruction = new jal(s.split(" ")[1]);
                break;
            case "jr":
                instruction = new jr(s.split(" ")[1]);
                break;
            default:
                throw new InvalidOperationException();
        }
        instructionExecute(instruction);
    }

    public void instructionExecute(Instruction instruction) throws Exception {
        instruction.execute();
    }

    public void jumpTo(int index) {
        pc = index;
    }

    public static void main(String[] args) throws Exception {
        simulator.run();
        Register.getRegister().writeRegister("$s0", 2);
        Register.getRegister().writeRegister("$s1", 2);
        simulator.instructionFetch();
        simulator.instructionFetch();
        simulator.instructionFetch();
        simulator.instructionFetch();
        Label.getLabelInstance().printLabelInstance();
        System.out.println(simulator.getPc());
//        Register.getRegister().printRegisters();
    }
}
