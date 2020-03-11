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
    
   void reverselevel(node root)
   {
       Stack<node> st=new Stack<node>();
       Queue<node> q=new LinkedList<node>();
       q.add(root);
       while(!q.isEmpty())
       {
           node temp=q.remove();
           st.push(temp);
           if(temp.right!=null)
           q.add(temp.right);
           if(temp.left!=null)
           q.add(temp.left);
       }
       while(!st.isEmpty())
       {
           node temp=st.pop();
           System.out.print(temp.data+" ");
       }
           
       
   }
}
public class reverselevelorder
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
	    bt.reverselevel(bt.root);
	}
}
