package kodlama.io.programmingLanguages.business.requests.subLanguageTech;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubLanguageTechRequest {

	private String name;
	private int languageId;
}
