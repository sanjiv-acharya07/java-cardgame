# JAVA Cardgame
## Instructions
The Java package can be run on a Java compiler. The user will use the formatted input file to create and run a card game.
## Classes

### 1. BTNode
### Basic Methods
The BTNode class defines binary tree nodes. Each node has the following attributes:
  player
  left
  right
The BTNode class contains a constructor, getter, and setter methods corresponding to these attributes.

### 2. BinaryTree
### Basic Methods
The BinaryTree class defines a binary tree. Each tree object has the following attributes:
  root
The BinaryTree class contains a constructor, getter methods, and setter methods corresponding to these attributes.
### Functionalities
1. insert
- void
- parameters: Player p
The insert method is used to insert a player into the binary tree object. If the tree is empty the player becomes the root, but if not the recursiveInsert method is used.

2. recursiveInsert
 - void
 - parameters: Player player, String playerName
The recursiveInsert method is used to recursively insert a player into the 
