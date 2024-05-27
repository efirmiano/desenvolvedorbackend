package br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.controller;

import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.dao.DocumentoDao;
import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.repository.DocumentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/cadastrardocumentos")
@Slf4j
@CrossOrigin("*")
public class DocumentoCadastroController {

    @Autowired
    private DocumentoRepository documentoRepository;

    @PostMapping
    public ResponseEntity save(

            @RequestParam("tipoDocumento") String tipoDocumento,
            @RequestParam("descricao") String descricao

            ){
        DocumentoDao documentoDao = new DocumentoDao();
        documentoDao.setTipoDocumento(tipoDocumento);
        documentoDao.setDescricao(descricao);
        documentoDao.setDataInclusao(LocalDateTime.now(Clock.systemDefaultZone()));
        documentoDao.setDataAtualizacao(LocalDateTime.now(Clock.systemDefaultZone()));

        DocumentoDao saveDocumentoDao = documentoRepository.save(documentoDao);

        log.info("tipoDocumento: {}", tipoDocumento);
        log.info("descricao: {}", descricao);

        return ResponseEntity.ok(saveDocumentoDao);
    }
}
