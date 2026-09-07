/**
 * LIFO stack of completed treatment records.
 * The most recently completed treatment is always on top.
 */
public class TreatmentHistoryStack {

    // Internal node holding one treatment record and a link to the one below it.
    private static class StackNode {
        TreatmentRecord record; // the completed treatment
        StackNode next;         // the record pushed before this one

        StackNode(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    private StackNode top; // most recently pushed record
    private int size;

    public TreatmentHistoryStack() {
        top = null;
        size = 0;
    }

    // record -> the newly completed treatment to store
    public void push(TreatmentRecord record) {
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Pushed treatment record for: " + record.getPatientName());
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty. Nothing to pop.");
            return null;
        }
        TreatmentRecord record = top.record;
        top = top.next;
        size--;
        return record;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("   No treatment records available.");
            return;
        }
        StackNode current = top;
        while (current != null) {
            System.out.println("   " + current.record);
            current = current.next;
        }
    }
}
