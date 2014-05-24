package Simulator;

import component.DataMemory;
import component.Register;
import formats.Instruction;
import instructions.*;

import java.util.ArrayList;

/**
 * Created by EslaMaged on 5/23/14.
 */
public class Simulator {
    private ArrayList<String> instructionSet;
    private DataMemory dataMemory;

    private int pc;
    private String currentInstruction;

    public ArrayList<String> getInstructionSet() {
        return instructionSet;
    }

    public void setInstructionSet(ArrayList<String> instructionSet) {
        this.instructionSet = instructionSet;
    }

    public DataMemory getDataMemory() {
        return dataMemory;
    }

    public void setDataMemory(DataMemory dataMemory) {
        this.dataMemory = dataMemory;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public String getCurrentInstruction() {
        return currentInstruction;
    }

    public void setCurrentInstruction(String currentInstruction) {
        this.currentInstruction = currentInstruction;
    }

    public void run() {
        gassanMattar();
        init();
        readInstructions();
        loadData();
    }

    private void loadData() {

    }

    private void readInstructions() {


        String instruction = "add s2, s0, s1";
        instructionSet.add(instruction);
        instruction = "lw s2, 4(s2)";
        instructionSet.add(instruction);
        instruction = "sub s2, s2, s0";
        instructionSet.add(instruction);
        instruction = "addi s2, s2, 1";
        instructionSet.add(instruction);

    }

    private void init() {
        this.pc = 0;
        this.currentInstruction = "";
        instructionSet = new ArrayList<>();

        dataMemory = new DataMemory();


    }

    private void gassanMattar() {
        System.out.println("Welcome to our MIPS Project!");
    }


    public static void main(String[] args) {
        Simulator sm = new Simulator();
        sm.run();
    }

    public void parser(String s) throws Exception {
        //  add s2, s0, s1
        //instruction decode
        Instruction instruction = null;
        String[] array = s.split(" ");
        String operation = array[0].trim();
        String rs = array[1].trim().substring(array[1].length() - 1);
        String rt = array[2].trim().substring(array[2].length() - 1);
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
        }

        instruction.execute();


    }
}
