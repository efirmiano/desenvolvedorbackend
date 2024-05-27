package br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.controller;

import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deletebeneficiarios")
public class BeneficiarioDeleteController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    // Endpoint para deletar um beneficiário pelo ID
    @DeleteMapping()
    public ResponseEntity<?> deletarBeneficiario(@RequestParam("id") Long id) {
        try {
            beneficiarioService.deletarBeneficiario(id);
            return ResponseEntity.ok().build();  // Retorna HTTP 200 se bem-sucedido
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();  // Retorna HTTP 404 se não encontrar o beneficiário
        }
    }
}
