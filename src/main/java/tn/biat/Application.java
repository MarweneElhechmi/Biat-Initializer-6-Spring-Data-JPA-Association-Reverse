package tn.biat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tn.biat.entities.Compte;
import tn.biat.entities.Operation;
import tn.biat.repository.ICompteRepository;
import tn.biat.repository.IOperationRepository;

@SpringBootApplication
public class Application {
	
	@Autowired
	private ICompteRepository repoCompte;
	@Autowired
	private IOperationRepository repoOperation;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	
	@Bean
	CommandLineRunner myRunner() {
		return args -> {
		
			Compte C1 = new Compte("C1000","Marwene",new BigDecimal("100"),null);
			Compte C2 = new Compte("C2000","Ghada",new BigDecimal("200"),null);
			Compte C3 = new Compte("C3000","Sami",new BigDecimal("300"),null);
			Compte C4 = new Compte("C4000","Chedly",new BigDecimal("400"),null);
			
			Operation op1 = new Operation();
			op1.setDateOperation(new Date());
			op1.setMontantOpertaion(BigDecimal.TEN);
			op1.setSens("CREDIT");
			op1.setCompte(C1);
			
			Operation op2 = new Operation();
			op2.setDateOperation(new Date());
			op2.setMontantOpertaion(BigDecimal.TEN);
			op2.setSens("DEBIT");
			op2.setCompte(C1);
			
			Operation op3 = new Operation();
			op3.setDateOperation(new Date());
			op3.setMontantOpertaion(new BigDecimal("1000"));
			op3.setSens("CREDIT");
			op3.setCompte(C3);
			
			Operation op4 = new Operation();
			op4.setDateOperation(new Date());
			op4.setMontantOpertaion(new BigDecimal("500"));
			op4.setSens("DEBIT");
			op4.setCompte(C3);
			
			Collection<Operation> opC1 = Arrays.asList(op1,op2);
			C1.setOperations(opC1);
			
			Collection<Operation> opC3 = Arrays.asList(op3,op4);
			C1.setOperations(opC3);
			
			repoCompte.save(C1);
			repoCompte.save(C2);
			repoCompte.save(C3);
			repoCompte.save(C4);
			repoOperation.saveAll(opC1);
			repoOperation.saveAll(opC3);

			System.out.println("***** FIN DE L'INITIALISATION DES DONNEES *****");
			
		};
	}

	
	
}
