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
    int cnt=0;
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
    
   int level(node root,int key)
   {
       Queue<node> q=new LinkedList<node>();
       q.add(root);
       while(!q.isEmpty())
       {
           int i=0;
		   int s=q.size();
		   while(i<s)
		   {
			   node temp=q.remove();
		   if(temp.data==key)
			   return cnt;
		   
           if(temp.left!=null)
           q.add(temp.left);
           if(temp.right!=null)
           q.add(temp.right);
	       i++;
		   }
		   cnt++;
       }
	   return -1;
   }
}
public class levelofnode
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
	    System.out.println(bt.level(bt.root,4));
	}
}
