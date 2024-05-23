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
    }

    public static class Rooms{
        private Rooms north;
        private Rooms east;
        private Rooms south;
        private Rooms west;
        private String description = "";
        private Items[] items;
        private String examine;

        public Rooms(String description, String examine, Items[] items){
            this.north = null;
            this.east = null;
            this.south = null;
            this.west = null;
            this.description = description;
            this.items = items;
            this.examine = examine;
        }
    }
    
    static Rooms createStory(){
        String description = "In front of you is a bookshelf filled with books and random potions. \nYou see a locked door to the East. \nYou see an alter with a sock engraving on it.";
        String examine = "You look closely at the bookshelf. You see a lot of different books and potions. \n You avoid the potions since they seem harmful.\nHowever you see a key poking out of a book";
        Items[] items = new Items[1];
        items[0] = new Items("key","A shiny key to an unknown door or chest",true);
        Rooms story = new Rooms(description,examine, items);

        
        return story;
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Rooms story = createStory();
        // Items backpack = new Items();

        System.out.println("Type something to start");
        String start = myObj.nextLine();
        System.out.println("You've woken up in cave like lair. As you look around, you see a board with a name 'Harry Potter'. It seems youre trapped in a mad wizards lair");
        do{
            System.out.println(story.description);
            System.out.println("Here are your options:");
            System.out.println("1) Go North");
            System.out.println("2) Go East");
            System.out.println("3) Go South");
            System.out.println("4) Go West");
            System.out.println("5) Examine the current room");
            System.out.println("6) Take an item");


        }while(!start.equals("") || );
    }
}
