package corewar.model.mars.memory;

import java.util.ArrayList;


public class CircularArrayList<E> extends ArrayList<E>{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6465849261706556743L;



	public CircularArrayList() {
		super();
	}
	
	
	
	public CircularArrayList(int initialCapacity) {
		super(initialCapacity);
	}
	
	
	
	@Override
	public E get(int index) {
		return super.get(index % size());
	}

}
