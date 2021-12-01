package com.training.shippersservice.service;


import com.training.shippersservice.entities.Shipper;

public interface ShipperService {

    //CRUD
    public Shipper addNewShipper(Shipper shipper);
    public Shipper getShipperById(Integer id);
    public Shipper updateShipper(Shipper shipper);
    public Shipper deleteShipper(Integer id);


    // Queries
    public Iterable<Shipper> getAllShippers(Integer pageNum, Integer pagesize);
    public Shipper getProductsByCompanyName(String companyName);
}
