package Heap;

public class Tree2_수식트리 {

	static char[] tree = {0, '+', 'x', '-', '1', '2', '3', '4'};
	
	public static void main(String[] args) {

		inorder(1);
		
		System.out.println();
		
		postorder(1);
	}
	
	static void inorder(int root) {
//		if (root>= tree.length)
//			return;
//		if (tree[root] >= '0' && tree[root] <= '9') {
//			System.out.print(tree[root]);
//			return;
//		}
		
		
		// LVR
		if (root*2 < tree.length)
			inorder(root*2);
		
		System.out.print(tree[root]);
		
		if (root*2+1 < tree.length)
			inorder(root*2 +1);
	}
	
	static void postorder(int root) {

		// LRV
		if (root*2 < tree.length)
			postorder(root*2);
		
		if (root*2+1 < tree.length)
			postorder(root*2 +1);
		
		System.out.print(tree[root]);
	}
}
