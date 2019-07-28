package magiccards.ui.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date launchDate;
	private Integer expansionCategoryId;
	private boolean isPromo;
	private boolean isLegal;
}
