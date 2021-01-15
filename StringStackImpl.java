import java.io.PrintStream;
import java.util.NoSuchElementException;


public class StringStackImpl<T> implements StringStack<T>{
		private Node<T> firstNode;
		private Node<T> lastNode;
		private String name; 
		private int numofel;
		public StringStackImpl(){
			this("Stack");
		}
		public StringStackImpl(String name){
			this.name=name;
			firstNode=lastNode=null;
			numofel=0;
		}
	
	  /**
		 * @return true if the stack is empty
		 */
		public boolean isEmpty(){
			return (firstNode==null && lastNode==null);
		}

		/**
		 * Push a T (generic) item to the stack
		 */
		public void push(T item){
			Node<T> node = new Node<T>(item);
			if(isEmpty())
				firstNode=lastNode=node;
			else{
				node.nextNode=firstNode;
				firstNode=node;
			}
			numofel++;
		}		

		/**
		 * remove and return the item on the top of the stack
		 * @return the item on the top of the stack
		 * @throws a NoSuchElementException if the stack is empty
		 */
		public T pop() throws NoSuchElementException{
			if(isEmpty())
				throw new NoSuchElementException(name);
			T removedItem = firstNode.data;
			if(firstNode==lastNode)
				firstNode=lastNode=null;
			else
				firstNode=firstNode.nextNode;
			numofel--;
			return removedItem;
			
		}

	        /**
		 * return without removing the item on the top of the stack
		 * @return the item on the top of the stack
		 * @throws a NoSuchElementException if the stack is empty
		 */
		public T peek() throws NoSuchElementException{
			if(isEmpty())
				throw new NoSuchElementException(name);
			return firstNode.data;
		}

		/**
		 * print the contents of the stack, starting from the item
	         * on the top,
		 * to the stream given as argument. For example, 
		 * to print to the standard output you need to pass System.out as
		 * an argument. E.g., 
		 * printStack(System.out); 
		 */
		public void printStack(PrintStream stream){
			if(isEmpty()){
				System.out.println("The Stack "+name+" is empty!");
				return;
			}
			Node<T> node1=firstNode;
			System.out.println("The Stack "+name+" is" );
			while(node1!=null){
				System.out.println(node1.data);
				node1=node1.nextNode;
			}
			
		}
		

	 	/**
	         * return the size of the stack, 0 if empty
		 * @return the number of items currently in the stack
		 */
		public int size(){
			return numofel;
		}

}
