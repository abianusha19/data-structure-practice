import java.util.*;
import java.lang.Math;
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
            temp.left=newnode;
        else if(s[s.length-1]=='R')
        temp.right=newnode;
        
        
        
    }
    
    boolean checkcontinuous(node root)
    {
        node temp=root;
        if(temp==null)
        return true;
        if(temp.left==null && temp.right==null)
        return true;
        if(temp.left==null)
        return (Math.abs(temp.data-temp.right.data)==1)&&checkcontinuous(temp.right);
        if(temp.right==null)
        return (Math.abs(temp.data-temp.left.data)==1)&&checkcontinuous(temp.left);
        return (Math.abs(temp.data-temp.left.data)==1)&&(Math.abs(temp.data-temp.right.data)==1)&&checkcontinuous(temp.left)&&checkcontinuous(temp.right);
        
    }
}
public class continuous
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
		continuous m=new continuous();
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
		boolean flag=bt.checkcontinuous(bt.root);
		
		if(flag)
		System.out.println("Yes!..Continuous tree");
		else
		System.out.println("No!..Not a Continuous tree");
		
	}
}
