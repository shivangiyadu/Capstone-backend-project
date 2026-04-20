package com.example.demo.dto.products;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetAllProductResponseDto {
    private List<GetProductResponseDto> products;

}
