package org.example.mapper;

import lombok.Getter;
import lombok.Setter;
import org.example.dto.DepositorDTO;
import org.example.entity.Depositor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Controller
    @Mapper
            (componentModel = "spring")
    @Qualifier("DepositorMapper")
//@Component
//    @Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
//        componentModel = MappingConstants.ComponentModel.SPRING,
//        unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public interface DepositorMapper extends EntityMapper<DepositorDTO,Depositor>  {
//    public abstract class DepositorMapper  {
    public DepositorDTO toDTO (Depositor depositor);
    public Depositor depositor (DepositorDTO toDTO);
    }

