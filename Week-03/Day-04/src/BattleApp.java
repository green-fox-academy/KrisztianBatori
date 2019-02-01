public class BattleApp {
    public static void main(String[] args) {
        Ship blackPearl = new Ship();
        blackPearl.fillShip();
        blackPearl.setCaptainName("John Wick");
        blackPearl.shipData();

        System.out.println();

        Ship death = new Ship();
        death.fillShip();
        death.setCaptainName("Vyx");
        death.shipData();

        System.out.println();
        System.out.println();

        blackPearl.battle(death);

        System.out.println();
        System.out.println();

        blackPearl.shipData();
        System.out.println();
        death.shipData();

        blackPearl.battle(death);

        System.out.println();
        System.out.println();

        blackPearl.shipData();
        System.out.println();
        death.shipData();
    }
}
