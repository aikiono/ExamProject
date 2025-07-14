import java.util.ArrayList;

public class GameMaster {

    public static void main(String[] args) {
        // パーティ編成
        Hero hero = new Hero("ミナト", 100, "剣");
        Wizard wizard = new Wizard("アサカ", 80, 20);
        Thief thief = new Thief("ヨシキ", 75);
        ArrayList<Character> party = new ArrayList<>();
        party.add(hero);
        party.add(wizard);
        party.add(thief);

        // 敵モンスター編成
        Matango m1 = new Matango('A', 50);
        Goblin g1 = new Goblin('B', 60);
        Slime s1 = new Slime('C', 45);
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(m1);
        monsters.add(g1);
        monsters.add(s1);

        // 初期ステータス表示
        System.out.println("=== 味方ステータス ===");
        for (Character c : party) c.showStatus();

        System.out.println("\n=== 敵ステータス ===");
        for (Monster m : monsters) m.showStatus();

        // 味方の総攻撃
        System.out.println("\n=== 味方の攻撃 ===");
        for (Character c : party) {
            for (Monster m : monsters) {
                c.attack(m);
            }
        }

        // クラスチェンジイベント
        System.out.println("\n=== クラスチェンジ ===");
        SuperHero superHero = new SuperHero(hero);
        party.set(0, superHero); // HeroをSuperHeroに置き換え
        for (Monster m : monsters) {
            superHero.attack(m);
        }

        // 敵の総攻撃
        System.out.println("\n=== 敵の攻撃 ===");
        for (Monster m : monsters) {
            for (Character c : party) {
                m.attack(c);
            }
        }

        // 最終ステータス表示
        System.out.println("\n=== 最終ステータス ===");
        for (Character c : party) {
            c.showStatus();
            System.out.println(c.isAlive() ? "生存" : "戦闘不能");
        }

        for (Monster m : monsters) {
            m.showStatus();
            System.out.println(m.isAlive() ? "生存" : "討伐済み");
        }
    }
}

