package corewar.model.mars.redcode.standards;

import corewar.model.mars.memory.MemoryAddress;
import corewar.model.mars.redcode.IOpcode;

public enum Icws88Opcode implements IOpcode{
	
	DAT {
		@Override
		public void execute(MemoryAddress memory) {
			// TODO Auto-generated method stub
		}
	},
	
	
	MOV {
		@Override
		public void execute(MemoryAddress memory) {
			// TODO Auto-generated method stub
			
		}
	},
	
	
	
	ADD {
		@Override
		public void execute(MemoryAddress memory) {
			// TODO Auto-generated method stub
			
		}
	},
	
	
	
	SUB {
		@Override
		public void execute(MemoryAddress memory) {
			// TODO Auto-generated method stub
			
		}
	},
	
	
	
	JMP {
		@Override
		public void execute(MemoryAddress memory) {
			// TODO Auto-generated method stub
			
		}
	},
	
	
	
	JMZ {
		@Override
		public void execute(MemoryAddress memory) {
			// TODO Auto-generated method stub
			
		}
	},
	
	
	
	JMN {
		@Override
		public void execute(MemoryAddress memory) {
			// TODO Auto-generated method stub
			
		}
	},
	
	
	
	CMP {
		@Override
		public void execute(MemoryAddress memory) {
			// TODO Auto-generated method stub
			
		}
	},
	
	
	
	SLT {
		@Override
		public void execute(MemoryAddress memory) {
			// TODO Auto-generated method stub
			
		}
	},
	
	
	
	DJN {
		@Override
		public void execute(MemoryAddress memory) {
			// TODO Auto-generated method stub
			
		}
	},
	
	
	
	SPL {
		@Override
		public void execute(MemoryAddress memory) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
	
	
	public abstract void execute(MemoryAddress memory);
	
	
	
	
	public IOpcode getDat() {
		return Icws88Opcode.DAT;
	}
	
	

}
