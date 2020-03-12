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

class binarytree
{
node root=null;
Vector<node> dic=new Vector<node>();
int maxlevel=0;
void insert(int v)
{
node newnode=new node(v);
node temp=this.root;
if(temp==null)
{
this.root=newnode;
return;
}
Queue<node> q=new LinkedList<node>();
q.add(temp);
while(!q.isEmpty())
{
temp=q.remove();
if(temp.left==null)
{
temp.left=newnode;
return;
}
else
q.add(temp.left);
if(temp.right==null)
{
temp.right=newnode;
return;
}else
q.add(temp.right);
}
}

void printLeaves(node root)
{
if(root==null)
return;
printLeaves(root.left);
if(root.left==null && root.right==null)
{
if(!dic.contains(root))
{
dic.add(root);
System.out.print(root.data+" ");
}
}
printLeaves(root.right);
}

void leftview(node root,int level)
{
if(root!=null)
{
if(maxlevel<level)
{
System.out.print(root.data+" ");
maxlevel=level;
dic.add(root);
}
leftview(root.left,level+1);
leftview(root.right,level+1);
}
}

void rightview(node root,int level)
{
if(root!=null)
{
if(maxlevel<level && !dic.contains(root))
{
System.out.print(root.data+" ");
maxlevel=level;
dic.add(root);
}
rightview(root.right,level+1);
rightview(root.left,level+1);
}
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
class boundarytraversal
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
binarytree bt=new binarytree();
for(int i=0;i<n;i++)
{
int m=sc.nextInt();
bt.insert(m);
}
bt.leftview(bt.root,1);
bt.maxlevel=0;
bt.printLeaves(bt.root.left);
bt.printLeaves(bt.root.right);
bt.rightview(bt.root,1);
}
}
















