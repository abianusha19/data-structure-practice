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
class pre{
    static node prev;
  pre()
  {
     prev=null;
  }
}
class binarytree
{
    node root=null;
    node prev=null;
    
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
    
    void findinorder(node root,pre prev)
    {
        if(root!=null)
        {
        findinorder(root.right,prev);
         System.out.println("Successor of "+root.data+" is :"+(pre.prev!=null?pre.prev.data:"null"));
        pre.prev=root;
        findinorder(root.left,prev);
        }
        
    }
}
public class inordersuccessors
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		char arr[]=new char[n];
		binarytree bt=new binarytree();
		for(int i=0;i<n;i++)
		{
		String s=sc.next();
		arr=s.toCharArray();
		System.out.println("node");
		int j=sc.nextInt();
		bt.insert(arr,j);
		}
		pre prev=new pre();
	    bt.findinorder(bt.root,prev);
	}
}
