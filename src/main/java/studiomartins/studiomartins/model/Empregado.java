package studiomartins.studiomartins.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "empregados")
@AllArgsConstructor @NoArgsConstructor
@Data
public class Empregado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @NotNull
    @Column(name = "perfil")
    private String perfil;
    @NotNull
    @Column(name = "nome")
    private String nome;
    @NotNull
    @Column(name = "sobrenome")
    private String sobrenome;
    @NotNull
    @Column(name = "email")
    private String email;
    @NotNull
    @Column(name = "telefone")
    private String telefone;
    @NotNull
    @Column(name = "registro")
    private String registro;
    @NotNull
    @Column(name = "cpf")
    private String cpf;
    @NotNull
    @Column(name = "endereco")
    private String endereco;
    @NotNull
    @Column(name = "cidade")
    private String cidade;
    @NotNull
    @Column(name = "estado")
    private String estado;
    @NotNull
    @Column(name = "cep")
    private String cep;
}
