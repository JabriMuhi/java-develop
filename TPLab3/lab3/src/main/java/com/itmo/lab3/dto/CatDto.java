package com.itmo.lab3.dto;

import com.itmo.lab3.model.entity.Cat;
import com.itmo.lab3.model.entity.Color;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class CatDto {
    private Long id;
    private String name;
    private LocalDateTime dateOfBorn;
    private String breed;
    private Color color;
    private List<CatDto> catList = new ArrayList<>();
}
