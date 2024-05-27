package br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.repository;

import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.dao.BeneficiarioDao;
import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.dao.DocumentoDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoDao, Long> {

    List<DocumentoDao> findBytipoDocumento(String tipoDocumento);
    // Buscar documentos pelo ID do beneficiário
    List<DocumentoDao> findByBeneficiario_Id(Long beneficiarioId);

    void deleteByBeneficiario(BeneficiarioDao beneficiario);
}
