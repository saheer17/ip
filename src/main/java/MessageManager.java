public class MessageManager {
    private Message[] messages;
    private int count;

    public MessageManager(int capacity) {
        messages = new Message[capacity];
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void addMessage(String content) {
        messages[count] = new Message(content);
        count++;
    }

    public void listMessages() {
        if (count == 0) {
            System.out.println("There are no messages in the system");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println((i+1) + "." + messages[i].getContent());
            }
        }
    }
}
