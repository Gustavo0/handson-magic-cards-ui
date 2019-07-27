package magiccards.ui.entities;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Expansion {
	private Integer expansionId;
	private String name;
	private String ptBrName;
	private String linkName;
	private String code;
	private LocalDate launchDate;
	private Integer expansionCategoryId;
	private Boolean isPromo;
	private Boolean isLegal;
}
