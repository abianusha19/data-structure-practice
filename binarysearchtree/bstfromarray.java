import java.util.*;
class node
{
int data;
node left,right;
node(int v)
{
data=v;
}
}

class bst
{
node root=null;
node insert(int[] arr,int st,int n)
{
	if(st>n)
		return null;
int mid=(st+n)/2;
node newnode=new node(arr[mid]);
newnode.left=insert(arr,st,mid-1);
newnode.right=insert(arr,mid+1,n);
return newnode;

}

void inorder(node root)
{
if(root==null)
return;
inorder(root.left);
System.out.print(root.data+" ");
inorder(root.right);
}

}
class bstfromarray
{
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int arr[]=new int[n];
bst bt=new bst();
for(int i=0;i<n;i++)
{
arr[i]=sc.nextInt();
}
bt.root=bt.insert(arr,0,n-1);
bt.inorder(bt.root);
}
}