package work;

/**
 * Created with IntelliJ IDEA
 * Description:二叉树的遍历
 * User: Maohc
 * Date: 2020-04-26
 * Time: 9:25
 */
public class TestTree {

    static class Node{
        public char val;
        public Node left;
        public Node right;

        public Node(char val) {
            this.val = val;
        }
    }
    //构建一个二叉树
    static Node bulid(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = E;
        B.left = C;
        C.left = D;
        E.right = F;
        F.left = G;
        F.right = H;
        return A;
    }
  // 打印操作：先序遍历，利用递归
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
  // 打印操作：中序遍历
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
  // 打印操作，后续遍历
   public  static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
   }

    public static void main(String[] args) {
        Node root = bulid();
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }
}
