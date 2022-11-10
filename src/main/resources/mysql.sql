create table OrdersHistory(
	orderid int not null PRIMARY KEY,
	Order_Name varchar(128) ,
	Order_Count int  ,
    Order_Day varchar(128),
    Order_Date DATE
);




insert into OrdersHistory(orderid, Order_Name, Order_Count,Order_Day,Order_Date) values (1, 'Starters', 3,'Tuesday','2022-02-20');
