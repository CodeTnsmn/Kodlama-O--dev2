package kodlama.io.programmingLanguages.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.programmingLanguages.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
	
	

}
