package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;
import java.util.Objects;

/**
 * This class represents the "out" instruction in SML.
 * It outputs the contents of a register to the console.
 *
 */
public class OutInstruction extends Instruction {
    private final RegisterName result;

    public static final String OP_CODE = "out";

    public OutInstruction(String label, RegisterName result) {
        super(label, OP_CODE);
        this.result = result;
    }

    @Override
    public int execute(Machine m) {
        int value = m.getRegisters().get(result);
        System.out.println("Register " + result.name() + ": " + value);
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + " " + result;
    }

    @Override
    public int hashCode() {return Objects.hash(label, result);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof OutInstruction other))return false;
        return Objects.equals(this.label, other.label)
                && Objects.equals(this.result, other.result);
    }
}


