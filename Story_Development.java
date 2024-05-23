import java.util.Scanner;

public class Story_Development {
    public class Items{
        private String name;
        private String description;
        private boolean take = false;
        private boolean used = false;
        
        public Items(String name,String description,boolean take){
            this.name = name;
            this.description = description;
            this.take = take;
            this.used = false;
        }
        public void setUsed(boolean used){
            this.used = true;
        }
    }

    public class Rooms{
        Rooms north;
        Rooms east;
        Rooms south;
        Rooms west;
        String description = "";
        Items[] items;
    }
    
    static Rooms createStory(){
        Rooms story = new Rooms();
        story.items = new Items[2];
        story.description = "In front of you is a bookshelf filled with books and random potions. \nYou see a locked door to the East. \nYou see a alter with a sock engraving on it.";
        return story;
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Rooms story = createStory();
        Items backpack = new Items();

        System.out.println("Type something to start");
        String start = myObj.nextLine();
        System.out.println("You've woken up in cave like lair. As you look around, you see a board with a name 'Harry Potter'. It seems youre trapped in a mad wizards lair");
        do{
            System.out.println(story.description);
            System.out.println("Here are your options:");
            if(story.north!= null){
                System.out.println("1) Go North");
            }
            if(story.east!= null){
                System.out.println("2) Go East");
            }
            if(story.south!= null){
                System.out.println("3) Go South");
            }
            if(story.west!= null){
                System.out.println("4) Go West");
            }

            


        }while(start);
    }
}
