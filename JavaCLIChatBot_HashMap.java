import java.util.*;

public class JavaCLIChatBot_HashMap {
    static Map<String,List<Message>> byRole = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("CHATBOT IS READY!PRINT 'EXIT' TO QUIT");

        while (true){
            System.out.print("You:");
            String input = scan.nextLine();
            if(input.equals("exit")) break;

            addMessage("user",input);

            String reply = "echo" + input;

            addMessage("assistant",reply);

            System.out.println("Bot" + reply);
        }

        System.out.println("----Historu----");

        for (String role : byRole.keySet()){
            for (Message m : byRole.get(role)){
                System.out.println(m.role + " : " + m.content);
            }
        }
    }

    static void addMessage(String role,String content){
        List<Message> list = byRole.get(role);
        if(list == null){
            list = new ArrayList<>();
            byRole.put(role,list);
        }

        list.add(new Message(role,content));
    }
}


class Message{
    String role;
    String content;

    Message(String role,String content){
        this.role = role;
        this.content = content;
    }
}
