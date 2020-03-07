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
    int preindex=0;
    newnode root=null;
    
    newnode buildtree(int[] pre,int[] in,int st,int end)
    {
        if(st>end)
        return null;
        newnode tnode=new newnode(pre[preindex++]);
        if(st==end)
        return tnode;
        int inindex=search(in,st,end,tnode.data);
        tnode.left=this.buildtree(pre,in,st,inindex-1);
        tnode.right=this.buildtree(pre,in,inindex+1,end);
        return tnode;
    }
     int search(int[] in,int st,int end,int key)
     {
         int i;
        for(i=st;i<=end;i++)
        {
            if(in[i]==key)
            {
                return i;
            }
        }
        return i;
     }
}
public class constructtree
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
		constructtree m=new constructtree();
		int in[]=new int[n];
		int pre[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    in[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
		    pre[i]=sc.nextInt();
		}
		bt.root=bt.buildtree(pre,in,0,n-1);
		System.out.println("After Consrtuction");
		m.inorder(bt.root);
		
	}
}
