package br.com.infocomrobson;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "tb_contNum")
public class ControleNumeracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipoConta")
    @Setter private String tipoConta;

    public Integer numeracao(String tipo){
        this.tipoConta = tipo;
        return getId();
    }

    public String tipoPoup(){
        return "Poupança";
    }

    public String tipoCorr(){
        return "Corrente";
    }
}
