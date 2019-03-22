package iterator;

import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public interface Container {
   public Iterator getIterator();
   public void add(GameObject m);
   public void remove(GameObject m);
   public void list(List<GameObject> game);

}
