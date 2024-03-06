package com.prj.api.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
	   	private Long id;
	    private @NotNull String name;
	    private @NotNull String imageURL;
	    private @NotNull double price;
	    private @NotNull String description;
	    private @NotNull Long categoryId;
}
