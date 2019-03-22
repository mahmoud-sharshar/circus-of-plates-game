package game_strategy;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

public class StartGame implements State{

	@Override
	public void changeGameMode(World engine) {
		
		
	}

	@Override
	public int refresh(iterator.Iterator m) {
		while (m.hasNext()) {
			GameObject x = (GameObject) (m.next());
			x.setX(x.getX() + 1);
			x.setY(x.getY() + 1);
		}
		
		return 200;
		
	}

}
