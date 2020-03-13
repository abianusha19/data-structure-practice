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
static boolean v1=false,v2=false;
void insert(char[] s,int v)
{
node newnode=new node(v);
node temp=this.root;
if(temp==null && s[0]=='n')
{
this.root=newnode;
return;
}
int i=0;
while(i<s.length-1)
{
if(s[i]=='l')
temp=temp.left;
if(s[i]=='r')
temp=temp.right;
i++;
}
if(s[i]=='l')
temp.left=newnode;
if(s[i]=='r')
temp.right=newnode;
}

node lca(node root,int n1,int n2)
{
if(root==null)
return null;

node temp=null;
if(root.data==n1)
{
v1=true;
temp=root;
}
if(root.data==n2)
{
v2=true;
temp=root;
}

node left_lca=lca(root.left,n1,n2);
node right_lca=lca(root.right,n1,n2);
if(temp!=null)
return temp;

if(left_lca!=null && right_lca!=null)
return root;

return left_lca!=null?left_lca:right_lca;
}

node checklca(node root,int n1,int n2)
{
v1=false;
v2=false;
node lca_node=lca(root,n1,n2);
if(v1&& v2)
return lca_node;
return null;
}
}

class findlca
{
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int arr[]=new int[n];
bst bt=new bst();
for(int i=0;i<n;i++)
{
String s=sc.next();
char ch[]=s.toCharArray();
int v=sc.nextInt();
bt.insert(ch,v);
}
System.out.println("Enter the nodes");
int n1=sc.nextInt();
int n2=sc.nextInt();
node result=bt.checklca(bt.root,n1,n2);
if(result!=null)
System.out.println("LCA of "+n1+" and "+n2+" : "+result.data);
else
System.out.println("Keys are not present");


}
}
	
	
	
