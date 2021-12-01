package com.training.shippersservice.controllers;

import com.training.shippersservice.entities.ApiError;
import com.training.shippersservice.entities.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.training.shippersservice.service.ShipperService;

import java.util.Date;

@RestController
@RequestMapping("/api/shippers")
public class ShipperController {

    @Autowired
    ShipperService service;

    @GetMapping(value = "/{id}", produces = "text/plain")
    public String handleGetShipperByIdAsString(@PathVariable Integer id)
    {
        return service.getShipperById(id).toString();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> handleGetShippersById(@PathVariable Integer id)
    {
        Shipper s = service.getShipperById(id);
        if(s!=null)
        {
            return ResponseEntity.ok(s);
        }

        else
        {
            ApiError err = new ApiError(HttpStatus.NOT_FOUND, new Date(), "Shipper not found for id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        }
    }

    @GetMapping(produces = {"application/json", "application/xml"})
    public Iterable<Shipper> handleGetAllShippers(
            @RequestParam(value = "_page" , required = false, defaultValue = "1")  Integer pageNum,
            @RequestParam(value = "_limit", required = false, defaultValue = "8") Integer pagesize
    )
    {
        return service.getAllShippers(pageNum, pagesize);
    }

    @GetMapping(path = "/filter", params = {"companyName"})
    public Shipper handleGetShippersByCompanyName(@RequestParam String companyName)
    {
        return service.getProductsByCompanyName(companyName);
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleAddNewShipper(@RequestBody Shipper shipper)
    {
        try
        {
            Shipper s = service.addNewShipper(shipper);
            return ResponseEntity.ok(s);
        }
        catch (Exception e)
        {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);
        }
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> handleUpdateProduct(@PathVariable Integer id, @RequestBody Shipper shipper)
    {
        try
        {
            shipper.setShipperId(id);
            Shipper s = service.updateShipper(shipper);
            return ResponseEntity.ok(s);
        }
        catch (Exception e)
        {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);

        }
    }


    @DeleteMapping(path = "/{id}", produces = "application/json") // doesnt have consumes field
    public  ResponseEntity<Object> handleDeleteShipper(@PathVariable Integer id)
    {
        try
        {
            Shipper s = service.deleteShipper(id);
            return ResponseEntity.ok(s);
        }
        catch (Exception e)
        {
            ApiError ai = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ai);

        }
    }
}
