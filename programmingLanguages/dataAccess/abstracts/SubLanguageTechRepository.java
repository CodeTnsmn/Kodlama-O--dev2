package kodlama.io.programmingLanguages.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.programmingLanguages.entities.concretes.SubLanguageTechnology;

public interface SubLanguageTechRepository extends JpaRepository<SubLanguageTechnology,Integer> {

}
