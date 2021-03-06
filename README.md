# S3 Billing Calculator (Assignment Description)

### History
In 2006 Amazon released a product called S3. S3 stands for Simple Storage Solution and it is a cloud based flat object store, and it is not hierarchical. S3 contains buckets in which users can upload an "infinite" amount of files to the cloud. Users are charged based on the size of the file and how many times they upload or download files from their S3 buckets. In 2008 the price to store 1 GB (GigaByte) of data was roughly 10 cents per GB. Now it's as low as 1 cent per GB.

### Assignment
Create an S3BillingCalculator that creates invoices for customers that store their data in S3. The S3BillingCalculator must use a HashMap to store billing data for each user.

To make our math easy, the pricing model for this assignment is the following:

- Storage: $0.10 per GB
- GET Requests: $0.50 per 1000 requests
- PUT Requests: $0.25 per 1000 requests

A GET request is an action that downloads data from the cloud.  A PUT request is an action that uploads data to the cloud.
The constructor for the S3BillingCalculator takes three arguments:

- float: price per GB
- float: cost per 1000 put requests
- float: cost per 1000 get requests

The S3BillingCalculator must implement the following interface:

```java
public interface S3Calculable {

    void addStorageGB(int userId, int amount);

    void addPutRequests(int userId, int number);

    void addGetRequests(int userId, int number);

    Invoice createInvoice(int userId);
}
```


The s3BillingCalculator must be used in the following manner and must produce the output below.

Usage:
```java
var s3BillingCalculator = new S3BillingCalculator(.10F, .25F, .50F);
s3BillingCalculator.addStorageGB(1111, 1);
s3BillingCalculator.addGetRequests(1111, 1000);
s3BillingCalculator.addPutRequests(1111, 1000);

s3BillingCalculator.addStorageGB(2222, 2);
s3BillingCalculator.addGetRequests(2222, 2000);
s3BillingCalculator.addPutRequests(2222, 2000);

var invoice1 = s3BillingCalculator.createInvoice(1111);
var invoice2 = s3BillingCalculator.createInvoice(2222);

System.out.println(invoice1);
System.out.println(invoice2);

```

Output:
```
UserId: 1111
Storage: $0.10
GET Requests: $0.50
PUT Requests: $0.25
Total Cost: $0.85

UserId: 2222
Storage: $0.20
GET Requests: $1.00
PUT Requests: $0.50
Total Cost: $1.70