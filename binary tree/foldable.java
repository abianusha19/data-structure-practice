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
    
    void insert(char[] s,int key)
    {
        node temp=this.root;
        int i=0;
        node newnode=new node(key);
        if(temp==null && s[i]=='n')
        {
            this.root=newnode;
            return;
        }
        while(i<s.length-1)
        {
            if(s[i]=='L' && temp.left!=null)
            temp=temp.left;
            else if(s[i]=='R' && temp.right!=null)
            temp=temp.right;
            i+=1;
        }
        if(s[s.length-1]=='L')
        {
            temp.left=newnode;
        }
        else if(s[s.length-1]=='R')
        temp.right=newnode;
        
        
        
    }
    
    boolean checkmirror(node root1,node root2)
    {
        if(root1==null && root2==null)
        return true;
        
        if(root1!=null && root2!=null)
        {
            return(checkmirror(root1.left,root2.right)&&checkmirror(root1.right,root2.left));
        }
    
        return false;
    }
}
public class foldable
{
     public void inorder(node temp)
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
		char arr[]=new char[n];
		binarytree bt=new binarytree();
		foldable m=new foldable();
		for(int i=0;i<n;i++)
		{
		String s=sc.next();
		arr=s.toCharArray();
		System.out.println("node");
		int j=sc.nextInt();
		bt.insert(arr,j);
		}
		System.out.println("inorder traversel of tree");
		m.inorder(bt.root);
		boolean flag=bt.checkmirror(bt.root,bt.root);
		
		if(flag)
		System.out.println("Yes!..Foldable tree");
		else
		System.out.println("No!..Not a Foldable tree");
		
	}
}
