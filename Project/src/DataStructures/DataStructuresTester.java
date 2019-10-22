package dataStructures;

public class DataStructuresTester {

	public static void main(String[] args) {
		
		k_Queue<String> test = new Queue<String>((short)5);
		
		test.enqueue("hi");
		test.enqueue("how");
		test.enqueue("are");
		test.enqueue("are");
		test.enqueue("you");
		test.enqueue("henlo");
		System.out.println(test.isEmpty());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.dequeue());
		System.out.println(test.isEmpty());
		
		
	}

}
