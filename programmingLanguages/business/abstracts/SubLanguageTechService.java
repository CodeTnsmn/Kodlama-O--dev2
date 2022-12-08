package kodlama.io.programmingLanguages.business.abstracts;

import java.util.List;

import kodlama.io.programmingLanguages.business.requests.subLanguageTech.CreateSubLanguageTechRequest;
import kodlama.io.programmingLanguages.business.requests.subLanguageTech.DeleteSubLanguageTechRequest;
import kodlama.io.programmingLanguages.business.requests.subLanguageTech.UpdateSubLanguageTechRequest;
import kodlama.io.programmingLanguages.business.responses.subLanguageTech.GetAllLanguageTechsResponse;
import kodlama.io.programmingLanguages.business.responses.subLanguageTech.GetLanguageTechByIdResponse;

public interface SubLanguageTechService {

		List<GetAllLanguageTechsResponse> getAll();
		void add(CreateSubLanguageTechRequest createLanguageTechRequest);
		void delete(DeleteSubLanguageTechRequest deleteLanguageTechRequest);
		void update(UpdateSubLanguageTechRequest updateLanguageTechRequest);

        GetLanguageTechByIdResponse getId(int id);
}
