import java.util.*;
class newnode
{
    int data;
    newnode left=null;
    newnode right=null;
    newnode(int val)
    {
        data=val;
        
    }
}
class binarytree
{
    newnode root=null;
    void insert(int[] arr,newnode tnode,int startindex)
    {
        if(startindex<arr.length)
		{
			newnode temp=new newnode(arr[startindex]);
			tnode=temp;
			tnode.left=this.insert(arr,tnode.left,2*startindex+1);
			tnode.right=this.insert(arr,tnode.right,2*startindex+2);
		}
		return tnode;
    }
}
public class treeinsert
{
    public void inorder(newnode temp)
    {
        if(temp==null)
        return;
        else
        {
            inorder(temp.left);
            System.out.println(temp.data);
            inorder(temp.right);
        }
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		binarytree bt=new binarytree();
		treeinsert m=new treeinsert();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    arr[i]=sc.nextInt();
		}
		bt.root=bt.insert(arr,bt.root,0);
		m.inorder(bt.root);
		
	}
}
