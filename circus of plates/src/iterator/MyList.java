package iterator;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public class MyList implements Container {
	ArrayList objects = new ArrayList();
	   @Override
	public void add (GameObject object){
	objects.add(object);
}
	   public void remove (GameObject object){
			objects.remove(object);
		}
   @Override
   public Iterator getIterator() {
      return new ListIterator();
   }

   private class ListIterator implements Iterator {

      int index;

      @Override
      public boolean hasNext() {
      
         if(index < objects.size()){
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
            return objects.get(index++);
         }
         return null;
      }		
   }

@Override
public void list(List<GameObject> game) {
	objects=(ArrayList) game;
}
}