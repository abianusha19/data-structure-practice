import java.util.*;
class node
{
    int data;
    node left,right;
    node(int val)
    {
        data=val;
        left=null;
        right=null;
    }
}
class binarytree
{
    node root=null;
    
    node insert(int arr[],node root,int startindex)
    {
        if(startindex<arr.length)
        {
            node newnode=new node(arr[startindex]);
            root=newnode;
            root.left=this.insert(arr,root.left,2*startindex+1);
            root.right=this.insert(arr,root.right,2*startindex+2);
        }
        return root;
    }
    
    boolean checkmirror(node root1,node root2)
    {
        if(root1==null && root2==null)
        return true;
        
        if(root1!=null && root2!=null && root1.data==root2.data)
        {
            return(checkmirror(root1.left,root2.right)&&checkmirror(root1.right,root2.left));
        }
    
        return false;
    }
}
public class mirrortree
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		binarytree bt=new binarytree();
		for(int i=0;i<n;i++)
		arr[i]=sc.nextInt();
		bt.root=bt.insert(arr,bt.root,0);
		boolean flag=bt.checkmirror(bt.root,bt.root);
		if(flag)
		System.out.println("yes!..Mirror tree");
		else
		System.out.println("No!..Not a mirror tree");
		
	}
}
