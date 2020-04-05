package Trees_And_Heap_Bootcamp;

import java.util.Scanner;

class Node{
	int data;
	Node left,right;
	Node(int data){
		this.data=data;
		left=right=null;
	}
}
public class spiralOrderTraversal {
	Node root;
	spiralOrderTraversal(){
		root=null;
	}
	void insert(int data) {
		root=insertR(root,data);
	}
	Node insertR(Node root,int data) {
		if(root==null) {
			root=new Node(data);
			return root;
		}
		if(data<root.data) {
			root.left=insertR(root.left,data);
		}
		if(data>root.data) {
			root.right=insertR(root.right,data);
		}
		return root;
	}
	public static void sp(Node root) {
		if(root==null) {
			return ;
		}
		int level=1;
		while(printltor(root,level++)&&printrtol(root,level++));
	}
	public static boolean printltor(Node root,int level) {
		if(root==null) {
			return false;
		}
		if(level==1) {
			System.out.print(root.data+" ");
			return true;
		}
		boolean left=printltor(root.left,level-1);
		boolean right=printltor(root.right,level-1);
		return left|| right;
	}
	public static boolean printrtol(Node root,int level) {
		if(root==null) {
			return false;
		}
		if(level==1) {
			System.out.print(root.data+" ");
			return true;
		}
		boolean left=printrtol(root.right,level-1);
		boolean right=printrtol(root.left,level-1);
		return right|| left;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		spiralOrderTraversal ob = new spiralOrderTraversal();
		Scanner sc =new Scanner(System.in);
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
			ob.insert(arr[i]);
		}
		ob.sp(ob.root);
	}
}
