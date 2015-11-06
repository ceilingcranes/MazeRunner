
public class CS2Stack<E> extends CS2LinkedList<E> { 
	public void push(E e){
		add(0, e);
	}
	public E pop(){
		return remove(0);
	}
	public E peep(){
		return get(0);
	}
}
