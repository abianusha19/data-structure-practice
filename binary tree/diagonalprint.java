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
void insert(char[] s,int v)
{
node temp=this.root;
node newnode=new node(v);
if(temp==null && s[0]=='N')
{
this.root=newnode;
return;
}
int i=0;
while(i<s.length-1)
{
if(s[i]=='L')
temp=temp.left;
if(s[i]=='R')
temp=temp.right;
i++;
}
if(s[i]=='L')
temp.left=newnode;
if(s[i]=='R')
temp.right=newnode;

}

void diagonal()
{
node temp=this.root;
Queue<node> q=new LinkedList<node>();
q.add(temp);
q.add(null);
while(!q.isEmpty())
{
temp=q.remove();
if(temp==null)
{
if(q.size()==0)
return;
System.out.println();
q.add(null);
}
else
{
while(temp!=null)
{
System.out.print(temp.data+" ");
if(temp.left!=null)
q.add(temp.left);
temp=temp.right;
}
}
}
}
}

class diagonalprint
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
binarytree bt=new binarytree();
int n=sc.nextInt();
for(int i=0;i<n;i++)
{
String s=sc.next();
char[] st=s.toCharArray();
int nd=sc.nextInt();
bt.insert(st,nd);
}
bt.diagonal();
}
}