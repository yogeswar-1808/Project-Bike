package Appointmentpkg;

import java.sql.SQLException;
import java.util.List;

public interface AppointmentDoa {
	Appointment get(String id) throws SQLException;
	List<Appointment> getAll() throws SQLException;
	int insert(Appointment appointment) throws SQLException;
	int update(Appointment appointment,String appointementId) throws SQLException;
	int delete(Appointment appointment) throws SQLException;
}
