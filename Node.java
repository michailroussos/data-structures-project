
public class Node <T> {
	T data;
	Node<T> nextNode;
	
	Node(T data){
		this(data,null);
	}
	
	Node(T data, Node<T> nextNode){
		this.data=data;
		this.nextNode=nextNode;
		
	}
	T getObject() {
		return data;
	}
	
	Node<T> getNext(){
		return nextNode;
	}
	

}
