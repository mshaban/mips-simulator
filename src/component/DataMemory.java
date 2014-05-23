package component;

import java.util.Arrays;

import exceptions.MemoryOutOfBoundsException;
import exceptions.WrongIndiciesException;

/**
 * Created by EslaMaged on 5/23/14.
 */
public class DataMemory {


    private byte[] memory;
    private static DataMemory dataMemory = new DataMemory();

    /**
     * The constructor of the Memory class
     *
     * @param memory
     * @author: EslaMaged
     */
    public DataMemory(byte[] memory) {
        this.memory = memory;
    }

    /**
     * The default constructor of the Memory class, and it sets the size of the memory to 2 to the power of 5
     *
     * @author: EslaMaged
     */
    private DataMemory() {
        memory = new byte[1 << 5];
    }

    /**
     * Gets the memory byte array
     *
     * @return memory : Array of Bytes
     * @author: EslaMaged
     */
    public byte[] getMemory() {
        return memory;
    }

    /**
     * Sets the memory array of bytes to a given value
     *
     * @param memory
     * @author: EslaMaged
     */
    public void setMemory(byte[] memory) {
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
     * @param value Array of Bytes
     * @param index Integer
     * @throws MemoryOutOfBoundsException
     * @author: Eslam
     */
    public void write(byte[] value, int index) throws MemoryOutOfBoundsException {
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
     * @return Array of Bytes
     * @throws WrongIndiciesException
     * @throws MemoryOutOfBoundsException
     * @author: EslaMaged
     */

    public byte[] read(int startIndex, int endIndex) throws WrongIndiciesException, MemoryOutOfBoundsException {
        if (startIndex < endIndex) {
            throw new WrongIndiciesException();
        } else if (startIndex < 0 || endIndex > this.getSize()) {
            throw new MemoryOutOfBoundsException();
        }

        byte[] result = new byte[endIndex - startIndex];

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

    public static DataMemory getDataMemory() {
        return dataMemory;
    }

}
