package sml;

// TODO: write a JavaDoc for the class

/**
 * Represents an abstract instruction.
 *
 * @author Wing Kui Tang
 */
public abstract class Instruction {
	protected final String label;
	protected final String opcode;

	/**
	 * Constructor: an instruction with a label and an opcode
	 * (opcode must be an operation of the language)
	 *
	 * @param label  optional label (can be null)
	 * @param opcode operation name
	 */
	public Instruction(String label, String opcode) {
		this.label = label;
		this.opcode = opcode;
	}

	public String getLabel() {
		return label;
	}

	public String getOpcode() {
		return opcode;
	}

	public static int NORMAL_PROGRAM_COUNTER_UPDATE = -1;

	/**
	 * Executes the instruction in the given machine.
	 *
	 * @param machine the machine the instruction runs on
	 * @return the new program counter (for jump instructions)
	 * or NORMAL_PROGRAM_COUNTER_UPDATE to indicate that
	 * the instruction with the next address is to be executed
	 */

	public abstract int execute(Machine machine);

	protected String getLabelString() {
		return (getLabel() == null) ? "" : getLabel() + ": ";
	}

	// TODO: What does abstract in the declaration below mean?
	//The functions function toString(), equals(), and hashCode() are all specified as abstract,
	// meaning that the present class does not implement them;
	// nonetheless, any subclass that extends this class is required to implement them.
	@Override
	public abstract String toString();
	public abstract boolean equals(Object o);
	public abstract int hashCode();
}
// TODO: Make sure that subclasses also implement equals and hashCode (needed in class Machine).