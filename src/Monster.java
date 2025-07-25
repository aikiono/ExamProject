public abstract class Monster implements Creature {
    private String name;
    private int hp;
    private char suffix ;
    public Monster(String name, int hp,char suffix) {
        if (hp < 0) {
            throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
        }
        this.name = name;
        this.hp = hp;
        this.suffix = suffix;
    }

    public char getSuffix(){
        return suffix;
    }

    public void setSuffix(char suffix){
        this.suffix = suffix;
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public final boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    @Override
    public void showStatus() {
        System.out.println(this.name +this.suffix + "：HP " + this.hp);
    }
}
