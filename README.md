# SpringBoot_RESTAPI_ECommerce_Sample

Run the Code
[GET]
localhost:8080/items/
localhost:8080/items/{ItemID}
localhost:8080/orders/
localhost:8080/orders/{OrderID}

[POST]
localhost:8080/items/
Request:
    {
        "itemCode": "2",
        "name": "Chair",
        "quantity": 20
    }

localhost:8080/orders/
Request:
[{	
	"orderCode" : "1",
	"itemCode" : "2",
	"numberOfItems" : "10",
	"email" : "tempm@gmail.com"
},{	
	"orderCode" : "2",
	"itemCode" : "5",
	"numberOfItems" : "20",
	"email" : "tempm@gmail.com"
}]

Sql file is attached. Use it into any SQL server.
