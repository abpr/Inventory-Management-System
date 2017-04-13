# Inventory-Management-System

Inventory management System


Introduction

Assume a new warehouse inventory management system named IMS. IMS will be responsible for the inventory

tracking within physical, single site warehouses. IMS will track the named physical location of a product within the warehouse and the inventory

level of each product. IMS will be deployed to busy warehouses supporting many pickers and restockers working with individual terminals and

clients. Updates to inventory levels will be handled in real time to prevent pickers trying to pick a product that is out of stock.



Assumptions

Each product will be stored at one and only one named location within the warehouse.

Inventory adjustments may be additive (restocks) or subtractive (picks).

No additional product information needs to be tracked beyond location and level.



Problem

In Java, I have implemented the picking and restocking routines for the IMS system. The InventoryManagementSystem interface will be the

first component to be implemented; all relevant domain objects are implemented. The InventoryManagementSystem interface

has already been distributed to other teams which depend on it.
