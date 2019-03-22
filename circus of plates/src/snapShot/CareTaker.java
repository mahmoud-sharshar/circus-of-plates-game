package snapShot;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

	private List<Memento>  mementoList = new ArrayList<>();
	
	public void add(Memento m) {
		this.mementoList.add(m);
	}
	
	
	public Memento get(int index) {
		return mementoList.get(0);
	}
}
