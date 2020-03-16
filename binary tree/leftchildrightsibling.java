import java.util.*;
class node
{
int data;
node next,child;
node(int v)
{
data=v;
}
}

class tree
{
node root=null;

void insertsibling(node parentchild,node newnode)
{
if(parentchild.next==null)
parentchild.next=newnode;
else
{
while(parentchild.next!=null)
parentchild=parentchild.next;
parentchild.next=newnode;
}
}


void insert(int parentkey,int key)
{
node newnode=new node(key);
node parent=traversetree(this.root,parentkey);
if(parent.child==null)
parent.child=newnode;
else
insertsibling(parent.child,newnode);
}

node traversetree(node root,int data)
{
if(root==null)
return null;
else
{
while(root!=null)
{
if(root.data==data)
	return root;
if(root.child!=null)
{
node pt=traversetree(root.child,data);
if(pt!=null)
	return pt;

}
root=root.next;

}
}
return null;
}

void printtree(node root)
{
if(root==null)
return;
else
{
while(root!=null)
{
System.out.print(root.data+" ");
if(root.child!=null)
printtree(root.child);
root=root.next;
}
}
}
}

class leftchildrightsibling
{
	public static void main(String args[])
	{
Scanner sc=new Scanner(System.in);
int rootnode=sc.nextInt();
tree t=new tree();
t.root=new node(rootnode);
int n=sc.nextInt();


for(int i=0;i<n;i++)
{
	int parentkey=sc.nextInt();
	int newkey=sc.nextInt();
	t.insert(parentkey,newkey);
}
t.printtree(t.root);
}
}



















