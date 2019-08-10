# orders-microservice
A Service (Java Web Application) which provides API's on Orders, Accounts and Inventory of an E-commerce System.


## Pre-Requisites

- `mongodb` - Download and install if not already 
- Download or clone this application
- Change the configuration in `application.properties`
```
Like below:
spring.data.mongodb.host=yourMongoDBServiceRunningMachine
spring.data.mongodb.port=Port
spring.data.mongodb.database=yourDatabaseName
```
- Run the application
- use `Postman` or any similiar sort of API call environment to test the below API's

## API
This application provides API's like

Note: Under Assumption that application is running in `localhost` at `port 8080`. 

#### Implemented
- Add Inventory

  `POST` http://localhost:8080/inventory/add _with List of inventories in **RequestBody**_
  ```
  Below example **Request Body** shows parameters it can hold and list of JSON inventories
  [
      {
          "inventoryId": "inv1",
          "itemName": "mobile_phone",
          "inStockQuantity": 10,
          "soldQuantity": 0,
          "mrp": 50000.0,
          "discount": 20.0
      },
      {
          "inventoryId": "inv2",
          "itemName": "shirts",
          "inStockQuantity": 10,
          "soldQuantity": 0,
          "mrp": 1500.0,
          "discount": 20.0
      }
  ]

  Note: Not Mandotary to send inventoryId as it creates unique id if not provided. But for better testing purpose lets pass id.
  Usecase: Before creating order database show contain some inventory.
  ```

- Show Inventory

    `GET` http://localhost:8080/inventory/show _with inventoryId as **RequestParam**_
    ```
    For Example:
    
    http://localhost:8080/inventory/show?inventoryId="inv1"
    
    Usecase : To check the updated stock inventory after order creation. 
    ```

- Show All Inventory
  
    `GET` http://localhost:8080/inventory/showAll
    ```
    Usecase: To create order user should know what all inventories are available.
    Note: This API is created assuming StockInventory collection is of less size and else can be created with filters.
    ```

- Create Account
  
  `POST` http://localhost:8080/account/create _with Account Details as **RequestBody**_
  
  ```
  Example: 
  {
    "accountId": "acc1",
    "username": "durga1234",
    "accountEmail": "durga1@gmail.com",
      "accountPhone": "8019xxxxxx",
      "country": "India",
      "addresses": [{
        "id": "add1",
        "phone": "8019300005",
        "addLine1": "house 1/a/b",
        "addLine2": "Street 2",
        "landmark": "InOrbit mall",
        "city": "Hyderabad",
        "state": "Telangana",
        "country": "India",
        "pincode": "500001",
        "addressType": "Office"
      }],
      "currentOrders": [],
      "orderHistory": []
  }
  
  Note: Only username is mandatory field, user can ignore remaining fields. And Can be extended to unique email, phone.
  Usecase: Before creating a order one must create account. Order is associated wwith a users account
  ```
- Account Details
  
  `GET` http://localhost:8080/account/details/{accountId} _where accountId as **PathVariable**_
  ```
  Example: http://localhost:8080/account/details/acc1
  
  Usecase: Gets the every detail of an account including currentOrders, OrderHistory and etc (if they are available).
  ```

- **Create Order**

  `POST` http://localhost:8080/account/{accountId}/placeOrder _with Order Details as **Request Body** and accountId as **PathVariable**_
  ```
  Example:
  http://localhost:8080/account/acc1/placeOrder
  {
    "orderId": "ord1",
    "items": [
      {
        "inventoryId": "inv1",
        "itemName": null,
        "quantity": 2,
        "price": 80000.0,
        "deliveredDate": null,
        "delivered": false
      }
    ],
    "orderDate": null,
    "shippingAddress": null
  }
  
  Note: parameters like inventoryId, quantity are mandatory. Checks before placing order for stock availabilty if not it will drop those
  particular items. (User can place/create order containing multiple different items)
  Usecase: To place/create order
  returns: Order containing all the items only whose order got placed
  
  ```
  
- Get Order Details

  `GET` http://localhost:8080/account/{accountId}/orderDetails _with accountId as **PathVariable**_
  ```
  Example:
  http://localhost:8080/account/acc1/orderDetails
    
  Usecase: gets the current Order details for a user. 
  ```

#### Created But Unimplemented API's

- Cancel Order
- Order Delievered
- Delete Account
- Update Account
- Remove Inventory

## Next Steps

- Adding _**Spring Security**_
- _**Indexing**_ for Model Fields
- _**Implement**_ remaining API's
- Implementing _**Cart**_
- Better _**Exception Handling** 
- Account(includes Orders) and Inventory can be made into seperate _**Miscroservices**_

