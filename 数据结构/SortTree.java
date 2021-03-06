//二叉排序树原理说明
//二叉排序树：BST: (Binary Sort(Search) Tree), 对于二叉排序树的 任何一个非叶子节点，要求 左子节点的值比当
 //前节点的值小， 右子节点的值比当前节点的值大
//二叉排序树 1、创建和遍历，二叉排序树的删除、二叉排序树删除节点


/*
创建二叉排序树
add
递归形式添加结点，
判断传入得结点得值，和当前子树根节点比较，大就接着调右子节点得add方法，小就调左子节点得add方法

遍历
前序、中序、后序遍历
*/
/*
二叉排序树的删除：
1、删除叶子节点
2、删除只有一颗子树的节点
3、删除有两颗子树的节点

第一种情况
思路：
1、先找到要删除得结点
2、找到要删除得结点得父节点
3、判断要删除结点是父节点得左子节点还是右子节点
4、根据前面得情况对应删除（父节点得左右结点置为null）
第二种情况
思路：
1、2、前两步同上
3、确定待删除结点得子节点是左子节点还是右子节点
4、 要删除结点时parent得左子节点还是右子节点
5、对应不同情况进行不同处理

第三种情况
前两步同上
3、从要删除结点得右子树找到最小的结点
4、用一个临时变量，将最小的结点值保存
5、删除该最小结点
6、最小结点值赋给删除的结点
*/
//二叉排序树代码
//创建二叉排序树
class BinarySortTree {
private Node root;
public Node getRoot() {
return root;
}
//查找要删除的结点
public Node search(int value) {
 if(root == null) {
return null;
} else {
return root.search(value);
}
}
//查找父结点
public Node searchParent(int value) {
if(root == null) {
return null;
} else {
return root.searchParent(value);
}
}
