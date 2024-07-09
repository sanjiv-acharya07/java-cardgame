import java.io.IOException;

public class BinaryTree {
    private BTNode root;

    public BinaryTree() {
        this.root = null;
    }
    public BTNode getRoot() {
        return root;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }

    public void insert(Player p) {
        if (getRoot() == null) {
            setRoot(new BTNode(null));
        }
        recursiveInsert(p, p.getName());
    }

    public void recursiveInsert(Player player, String playerName) {
        BTNode current = getRoot();
        for (int i = 0; i < playerName.length(); i++) {
            char currChar = playerName.charAt(i);
            if (isVowel(currChar)) {
                if (current.getLeft() == null) {
                    current.setLeft(new BTNode(null));
                }
                current = current.getLeft();
            } else {
                if (current.getRight() == null) {
                    current.setRight(new BTNode(null));
                }
                current = current.getRight();
            }
        }
        if (current.getPlayer() == null) {
            current.setPlayer(player);
        } else {
            flippedRecursive(player, playerName + playerName);
        }
    }

    public void flippedRecursive(Player p, String playerName) {
        BTNode current = getRoot();
        for (int i = 0; i < playerName.length(); i++) {
            char currChar = playerName.charAt(i);
            if (isVowel(currChar)) {
                if (current.getRight() == null) {
                    current.setRight(new BTNode(null));
                }
                current = current.getRight();
            } else {
                if (current.getLeft() == null) {
                    current.setLeft(new BTNode(null));
                }
                current = current.getLeft();
            }
        }
        if (current.getPlayer() == null) {
            current.setPlayer(p);
        } else {
            recursiveInsert(p, playerName + playerName);
        }
    }

    public void delete(char [] dirs) throws IOException {
        //TODO
        BTNode current = getRoot();
        for (char dir : dirs) {
            if (dir == 'L') {
                current = current.getLeft();
            } else if (dir == 'R') {
                current = current.getRight();
            }
        }
        if (current.getPlayer() != null) {
            current.setPlayer(null);
        }

    }

    public int obfuscation(char[] dirs) {
        //TODO
        String strArray = new String(dirs);
        if (dirs.length == 0) {
            return 0;
        }
        BTNode current = getRoot();
        int blankNodes = 1;
        for (char dir : dirs) {
            if (dir == 'L') {
                if (current.getLeft() == null) {
                    return -1;
                }
                current = current.getLeft();
                if (current.getPlayer() == null) {
                    blankNodes++;
                }
            } else if (dir == 'R') {
                if (current.getRight() == null) {
                    return -1;
                }
                current = current.getRight();
                if (current.getPlayer() == null) {
                    blankNodes++;
                }
            } else {
                return -1;
            }

        }
        if (current.getPlayer() == null) {
            return blankNodes - 1;
        }
        if (current.getPlayer() != null) {
            return blankNodes * current.getPlayer().getScore();
        }
        return -1;
    }

    public Player search(char[] dirs) {
        //TODO
        BTNode current = getRoot();

        for (char dir : dirs) {
            if (dir == 'L') {
                current = current.getLeft();
            } else if (dir == 'R') {
                current = current.getRight();

            } else {
                return null;
            }
        }
        if (current.getPlayer() != null) {
            return current.getPlayer();
        }
        return null;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}

//(Tylor Megill is the best pitcher in baseball.)