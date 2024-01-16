package com.paulo011.AGA.application.gateways;

import com.paulo011.AGA.domain.entities.Warehouse;
import com.paulo011.AGA.infrastructure.schemes.WarehouseScheme;
import org.springframework.stereotype.Component;


@Component
public class WarehouseGateway {
    public static WarehouseScheme toWarehouseScheme(Warehouse warehouse){
        return new WarehouseScheme(
                warehouse.getId(),
                warehouse.getName(),
                warehouse.getUserList()
                        .stream().map(UserGateway::toUserSchema)
                        .toList(),
                warehouse.getProductList()
                        .stream().map(ProductGateway::toProductScheme)
                        .toList());
    }
    public static Warehouse toWarehouse(WarehouseScheme warehouseScheme){
        return new Warehouse(
                warehouseScheme.getId(),
                warehouseScheme.getName(),
                warehouseScheme.getUserList()
                        .stream().map(UserGateway::toUser)
                        .toList(),
                warehouseScheme.getProductList()
                        .stream().map(ProductGateway::toProduct)
                        .toList());
    }
}
