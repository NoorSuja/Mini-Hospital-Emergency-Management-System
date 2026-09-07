import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Demo driver for the Mini Hospital Emergency Management System.
 * Runs through every required operation for every data structure so this
 * single run can be used directly for the demonstration video:
 *   1) Patient Records      - Binary Search Tree
 *   2) Emergency Patient Queue - Queue
 *   3) Treatment History    - Stack
 *   4) Patient Visit History - Singly Linked List
 *   5) Empty-structure handling
 */
public class Main {

    public static void main(String[] args) {

        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentHistoryStack treatmentStack = new TreatmentHistoryStack();

        System.out.println("=================================================");
        System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM DEMO");
        System.out.println("=================================================\n");

        // ---------- 1. BST: Patient Records ----------
        System.out.println("---- 1. PATIENT RECORDS (BINARY SEARCH TREE) ----\n");

        Patient p1 = new Patient(105, "Nimal Perera", 45, "0771234567", "Chest Pain");
        Patient p2 = new Patient(102, "Kamala Silva", 30, "0772345678", "Fracture");
        Patient p3 = new Patient(110, "Ruwan Fernando", 60, "0773456789", "Breathing Difficulty");
        Patient p4 = new Patient(101, "Ishara Perera", 25, "0774567890", "Fever");
        Patient p5 = new Patient(107, "Dinesh Kumar", 50, "0775678901", "Allergic Reaction");

        patientBST.insert(p1);
        patientBST.insert(p2);
        patientBST.insert(p3);
        patientBST.insert(p4);
        patientBST.insert(p5);

        System.out.println("\nAll patients (in-order traversal by Patient ID):");
        patientBST.inorderTraversal();

        System.out.println("\nSearching for Patient ID 107:");
        Patient found = patientBST.search(107);
        System.out.println(found != null ? "   Found -> " + found : "   Patient not found.");

        System.out.println("\nDeleting Patient ID 102:");
        patientBST.delete(102);
        System.out.println("Patients after deletion:");
        patientBST.inorderTraversal();

        // ---------- 2. Queue: Emergency Patient Queue ----------
        System.out.println("\n---- 2. EMERGENCY PATIENT QUEUE ----\n");

        emergencyQueue.enqueue(p1);
        emergencyQueue.enqueue(p3);
        emergencyQueue.enqueue(p5);

        System.out.println("\nCurrent waiting queue:");
        emergencyQueue.displayQueue();

        System.out.println("\nDequeuing next patient for treatment:");
        Patient nextPatient = emergencyQueue.dequeue();
        System.out.println("   Now treating: " + nextPatient);

        System.out.println("\nQueue after dequeue:");
        emergencyQueue.displayQueue();

        // ---------- 3. Stack: Treatment History ----------
        System.out.println("\n---- 3. TREATMENT HISTORY (STACK) ----\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String completedAt = LocalDateTime.now().format(formatter);

        TreatmentRecord record1 = new TreatmentRecord(
                nextPatient.getPatientId(), nextPatient.getName(),
                "Administered pain relief and ECG", completedAt);
        treatmentStack.push(record1);

        Patient nextPatient2 = emergencyQueue.dequeue();
        TreatmentRecord record2 = new TreatmentRecord(
                nextPatient2.getPatientId(), nextPatient2.getName(),
                "Oxygen support provided", completedAt);
        treatmentStack.push(record2);

        System.out.println("\nAll completed treatment records (most recent first):");
        treatmentStack.displayStack();

        System.out.println("\nPopping most recent treatment record:");
        TreatmentRecord popped = treatmentStack.pop();
        System.out.println("   Removed -> " + popped);

        System.out.println("\nTreatment stack after pop:");
        treatmentStack.displayStack();

        // ---------- 4. Singly Linked List: Patient Visit History ----------
        System.out.println("\n---- 4. PATIENT VISIT HISTORY (SINGLY LINKED LIST) ----\n");

        Visit v1 = new Visit(1, "2026-01-10", "Dr. Silva", "Common Cold", "Prescribed medication");
        Visit v2 = new Visit(2, "2026-03-22", "Dr. Bandara", "Sprained Ankle", "Bandage and rest");
        Visit v3 = new Visit(3, "2026-06-15", "Dr. Silva", "Chest Pain", "ECG and monitoring");

        p1.getVisitHistory().addVisit(v1);
        p1.getVisitHistory().addVisit(v2);
        p1.getVisitHistory().addVisit(v3);

        System.out.println("Visit history for " + p1.getName() + ":");
        p1.getVisitHistory().displayHistory();

        System.out.println("\nSearching for Visit ID 2:");
        Visit foundVisit = p1.getVisitHistory().searchVisit(2);
        System.out.println(foundVisit != null ? "   Found -> " + foundVisit : "   Visit not found.");

        System.out.println("\nRemoving Visit ID 1:");
        p1.getVisitHistory().removeVisit(1);

        System.out.println("Visit history after removal:");
        p1.getVisitHistory().displayHistory();

        // ---------- 5. Empty structure handling ----------
        System.out.println("\n---- 5. EMPTY STRUCTURE HANDLING ----\n");

        EmergencyQueue emptyQueue = new EmergencyQueue();
        System.out.println("Dequeue from empty queue:");
        emptyQueue.dequeue();

        TreatmentHistoryStack emptyStack = new TreatmentHistoryStack();
        System.out.println("\nPop from empty stack:");
        emptyStack.pop();

        System.out.println("\n=================================================");
        System.out.println(" END OF DEMO");
        System.out.println("=================================================");
    }
}
