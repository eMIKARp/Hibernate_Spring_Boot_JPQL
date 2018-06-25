package pl.myapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name= "Product.findByName", query="SELECT p FROM Product p WHERE p.name=:name"),
    @NamedQuery(name= "Product.deleteByProducer", query="DELETE FROM Product p WHERE p.producer=:producer"),
    @NamedQuery(name = "Product.deleteAll", query = "DELETE FROM Product p")
})
public class Product implements Serializable{
	
	private static final long serialVersionUID = -8903956080357392266L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String producer;
	private Double price;
	
	public Product() {
		
	}

	public Product(String name, String producer, Double price) {
		super();
		this.name = name;
		this.producer = producer;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getProducer() {
		return producer;
	}

	public Double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", producer=" + producer + ", price=" + price + "]";
	}
	
}
