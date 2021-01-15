import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringQueueWithOnePointer<T> implements StringQueue<T> {
	
	//private Node<T> firstNode;
	private Node<T> lastNode;
	private String name; 
	private int numofel;
	public StringQueueWithOnePointer(){
		this("Queue");
	}
	public StringQueueWithOnePointer(String name){
		this.name=name;
		lastNode=null;
		numofel=0;
	}
	public boolean isEmpty(){
		return lastNode==null;
	}

	/**
	 * insert a T item to the queue
	 */
	public void put(T item){
		Node<T> node= new Node<T>(item);
		if(isEmpty()){
			lastNode=node;
			lastNode.nextNode=lastNode;
		}
		else {
			Node <T> node1=lastNode.nextNode;
			lastNode.nextNode=node;
			lastNode=node;
			lastNode.nextNode=node1;
		}
		numofel++;
	
	}

	/**
         * remove and return the oldest item of the queue
         * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T get() throws NoSuchElementException{
		if(isEmpty()){
			throw new  NoSuchElementException(name);
		}
		Node<T> node1 =lastNode.nextNode;
		if(lastNode== lastNode.nextNode){
			lastNode=null;
		}
		else{
			lastNode.nextNode=lastNode.nextNode.nextNode;
		}
		numofel--;
		return node1.data;
		
	}

        /**
	 * return without removing the oldest item of the queue
 	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T peek() throws NoSuchElementException{
		if(isEmpty()){
			throw new  NoSuchElementException(name);
		}
		
		return lastNode.nextNode.data;
		
	}


	/**
	 * print the elements of the queue, starting from the oldest 
         * item, to the print stream given as argument. For example, to 
         * print the elements to the
	 * standard output, pass System.out as parameter. E.g.,
	 * printQueue(System.out);
	 */
	public void printQueue(PrintStream stream){
		if(isEmpty()){
			System.out.println("The Queue "+name+" is empty!");
			return;
		}
		Node<T> node1=lastNode.nextNode;
		System.out.println("The Queue "+name+" is" );
		while(node1 !=lastNode){
			System.out.println(node1.data);
			node1=node1.nextNode;
		}
		System.out.println(node1.data);
		
	}

	/**
	 * return the size of the queue, 0 if it is empty
	 * @return number of elements in the queue
	 */
	public int size(){
		return numofel;
	}

	
}
