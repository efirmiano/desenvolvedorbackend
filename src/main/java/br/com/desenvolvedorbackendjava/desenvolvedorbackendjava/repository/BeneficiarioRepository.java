package br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.repository;

import br.com.desenvolvedorbackendjava.desenvolvedorbackendjava.dao.BeneficiarioDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRepository extends JpaRepository <BeneficiarioDao, Long>{
}
