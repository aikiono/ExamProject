import java.util.ArrayList;

public class GameMaster {

    public static void main(String[] args) {
        // パーティ編成
        Hero hero = new Hero("勇者", 100, "剣");
        Wizard wizard = new Wizard("魔法使い",60, 20);
        Thief thief = new Thief("盗賊", 70);
        //Character c = new Character("名無し", 50);
        //Hero testHero = new Hero("テスト勇者", -10, "テスト剣");
        //hero.name = "ミナト";
        //hero.hp = 200;
        ArrayList<Character> party = new ArrayList<>();
        party.add(hero);
        party.add(wizard);
        party.add(thief);

        // 敵モンスター編成
        Matango m1 = new Matango('A', 45);
        Goblin g1 = new Goblin('A', 50);
        Slime s1 = new Slime('A', 40);
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(m1);
        monsters.add(g1);
        monsters.add(s1);

        // 初期ステータス表示
        System.out.println("---味方パーティー---");
        for (Character c : party) c.showStatus();

        System.out.println("\n---敵グループ---");
        for (Monster m : monsters) m.showStatus();

        // 味方の総攻撃
        System.out.println("\n味方の総攻撃！");
        for (Character c : party) {
            for (Monster m : monsters) {
                c.attack(m);
            }
        }

        // 敵の総攻撃
        System.out.println("\n敵の総攻撃！");
        for (Monster m : monsters) {
            for (Character c : party) {
                m.attack(c);
            }
        }

        // クラスチェンジイベント
        System.out.println("\nダメージを受けた"+hero.getName()+"が突然光りだした！");
        System.out.println(hero.getName()+"はスーパーヒーローに進化した！");
        SuperHero superHero = new SuperHero(hero);
        party.set(0, superHero); // HeroをSuperHeroに置き換え
        for (Monster m : monsters) {
            superHero.attack(m);
        }

        // 最終ステータス表示
        System.out.println("\n---味方パーティー最終ステータス---");
        for (Character c : party) {
            c.showStatus();
            System.out.println("生存状況:"+(c.isAlive() ? "生存" : "戦闘不能"));
        }
        System.out.println("\n---敵グループ最終ステータス---");
        for (Monster m : monsters) {
            m.showStatus();
            System.out.println("生存状況:"+(m.isAlive() ? "生存" : "討伐済み"));
        }
    }
}

