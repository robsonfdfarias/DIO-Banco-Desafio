package br.com.infocomrobson;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@ToString
@Getter
@Table(name = "tb_endereco")
public class Endereco {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "numero", nullable = false)
    @Setter private String numero; //pq pode ser s/n
    @Column(name = "rua", nullable = false)
    @Setter private String rua;
    @Column(name = "bairro", nullable = false)
    @Setter private String bairro;
    @Column(name = "cidade", nullable = false)
    @Setter private String cidade;
    @Column(name = "estado", nullable = false)
    @Setter private String estado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    @Setter private Cliente cliente;
}
