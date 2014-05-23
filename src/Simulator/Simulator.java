package Simulator;

import component.DataMemory;
import component.Register;

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
        displayWelcomeMsg();
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

    private void displayWelcomeMsg() {
        System.out.println("Welcome to our MIPS Project!");
    }


    public static void main(String[] args) {
        Simulator sm = new Simulator();
        sm.run();
    }
}
