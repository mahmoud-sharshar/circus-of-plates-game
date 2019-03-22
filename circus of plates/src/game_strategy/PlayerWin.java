package game_strategy;

import iterator.Iterator;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

public class PlayerWin implements State{

	@Override
	public void changeGameMode(World engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int refresh(Iterator m) {
		while (m.hasNext()) {
			GameObject x = (GameObject) (m.next());
			x.setX(x.getX() + 2);
			x.setY(x.getY() + 1);
		}
		return 100;
	}

}
