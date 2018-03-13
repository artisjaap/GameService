package be.qnh.gameservice.gameservice.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }
}
