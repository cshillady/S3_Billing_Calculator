import java.util.HashMap;
import java.util.Map;

public class S3BillingCalculator implements S3Calculable {

    //
    // Data Members
    //
    private final int PRICE_PER_1000_REQUESTS = 1000;
    private final float priceStorage;
    private final float pricePutRequests;
    private final float priceGetRequests;
    private final HashMap<Integer, S3BillCalcItem> s3Map;

    //
    // Constructors
    //
    public S3BillingCalculator(float priceStorage, float pricePutRequests, float priceGetRequests) {
        this.priceStorage = priceStorage;
        this.pricePutRequests = pricePutRequests / PRICE_PER_1000_REQUESTS;
        this.priceGetRequests = priceGetRequests / PRICE_PER_1000_REQUESTS;
        this.s3Map = new HashMap<>();
    }

    //
    // Methods
    //
    public void addStorageGB(int userId, int amount) {
        var s3Item = getOrAddS3Item(userId);
        s3Item.incrementStorage(amount);
    }
    public void addPutRequests(int userId, int number) {
        var s3Item = getOrAddS3Item(userId);
        s3Item.incrementPutRequests(number);
    }
    public void addGetRequests(int userId, int number) {
        var s3Item = getOrAddS3Item(userId);
        s3Item.incrementGetRequests(number);
    }
    public Invoice createInvoice(int userId) {
        var s3Item = s3Map.get(userId);
        var costStorage = s3Item.getStorageInGigaBytes() * priceStorage;
        var costPutRequests = s3Item.getNumberPutRequests() * pricePutRequests;
        var costGetRequests = s3Item.getNumberGetRequests() * priceGetRequests;
        var total = costStorage + costPutRequests + costGetRequests;
        return new Invoice(userId, costStorage, costPutRequests, costGetRequests, total);
    }
    private S3BillCalcItem getOrAddS3Item(int userId) {
        S3BillCalcItem retVal;
        if (!s3Map.containsKey(userId)) {
            retVal = new S3BillCalcItem();
            s3Map.put(userId, retVal);
        } else retVal = s3Map.get(userId);
        return retVal;
    }
}