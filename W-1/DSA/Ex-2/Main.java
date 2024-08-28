public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[] {
            new Product(1, "Product A", "Category A"),
            new Product(2, "Product B", "Category B"),
            new Product(3, "Product C", "Category C"),
            new Product(4, "Product D", "Category D"),
            new Product(5, "Product E", "Category E")
        };

        java.util.Arrays.sort(products, (a, b) -> a.getProductName().compareTo(b.getProductName()));

        // Perform linear search
        String target = "Product C";
        Product resultLinear = LinearSearch.search(products, target);
        if (resultLinear != null) {
            System.out.println("Linear Search: Found product " + resultLinear.getProductName());
        } else {
            System.out.println("Linear Search: Product not found");
        }

        // Perform binary search
        Product resultBinary = BinarySearch.search(products, target);
        if (resultBinary != null) {
            System.out.println("Binary Search: Found product " + resultBinary.getProductName());
        } else {
            System.out.println("Binary Search: Product not found");
        }
    }
}