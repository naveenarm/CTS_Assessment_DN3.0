import java.util.Arrays;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Order[] orders = new Order[5];
        orders[0] = new Order(1, "John", 100.0);
        orders[1] = new Order(2, "Alice", 50.0);
        orders[2] = new Order(3, "Bob", 200.0);
        orders[3] = new Order(4, "Eve", 150.0);
        orders[4] = new Order(5, "Charlie", 75.0);

        System.out.println("Original Orders:");
        printOrders(orders);

        bubbleSort(orders);
        System.out.println("Orders sorted by Bubble Sort:");
        printOrders(orders);

        orders[0] = new Order(1, "John", 100.0);
        orders[1] = new Order(2, "Alice", 50.0);
        orders[2] = new Order(3, "Bob", 200.0);
        orders[3] = new Order(4, "Eve", 150.0);
        orders[4] = new Order(5, "Charlie", 75.0);

        quickSort(orders, 0, orders.length - 1);
        System.out.println("Orders sorted by Quick Sort:");
        printOrders(orders);
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice < orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice > pivot.totalPrice) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }
}