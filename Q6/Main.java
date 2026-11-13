import java.util.*; 

class Patient { 
    String name; 
    int priority; 
    int arrival; 
    Patient(String name, int priority, int arrival) { 
        this.name = name; 
        this.priority = priority; 
        this.arrival = arrival; 
    } 
    public String toString() { 
        return name + "(S" + priority + ")"; 
    } 
} 
public class Main { 
    public static void main(String[] args) {         PriorityQueue<Patient> queue = 
            new PriorityQueue<>( 
                Comparator.comparingInt((Patient p) -> p.priority) 
                .thenComparingLong(p -> p.arrival) 
            ); 
        queue.add(new Patient("Ravi", 3, 1)); 
        queue.add(new Patient("Meena", 1, 2)); 
        queue.add(new Patient("John", 3, 3)); 
        queue.add(new Patient("Asha", 5, 4)); 
        queue.add(new Patient("Kumar", 1, 5)); 
        queue.add(new Patient("Lata", 2, 6)); 
        while (!queue.isEmpty()) { 
            System.out.print(queue.poll() + " "); 
        } 
    } 
} 
