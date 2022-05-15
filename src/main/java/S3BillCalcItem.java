public class S3BillCalcItem {

    //
    // Data Members
    //
    private float storageInGigaBytes;
    private int numberPutRequests;
    private int numberGetRequests;

    //
    // Constructors
    //
    public S3BillCalcItem() {
        this.storageInGigaBytes = storageInGigaBytes;
        this.numberPutRequests = numberPutRequests;
        this.numberGetRequests = numberGetRequests;
    }

    //
    // Methods
    //
    public void incrementStorage(float storage) {
        this.storageInGigaBytes += storage;
    }
    public void incrementPutRequests(float putRequests) {
        this.numberPutRequests += putRequests;
    }
    public void incrementGetRequests(float getRequests) {
        this.numberGetRequests += getRequests;
    }

    //
    // Accessors
    //
    public float getStorageInGigaBytes() {
        return storageInGigaBytes;
    }
    public int getNumberPutRequests() {
        return numberPutRequests;
    }
    public int getNumberGetRequests() {
        return numberGetRequests;
    }
}