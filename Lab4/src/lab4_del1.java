public class lab4 {
    public static void main(String[] args){
        Composite suitcase = new Composite("suitcase");
        Composite bag = new Composite("bag");
        Composite trunk = new Composite("trunk");
        Composite ness = new Composite("ness");

        Leaf laptop = new Leaf("laptop", 10);
        Leaf camera = new Leaf("camera", 40);
        Leaf toothbrush = new Leaf("toothbrush", 50);
        Leaf charger = new Leaf("charger", 12);
        Leaf paper = new Leaf("paper", 17);
        Leaf jumper = new Leaf("jumper", 29);
        Leaf tshirt = new Leaf("tshirt", 32);
        Leaf hairspray = new Leaf("hairspray", 10);
        Leaf phone = new Leaf("phone", 11);

        //ness has hairspray
        ness.add(hairspray);

        //trunk has ness as well as charger, paper and jumper
        trunk.add(ness);
        trunk.add(charger);
        trunk.add(paper);
        trunk.add(jumper);


        //bag has trunk as well as camera, toothbrush and laptop
        bag.add(laptop);
        bag.add(camera);
        bag.add(toothbrush);
        bag.add(trunk);


        //suitcase has bag as well as tshirt and phone
        suitcase.add(bag);
        suitcase.add(tshirt);
        suitcase.add(phone);


        //printing the entire suitcase
        System.out.println(suitcase);
        System.out.println(suitcase.getWeight());


        //removing the hairspray
        System.out.println("Removing the hairspray");
        ness.remove(hairspray);

        System.out.println(suitcase);
        System.out.println(suitcase.getWeight());

        //removing the entire trunk
        System.out.println("Removing the trunk");
        bag.remove(trunk);

        System.out.println(suitcase);
        System.out.println(suitcase.getWeight());
        

    }
}
