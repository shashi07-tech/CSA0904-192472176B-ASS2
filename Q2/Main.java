import java.util.*;
public class PlaylistBenchmark {
static void test(int n) {
List<Integer> array = new ArrayList<>(); List<Integer> linked = new LinkedList<>();
long start, end;
// Adding elements at the end start = System.nanoTime();
for (int i = 0; i < n; i++) array.add(i);
end = System.nanoTime(); long arrayAdd = end - start;
start = System.nanoTime();
for (int i = 0; i < n; i++)
linked.add(i);
end = System.nanoTime(); long linkedAdd = end - start;
// Insertion at front
start = System.nanoTime();
for (int i = 0; i < 100; i++) array.add(0, i);
end = System.nanoTime(); long arrayInsert = end - start;
start = System.nanoTime();
for (int i = 0; i < 100; i++) linked.add(0, i);
end = System.nanoTime(); long linkedInsert = end - start;
// Accessing middle element start = System.nanoTime();
int a = array.get(n / 2);
end = System.nanoTime(); long arrayAccess = end - start;
start = System.nanoTime();
int b = linked.get(n / 2);
end = System.nanoTime();
long linkedAccess = end - start;
// Iteration
start = System.nanoTime();
for (int x : array) {
}
end = System.nanoTime(); long arrayIterate = end - start;
start = System.nanoTime();
for (int x : linked) {
}
end = System.nanoTime(); long linkedIterate = end - start;
System.out.println("\nPlaylist size: " + n);
System.out.println(
"Operation	ArrayList(ns) LinkedList(ns)"
);
System.out.println(
"Add end	" + arrayAdd + "	" + linkedAdd
);
System.out.println(
"Insert front	" + arrayInsert + "	" + linkedInsert
);
System.out.println(
"Access middle " + arrayAccess + "	" + linkedAccess
);
System.out.println(
"Iteration	" + arrayIterate + "	" + linkedIterate
);
}
public static void main(String[] args) {
test(1000); test(10000); test(100000);
}
}
 
