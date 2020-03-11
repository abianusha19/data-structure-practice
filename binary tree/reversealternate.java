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
    
   void reversealternatelevel(node root)
   {
       
       Queue<node> q=new LinkedList<node>();
       q.add(root);
	   int cnt=0;
       while(!q.isEmpty())
       {
           
		   if(cnt%2==0)
		   { 
	   int sz=q.size();
	   int i=0;
	      while(i<sz)
		   {node temp=q.remove();
		   System.out.print(temp.data+" ");
		   if(temp.left!=null)
           q.add(temp.left);
           if(temp.right!=null)
           q.add(temp.right);
	       i++;
		   }
		   }
		   
		   else{
		   Stack<node> st=new Stack<node>();
		   int sz=q.size();
		   int i=0;
		   while(i<sz)
		   {
		       
		  node temp=q.remove();
		  st.push(temp);
		   if(temp.left!=null)
           q.add(temp.left);
           if(temp.right!=null)
           q.add(temp.right);
           i++;
		   }
		    while(!st.isEmpty())
       {
           node temp1=st.pop();
           System.out.print(temp1.data+" ");
       }
		   }
           
		   cnt++;
       }
   }
}
public class reversealternate
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
	    bt.reversealternatelevel(bt.root);
	}
}
