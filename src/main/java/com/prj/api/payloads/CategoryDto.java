package com.prj.api.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private @NotBlank String categoryName;
    private @NotBlank String description;

    // add imageURL here
    private @NotBlank String imageUrl;
}
