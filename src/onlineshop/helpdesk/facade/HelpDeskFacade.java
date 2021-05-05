package onlineshop.helpdesk.facade;


import onlineshop.helpdesk.entities.SupportTicket;

public interface HelpDeskFacade {

    void addNewSupportTicket(SupportTicket supportTicket);

    SupportTicket getNextSupportTicket();

    /**
     * @return amount of tickets that are not processed
     */
    int getNumberOfTickets();
}
