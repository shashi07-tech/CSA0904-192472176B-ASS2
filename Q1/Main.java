public class TicketBenchmark {
    static String buildTicket(int fields, int type) {
        String result = "";
        StringBuilder sb = new StringBuilder();
        StringBuffer buffer = new StringBuffer();
 
        for (int i = 1; i <= fields; i++) {
            String value = "Field" + i + ":Value" + i + " ";
            if (type == 1) {
                result += value;
            } else if (type == 2) {
                sb.append(value);
            } else {
                buffer.append(value);
            }
        }

        if (type == 1)
            return result;
        if (type == 2)
            return sb.toString();
        return buffer.toString();
    }

    static long execute(int tickets, int fields, int type) {
        long checksum = 0;
        for (int i = 0; i < tickets; i++) {
            String ticket = buildTicket(fields, type);
            checksum += ticket.length();
        }
        return checksum;
    }

    static void test(int tickets, int fields) {
        String[] methods = {
            "String",
            "StringBuilder",
            "StringBuffer"
        };

        System.out.println(
            "\nTickets: " + tickets + ", Fields: " + fields
        );

        for (int type = 1; type <= 3; type++) {
            execute(200, fields, type); // Warm-up
            long total = 0;
            long checksum = 0;

            for (int r = 0; r < 5; r++) {
                long start = System.nanoTime();
                checksum = execute(tickets, fields, type);
                long end = System.nanoTime();
                total += end - start;
            }

            double average = total / 5.0 / 1_000_000;
            System.out.printf(
                "%s: %.3f ms | Checksum: %d%n",
                methods[type - 1],
                average,
                checksum
            );
        }
    }

    public static void main(String[] args) {
        test(1, 6);
        test(10000, 50);
        test(1000, 100);
    }
}
