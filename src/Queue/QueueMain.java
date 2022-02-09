package Queue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue();
        queue.insert(3);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);

        queue.display();

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.display();

        System.out.println();
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.insert(3);
        circularQueue.insert(6);
        circularQueue.insert(5);
        circularQueue.insert(19);
        circularQueue.insert(1);

        circularQueue.display();

        System.out.println(circularQueue.remove());
        circularQueue.insert(133);
        circularQueue.display();

        System.out.println(circularQueue.remove());
        circularQueue.insert(99);
        circularQueue.display();

        System.out.println();
        CircularQueue dynamicQueue = new DynamicQueue(3);
        dynamicQueue.insert(3);
        dynamicQueue.insert(6);
        dynamicQueue.insert(5);
        dynamicQueue.insert(19);
        dynamicQueue.insert(1);

        dynamicQueue.display();

        System.out.println(dynamicQueue.remove());
        dynamicQueue.insert(133);
        dynamicQueue.display();
    }
}
