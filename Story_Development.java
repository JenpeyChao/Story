import java.util.Scanner;

public class Story_Development {
    class Rooms{
        rooms north = null;
        rooms east =null;
        rooms south = null;
        rooms west = null;
        string description = "";
        Item item = null;
    }
    class Items{
        String name;
    }
    static rooms createStory(){
        rooms story = new Rooms();
        story.description = "You've woken up in ";
        return story;
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        rooms story = createStory();
        Items backpack = new Items();

        System.out.println("Type something to start");
        String start = myObj.nextLine();
        do{
            System.out.println(story.description);

        }while(start);
    }
}
