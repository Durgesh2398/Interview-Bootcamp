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
public class lowestCommonAnsestor {
	Node root;
	lowestCommonAnsestor(){
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
	Node lca(Node root, int n1, int n2) {
		if(root==null) {
			return null;
		}
		if(n1<root.data&&n2<root.data) {
			return lca(root.left,n1,n2);
		}
		if(n1>root.data&&n2>root.data) {
			return lca(root.right,n1,n2);
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lowestCommonAnsestor ob = new lowestCommonAnsestor();
		Scanner sc =new Scanner(System.in);
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
			ob.insert(arr[i]);
		}
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		int r=ob.lca(ob.root,n1,n2).data;
		System.out.print(r);
	}

}
