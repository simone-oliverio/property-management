package com.example.demo.service.impl;

import com.example.demo.converter.PropertyConverter;
import com.example.demo.dto.PropertyDTO;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service  //singleton
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);

        pe = propertyRepository.save(pe);
        propertyDTO = propertyConverter.convertEntitytoDTO(pe);

        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {

        List<PropertyEntity> propertyEntityList=  (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList= new ArrayList<>();

        for (PropertyEntity pe : propertyEntityList){
            PropertyDTO propertyDTO = propertyConverter.convertEntitytoDTO(pe);
            propertyDTOList.add(propertyDTO);
        }

        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        //propertyDTO ---> contiene i dati aggiornati
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        if(optionalPropertyEntity.isPresent()) {
            PropertyEntity pe = optionalPropertyEntity.get();

            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setOwnerMail(propertyDTO.getOwnerMail());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setDescription(propertyDTO.getDescription());
            pe.setPrice(propertyDTO.getPrice());

            pe = propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);

            return propertyDTO;

        }

        return null;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        if(optionalPropertyEntity.isPresent()) {
            PropertyEntity pe = optionalPropertyEntity.get();

            pe.setDescription(propertyDTO.getDescription());

            pe = propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);

            return propertyDTO;

        }

        return null;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        if(optionalPropertyEntity.isPresent()) {
            PropertyEntity pe = optionalPropertyEntity.get();

            pe.setPrice(propertyDTO.getPrice());

            pe = propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntitytoDTO(pe);

            return propertyDTO;

        }


        return null;
    }

    @Override
    public void deleteProperty(Long propertyId) {

        propertyRepository.deleteById(propertyId);

    }

}
