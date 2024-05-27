package br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.service;
import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.dao.BeneficiarioDao;
import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.repository.BeneficiarioRepository;
import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Transactional
    public void deletarBeneficiario(Long beneficiarioId) {
        BeneficiarioDao beneficiario = beneficiarioRepository.findById(beneficiarioId)
                .orElseThrow(() -> new RuntimeException("Beneficiário não encontrado com o ID: " + beneficiarioId));

        // Primeiro deletar documentos associados
        documentoRepository.deleteByBeneficiario(beneficiario);

        // Depois deletar o beneficiário
        beneficiarioRepository.delete(beneficiario);
    }
}
