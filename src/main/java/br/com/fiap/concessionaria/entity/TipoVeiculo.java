package br.com.fiap.concessionaria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_TIPO_VEICULO", uniqueConstraints = {
/**
 * UK para garantir que não se tenha mais de um tipo com o mesmo nome.
 */
        @UniqueConstraint(name = "UK_TIPO_NOME", columnNames = {"NOME"})
})
public class TipoVeiculo {

    @Id // Indica que essa propriedade é a chave primária da entidade
    @Column(name = "ID_TIPO_VEICULO")
    private Long id;

    @Column(name = "NOME")
    private String nome;
}
