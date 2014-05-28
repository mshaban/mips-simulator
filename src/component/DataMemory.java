package component;

import exceptions.MemoryOutOfBoundsException;
import exceptions.WrongIndiciesException;

import java.util.Arrays;

/**
 * Created by EslaMaged on 5/23/14.
 */
public class DataMemory {


    private static DataMemory dataMemory = new DataMemory();
    private int[] memory;

    /**
     * The constructor of the Memory class
     *
     * @param memory
     * @author: EslaMaged
     */
    public DataMemory(int[] memory) {
        this.memory = memory;
    }

    /**
     * The default constructor of the Memory class, and it sets the size of the memory to 2 to the power of 5
     *
     * @author: EslaMaged
     */
    public DataMemory() {
        memory = new int[1 << 8];
    }

    public static DataMemory getDataMemory() {
        return dataMemory;
    }

    /**
     * Gets the memory int array
     *
     * @return memory : Array of int
     * @author: EslaMaged
     */
    public int[] getMemory() {
        return memory;
    }

    /**
     * Sets the memory array of int to a given value
     *
     * @param memory
     * @author: EslaMaged
     */
    public void setMemory(int[] memory) {
        this.memory = memory;
    }

    /**
     * Gets the size of the memory
     *
     * @return int
     * @author: EslaMaged
     */
    public int getSize() {
        return this.memory.length;
    }

    /**
     * @param value Array of int
     * @param index Integer
     * @throws MemoryOutOfBoundsException
     * @author: Eslam
     */
    public void write(int[] value, int index) throws MemoryOutOfBoundsException {
        if (index < 0 || (value.length + index) > this.getSize()) {
            throw new MemoryOutOfBoundsException();
        }

        for (int i = index; i - index < value.length; i++) {
            memory[i] = value[i - index];

        }
    }

    /**
     * @param startIndex Integer
     * @param endIndex   Integer
     * @return Array of int
     * @throws WrongIndiciesException
     * @throws MemoryOutOfBoundsException
     * @author: EslaMaged
     */

    public int[] read(int startIndex, int endIndex) throws WrongIndiciesException, MemoryOutOfBoundsException {
        if (startIndex > endIndex) {
            throw new WrongIndiciesException();
        } else if (startIndex < 0 || endIndex > this.getSize()) {
            throw new MemoryOutOfBoundsException();
        }

        int[] result = new int[endIndex - startIndex];

        for (int i = 0; i < result.length; i++) {
            result[i] = memory[startIndex + i];
        }
        return result;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "memory=" + Arrays.toString(memory) +
                '}';
    }

    public void reset() {
        dataMemory = new DataMemory();
    }

    public void printDataMemory() {
        for (int i = 0; i < memory.length; i++)
            System.out.println(i + "=>" + memory[i]);
    }
}
