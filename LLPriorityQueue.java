public class LLPriorityQueue {
	class Node implements Comparable<Node> {  
		int i;  
		Node next, previous; 
		public Node(int i) {  
			this.i = i;  
		}  

		public int compareTo(Node o) throws ClassCastException {
			if(!(o instanceof Comparable))
			{
				throw new IllegalArgumentException("Object not comparable");
			}
			return Integer.compare(o.i, i);
		}
	}  

	Node front, back = null;  
	
	public void enque(int i) {   
		if (front == null) {
			Node newNode = new Node(i);
			front = newNode;
			return;
		}
		Node node = new Node(i);
		Node temp = front, parent = null;
		while (temp != null && temp.compareTo(node) > 0) {
			parent = temp;
			temp = temp.next;
		}
		if (parent == null) {
			node.next = front;
			front.previous = node;
			front = node;
		}
		else if (temp == null) {
			parent.next = node;
			node.previous = parent;
		}
		else {
			parent.next = node;
			node.previous = parent;
			node.next = temp;
			temp.previous = node;
		}
	}  

	public int deque() {
		if (front != null) {
			int current = front.i;
			front = front.next;
			if (front != null) 
				front.previous = null;
			return current;
		}
		return -1;
	}

	public int getSize() {
		Node current = front;  
		int output = 0;
		if(front == null) {  
			return 0;   
		} 
		else {
			while(current != null) {  
				output ++;
				current = current.next;  
			}  
			return output;
		}
	}

	public String testPrint() {  
		Node current = front;  
		String output = "";
		if(front == null) {  
			return "empty pq";    
		} 
		else {
			while(current != null) {  
				output += (current.i);
				current = current.next;  
			}  
			return output;
		}
	}  
}

