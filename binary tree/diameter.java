import java.util.*;
import java.lang.Math;
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
int ans=0;
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

int height(node root)
{
if(root==null)
return 0;

int lh=height(root.left);
int rh=height(root.right);

ans=Math.max(ans,lh+rh+1);
return Math.max(lh,rh)+1;
}
}

class diameter
{
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int n1=sc.nextInt();

bst t1=new bst();
for(int i=0;i<n1;i++)
{
String s=sc.next();
char ch[]=s.toCharArray();
int v=sc.nextInt();
t1.insert(ch,v);
}
t1.height(t1.root);
System.out.println("Diameter of the tree is : "+t1.ans);


}
}
	
	
	
