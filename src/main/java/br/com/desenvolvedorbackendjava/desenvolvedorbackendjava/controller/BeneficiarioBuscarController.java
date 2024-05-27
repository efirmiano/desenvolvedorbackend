package br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.controller;

import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.dao.BeneficiarioDao;
import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buscarbeneficiarios")
public class BeneficiarioBuscarController {
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;
    @GetMapping
    public ResponseEntity buscar(){

        List <BeneficiarioDao> beneficiarios = beneficiarioRepository.findAll();

        beneficiarios.forEach(System.out::println);

        return ResponseEntity.ok(beneficiarios);
    }
}
