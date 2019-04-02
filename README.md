# SpringBoot_RESTAPI_ECommerce_Sample

#Run the Code <br>
#[GET] <br><br>
localhost:8080/items/<br>
localhost:8080/items/{ItemID}<br>
localhost:8080/orders/<br>
localhost:8080/orders/{OrderID}<br>
<br><br>
#[POST]<br><br>
localhost:8080/items/<br><br>
#Request:<br>
    {<br>
        "itemCode": "2",<br>
        "name": "Chair",<br>
        "quantity": 20<br>
    }<br>
<br><br>
localhost:8080/orders/<br><br>
#Request:<br>
[{	<br>
	"orderCode" : "1",<br>
	"itemCode" : "2",<br>
	"numberOfItems" : "10",<br>
	"email" : "tempm@gmail.com"<br>
},{	<br>
	"orderCode" : "2",<br>
	"itemCode" : "5",<br>
	"numberOfItems" : "20",<br>
	"email" : "tempm@gmail.com"<br>
}]<br>
<br><br><br>
Sql file is attached. Use it into any SQL server.
