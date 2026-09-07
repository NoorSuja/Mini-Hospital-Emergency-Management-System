/**
 * FIFO queue of patients waiting in the emergency unit.
 * Implemented as a singly linked structure with front/rear pointers
 * so enqueue and dequeue are both O(1).
 */
public class EmergencyQueue {

    // Internal node holding one waiting patient and a link to the next one in line.
    private static class QueueNode {
        Patient patient; // the waiting patient
        QueueNode next;  // next patient behind this one

        QueueNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QueueNode front; // next patient to be treated
    private QueueNode rear;  // last patient in line
    private int size;

    public EmergencyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // patient -> the new patient arriving at the emergency unit
    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Enqueued: " + patient.getName() + " (ID: " + patient.getPatientId() + ")");
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No patient to dequeue.");
            return null;
        }
        Patient patient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null; // queue just became empty
        }
        size--;
        return patient;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("   Emergency queue is empty.");
            return;
        }
        QueueNode current = front;
        int position = 1;
        while (current != null) {
            System.out.println("   " + position + ". " + current.patient);
            current = current.next;
            position++;
        }
    }
}
