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
    void postorder()
    {
        node temp=this.root;
        Stack<node> st=new Stack<node>();
        if(temp==null)
        return;
		while(true)
		{
			while(temp!=null)
			{
				st.push(temp);
				st.push(temp);
				temp=temp.left;
			}
			if(st.isEmpty())
				return;
			temp=st.pop();
			if(!st.isEmpty() && st.peek()==temp)
				temp=temp.right;
			else
			{
				System.out.print(temp.data+" ");
			temp=null;
			}
			}
			
    }
}
public class postorderwithoutrec
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
		bt.postorder();
		
	}
}


