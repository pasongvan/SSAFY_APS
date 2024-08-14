package 트리구현;

public class Solution {

	static int[] tree = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	
	public static void main(String[] args) {
		
		System.out.println("전위");
		preorder(1);
		System.out.println();
		
		System.out.println("중위");
		inorder(1);
		System.out.println();
		
		System.out.println("후위");
		postorder(1);
		System.out.println();
	}
	
	// 전위
	static void preorder(int root) {
		// 기저조건
		if (root>=tree.length || tree[root]==0)
			return;
		
		// VLR
		System.out.print(tree[root] + "=>");
		preorder(root*2);
		preorder(root*2+1);
	}
	
	// 중위
	static void inorder(int root) {
		// 기저조건
		if (root>=tree.length || tree[root]==0)
			return;
		
		// LVR
		inorder(root*2);
		System.out.print(tree[root] + "=>");
		inorder(root*2+1);
	}
	
	// 후위
	static void postorder(int root) {
		// 기저조건
		if (root>=tree.length || tree[root]==0)
			return;
		
		// LRV
		postorder(root*2);
		postorder(root*2+1);
		System.out.print(tree[root] + "=>");
	}
}