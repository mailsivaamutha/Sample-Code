
class Node{
	int data;
	Node left, right;
	
	public Node(int item){
		data = item;
		left = right = null;
	}
}


class BinaryTree {

	static Node root;
	static int minValue = 0;
	
	void leftViewUtil(Node node){
		if(node == null) return;
		
/*		if(minValue < level){
			System.out.println(node.data+" ");
			minValue = level;
		}*/
		System.out.print(node.data+" ");
		leftViewUtil(node.left);
		//System.out.println();
		//leftViewUtil(node.right, level+1);
	}
	
	void deleteRecord(Node node, int data){
		if(node == null) return;
		
        if (data < root.data)
            deleteRecord(root.left, data);
        else if (data > root.data)
            deleteRecord(root.right, data);
        System.out.println(node.left+"");
	}
	
	void leftView(){
		leftViewUtil(root);
	}
	
	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.left.left.left = new Node(7);
		tree.root.left.right.left = new Node(8);
		tree.root.left.left.left.left = new Node(9);
		//tree.leftView();
		tree.leftViewUtil(root);
		tree.deleteRecord(tree.root,1);
	}


}
