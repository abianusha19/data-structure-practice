import java.util.*;
class newnode
{
    int data;
    newnode left=null;
    newnode right=null;
    newnode(int val)
    {
        data=val;
        
    }
}
class binarytree
{
    newnode root=null;
    
    void insert(int value)
    {
        newnode temp=this.root;
        newnode n1=new newnode(value);
        if(temp==null)
        {
            this.root=n1;
        }
        else
        {
            Queue<newnode> q=new LinkedList<newnode>();
            q.add(temp);
            while(!q.isEmpty())
            {
                temp=q.peek();
                q.remove();
                if(temp.left==null)
                {
                    temp.left=n1;
                    break;
                }
                else{
                    q.add(temp.left);
                }
                if(temp.right==null)
                {
                    temp.right=n1;
                    break;
                }
                else{
                    q.add(temp.right);
                }
                
            }
        }
    }
    
    void delete(int d)
    {
        newnode temp=this.root;
        newnode parent=null;
        if(temp==null)
        {
            System.out.println("No node available");
            return;
        }
            
        if(temp.left==null && temp.right==null)
        {
            if(temp.data==d)
               {
                   this.root=null;
                    return;
               }
               
        }
        Queue<newnode> q1=new LinkedList<newnode>();
        q1.add(temp);
        newnode keynode=null;
        while(!q1.isEmpty())
        {
            temp=q1.remove();
            if(temp.left!=null || temp.right!=null)
            {
            parent=temp;
            }
            if(temp.data==d)
            keynode=temp;
            if(temp.left!=null)
            q1.add(temp.left);
            if(temp.right!=null)
            q1.add(temp.right);
            
        }
        if(keynode!=null)
        {
            keynode.data=temp.data;
            if(parent.left==temp)
            {
                parent.left=null;
            }
            else if(parent.right==temp)
            {
                parent.right=null;
            }
        }
        
    }
}
public class treedel
{
    public void inorder(newnode temp)
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
		binarytree bt=new binarytree();
		treedel m=new treedel();
		for(int i=0;i<n;i++)
		{
		    bt.insert(sc.nextInt());
		}
		m.inorder(bt.root);
		int del=sc.nextInt();
        bt.delete(del);
		System.out.println("After deletion");
		m.inorder(bt.root);
		
	}
}
