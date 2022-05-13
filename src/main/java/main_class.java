import java.util.ArrayList;

public class main_class {
    public static void main(String[] args) {
        ArrayList<Weapons> wep = XMLin.XMLIn("src/main/resources/data.xml");
        String buttons="1 - Fegyverlista megjelenítése" + "\n" + "2 - Fegyvertípusok megjelenítése" + "\n" + "3 - Rendelés" + "\n" + "4 - Fegyver törlése a rendelések közül"
                + "\n" + "5 - Rendelés módosítása" + "\n" + "6 - Összegzés" + "\n" + "7 - Kilépés" + "\n" + "menu - Menu kiíratása";
        System.out.println(buttons);
        Orders order = new Orders();
        String menu = Orders.in.nextLine();
        while (!(menu.equals("7"))) {
            switch (menu) {
                case "1" -> System.out.println(Weapons.getAllWeaponNames(wep));

                case "2" -> System.out.println(Weapons.getAllWeaponTypes(wep));

                case "3" -> order.newWeapon(wep);

                case "4" -> order.deleteWeapon();

                case "5" -> order.modifyWeapon(wep);

                case "6" -> System.out.println(order.sumOfOrders());
                case "7" -> {
                    break;
                }

                case "menu" -> System.out.println(buttons);

                default -> System.out.println("1-7 közötti számot fogadok el");

            }
            menu = Orders.in.nextLine();
        }
        XMLout out=new XMLout();
        out.XMLOut("src/main/resources/data2.xml",order.order);
    }
}