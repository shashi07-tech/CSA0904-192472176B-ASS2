import java.util.*; 
class Patient {     String name; 
    int severity; 
    long arrival; 
    Patient(String name, int severity, long arrival) { 
        this.name = name; 
        this.severity = severity; 
        this.arrival = arrival; 
    } 
    public String toString() { 
        return name + "(S" + severity + ")"; 
    } 
} 
public class Main {     PriorityQueue<Patient> queue; 
    long clock = 0; 
    final int AGING_INTERVAL = 2;     Main() { 
        queue = new PriorityQueue<>(             Comparator.comparingInt( 
                (Patient p) -> effectivePriority(p) 
            ).thenComparingLong(p -> p.arrival) 
        ); 
    } 
    int effectivePriority(Patient p) { 
        long waited = clock - p.arrival; 
        int improvement = (int)(waited / AGING_INTERVAL); 
        return Math.max(1, p.severity - improvement); 
    } 
    void admit(String name, int severity) { 
        queue.add(new Patient(name, severity, ++clock)); 
    } 
    Patient next() { 
        clock++; 
        List<Patient> patients = new ArrayList<>(queue); 
        queue.clear(); 
        queue.addAll(patients); 
        return queue.poll(); 
    } 
    public static void main(String[] args) {         Main er = new Main(); 
        er.admit("Arun", 5); 
        er.admit("Ravi", 1); 
        er.admit("Divya", 1); 
        er.admit("Kumar", 1); 
        er.admit("Priya", 2); 
        System.out.println("Treatment Order:");         Patient p; 
        while ((p = er.next()) != null) {             System.out.println( 
                p + " Effective Priority: " 
                + er.effectivePriority(p) 
            ); 
        } 
    } 
} 
