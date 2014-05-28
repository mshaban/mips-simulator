package GUI;

import component.DataMemory;
import component.InstructionMemory;
import component.Register;
import simulator.Simulator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by mohamed on 5/27/14.
 * package GUI
 * project mips-simulator
 */
public class mipsGUI extends JFrame implements ActionListener, DocumentListener {
    private JPanel mipsPanel;
    private JButton nextInstructionButton;
    private JButton nextStepButton;
    private JButton runProgramButton;
    private JButton resetButton;
    private JEditorPane editorPane1;
    private JList<String> registerList;
    private JList<String> memoryList;
    private JTextField toDecode;
    private JTextField toFetch;
    private JTextField toExecute;
    private JTextField clkCycle;

    public mipsGUI() {
        super("mips simulator");
        setContentPane(mipsPanel);
        initList();
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        nextInstructionButton.addActionListener(this);
        nextStepButton.addActionListener(this);
        runProgramButton.addActionListener(this);
        resetButton.addActionListener(this);
        editorPane1.getDocument().addDocumentListener(this);
        toDecode.setEditable(false);
        toExecute.setEditable(false);
        toFetch.setEditable(false);
        clkCycle.setEditable(false);
        setVisible(true);
    }

    private void initList() {
        DefaultListModel<String> registerModel = new DefaultListModel<>();
        String line;
        try {
            BufferedReader bf = new BufferedReader(new FileReader("registers.in"));
            while ((line = bf.readLine()) != null)
                registerModel.addElement(line + ": 0");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        registerList.setModel(registerModel);
        DefaultListModel<String> memoryModel = new DefaultListModel<>();
        int cnt = 0;
        for (int val : DataMemory.getDataMemory().getMemory()) {
            memoryModel.addElement(cnt + " => " + val);
            cnt++;
        }
        memoryList.setModel(memoryModel);
    }

    public void updateList() {
        DefaultListModel<String> registerModel = new DefaultListModel<>();
        for (int i = 0; i < registerList.getModel().getSize(); ++i) {
            try {
                String reg = registerList.getModel().getElementAt(i).split(":")[0];
                int value = Register.getRegister().readRegister(reg);
                registerModel.addElement(reg + ": " + value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        registerList.setModel(registerModel);

        DefaultListModel<String> memoryModel = new DefaultListModel<>();
        int cnt = 0;
        for (int val : DataMemory.getDataMemory().getMemory()) {
            memoryModel.addElement(cnt + " => " + val);
            cnt++;
        }
        memoryList.setModel(memoryModel);
    }

    public void updateTextField() {
        clkCycle.setText(Simulator.getSimulator().getClkCycle() + "");
        if (Simulator.getSimulator().getToDecode() != null)
            toDecode.setText(Simulator.getSimulator().getToDecode());
        else
            toDecode.setText("None");
        if (Simulator.getSimulator().getToExecute() != null)
            toExecute.setText(Simulator.getSimulator().getToExecute().toString());
        else
            toExecute.setText("None");
        try {
            if (Simulator.getSimulator().getToFetch() < InstructionMemory.getInstructionSet().getInstructions().size())
                toFetch.setText(InstructionMemory.getInstructionSet().getInsruction(Simulator.getSimulator().getToFetch()));
            else
                toFetch.setText("None");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        try {
            switch (action) {
                case "Compile":
                    Simulator.getSimulator().resetSimulator();
                    Simulator.getSimulator().readInstructionsFromString(editorPane1.getText());
                    break;
                case "Next step":
                    Simulator.getSimulator().nextStep();
                    break;
                case "Run program":
                    Simulator.getSimulator().runProgram();
                    break;
                case "Reset":
                    Simulator.getSimulator().resetSimulator();
                    break;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        updateList();
        updateTextField();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
}
