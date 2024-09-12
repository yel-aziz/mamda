
package com.dto;

public class EntityCountDTO {
    private long prospectCount;
    private long rendezvousCount;
    private long ticketCount;
    private long userCount;

    // Constructors
    public EntityCountDTO() {
    }

    public EntityCountDTO(long prospectCount,  long userCount) {
        this.prospectCount = prospectCount;

        this.userCount = userCount;
    }

    // Getters and Setters
    public long getProspectCount() {
        return prospectCount;
    }

    public void setProspectCount(long prospectCount) {
        this.prospectCount = prospectCount;
    }

    public long getRendezvousCount() {
        return rendezvousCount;
    }

    public void setRendezvousCount(long rendezvousCount) {
        this.rendezvousCount = rendezvousCount;
    }

    public long getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(long ticketCount) {
        this.ticketCount = ticketCount;
    }

    public long getUserCount() {
        return userCount;
    }

    public void setUserCount(long userCount) {
        this.userCount = userCount;
    }
}
