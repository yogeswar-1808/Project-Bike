package Appointmentpkg;

import java.util.List;



public interface AppointmentService {
	Appointment getAppointmentById(String id);
	List<Appointment> allRecords();
	int addAppointment(Appointment appointment);
	int updateAppointment(Appointment appointment,String old_appointmentId);
	int deleteAppointment(Appointment appointment);
}
