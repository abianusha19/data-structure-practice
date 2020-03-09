import java.util.*;
class node
{
    int data;
    node(int v)
    {
        data=v;
    }
}
class binarytree
{
    
   void printpost(int[] pre,int length,int minval,int maxval,node preindex)
   {
  
       if(preindex.data==length)
       return;
       if(pre[preindex.data]<minval || pre[preindex.data]>maxval)
       return;
       int val=pre[preindex.data];
       preindex.data++;
       
       printpost(pre,length,minval,val,preindex);
       printpost(pre,length,val,maxval,preindex);
       System.out.println(val);
   }
}
public class postfrompre
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		binarytree bt=new binarytree();
		int n=sc.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    ar[i]=sc.nextInt();
		}
		node n1=new node(0);
		bt.printpost(ar,n,Integer.MIN_VALUE,Integer.MAX_VALUE,n1);
		
	}
}
