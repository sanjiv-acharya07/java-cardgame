public class Player {
    private String name;
    private int age;
    private int id;
    private int score;

    public Player(String n, int a, int i) {
        name = n;
        age = a;
        id = i;
        score = 0;
    }
    public Player(String n, int s) {
        name = n;
        score = s;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void addToScore(int amount) {
        score += amount;
    }
    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
    @Override
    public boolean equals(Object o) {
        Player cd = (Player)o;
        return this.name.equals(cd.getName());
    }

}
