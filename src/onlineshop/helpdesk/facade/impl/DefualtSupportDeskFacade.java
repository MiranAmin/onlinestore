package onlineshop.helpdesk.facade.impl;

import onlineshop.helpdesk.entities.SupportTicket;
import onlineshop.helpdesk.facade.HelpDeskFacade;
import onlineshop.helpdesk.utils.CustomSupportTicketsComparator;

import java.util.PriorityQueue;
import java.util.Queue;

public class DefualtSupportDeskFacade {


    public class DefaultHelpDeskFacade implements HelpDeskFacade {

        private Queue<SupportTicket> tickets;

        {
            tickets = new PriorityQueue<>(new CustomSupportTicketsComparator());
        }

        @Override
        public void addNewSupportTicket(SupportTicket supportTicket) {
            tickets.offer(supportTicket);
        }

        @Override
        public SupportTicket getNextSupportTicket() {
            return tickets.poll();
        }

        @Override
        public int getNumberOfTickets() {
            return tickets.size();
        }

    }
}
