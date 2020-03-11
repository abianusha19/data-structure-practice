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
    static int cnt=0;
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
    
   void perfectbinary(node root)
   {
       Queue<node> q=new LinkedList<node>();
       Stack<node> st=new Stack<node>();
       if(root==null)
       return;
       st.push(root);
       if(root.left!=null)
       {
       
       st.push(root.right);
       st.push(root.left);
       }
       if(root.left.left==null)
       return;
       node first=null,second=null;
       q.add(root.right);
       q.add(root.left);
       while(!q.isEmpty())
       {
           first=q.remove();
           second=q.remove();
           st.push(first.left);
           st.push(second.right);
           st.push(first.right);
           st.push(second.left);
           
       if(first.left.left!=null)
       {
             q.add(first.left);
             q.add(second.right);
             q.add(first.right);
             q.add(second.left);
       }
       }
       while(!st.isEmpty())
       {
           System.out.print(st.pop().data+" ");
       }
   }
}
public class reverseperfect
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
	    bt.perfectbinary(bt.root);
	}
}
