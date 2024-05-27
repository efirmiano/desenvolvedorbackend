package br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "DOCUMENTOS")
public class DocumentoDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TIPODOCUMENTO", length = 10)
    private String tipoDocumento;

    @Column(name = "DESCRICAO", unique = true, length = 20)
    private String descricao;

    @Column(name = "DATAINCLUSAO", length = 11)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataInclusao;

    @Column(name = "DATAATUALIZACAO", length = 11 )
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataAtualizacao;

    public BeneficiarioDao getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(BeneficiarioDao beneficiario) {
        this.beneficiario = beneficiario;
    }

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")  // Chave estrangeira para BeneficiarioDao
    private BeneficiarioDao beneficiario;

    public Long getId() {
        return id;
    }

     public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return "DocumentoDao{" +
                "id=" + id +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInclusao=" + dataInclusao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
