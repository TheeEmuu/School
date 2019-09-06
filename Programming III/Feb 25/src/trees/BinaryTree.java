package trees;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public abstract class BinaryTree<E> {
	private Node<E> root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	// apply some policy to find a spot, create a node, and insert this data.
	public abstract void insert(E value);
	
	// search the tree for this data.  Again, we need a policy for how to search,
	// which will depend on how the tree is organized
	public abstract boolean contains(E value);
	
	// find a particular value in the tree.   Returns an iterator that refers to that spot
	// in the tree.  If the value is not found, then the iterator's next() method will return
	// null.
	public abstract TreeIterator<E> find(E value);

	// search for this value in the tree, and remove it if we find it.  Returns the value found 
	// in the tree (or null if nothing was found)
	public abstract E remove(E value);
	
	// remove the node that iter points to.  Note that iter becomes unusable as a result.
	public abstract void remove(TreeIterator<E> iter);
	
	// return an iterator referring to the "first" node in the tree.
	public abstract TreeIterator<E> iterator();
	
	// get the root of the tree.
	protected Node<E> getRoot() {
		return root;
	}
	
	protected void setRoot(Node<E> root) {
		this.root = root;
	}
	
	// returns the number of leaf nodes in this tree
	public int numLeaves() {
		return numLeaves(root);
	}
	
	// recursive implementation for numLeaves.  Returns the number 
	// of leaves in the subtree rooted at cur.
	private int numLeaves(Node<E> cur) {
		if (cur == null)
			return 0;
		else if (cur.left == null && cur.right == null)
			return 1;
		else 
			return numLeaves(cur.left) + numLeaves(cur.right);
	}
	
	// returns the number of full nodes in this tree.
	public int numFull() {
		return numFull(root);
	}
	
	// recursive implementation.  Returns the number of full nodes
	// in the subtree rooted at cur.  Does this by recursively computing
	// the number in the left and right subtrees of cur, checking if this
	// node is full, and adding up.
	private int numFull(Node<E> cur) {
		if (cur == null)
			return 0;
		else {
			int curIsFull = (cur.left != null && cur.right != null) ? 1 : 0;
			return curIsFull + numFull(cur.left) + numFull(cur.right);
		}
	}
	
	
	// Use the GraphViz library of tools to produce a picture of this graph. We do this by generating a 
	// .dot file that describes the tree, and then executes the dot command to convert that file into a 
	// .png file.
	public void makePic(String picName) {

		String dotFileName = picName + ".dot";
		PrintWriter dotFile = null;
		try {
			dotFile = new PrintWriter(new BufferedWriter(new FileWriter(dotFileName)));
		} 
		catch (IOException e) {
			return;
		}

		// boilerplate header for the
		dotFile.println("digraph tree {");
		dotFile.println("\tratio=0.5;");
		dotFile.println("\tsplines=false;");

		// recursively handle all the nodes in the tree
		dotNode(getRoot(), dotFile);

		dotFile.println("}");
		dotFile.close();


		try {
			String cmd = "dot -Tpng -o" + picName + " " + dotFileName;
			Process p = Runtime.getRuntime().exec(cmd);
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void dotNode(Node<E> cur, PrintWriter file) {
		if (cur == null)
			return;
		
		if (cur.left == null && cur.right == null)
			return;
		
		// at least one child if we get here
		if (cur.left != null) {
			file.println("\t" + cur.data+"_"+cur.height + ":sw -> " + cur.left.data + "_" + cur.left.height);
		}
		
		if (cur.right != null) {
			file.println("\t" + cur.data+"_"+cur.height + ":se -> " + cur.right.data + "_" + cur.right.height);
		}
	
		dotNode(cur.left, file);
		dotNode(cur.right, file);
	}

	public int height(){
		return root.height;
	}

	public boolean isComplete() {
		LinkedList<Node<E>> todo = new LinkedList<>();

		todo.add(root);

		boolean nonFullNodeFound = false;
		while(!todo.isEmpty()) {
			Node<E> cur = todo.remove();

			//check left child
			if (cur.left != null) {
				//if we find a left child after a non-full node was found
				//the tree is not complete
				if (nonFullNodeFound) {
					return false;
				}
				todo.push(cur.left);
			}
			else {
				//if cur doesn't have left child, it isn't full
				nonFullNodeFound = true;
			}

			//check right child
			if (cur.right != null) {
				//if we find a right child after a non-full node was found
				//the tree is not complete
				if (nonFullNodeFound) {
					return false;
				}
				todo.push(cur.right);
			}
			else{
				//if cur doesn't have right child, it isn't full
				nonFullNodeFound = true;
			}
		}
		return true;
	}

	public boolean isFull() {
		int treeHeight = height();
		int fullNodes = numFull();
		int leaves = numLeaves();

		int treeSize = (int)Math.pow(treeHeight, 2);

		if(treeSize == fullNodes + leaves){
			return true;
		}
		return false;
	}
}

