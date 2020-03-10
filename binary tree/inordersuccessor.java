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
    
    void findinorder(node root,pre prev,int searchnode)
    {
        if(root.right!=null)
        findinorder(root.right,prev,searchnode);
        
        if(root.data==searchnode)
        {
            System.out.println(pre.prev!=null?pre.prev.data:"null");
        }
        pre.prev=root;
        if(root.left!=null)
        findinorder(root.left,prev,searchnode);
        
    }
}
public class inodersuccessor
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
		int sn=sc.nextInt();
		pre prev=new pre();
	    bt.findinorder(bt.root,prev,sn);
	}
}
