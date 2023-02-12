package corewar.model.redcode;

public interface IOpcode {
	
	public void execute(Operand a, Operand b);
	
	
	public IOpcode getDat();

}
