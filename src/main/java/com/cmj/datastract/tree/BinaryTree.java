package com.cmj.datastract.tree;

/**
 * ================================================
 * Description:  二叉树
 *
 * Created by chmj on 2019/4/26
 *
 * ================================================
 */
public class BinaryTree {

    private Node tree;

    /**
     * 插入
     * @param data
     */
    public void insert(int data) {

        if(tree == null) {
            // 插入根节点
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if(data > p.data) {
                // 如果要插入的数大于当前节点，则插到当前节点的右子节点中
                if(p.right == null) {
                    // 如果当前节点的右子节点没有，则直接插入
                    p.right = new Node(data);
                    return;
                } else {
                    // 如果右子节点有值，则遍历重复操作
                    p = p.right;
                }
            } else {
                // 如果要插入的数小于当前节点，则插到当前节点的左子节点中
                if(p.left == null) {
                    // 如果当前节点的左子节点没有，则直接插入
                    p.left = new Node(data);
                    return;
                } else {
                    p = p.left;
                }
            }
        }
    }

    /**
     * 查找
     * @param data
     * @return
     */
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if(data > p.data) {
                // 当要查找的值比当前节点值大，则去当前节点的右子节点去查
                p = p.right;
            } else if(data < p.data) {
                // 当要查找的值比当前节点值小，则去当前节点的左子节点去查
                p = p.left;
            } else {
                return p;
            }
        }

        return null;
    }

    /**
     * 删除:分三种情况
     * 1：如果要删除的节点没有子节点，我们只需将父节点中，指向要删除节点的指针置为null。
     * 2：如果要删除的节点只有一个子节点(左右都可以),我们只需更新父节点中指向要删除节点的指针，让他指向要删除节点的子节点即可。
     * 3：如果要删除的节点有两个子节点，这是我们需要找到这个节点的右子节点中最小的节点，把它替换到要删除的节点上，然后在删除这个最小的子节点
     * @param data
     */
    public void delete(int data) {

        // p 指向要删除的节点，初始化为根节点
        Node p = tree;
        // p的父节点
        Node pp = null;

        // 先遍历获取要删除的节点
        while (p != null && p.data != data) {
            // 将p当成父节点，准备处理P的子节点
            pp = p;
            if(data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        // 没有找到要删除的节点，直接返回
        if(p == null) {
            return;
        }

        // 当改节点有两个子节点
        if(p.left != null && p.right != null) {
            // 找到这个节点的右子节点中最小的节点
            Node minP = p.right;
            // 父节点
            Node minPP = p;

            // 因为最小的子节点肯定没有左子节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }

            // 找到最小子节点，把它替换到要删除的节点上
            p.data = minP.data;  // 将minP的值替换掉p
            p = minP; // 下面就变成了删除
            pp = minPP;
        }

        // 要删除是叶节点或者只有一个节点
        Node child;
        if(p.left != null) {
            // 当左节点不为空
            child = p.left;
        } else if(p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        // 更新要删除节点的父节点指向删除节点的指针
        if(pp == null) {
            // 说明是根节点
            tree = child;
        } else if(pp.left == p) {
            // 左子节点
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    /**
     * 查找最大值
     * @return
     */
    public Node findMax() {
        if(tree == null) {
            return null;
        }

        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }

        return p;
    }

    /**
     * 查找最小值
     * @return
     */
    public Node findMin(){
        if(tree == null) {
            return null;
        }
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }

        return p;
    }

    /**
     * 前序遍历
     */
    public void printPre(Node node) {
        if(node == null) {
            return;
        }
        // 先打印本节点
        System.out.print(node.data + "->");

        printPre(node.left);
        printPre(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public void printIn(Node node) {
        if(node == null) {
            return;
        }
        printIn(node.left);
        // 先打印本节点
        System.out.print(node.data + "->");
        printIn(node.right);
    }

    /**
     * 后续遍历
     * @param node
     */
    private void printPost(Node node) {
        if(node == null) {
            return;
        }
        printPost(node.left);
        printPost(node.right);
        System.out.print(node.data + "->");
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(33);
        tree.insert(16);
        tree.insert(50);
        tree.insert(13);
        tree.insert(18);
        tree.insert(34);
        tree.insert(58);
        tree.insert(15);
        tree.insert(17);
        tree.insert(25);
        tree.insert(51);
        tree.insert(66);
        tree.insert(19);
        tree.insert(27);
        tree.insert(55);

        tree.printPre(tree.find(33));
        System.out.println("");
        tree.printIn(tree.find(33));
        System.out.println("");
        tree.printPost(tree.find(33));
        System.out.println("");
        System.out.println(tree.findMax().data);
        System.out.println(tree.findMin().data);
    }
}
