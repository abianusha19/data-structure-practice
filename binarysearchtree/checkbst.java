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

boolean checkbst(node root,int min,int max)
{
if(root==null)
return true;
if(root.data<min || root.data>max)
return false;

return (checkbst(root.left,min,root.data-1) && checkbst(root.right,root.data+1,max));
}
}

class checkbst
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
if(bt.checkbst(bt.root,Integer.MIN_VALUE,Integer.MAX_VALUE))
System.out.println("Binay tree is a binary search tree");
else
System.out.println("Binay tree is not a binary search tree");

}
}
	
	
	
