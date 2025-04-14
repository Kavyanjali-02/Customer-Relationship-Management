package CustomerRelationship;

import java.time.LocalDate;

public class Interaction {
    private int customerId;
    private String notes;
    private LocalDate date;
    private String interactionType;

    public Interaction(int customerId, String notes, String interactionType) {
        this.customerId = customerId;
        this.notes = notes;
        this.interactionType = interactionType;
        this.date = LocalDate.now();
    }

    public int getCustomerId() { return customerId; }
    public String getNotes() { return notes; }
    public LocalDate getDate() { return date; }
    public String getInteractionType() { return interactionType; }

    @Override
    public String toString() {
        return "Date: " + date + ", Type: " + interactionType +
               ", CustomerID: " + customerId + ", Notes: " + notes;
    }
}
