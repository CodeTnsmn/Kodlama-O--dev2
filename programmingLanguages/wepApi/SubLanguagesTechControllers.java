package kodlama.io.programmingLanguages.wepApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programmingLanguages.business.abstracts.SubLanguageTechService;
import kodlama.io.programmingLanguages.business.requests.subLanguageTech.CreateSubLanguageTechRequest;
import kodlama.io.programmingLanguages.business.requests.subLanguageTech.DeleteSubLanguageTechRequest;
import kodlama.io.programmingLanguages.business.requests.subLanguageTech.UpdateSubLanguageTechRequest;
import kodlama.io.programmingLanguages.business.responses.subLanguageTech.GetAllLanguageTechsResponse;
import kodlama.io.programmingLanguages.business.responses.subLanguageTech.GetLanguageTechByIdResponse;



@RequestMapping("/api/subLanguages")
@RestController
public class SubLanguagesTechControllers {

	  private SubLanguageTechService subLanguageTechService;
	
	  @Autowired
	    public SubLanguagesTechControllers(SubLanguageTechService languageTechService) {
	        this.subLanguageTechService = languageTechService;
	    }

	    @PostMapping("/add-subLanguage")
	    public void add(CreateSubLanguageTechRequest createLanguageTechRequest){
	        this.subLanguageTechService.add(createLanguageTechRequest);
	    }

	    @GetMapping("/get-subLanguageTech")
	    public List<GetAllLanguageTechsResponse> getAll(){
	       return this.subLanguageTechService.getAll();
	    }

	    @DeleteMapping("/delete-subLanguageTech")
	    public void delete(DeleteSubLanguageTechRequest deleteLanguageTechRequest){
	        this.subLanguageTechService.delete(deleteLanguageTechRequest);
	    }

	    @GetMapping("/get-tech/{id}")
	    public GetLanguageTechByIdResponse getId(int id){
	        return this.subLanguageTechService.getId(id);
	    }

	    @PutMapping("/update-tech")
	    public void update(UpdateSubLanguageTechRequest subUpdateLanguageTechRequest){
	        this.subLanguageTechService.update(subUpdateLanguageTechRequest);
	    }
	  
	  
}
