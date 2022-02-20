
import java.util.Scanner;

public class BST {
	public class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode (int data){
			this.data=data;
			this.left =  this.right = null;
		}
	}
	TreeNode root;
		
	BST(){
		root = null;
	}
	public TreeNode insert(TreeNode root, int dataToBeInserted) {
		if(root == null) {
			root = new TreeNode(dataToBeInserted);
			return root;
		}
		if(root.data > dataToBeInserted) {
			root.left = insert(root.left, dataToBeInserted);
		}
		else if(root.data < dataToBeInserted) {
			root.right = insert(root.right, dataToBeInserted);
		}
		return root;
	}
	
	public TreeNode search(TreeNode root, int dataToBeInserted) {
		if(root == null || root.data==dataToBeInserted)
			return root;
		if(root.data > dataToBeInserted)
			return search(root.left, dataToBeInserted);
		return search(root.right, dataToBeInserted);				
	}
	
	// Left node, root, right node
	public void inOrder (TreeNode root) {
		if (root==null)
			return;
		inOrder(root.left);
		System.out.println(root.data+" ");
		inOrder(root.right);
	}
	
	// Root, left node, right node
	public void preOrder (TreeNode root) {
		if (root==null)
			return;
		System.out.println(root.data+" ");
		inOrder(root.left);
		inOrder(root.right);
	}
	//Left node, right node, root
		public void postOrder (TreeNode root) {
			if (root==null)
				return;
			inOrder(root.left);
			inOrder(root.right);
			System.out.println(root.data+" ");
	}

	int height(TreeNode root) {
	    if (root == null)
	     return -1;
	    else {
	            /* compute the depth of each subtree */
	    int lDepth = height(root.left);
	    int rDepth = height(root.right);
	  
	            /* use the larger one */
	    if (lDepth > rDepth)
	     return (lDepth + 1);
	    else	 
	     return (rDepth + 1);
      }
	}
	public void insertIntoTree(int dataToBeInserted) {
		root = insert(root, dataToBeInserted);
	}
	public TreeNode searchIntoTree(int dataToBeInserted) {
		return search(root, dataToBeInserted);
	}
	public void inOrderTraversal() {
		inOrder(root);
	}
	public void preOrderTraversal() {
		preOrder(root);
	}
	public void postOrderTraversal() {
		postOrder(root);
	}
	public static void main(String[] args) {
		BST bst = new BST();
		TreeNode nodeFound;
		int n, num;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter how many number to be input");
		n = scan.nextInt();
		System.out.println("Enter " + n + " numbers: ");
		for(int i = 0; i<n;i++) {
			num = scan.nextInt();
			bst.insertIntoTree(num);
		}
		System.out.println("Tree insertion done");
		
		System.out.println("Enter number to be searched");
		n = scan.nextInt();
		nodeFound = bst.searchIntoTree(n);		
		if(nodeFound != null) {
			System.out.println("Number found");
			System.out.println(bst.height(nodeFound));
			
		}
		else {
			System.out.println("Number not found");
		}
		System.out.println("Inorder traversal of bst");
		bst.inOrderTraversal();
		System.out.println("Preorder traversal of bst");
		bst.preOrderTraversal();
		System.out.println("Postorder traversal of bst");
		bst.postOrderTraversal();
	}
}
