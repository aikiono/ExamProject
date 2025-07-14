public abstract class Monster implements Creature {
    private String name;
    private int hp;
    private char suffix;

    public Monster(String name, char suffix, int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
        }
        this.name = name;
        this.suffix = suffix;
        setHp(hp);
    }

    public final boolean isAlive() {
        return hp > 0;
    }

    public void showStatus() {
        System.out.println(name + suffix + "：HP " + hp);
    }

    public String getName() {
        return name + suffix;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuffix(char suffix) {
        this.suffix = suffix;
    }
}
