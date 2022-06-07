package woowacourse.shoppingcart.domain;

public class Product {

    private Long id;
    private String name;
    private Integer price;
    private String imageUrl;
    private Integer quantity;

    public Product() {
    }

    public Product(final String name, final int price, final String imageUrl, final int quantity) {
        this(null, name, price, imageUrl, quantity);
    }

    public Product(Long id, String name, Integer price, String imageUrl, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
