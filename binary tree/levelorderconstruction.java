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
    
    newnode buildtree(int[] level,int[] in,int st,int end)
    {
        
        if(st>end)
        return null;
        if(st==end)
        {
          return new newnode(in[st]);
        }
        newnode tnode=null;
        boolean found=false;
        int inindex=0;
         for(int i=0;i<level.length-1;i++)
        {
            int data=level[i];
            
        for(int j=st;j<=end;j++)
        {
            if(in[j]==data)
            {
                tnode=new newnode(in[j]);
                inindex=j;
                found=true;
                break;
            }
        }
        if(found==true)
            break;
     }
        
        tnode.left=this.buildtree(level,in,st,inindex-1);
        tnode.right=this.buildtree(level,in,inindex+1,end);
        return tnode;
    }
}
public class levelorderconstruction
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
		levelorderconstruction m=new levelorderconstruction();
		int in[]=new int[n];
		int level[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    in[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
		    level[i]=sc.nextInt();
		}
		bt.root=bt.buildtree(level,in,0,n-1);
		System.out.println("After Consrtuction");
		m.inorder(bt.root);
		
	}
}
