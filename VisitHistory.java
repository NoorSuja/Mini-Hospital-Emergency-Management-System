/**
 * Singly linked list holding one patient's past visits, oldest to newest.
 * Each Patient object owns exactly one VisitHistory.
 */
public class VisitHistory {

    // Internal node holding one visit and a link to the next visit.
    private static class VisitNode {
        Visit visit;    // the visit data
        VisitNode next; // the next (later) visit in the list

        VisitNode(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private VisitNode head; // first (oldest) visit in the list

    public VisitHistory() {
        head = null;
    }

    // visit -> the new visit to append to the end of the history
    public void addVisit(Visit visit) {
        VisitNode newNode = new VisitNode(visit);
        if (head == null) {
            head = newNode;
            return;
        }
        VisitNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // visitId -> the ID of the visit to remove from the history
    public boolean removeVisit(int visitId) {
        if (head == null) {
            return false;
        }
        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            return true;
        }
        VisitNode current = head;
        while (current.next != null) {
            if (current.next.visit.getVisitId() == visitId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // visitId -> the ID of the visit to look for
    public Visit searchVisit(int visitId) {
        VisitNode current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null;
    }

    public void displayHistory() {
        if (head == null) {
            System.out.println("   No visit history available.");
            return;
        }
        VisitNode current = head;
        while (current != null) {
            System.out.println("   " + current.visit);
            current = current.next;
        }
    }
}
