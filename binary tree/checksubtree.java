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

boolean areidentical(node root1,node root2)
{
if(root1==null && root2==null)
return true;
if(root1==null || root2==null)
return false;

return (root1.data==root2.data && areidentical(root1.left,root2.left) && areidentical(root1.right,root2.right));

}

boolean issubtree(node t1,node t2)
{
if(t1==null)
return false;
if(t2==null)
return false;

if(areidentical(t1,t2))
return true;

return issubtree(t1.left,t2)|| issubtree(t1.right,t2);
}
}

class checksubtree
{
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int n1=sc.nextInt();

bst t1=new bst();
bst t2=new bst();
for(int i=0;i<n1;i++)
{
String s=sc.next();
char ch[]=s.toCharArray();
int v=sc.nextInt();
t1.insert(ch,v);
}
int n2=sc.nextInt();
for(int i=0;i<n2;i++)
{
String s=sc.next();
char ch[]=s.toCharArray();
int v=sc.nextInt();
t2.insert(ch,v);
}
if(t1.issubtree(t1.root,t2.root))
System.out.println("YES!! SUBTREE");
else
System.out.println("NO!! NOT A SUBTREE");


}
}
	
	
	
