package data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

	private String user_id;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String user_pass;
}
