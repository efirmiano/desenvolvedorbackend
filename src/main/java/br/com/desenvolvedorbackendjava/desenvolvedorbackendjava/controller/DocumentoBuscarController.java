package br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.controller;

import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.dao.DocumentoDao;
import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buscardocumento")
public class DocumentoBuscarController {

    @Autowired
    private DocumentoRepository documentoRepository;
    @GetMapping
    public ResponseEntity buscarDocumento(

            @RequestParam("beneficiario_id") long beneficiario_id
    ){

        List<DocumentoDao> doc = documentoRepository.findByBeneficiario_Id(beneficiario_id);

        return ResponseEntity.ok(doc);

    }
}
