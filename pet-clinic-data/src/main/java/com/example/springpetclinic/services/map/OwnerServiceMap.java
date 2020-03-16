package com.example.springpetclinic.services.map;

import com.example.springpetclinic.model.Owner;
import com.example.springpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Autowired
    public OwnerService ownerService;

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return ownerService.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
