# Mini Hospital Emergency Management System

A CIT300 individual assignment implementing a simplified hospital emergency
management system in Java, using four core data structures.

## Project Overview

The system simulates:
- Registering patients and storing their records
- Managing an emergency waiting queue
- Recording completed treatments
- Keeping each patient's past visit history

## Data Structures Used

| Requirement                | Data Structure         | File(s)                                  |
|-----------------------------|------------------------|-------------------------------------------|
| Patient Records             | Binary Search Tree     | `Patient.java`, `PatientBST.java`         |
| Emergency Patient Queue     | Queue (linked list)    | `EmergencyQueue.java`                     |
| Treatment History           | Stack (linked list)    | `TreatmentRecord.java`, `TreatmentHistoryStack.java` |
| Patient Visit History       | Singly Linked List     | `Visit.java`, `VisitHistory.java`         |
| Demo / entry point          | -                      | `Main.java`                               |

### Patient Records — Binary Search Tree
Each `Patient` is inserted into `PatientBST` keyed by `patientId`.
Supports `insert`, `search`, `delete` (all 3 delete cases: leaf, one child,
two children via in-order successor), and `inorderTraversal` to print
patients in ascending Patient ID order.

### Emergency Patient Queue — Queue
`EmergencyQueue` is a FIFO queue built from a singly linked structure with
`front`/`rear` pointers, giving O(1) `enqueue` and `dequeue`. Includes
`displayQueue` and safe handling of dequeuing from an empty queue.

### Treatment History — Stack
`TreatmentHistoryStack` is a LIFO stack built from a singly linked structure
with a `top` pointer. Supports `push`, `pop`, `displayStack`, and safe
handling of popping an empty stack.

### Patient Visit History — Singly Linked List
Each `Patient` owns one `VisitHistory` (a singly linked list of `Visit`
objects). Supports `addVisit`, `removeVisit`, `searchVisit`, and
`displayHistory`.

## Project Structure

```
HospitalEMS/
├── src/
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── EmergencyQueue.java
│   ├── TreatmentRecord.java
│   ├── TreatmentHistoryStack.java
│   ├── Visit.java
│   ├── VisitHistory.java
│   └── Main.java
├── README.md
├── git-commit-script.sh
└── video-narration-script.md
```

## How to Compile and Run

From the project root:

```bash
cd src
javac *.java
java Main
```

This runs `Main.java`, which exercises every operation for every data
structure (insert/search/delete/traversal for the BST, enqueue/dequeue/display
for the queue, push/pop/display for the stack, add/search/remove/display for
the linked list) and prints clearly labeled output for each step — useful for
both testing and the demonstration video.

## Author

Submitted as an individual assignment for CIT300 - Data Structures and
Algorithms.
