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

import static component.InstructionMemory.getInstructionSet;

/**
 * Created by EslaMaged on 5/23/14.
 * package simulator
 * project mips-simulator
 */
public class Simulator {

    private int pc;
    private static Simulator simulator = new Simulator();
    int clkCycle;
    String toDecode;
    Instruction toExecute;
    Instruction toWriteBack;
    int toFetch;

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
                    getInstructionSet().addInstruction(line);
                    counter++;
                }
            }
        } catch (java.io.IOException | InvalidOperationException e) {
            e.printStackTrace();
        }
    }

    public void resetSimulator() {
        pc = 0;
        getInstructionSet().reset();
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
        if (toFetch < InstructionMemory.getInstructionSet().getInstructions().size())
            toDecode = getInstructionSet().getInsruction(toFetch);
        toFetch++;
    }


    public void instructionDecode() throws Exception {
        //instruction decode
        String s = toDecode;
        String[] array = s.split(" ");
        String operation = array[0].trim();
        String rs = "";
        String rt = "";
        if (array.length > 2) {
            rs = array[1].trim().substring(0, array[1].length());
            rt = array[2].trim().substring(0, array[2].length());
            rs = rs.replaceAll(",", "");
            rt = rt.replaceAll(",", "");
        }
        switch (operation) {
            case "add":
                toExecute = new add(rs, rt, array[3].trim());
                break;
            case "addi":
                toExecute = new addi(rs, rt, Integer.parseInt(array[3].trim()));
                break;
            case "and":
                toExecute = new and(rs, rt, array[3].trim());
                break;
            case "andi":
                toExecute = new andi(rs, rt, Integer.parseInt(array[3].trim()));
                break;
            case "lw":
                toExecute = new lw(rs, rt, 0);
                break;
            case "nor":
                toExecute = new nor(rs, rt, array[3].trim());
                break;
            case "or":
                toExecute = new or(rs, rt, array[3].trim());
                break;
            case "ori":
                toExecute = new ori(rs, rt, Integer.parseInt(array[3].trim()));
                break;
            case "sll":
                toExecute = new sll(rs, rt, array[3].trim());
                break;
            case "slt":
                toExecute = new slt(rs, rt, array[3].trim());
                break;
            case "srl":
                toExecute = new srl(rs, rt, array[3].trim());
                break;
            case "sub":
                toExecute = new sub(rs, rt, array[3].trim());
                break;
            case "sw":
                toExecute = new sw(rs, rt);
                break;
            case "beq":
                toExecute = new beq(rs, rt, array[3].trim());
                break;
            case "bne":
                toExecute = new bne(rs, rt, array[3].trim());
                break;
            case "j":
                toExecute = new j(s.split(" ")[1]);
                break;
            case "jal":
                toExecute = new jal(s.split(" ")[1]);
                break;
            case "jr":
                toExecute = new jr(s.split(" ")[1]);
                break;
            default:
                throw new InvalidOperationException();
        }
    }

    public void instructionExecute() throws Exception {
        if (!(toExecute instanceof sw || toExecute instanceof lw))
            toExecute.execute();
        else {
            toWriteBack = toExecute;
        }
        pc++;
    }

    public void accessMemory() throws Exception {
        if (toWriteBack instanceof sw || toWriteBack instanceof lw) {
            toWriteBack.execute();
        }
    }

    public void jumpTo(int index) {
        pc = index;
        toDecode = null;
        toFetch = pc;
        toExecute = null;
    }

    public void nextStep() throws Exception {
        if (toExecute != null) {
            instructionExecute();
            toExecute = null;
        }
        if (toDecode != null) {
            instructionDecode();
            toDecode = null;
        }

        if (toWriteBack != null) {
            accessMemory();
            toWriteBack = null;
        }
        if (toFetch < InstructionMemory.getInstructionSet().getInstructions().size())
            instructionFetch();
    }


    public void runProgram() throws Exception {
        clkCycle = 0;
        while (toExecute != null || toDecode != null || clkCycle == 0 || toWriteBack != null) {
            nextStep();
            clkCycle++;
        }
    }

    public static void main(String[] args) throws Exception {
        simulator.run();
        simulator.runProgram();
        DataMemory.getDataMemory().printDataMemory();
    }

}