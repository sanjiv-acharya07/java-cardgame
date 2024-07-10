public class BTNode {
    private Player player;
    private BTNode left;
    private BTNode right;

    public BTNode(Player player) {
        this.player = player;
        this.left = null;
        this.right = null;
    }

    public BTNode getLeft() {
        return left;
    }

    public BTNode getRight() {
        return right;
    }

    public Player getPlayer() {
        return player;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }
}
