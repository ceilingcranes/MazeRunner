
public class CS2LinkedList <E> /*implements List*/{
	private Node head;
	private Node tail;
	private int size;
	public CS2LinkedList(){
		setHead(null);
		size=0;
		tail=null;
	}
	public boolean add(E e) { 
		Node n=new Node(e);
		if(getHead()==null){
			setHead(n);
			tail=n;
			size=1;
			return true;
		}
		Node node=tail;
		node.setNext(n);
		tail=n;
		size++;
		return true;
		
	}

	public void add(int index, E element) {
		Node newNode=new Node(element);
		if(getHead()==null){
			setHead(newNode);
			tail=newNode;
			size=1;
			return;
		}
		if(index==size()){
			add(element);
			return;
		}
		Node next=getHead();
		Node pre=null;
		for(int i=0; i<index; i++){
			if(next==null){
				throw new IndexOutOfBoundsException("Index is too large");
			}
			pre=next;
			next=next.getNext();
		}
		newNode.setNext(next);
		if(pre==null){
			setHead(newNode);
			size++;
			return;
		}
		size++;
		pre.setNext(newNode);
		
	}
	public E get(int index) {
		if(getHead()==null||index>=size()){
			return null;
		}
		if(index==size()-1){
			return tail.getValue();
		}
		Node n=getHead();
		for(int i=0; i<index; i++){
			n=n.getNext();
		}
		return n.getValue();
	}
	public E remove(int index) {
		if(getHead()==null||index>size()){
			return null;
		}
		if(index==0){
			E t=getHead().getValue();
			setHead(getHead().getNext());
			size--;
			return t;
		}
		Node pre=getHead();
		for(int i=0; i<index-1; i++){
			pre=pre.getNext();	
		}
		Node toRemove=pre.getNext();
		E temp=toRemove.getValue();
		if(toRemove.getNext()==null){
			pre.setNext(null);
			tail=pre;
			size--;
			return temp;
		}
		pre.setNext(toRemove.getNext());
		size--;
		return temp;	
	}

	public E set(int index, E element) {
		if(getHead()==null){
			return null;
		}
		if(index==size()-1){
			Node node=tail;
			Node newNode=new Node(element);
			node.setNext(newNode);
			tail=newNode;
			
		}
		if(index>=size()){
			throw new IndexOutOfBoundsException("Index out of Bounds");
		}
		E o;
		Node n=getHead();
		for(int i=0; i<index; i++){
			n=n.getNext();
		}
		o=n.getValue();
		n.setVal(element);
		size++;
		return o;
		
	}

	public int size() { //will return the number of elements in an array, starting counting from 1
		/*int size=0;
		if(head==null){
			return size;
		}
		Node n=head;
		while(n.getNext()!=null){
			n=n.getNext();
			size++;
		}
		size++;
		return size;*/
		return size;
	}
	public String toString(){
		if(getHead()==null)
			return "Empty List";
		int r=0;
		String string="";
		Node n=getHead();
		while(n!=null){
			string+="["+r+"]"+n.getValue()+" ";
			n=n.getNext();
			r++;
		}
		return string;
		
	}
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	private class Node{
		private E value;
		private Node next;
		public Node(E val){
			value=val;
			next=null;
		}
		public void setVal(E val){
			value=val;
		}
		public void setNext(Node nextNode){
			next=nextNode;
		}
		public E getValue(){
			return value;
		}
		public Node getNext(){
			return next;
		}
		public String toString(){
			return value+"";
		}
	}
}
