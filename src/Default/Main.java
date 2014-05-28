package Default;

import component.Register;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by mohamed on 5/21/14.
 * package Default
 * project mips-simulator
 */
public class Main {

    public static void main(String[] args) {

        Register reg = Register.getRegister();

        for (Map.Entry<String, Integer> ent : reg.getRegisters().entrySet()) {
            System.out.println(ent.getKey() + "=>" + ent.getValue());
        }
        String rt = "0(15)";
        int core = Integer.parseInt(rt.substring(rt.indexOf('(') + 1, rt.indexOf(')')));
        System.out.println(core);
        int offset = Integer.parseInt(rt.split("\\(")[0]);
        System.out.println(offset);
    }
}
