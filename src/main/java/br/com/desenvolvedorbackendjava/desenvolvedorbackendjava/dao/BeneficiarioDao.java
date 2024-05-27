
package br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.dao;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "BENEFICIARIOS")
public class BeneficiarioDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TELEFONE")
    private String telefone; // Alterado para String

    @Column(name = "DATANASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "DATAINCLUSAO")
    private LocalDateTime dataInclusao;

    @Column(name = "DATAATUALIZACAO")
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "beneficiario")
    private List<DocumentoDao> documentos;  // Lista de documentos associados

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDateTime dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }


}
