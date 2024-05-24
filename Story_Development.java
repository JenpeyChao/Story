import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Story_Development {

    public static class Items{
        private String name;
        private String description;
            
        public Items(String name,String description){
            this.name = name;
            this.description = description;
            
        }
        public Items(){
            this.name = "";
            this.description = "";
            
        }
        public void getDescription(){
            System.out.println(this.description);
        }

        public String getName(){
            return this.name;
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
            this.locked = locked;
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
        public Items getItem(String name){
            for (int i =0;i < this.items.length;i++){
                if (this.items[i].getName().equals(name)){
                    return items[i];
                }
            }
            return new Items();
        }
        public String[] getItemName(){
            String[] itemsName = new String[this.items.length];
            for(int i = 0; i < this.items.length; i++){
                itemsName[i] = this.items[i].getName();
            }
            return itemsName;
        }
        public void setLock(boolean locked){
            this.locked = locked;
        }
        public boolean isLocked(){
            return this.locked;
        }
        public String getKey(){
            return this.key;
        }
        public void getDescription(){
            System.out.println(this.description);
        }
        public String getExamine(){
            return (this.examine);
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
        String description = "In front of you is a bookshelf filled with books and random potions. \nYou see a locked door to the East. \nYou see an alter with a sock engraving on it to the South.";
        String examine = "You look closely at the bookshelf. You see a lot of different books and potions. \n You avoid the potions since they seem harmful.\nHowever you see a bloody key poking out of a book";
        Items[] items = new Items[1];
        items[0] = new Items("bloody key","A bloody key to an unknown door or chest");
        Rooms main = new Rooms(description, examine, items, false, "");

        description = "Youre in a dark long hall way. With the exit to the west";
        examine = "As you look down the hallway, you can see a small light flickering";
        items = new Items[0];
        Rooms locked_door = new Rooms(description, examine, items, true, "bloody key");
        main.setEast(locked_door);
        locked_door.setWest(main);

        items = new Items[0];
        description = "You pressed the hard sock into the alter and a door opens up."+
                    "\nAs the door opens, you see harry potter staring at you while holding a wand."+
                    "\nBefore you know, you have died.";
        Rooms exit = new Rooms(description, "", items, true, "sock");
        main.setSouth(exit);
        exit.setNorth(main);

        description = "Youre deeper in the dark long hall way. With the way back to the west. \nYou can see the light get brighter. ";
        examine = "As you look down the hallway, you can see some sort of shadow, but you cant see what it is";
        items = new Items[0];
        Rooms hall = new Rooms(description, examine, items, false, "");
        locked_door.setEast(hall);
        hall.setWest(locked_door);

        description = "Youre in a dim lit room. \nYou see a hole in the wall thats too small to fit your hand in.\nYou also see a sign above the hole saying 'Special Suprise'";
        examine = "As you look closely at the sign, you can see something dripping all over the sign, with a sock stuck behind it";
        items = new Items[1];
        items[0] = new Items("sock","A random sock that, you dont want to wear");
        Rooms board = new Rooms(description, examine, items, false, "");
        hall.setEast(board);
        board.setWest(hall);
        //need to add a statement for going backwards, we have a statement for forwards 
        
        return main;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Rooms story = createStory();
        ArrayList<String> backpack = new ArrayList<String>();
        ArrayList<Items> backpackObj = new ArrayList<Items>();

        System.out.println("Type something to start");
        String start = myObj.nextLine();
        System.out.println("You've woken up in cave like lair. As you look around, you see a board with a name 'Harry Potter'. It seems youre trapped in a mad wizards lair");
        story.getDescription();

        do{//swtich case with a 2 word case; ex: examine room
            //if it reaches the end then it breaks the loop
            if(story.getExamine().equals("")){
                break;
            }
            System.out.print("What do you want to do? ");
            start = myObj.nextLine();
            start.toLowerCase();
            String[] choice = start.split(" ");
            
            switch (choice[0]){

                case "take":
                    //since the input is split you add back the 
                    String item;
                    if (choice.length > 2){
                        item = choice[1]+" "+choice[2];
                    }else{
                        item = choice[1];
                    }
                    
                    if(Arrays.stream(story.getItemName()).anyMatch(item::equals)){
                        backpack.add(item);
                        backpackObj.add(story.getItem(item));

                    }else{
                        System.out.println("You rip a brain cell out of your head");
                    }
                    break;
                case "move":
                    
                    switch (choice[1]) {
                        //goes to each case that the user chose
                        case "east":
                        //checks N,E,S,W to see if theres a room linked to the current room youre in
                            //prints something if theres no room
                            if(story.getEast()== null ){
                                System.out.println("You hit your head against a wall");
                            }else{
                                //checks if the room is locked or if you have the key and its locked or its not locked
                                if( (story.getEast().isLocked() && backpack.contains((story.getEast()).getKey())) || !story.getEast().isLocked()){
                                    //if its locked and you have the key then it prints you opened the door and keeps it unlocked now 
                                    if(story.getEast().isLocked() && backpack.contains((story.getEast()).getKey())){
                                        story.getEast().setLock(false);
                                        System.out.println("Youve unlocked a door/alter");
                                    }
                                    //moves east and prints the description of the room
                                    story = story.getEast();
                                    story.getDescription();
                                }else{
                                    //if you dont have the key and its locked and it states its locked
                                    System.out.println("ITS LOCKED YOU WEIRDO");
                                }
                            }
                            break;
                        //repeats for north as well 
                        case "north":
                            if(story.getNorth()== null ){
                                System.out.println("You hit your head against a wall");
                            }else{
                                if( (story.getNorth().isLocked() && backpack.contains((story.getNorth()).getKey())) || !story.getNorth().isLocked()){

                                    if(story.getNorth().isLocked() && backpack.contains((story.getNorth()).getKey())){
                                        story.getNorth().setLock(false);
                                        System.out.println("Youve unlocked a door/alter");
                                    }
                                    //moves north and prints the description of the room
                                    story = story.getNorth();
                                    story.getDescription();
                                }else{
                                    System.out.println("ITS LOCKED YOU WEIRDO");
                                }
                            }
                        
                            break;
                        //repeats for south as well
                        case "south":
                            if(story.getSouth()== null ){
                                System.out.println("You hit your head against a wall");
                            }else{
                                if( ( story.getSouth().isLocked() && backpack.contains((story.getSouth()).getKey()) ) || !story.getSouth().isLocked()){

                                    if(story.getSouth().isLocked() && backpack.contains((story.getSouth()).getKey())){
                                        story.getSouth().setLock(false);
                                        System.out.println("Youve unlocked a door/alter");
                                    }
                                    //moves south and prints the description of the room
                                    story = story.getSouth();
                                    story.getDescription();
                                }else{
                                    System.out.println("ITS LOCKED YOU WEIRDO");
                                }
                            }
                            break;
                        //repeats for west as well
                        case "west":
                            if(story.getWest()== null ){
                                System.out.println("You hit your head against a wall");
                            }else{
                                if( (story.getWest().isLocked() && backpack.contains((story.getWest()).getKey())) || !story.getWest().isLocked()){
                                    if(story.getWest().isLocked() && backpack.contains((story.getWest()).getKey())){
                                        story.getWest().setLock(false);
                                        System.out.println("Youve unlocked a door/alter");
                                    }
                                    //moves west and prints the description of the room
                                    story = story.getWest();
                                    story.getDescription();
                                }else{
                                    System.out.println("ITS LOCKED YOU WEIRDO");
                                }
                            }
                            break;

                        default:
                            break;
                    }
                    
                    break;

                case "examine":
                    //checks if they want ot examine room or an item in the inventory
                        if (choice.length > 2){
                            choice[1] = choice[1]+" "+choice[2];
                        }
                    switch (choice[1]) {
                        
                        case "room":   
                            //prints out what the user examined in the room
                            System.out.println(story.getExamine());;
                            break;
                    
                        default:
                            //if the item is in the backpack then it prints it out 
                            if(backpack.contains(choice[1])){
                                backpackObj.get(backpack.indexOf(choice[1])).getDescription();
                            }else{
                                System.out.println("The item isnt in your inventory, i think youre going crazy");
                            }
                            break;
                    }

                    break;
                case "inventory":
                case "backpack":
                //checks the backpack
                    if (backpack.size() <=0){
                        System.out.println("You have nothing in your bag");
                    }
                    for(int i = 0; i < backpack.size();i++){
                        System.out.println(backpack.get(i));
                    }
                    break;

                default:
                //gives you a hint on what you can do 

                    System.out.println("Here are your options:");
                    System.out.println("1) Move North");
                    System.out.println("2) Move East");
                    System.out.println("3) Move South");
                    System.out.println("4) Move West");
                    System.out.println("5) Examine (the current room or an item in the inventory)");
                    System.out.println("6) Take (item)");
                    System.out.println("7) Backpack");
                    break;
            }
            System.out.println();
        }while(!start.equals("") );
        System.out.println("Teehee");
        myObj.close();
    }
}
