package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

/**
 * Branches to the given label if the contents of the given register are not zero.
 */
public class JnzInstruction extends Instruction {
    private final RegisterName source;
    private final String jumpLabel;

    public static final String OP_CODE = "jnz";

    public JnzInstruction(String label, RegisterName source, String jumpLabel) {
        super(label, OP_CODE);
        this.source = source;
        this.jumpLabel = jumpLabel;
    }

    @Override
    public int execute(Machine machine) {
        int value = machine.getRegisters().get(source);
        if (value == 0) {
            return NORMAL_PROGRAM_COUNTER_UPDATE;
        }
        else {
            return machine.getLabels().getAddress(jumpLabel);
        }
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + source + " " + jumpLabel;
    }

    @Override
    public int hashCode() {return Objects.hash(label, jumpLabel, source);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof JnzInstruction other))return false;
        return Objects.equals(this.label, other.label)
                && Objects.equals(this.source, other.source)
                && Objects.equals(this.jumpLabel, other.jumpLabel);
    }
}
