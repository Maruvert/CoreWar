package corewar.model.mars.redcode.standards;

import corewar.model.exceptions.InvalidAddressingModeException;
import corewar.model.mars.Ram;
import corewar.model.mars.RedcodeInstruction;
import corewar.model.mars.memory.MemoryAddress;
import corewar.model.mars.redcode.AddressingMode;
import corewar.model.mars.redcode.IOpcode;
import corewar.model.mars.redcode.Operand;

public enum Icws88Opcode implements IOpcode{
	
	DAT {
		@Override
		public void execute(Ram ram, MemoryAddress address) {
			//DAT contains a value and does nothing
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			AddressingMode aFieldMode = instruction.getAfield().getMode();
			AddressingMode bFieldMode = instruction.getAfield().getMode();
			return (aFieldMode.equals(AddressingMode.IMMEDIATE) ||
					aFieldMode.equals(AddressingMode.INDIRECT_PREDECREMENT)) &&
					(bFieldMode.equals(AddressingMode.IMMEDIATE) ||
					bFieldMode.equals(AddressingMode.INDIRECT_PREDECREMENT));
		}
	},
	
	
	MOV {
		@Override
		public void execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			RedcodeInstruction instruction = address.getInstruction();
			RedcodeInstruction instructionToCopy = this.getInstructionByOperand(ram, address, instruction.getAfield());
			MemoryAddress destination = this.getAddressbyOperand(ram, address, instruction.getBfield());
			destination.setInstruction(instructionToCopy);
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isBfieldImmediate(instruction);
		}
	},
	
	
	
	ADD {
		@Override
		public void execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isBfieldImmediate(instruction);
		}
	},
	
	
	
	SUB {
		@Override
		public void execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isBfieldImmediate(instruction);
		}
	},
	
	
	
	JMP {
		@Override
		public void execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isAfieldImmediate(instruction);
		}
	},
	
	
	
	JMZ {
		@Override
		public void execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isAfieldImmediate(instruction);
		}
	},
	
	
	
	JMN {
		@Override
		public void execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isAfieldImmediate(instruction);
		}
	},
	
	
	
	CMP {
		@Override
		public void execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isBfieldImmediate(instruction);
		}
	},
	
	
	
	SLT {
		@Override
		public void execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isBfieldImmediate(instruction);
		}
	},
	
	
	
	DJN {
		@Override
		public void execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isAfieldImmediate(instruction);
		}
	},
	
	
	
	SPL {
		@Override
		public void execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isAfieldImmediate(instruction);
		}
	};
	
	
	
	
	public abstract void execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException;
	
	public abstract boolean isLegal(RedcodeInstruction instruction);
	
	
	
	
	
	protected boolean isAfieldImmediate(RedcodeInstruction instruction) {
		return instruction.getAfield().getMode().equals(AddressingMode.IMMEDIATE);
	}
	
	
	
	protected boolean isBfieldImmediate(RedcodeInstruction instruction) {
		return instruction.getBfield().getMode().equals(AddressingMode.IMMEDIATE);
	}
	
	

	
	protected RedcodeInstruction getInstructionByOperand(Ram ram, MemoryAddress address, Operand op) {
		if (op.getMode().equals(AddressingMode.IMMEDIATE)) {
			return new RedcodeInstruction(op.getValue());
		}
		return ram.getMemoryAddress(op.getMode().getTargetedMemoryAddress(ram, address, op.getValue())).getInstruction();
	}

	
	
	protected MemoryAddress getAddressbyOperand(Ram ram, MemoryAddress address, Operand op) throws InvalidAddressingModeException {
		if (op.getMode().equals(AddressingMode.IMMEDIATE)) {
			throw new InvalidAddressingModeException();
		}
		return ram.getMemoryAddress(op.getMode().getTargetedMemoryAddress(ram, address, op.getValue()));
	}
	
	
	public IOpcode getDat() {
		return Icws88Opcode.DAT;
	}
	
	

}
