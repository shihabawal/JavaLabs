#ifndef h_t
#define h_t
class Ticket {
private:
	int ticket_no;
	int counter_no;
public:
	int getTicket_no();
	void setTicket_no(int ticketno);
	int getCounter_no();
	void setCounter_no(int counterno);
	Ticket& operator= (const Ticket &rhs);
	bool operator== (const Ticket &rhs);
	bool operator!= (const Ticket &rhs);
};

#endif
