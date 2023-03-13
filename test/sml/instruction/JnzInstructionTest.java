package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.*;

class JnzInstructionTest {
  private Machine machine;
  private Registers registers;

  @BeforeEach
  void setUp() {
    machine = new Machine(new Registers());
    registers = machine.getRegisters();
    machine.getLabels().addLabel("f1", 5);
  }

  @AfterEach
  void tearDown() {
    machine = null;
    registers = null;
  }

  @Test
  void executeValid1() {
    registers.set(EAX, 1);
    Instruction instruction = new JnzInstruction(null, EAX, "f1");
    Assertions.assertEquals(machine.getLabels().getAddress("f1"), instruction.execute(machine));
  }

  @Test
  void executeValid2() {
    registers.set(EAX, 3);
    Instruction instruction = new JnzInstruction(null, EAX, "f1");
    Assertions.assertEquals(Instruction.NORMAL_PROGRAM_COUNTER_UPDATE,instruction.execute(machine));
  }
}