package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import mk.finki.ukim.mk.lab.bootsrap.DataHolder;

@Data
public class Production {
    private Long id;
    private String name;
    private String country;
    private String address;

    public Production(String name, String country, String address) {
        this.id = DataHolder.ProdIdCount;
        this.name = name;
        this.country = country;
        this.address = address;
        DataHolder.ProdIdCount+=1;
    }
}
