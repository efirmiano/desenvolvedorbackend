package br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.controller;

import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.dao.BeneficiarioDao;
import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.dao.DocumentoDao;
import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.repository.BeneficiarioRepository;
import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.repository.DocumentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/cadastrarbeneficiarios")
@Slf4j
@CrossOrigin("*")
public class BeneficiarioCadastroController {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestParam("nome") String nome,
            @RequestParam("telefone") String telefone,
            @RequestParam("dataNascimento") LocalDate dataNascimento,
            @RequestParam("tipoDocumento") String tipoDocumento,
            @RequestParam("descricao") String descricao
    ) {
        BeneficiarioDao beneficiario = new BeneficiarioDao();
        beneficiario.setNome(nome);
        beneficiario.setTelefone(telefone);
        beneficiario.setDataNascimento(dataNascimento);
        beneficiario.setDataAtualizacao(LocalDateTime.now(Clock.systemDefaultZone()));
        beneficiario.setDataInclusao(LocalDateTime.now(Clock.systemDefaultZone()));

        // Crie o documento e associe o beneficiário imediatamente
        DocumentoDao documentoDao = new DocumentoDao();
        documentoDao.setTipoDocumento(tipoDocumento);
        documentoDao.setDescricao(descricao);
        documentoDao.setDataInclusao(LocalDateTime.now());
        documentoDao.setDataAtualizacao(LocalDateTime.now());
        documentoDao.setBeneficiario(beneficiario);  // Associe o beneficiário ao documento

        // Salvar o beneficiário e o documento
        BeneficiarioDao savedBeneficiario = beneficiarioRepository.save(beneficiario);
        DocumentoDao savedDocumento = documentoRepository.save(documentoDao);  // Salvar o documento


        log.info("nome:{}", nome);
        log.info("telefone: {}", telefone);
        log.info("dataNascimento: {}", dataNascimento);
        log.info("Recebendo solicitação para salvar beneficiário: {}", beneficiario);

        return ResponseEntity.ok(savedBeneficiario);
    }

}
