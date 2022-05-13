import java.util.ArrayList;
import java.util.Scanner;

public class Orders {
    static Scanner in = new Scanner(System.in);
    ArrayList<Weapons> order = new ArrayList<>();


    public void newWeapon(ArrayList<Weapons> list) {
        try {
            System.out.println("Név:");
            String name = in.nextLine();
            Integer i = 0;
            Boolean y = true;
            for (; i < list.size(); i++) {
                if (list.get(i).getName().equals(name)) {
                    y = false;
                    break;
                }
            }
            if (y) System.out.println("Fegyver nem található");
            this.order.add(new Weapons(name, list.get(i).getType(), list.get(i).getCost(), list.get(i).getTime(), list.get(i).getUpgradePath()));
        } catch (Exception exception) {
        }
        System.out.println(order);
    }

    public void modifyWeapon(ArrayList<Weapons> list) {
        if (order.isEmpty()) System.out.println("Nincs rendelés");
        else {
            System.out.println("Melyik rendelést módosítsam?");
            String name = in.nextLine();
            Boolean y = true;
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getName().equals(name)) {
                    y=false;
                    System.out.println("Új név:");
                    String newName = in.nextLine();
                    Boolean x = true;
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).getName().equals(newName)) {
                            order.get(i).setName(newName);
                            order.get(i).setType(list.get(j).getType());
                            order.get(i).setCost(list.get(j).getCost());
                            order.get(i).setTime(list.get(j).getTime());
                            order.get(i).setUpgradePath(list.get(j).getUpgradePath());
                            x = false;
                        }
                    }
                    if (x) System.out.println("Fegyver nem található a listában");
                }
            }
            if (y) System.out.println("Rendelés nem található");
            else System.out.println(order);
        }
    }

    public void deleteWeapon() {
        if (order.isEmpty()) System.out.println("Nincs rendelés");
        else {
            System.out.println("Melyik rendelést töröljem?");
            String name = in.nextLine();
            Boolean y = true;
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i).getName().equals(name)) {
                    order.remove(i);
                    y = false;
                }
            }
            if (y) System.out.println("Nincs ilyen rendelés");
            else System.out.println(order);
        }
    }
    public String sumOfOrders(){
        String sumText="";
        Integer sumTime=0,sumCost=0;
        int i=0;
        for(;i< order.size();i++){
            sumCost+=order.get(i).getCost();
            sumTime+=order.get(i).getTime();
        }
        sumText="Rendelések száma: "+i+", költség: "+sumCost+", elkészítési idő: "+sumTime+" munkanap";
        return sumText;
    }
}
