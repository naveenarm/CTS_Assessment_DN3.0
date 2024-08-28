public class LinearSearch {
    public static Product search(Product[] products, String target) {
        for (Product product : products) {
            if (product.getProductName().equals(target)) {
                return product;
            }
        }
        return null;
    }
}