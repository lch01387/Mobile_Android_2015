

public class StackGeneric {
	public static void main(String arg[]){
		Stack<Integer> stackInteger = new Stack<Integer>();	
		stackInteger.push(1);
		stackInteger.push(2);
		System.out.println(stackInteger.pop());
		System.out.println(stackInteger.pop());
		
		Stack<String> stackString = new Stack<String>();	
		stackString.push("Kookmin University");
		stackString.push("Korea Seoul");
		System.out.println(stackString.pop());
		System.out.println(stackString.pop());
	}
}


class Stack<T> {
	Node<T> top;
	
	public T pop() {
		T willreturn;
		willreturn = top.getData();
		top = top.getNext();
		return willreturn; 
	}
	
	public void push(T data) {
		Node<T> newnode = new Node<T>(data);
		newnode.setNext(top);
		top = newnode;
	}
}

class Node<T> {
	Node next;
	T data;
	public Node(T data) {
		this.data = data;	
    }
	public T getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node node) {
		next = node;
	}
}
