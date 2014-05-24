package formats;

/**
 * Created by mohamed on 5/22/14.
 * package formats
 * project mips-simulator
 */
public abstract class JFormat extends Instruction {

    private String label;

    public JFormat(String label) throws Exception {
        this.label = label;
    }


    public String getLabel() {
        return label;
    }

    public abstract void execute() throws Exception;
}
