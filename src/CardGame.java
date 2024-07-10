public class CardGame {
    private CircularDoublyLinkedList<Player> table;
    private DoublyLinkedList<Player> players;

    public CardGame() {
        table = new CircularDoublyLinkedList<>();
        players = new DoublyLinkedList<>();
    }

    public void addPlayer(Player p) {
        players.insert(p);
        table.insert(p);
    }

    public void removePlayer(Player p) {
        CDLLNode<Player> bad = table.search(p);
        table.delete(bad);
    }

    public void play(int seed) {
        // do not touch this method
        int randSeed = (971 * seed) % 4871;
        int seat = 0;
        for (Player p : table) {
            int roundScore = Math.abs(hash(p.getAge()) + hash(p.getId()) + hash(sumChars(p.getName())) + ((randSeed + seat) * 7607)) % 52;
            players.search(p).getData().addToScore(roundScore);
            seat++;
        }
    }

    public CircularDoublyLinkedList<Player> getTable() {
        return table;
    }

    public DoublyLinkedList<Player> getPlayers() {
        return players;
    }
    private int hash(int x) {
        // do not touch this method
        x = ((x >> 16) ^ x) * 0x45d9f3b;
        x = ((x >> 16) ^ x) * 0x45d9f3b;
        x = (x >> 16) ^ x;
        return x;
    }
    private int sumChars(String str) {
        // do not touch this method
        int res = 0;
        for(int i = 0; i < str.length(); i++) {
            res += str.charAt(i);
        }
        return res;
    }
}
