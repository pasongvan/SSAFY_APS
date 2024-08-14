package Tree;

public class Tree순회 {

	static char[] tree = {0, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 0, 0, 'H', 'I'};
	
	public static void main(String[] args) {
		
		preorder(1);
		System.out.println();
		
		inorder(1);
		System.out.println();
		
		postorder(1);

	}
	// 매개변수로 트리 루트 인덱스
	// 전위순회 => VLR
	public static void preorder(int root) {
		if (root >= tree.length || tree[root]==0)
			return;
		
		System.out.print(tree[root] + "=>");
		preorder(root*2);
		preorder(root*2+1);
	
	}

	// 중위 순회 => LVR
	public static void inorder(int root) {
		if (root >= tree.length || tree[root]==0)
			return;
		
		inorder(root*2);
		System.out.print(tree[root] + "=>");
		inorder(root*2+1);
		
	}
	
	// 후위 순회 => LRV
	public static void postorder(int root) {
		if (root >= tree.length || tree[root]==0)
			return;
		
		postorder(root*2);
		postorder(root*2+1);
		System.out.print(tree[root] + "=>");
		
	}
}
