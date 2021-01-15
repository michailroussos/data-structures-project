import java.io.PrintStream;
import java.util.NoSuchElementException;


public class StringQueueImpl<T> implements StringQueue<T> {
	private Node<T> firstNode;
	private Node<T> lastNode;
	private String name; 
	private int numofel;
	public StringQueueImpl(){
		this("Queue");
	}
	public StringQueueImpl(String name){
		this.name=name;
		firstNode=lastNode=null;
		numofel=0;
	}
	/**
	 * @return true if the queue is empty
	 */
	public boolean isEmpty(){
		return (firstNode==null && lastNode==null);
	}

	/**
	 * insert a T item to the queue
	 */
	public void put(T item){
		Node<T> node=new Node<T>(item);
		if(isEmpty())
			firstNode=lastNode=node;
		else{
			lastNode.nextNode=node;
			lastNode=node;
		}
		numofel++;
	}

	/**
         * remove and return the oldest item of the queue
         * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T get() throws NoSuchElementException{
		if (isEmpty())
			throw new  NoSuchElementException(name);
		T removedItem = firstNode.data;
		if(firstNode==lastNode)
			firstNode=lastNode=null;
		else
			firstNode=firstNode.nextNode;
		numofel--;
		return removedItem;
	}

        /**
	 * return without removing the oldest item of the queue
 	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public T peek() throws NoSuchElementException{
		if(isEmpty())
			throw new NoSuchElementException(name);
		return firstNode.data;
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
		Node<T> node1=firstNode;
		System.out.println("The Queue "+name+" is" );
		while(node1!=null){
			System.out.println(node1.data);
			node1=node1.nextNode;
		}
	}

	/**
	 * return the size of the queue, 0 if it is empty
	 * @return number of elements in the queue
	 */
	public int size(){
		return numofel;
	}
}
