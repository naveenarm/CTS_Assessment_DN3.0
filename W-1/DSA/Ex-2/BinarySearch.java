public class BinarySearch {
    public static Product search(Product[] products, String target) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].getProductName().equals(target)) {
                return products[mid];
            } else if (products[mid].getProductName().compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}