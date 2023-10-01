package com.sigasohqbom.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@DiscriminatorValue("professor")
@Data
public class Professor extends Usuario {
    private String especializacao;
}
