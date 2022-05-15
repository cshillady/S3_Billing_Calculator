import java.text.NumberFormat;

public class Invoice {

    //
    // Data Members
    //
    private final int userId;
    private final float total;
    private final float costStorage;
    private final float costPutRequests;
    private final float costGetRequests;
    private final NumberFormat formatter;

    //
    // Constructors
    //
    public Invoice (int userId, float costStorage, float costPutRequests, float costGetRequests, float total) {
        this.userId = userId;
        this.total = total;
        this.costStorage = costStorage;
        this.costPutRequests = costPutRequests;
        this.costGetRequests = costGetRequests;
        this.formatter = NumberFormat.getCurrencyInstance();
    }

    //
    // Overrides
    //
    @Override
    public String toString() {
        return  "UserId: " + userId + "\n" +
                "Storage: $" + formatter.format(this.costStorage) + "\n" +
                "GET Requests: " + formatter.format(this.costGetRequests) + "\n" +
                "PUT Requests: " + formatter.format(this.costPutRequests) + "\n" +
                "Total Cost: " + formatter.format(this.total) + "\n";
    }
}