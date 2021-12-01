package com.training.shippersservice.service;

import com.training.shippersservice.dao.ShipperDao;
import com.training.shippersservice.entities.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class DefaultShipperService implements ShipperService{

    @Autowired
    private ShipperDao dao;

    @Override
    public Shipper addNewShipper(Shipper shipper) {
        shipper.setShipperId(null);
        return dao.save(shipper);
    }

    @Override
    public Shipper getShipperById(Integer id) {
        Optional<Shipper> os = dao.findById(id);
        return os.isPresent()?os.get():null;
    }

    @Override
    public Shipper updateShipper(Shipper shipper) {

        if(shipper.getShipperId()==null)
        {
            throw new RuntimeException("Shipper must have ID for updating!");
        }

        if(!dao.existsById(shipper.getShipperId()))
        {
            throw new RuntimeException("Invalid ID, could not update the product.");
        }

        return  dao.save(shipper);
    }

    @Override
    public Shipper deleteShipper(Integer id) {
        if(!dao.existsById(id))
        {
            throw new RuntimeException("Shipper with this ID does not exist.");
        }

        Shipper p = dao.findById(id).get();
        dao.deleteById(id);
        return p;
    }

    @Override
    public Iterable<Shipper> getAllShippers(Integer pageNum, Integer pagesize) {
        PageRequest p = PageRequest.of(pageNum - 1, pagesize);
        Page<Shipper> result = dao.findAll(p);
        if(result.hasContent())
        {
            return result.getContent();
        }
        else{
            return new ArrayList<>();
        }
    }

    @Override
    public Shipper getProductsByCompanyName(String companyName) {
        return dao.findByCompanyName(companyName);
    }
}
