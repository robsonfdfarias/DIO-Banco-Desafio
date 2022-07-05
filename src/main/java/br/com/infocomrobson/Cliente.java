package br.com.infocomrobson;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@ToString
@Getter
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome", nullable = false)
    @Setter private String nome;
    @Column(name = "profissao")
    @Setter private String profissao;
    @Column(name = "nascimento")
    @Setter private String nascimento;

    @OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Setter private ContaCorrente contaCorrente;

    @OneToOne(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Setter private ContaPoupanca contaPoupanca;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Setter private List<Endereco> enderecos;

}
