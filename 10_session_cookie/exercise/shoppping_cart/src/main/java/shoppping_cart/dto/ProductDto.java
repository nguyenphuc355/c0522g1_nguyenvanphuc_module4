package shoppping_cart.dto;

import javax.persistence.Column;
import java.util.Objects;

public class ProductDto {
    private int id;
    private String name;
    private String image;
    private String describe;
    private long price;

    public ProductDto() {
    }

    public ProductDto(int id, String name, String image, String describe, long price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.describe = describe;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return describe;
    }

    public void setDescription(String describe) {
        this.describe = describe;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id && price == that.price && Objects.equals(name, that.name) && Objects.equals(image, that.image) && Objects.equals(describe, that.describe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, describe, price);
    }
}
