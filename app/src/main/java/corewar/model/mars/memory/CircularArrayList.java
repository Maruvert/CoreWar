package corewar.model.mars.memory;

import java.util.ArrayList;

/**
 * TODO Deal with the serial ID
 */
@SuppressWarnings("serial")
public class CircularArrayList<E> extends ArrayList<E>{
	
	
	
	public CircularArrayList() {
		super();
	}
	
	
	
	public CircularArrayList(int initialCapacity) {
		super(initialCapacity);
	}
	
	
	
	@Override
	public E get(int index) {
		return get(index % size());
	}

}
