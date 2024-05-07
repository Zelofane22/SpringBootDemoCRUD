package sn.ecpi.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter
@Table(name = "_machine")
public class Machine {
    @Id @GeneratedValue
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
    private String os;
    private String level;
    private String plateforme;
    private String description;

    public Machine() {
    }

    public Machine(UUID id, String name, String os, String level, String plateforme, String description) {
        this.id = id;
        this.name = name;
        this.os = os;
        this.level = level;
        this.plateforme = plateforme;
        this.description = description;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setPlateforme(String plateforme) {
        this.plateforme = plateforme;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
