#include "Ticket.h"

int Ticket::getTicket_no() {
	return ticket_no;
}
void Ticket::setTicket_no(int ticketno) {
	ticket_no = ticketno;
}
int Ticket::getCounter_no() {
	return counter_no;
}
void Ticket::setCounter_no(int counterno) {
	counter_no = counterno;
}
Ticket& Ticket::operator=(const Ticket &rhs) {
	counter_no = rhs.counter_no;
	ticket_no = rhs.ticket_no;
	return *this;
}

bool Ticket::operator==(const Ticket &rhs) {
	if (rhs.ticket_no != ticket_no && rhs.counter_no != counter_no)
		return false;
	return true;
}
bool Ticket::operator!=(const Ticket &rhs) {
	if (rhs.ticket_no == ticket_no && rhs.counter_no == counter_no)
		return false;
	return true;
}
