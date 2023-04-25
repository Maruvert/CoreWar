package corewar.model.mars.redcode.standards;

import corewar.model.exceptions.InvalidAddressingModeException;
import corewar.model.mars.Ram;
import corewar.model.mars.RedcodeInstruction;
import corewar.model.mars.memory.MemoryAddress;
import corewar.model.mars.redcode.AddressingMode;
import corewar.model.mars.redcode.IOpcode;
import corewar.model.mars.redcode.NextInstructionInformation;
import corewar.model.mars.redcode.NextInstructionOperation;
import corewar.model.mars.redcode.Operand;

public enum Icws88Opcode implements IOpcode{
	
	
	
	
	DAT {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress address) {
			return setNext(NextInstructionOperation.NEXT);
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
		public NextInstructionInformation execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			RedcodeInstruction instruction = address.getInstruction();
			RedcodeInstruction source = this.getInstructionByOperand(ram, address, instruction.getAfield());
			MemoryAddress destination = this.getAddressByOperand(ram, address, instruction.getBfield());
			destination.setInstruction(source);
			return setNext(NextInstructionOperation.NEXT);
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isBfieldImmediate(instruction);
		}
	},
	
	
	
	ADD {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			RedcodeInstruction instruction = address.getInstruction();
			RedcodeInstruction source = this.getInstructionByOperand(ram, address, instruction.getAfield());
			int numberToAdd = source.getBfield().getValue();
			MemoryAddress destination = this.getAddressByOperand(ram, address, instruction.getBfield());
			destination.getInstruction().addToBfield(numberToAdd);
			return setNext(NextInstructionOperation.NEXT);
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isBfieldImmediate(instruction);
		}
	},
	
	
	
	SUB {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			RedcodeInstruction instruction = address.getInstruction();
			RedcodeInstruction source = this.getInstructionByOperand(ram, address, instruction.getAfield());
			int numberToSub = source.getBfield().getValue();
			MemoryAddress destination = this.getAddressByOperand(ram, address, instruction.getBfield());
			destination.getInstruction().addToBfield(-numberToSub);
			return setNext(NextInstructionOperation.NEXT);
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isBfieldImmediate(instruction);
		}
	},
	
	
	
	JMP {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			RedcodeInstruction instruction = address.getInstruction();
			MemoryAddress destination = this.getAddressByOperand(ram, address, instruction.getAfield());
			return setNext(NextInstructionOperation.JUMP, destination.getAddress());
			
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isAfieldImmediate(instruction);
		}
	},
	
	
	
	JMZ {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			RedcodeInstruction instruction = address.getInstruction();
			int bPointedValue = this.getInstructionByOperand(ram, address, instruction.getBfield()).getBfield().getValue();
			
			if (bPointedValue == 0) {
				MemoryAddress destination = this.getAddressByOperand(ram, address, instruction.getAfield());
				return setNext(NextInstructionOperation.JUMP, destination.getAddress());
			}
			return setNext(NextInstructionOperation.NEXT);
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isAfieldImmediate(instruction);
		}
	},
	
	
	
	JMN {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			RedcodeInstruction instruction = address.getInstruction();
			int bPointedValue = this.getInstructionByOperand(ram, address, instruction.getBfield()).getBfield().getValue();
			
			if (bPointedValue != 0) {
				MemoryAddress destination = this.getAddressByOperand(ram, address, instruction.getAfield());
				return setNext(NextInstructionOperation.JUMP, destination.getAddress());
			}
			return setNext(NextInstructionOperation.NEXT, 0);
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isAfieldImmediate(instruction);
		}
	},
	
	
	
	CMP {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			RedcodeInstruction instruction = address.getInstruction();
			int aPointedValue = this.getInstructionByOperand(ram, address, instruction.getAfield()).getAfield().getValue();
			int bPointedValue = this.getInstructionByOperand(ram, address, instruction.getBfield()).getBfield().getValue();
			
			if (aPointedValue == bPointedValue) {
				return setNext(NextInstructionOperation.SKIP);
			}
			
			return setNext(NextInstructionOperation.NEXT);
			
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isBfieldImmediate(instruction);
		}
	},
	
	
	
	SLT {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			RedcodeInstruction instruction = address.getInstruction();
			int aPointedValue = this.getInstructionByOperand(ram, address, instruction.getAfield()).getAfield().getValue();
			int bPointedValue = this.getInstructionByOperand(ram, address, instruction.getBfield()).getBfield().getValue();
			
			if (aPointedValue < bPointedValue) {
				return setNext(NextInstructionOperation.SKIP);
			}
			
			return setNext(NextInstructionOperation.NEXT, 0);
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isBfieldImmediate(instruction);
		}
	},
	
	
	
	DJN {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			RedcodeInstruction instruction = address.getInstruction();
			RedcodeInstruction bPointedValue = this.getInstructionByOperand(ram, address, instruction.getBfield());
			bPointedValue.decrementBfield();
			
			if (bPointedValue.getBfield().getValue() != 0) {
				MemoryAddress destination = this.getAddressByOperand(ram, address, instruction.getAfield());
				return setNext(NextInstructionOperation.JUMP, destination.getAddress());
			}
			return setNext(NextInstructionOperation.NEXT, 0);
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isAfieldImmediate(instruction);
		}
	},
	
	
	
	SPL {
		@Override
		public NextInstructionInformation execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException {
			if (!isLegal(address.getInstruction())) throw new InvalidAddressingModeException();
			RedcodeInstruction instruction = address.getInstruction();
			MemoryAddress fork = this.getAddressByOperand(ram, address, instruction.getAfield());
			return setNext(NextInstructionOperation.FORK, fork.getAddress());
		}

		@Override
		public boolean isLegal(RedcodeInstruction instruction) {
			return !isAfieldImmediate(instruction);
		}
	};
	
	
	public abstract NextInstructionInformation execute(Ram ram, MemoryAddress address) throws InvalidAddressingModeException;
	
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

	
	
	protected MemoryAddress getAddressByOperand(Ram ram, MemoryAddress address, Operand op) throws InvalidAddressingModeException {
		if (op.getMode().equals(AddressingMode.IMMEDIATE)) {
			throw new InvalidAddressingModeException();
		}
		return ram.getMemoryAddress(op.getMode().getTargetedMemoryAddress(ram, address, op.getValue()));
	}
	
	
	
	protected NextInstructionInformation setNext(NextInstructionOperation operation, int address) {
		return new NextInstructionInformation(operation, address);
	}
	
	protected NextInstructionInformation setNext(NextInstructionOperation operation) {
		return new NextInstructionInformation(operation);
	}
	
	
	
	public IOpcode getDat() {
		return Icws88Opcode.DAT;
	}
	
	

}
