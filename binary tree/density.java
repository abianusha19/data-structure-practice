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

int countnodes()
{
node temp=this.root;
int cnt=0;
Queue<node> q=new LinkedList<node>();
q.add(temp);
while(!q.isEmpty())
{
temp=q.remove();
cnt++;
if(temp.left!=null)
{
q.add(temp.left);

}
if(temp.right!=null)
{
q.add(temp.right);
}
}
return cnt;}

int height(node root)
{
	if(root==null)
		return 0;
	int lh=height(root.left);
	int rh=height(root.right);
	return lh>rh?lh+1:rh+1;
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
class density
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
float c=bt.countnodes();

float h=bt.height(bt.root);

float d=c/h;
System.out.printf("%.2f",d);
}
}
















