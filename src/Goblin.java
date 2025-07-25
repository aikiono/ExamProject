public class Goblin extends Monster {
    public Goblin(char suffix, int hp) {
        super("ゴブリン",hp,suffix);
    }

    public void attack(Creature target) {
        System.out.println(getName() + getSuffix()+ "はナイフで切りつけた！" + target.getName() + "に8のダメージを与えた！");
        target.setHp(target.getHp() - 8);
    }
}

