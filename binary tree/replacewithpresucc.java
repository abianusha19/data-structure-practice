import java.util.*;
class node
{
    int data;
    node left,right;
    node(int v)
    {
        data=v;
        left=null;
        right=null;
    }
}
class ss
{
int d;
ss(int v)
{
d=v;
}
}

class binarytree
{
    node root=null;
    void insert(int d,char[] s)
    {
        node temp=this.root;
        node newnode=new node(d);
        if(s[0]=='N')
        {
        this.root=newnode;
        return;
        }
        int i=0;
        
        while(i<s.length-1)
        {
            if(s[i]=='L')
            temp=temp.left;
            else if(s[i]=='R')
            temp=temp.right;
            i+=1;
        }
        if(s[i]=='L')
        temp.left=newnode;
        else if(s[i]=='R')
        temp.right=newnode;
    }
    void inorder(node root,Vector<Integer> arr,int k)
    {
        if(root==null)
		return;
		inorder(root.left,arr,k);
		arr.add(root.data);
		inorder(root.right,arr,k);
    }
	void replacewithsum(node root,Vector<Integer> arr,ss i)
	{
	if(root==null)
	return;
	replacewithsum(root.left,arr,i);
	root.data=arr.get(i.d-1)+arr.get(i.d+1);
	i.d++;
	replacewithsum(root.right,arr,i);
	}
	
	void replaceutil(node root,int n)
	{
	Vector<Integer> ar=new Vector<Integer>();
	ar.add(0);
    inorder(root,ar,1);
	ar.add(0);
	ss i=new ss(1);
	replacewithsum(root,ar,i);
	}
	
	void preorder(node root)
	{
	    if(root==null)
	    return;
	    System.out.print(root.data+" ");
	    preorder(root.left);
	    preorder(root.right);
	    
	}
}
public class replacewithpresucc
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		binarytree bt=new binarytree();
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
		    String pos=sc.next();
		    char ar[]=pos.toCharArray();
		    System.out.println("Node");
		    int val=sc.nextInt();
		    bt.insert(val,ar);
		}
		bt.preorder(bt.root);
		bt.replaceutil(bt.root,n);
		System.out.println("\nAfter Replacing");
		bt.preorder(bt.root);
	}
}