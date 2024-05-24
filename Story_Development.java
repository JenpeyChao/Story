import java.util.Scanner;

public class Story_Development {

    public static class Items{
        private String name;
        private String description;
        private boolean take = false;
        private boolean used = false;
        
        public Items(String name,String description,boolean take){
            this.name = name;
            this.description = description;
            this.used = false;
            
        }
        public void setUsed(boolean used){
            this.used = true;
        }
        public String getName(){
            return name;
        }
    }

    public static class Rooms{
        private Rooms north;
        private Rooms east;
        private Rooms south;
        private Rooms west;
        private String description = "";
        private Items[] items;
        private String examine;
        private boolean locked;
        private String key;
        

        public Rooms(String description, String examine, Items[] items,boolean locked, String key){
            this.north = null;
            this.east = null;
            this.south = null;
            this.west = null;
            this.description = description;
            this.items = items;
            this.examine = examine;
            this.key = key;
        }
        public void printItems(){
            if (this.items.length == 0){
                System.out.println("Theres no items to grab");
            }else{
                for(int i = 0; i<this.items.length; i++){
                    System.out.println(this.items[i].getName());
                }
            }
            
        }
        public void getDescription(){
            System.out.println(this.description);
        }
        public void getExamine(){
            System.out.println(this.examine);
        }
        public void setNorth(Rooms room){
            this.north = room;
        }
        public void setEast(Rooms room){
            this.east = room;
        }
        public void setSouth(Rooms room){
            this.south = room;
        }
        public void setWest(Rooms room){
            this.west = room;
        }
        public Rooms getNorth(){
            return this.north;
        }
        public Rooms getEast(){
            return this.east;
        }
        public Rooms getSouth(){
            return this.south;
        }
        public Rooms getWest(){
            return this.west;
        }
    }
    
    static Rooms createStory(){
        String description = "In front of you is a bookshelf filled with books and random potions. \nYou see a locked door to the East. \nYou see an alter with a sock engraving on it.";
        String examine = "You look closely at the bookshelf. You see a lot of different books and potions. \n You avoid the potions since they seem harmful.\nHowever you see a key poking out of a book";
        Items[] items = new Items[1];
        items[0] = new Items("Bloody Key","A bloody key to an unknown door or chest",true);
        Rooms main = new Rooms(description, examine, items, false, "");

        description = "Youre in a dark long hall way. With the exit to the west";
        examine = "As you look down the hallway, you can see a small light flickering";
        items = new Items[0];
        Rooms locked_door = new Rooms(description, examine, items, true, "Bloody Key");
        main.setEast(locked_door);
        locked_door.setWest(main);

        items = new Items[0];
        description = "Congratulations youve found the exit to the mad lair";
        Rooms exit = new Rooms(description, "", items, true, "Sock","");
        main.setSouth(exit);
        exit.setNorth(main);

        description = "Youre deeper in the dark long hall way. With the way back to the west. \nYou can see the light get brighter. ";
        examine = "As you look down the hallway, you can see some sort of shadow, but you cant see what it is";
        items = new Items[0];
        Rooms hall = new Rooms(description, examine, items, false, "");
        locked_door.setEast(hall);
        hall.setWest(locked_door);

        description = "Youre in a dim lit room. \nYou see a hole in the wall thats too small to fit your hand in.";
        examine = "As you look closely at the sign, you can see something dripping all over the sign.";
        items = new Items[1];
        items[0] = new Items("Sock","A random sock that, you dont want to wear",true);
        Rooms board = new Rooms(description, examine, items, false, "");
        hall.setEast(board);
        board.setWest(hall);
        //need to add a statement for going backwards, we have a statement for forwards 
        
        return main;
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Rooms story = createStory();
        // Items backpack = new Items();

        System.out.println("Type something to start");
        String start = myObj.nextLine();
        System.out.println("You've woken up in cave like lair. As you look around, you see a board with a name 'Harry Potter'. It seems youre trapped in a mad wizards lair");
        do{//swtich case with a 2 word case; ex: examine room
            // story.getDescription();
            // story.printItems();
            // story = story.getEast();
            // story.getDescription();
            // story.printItems();
            // story = story.getWest();
            // story.getDescription();
            // story.printItems();
            // System.out.println("Here are your options:");
            // System.out.println("1) Go North");
            // System.out.println("2) Go East");
            // System.out.println("3) Go South");
            // System.out.println("4) Go West");
            // System.out.println("5) Examine the current room");
            // System.out.println("6) Take an item");
            break;

        }while(!start.equals("") );

        myObj.close();
    }
}
