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
listnode head=null;
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
	return lh>rh?lh+1:rh+1;
}

}
class checkbalance
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
int lh=bt.height(bt.root.left);
int rh=bt.height(bt.root.right);
if(Math.abs(lh-rh)>1)
System.out.print("NOT BALANCED");
else
System.out.print("BALANCED");
}
}