package br.com.fiap.concessionaria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_VEICULO")
public class Veiculo {
    @Id
    @SequenceGenerator(name = "SQ_VEICULO", sequenceName = "SQ_VEICULO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VEICULO")
    @Column(name = "ID_VEICULO")
    private Long id;
    @Column(name = "NM_VEICULO")
    private String nome;
    @Column(name = "ANO")
    private Year anoDeFabricacao;
    @Column(name = "COR")
    private String cor;
    @Column(name = "PRECO")
    private Double preco;
    @Column(name = "CILINDRADAS")
    private Short cilindradas;
    @Column(name = "MODELO")
    private String modelo;
    //15 digitos
    @Size(max = 15)
    @Column(name = "PALAVRA_EFEITO")
    private String palavraDeEfeito;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "FABRICANTE",
            referencedColumnName = "ID_FABRICANTE",
            foreignKey = @ForeignKey(
                    name = "FK_FABRICANTE_VEICULO"
            )
    )
    private Fabricante fabricante;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "TIPO",
            referencedColumnName = "ID_TIPO_VEICULO",
            foreignKey = @ForeignKey(
                    name = "FK_TIPO_VEICULO"
            )
    )
    private TipoVeiculo tipo;
    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "ACESSORIO",
            joinColumns = @JoinColumn(name = "ID_ACESSORIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_VEICULO"),
            foreignKey = @ForeignKey(name = "FK_ACESSORIO_VEICULO"),
            inverseForeignKey = @ForeignKey(name = "FK_VEICULO_ACESSORIO"
            ))
    private Set<Acessorio> acessorios = new LinkedHashSet<>();
}


