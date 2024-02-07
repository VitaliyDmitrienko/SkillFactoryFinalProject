package org.example.mapper;

import lombok.Getter;
import lombok.Setter;
import org.example.dto.DepositorDTO;
import org.example.entity.Depositor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Controller;

//@Controller
    @Mapper(componentModel = "spring")
    public interface DepositorMapper {
        DepositorDTO toDTO(Depositor depositor);

        Depositor toDepositor(DepositorDTO toDTO);
    }

