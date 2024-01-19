package Appointmentpkg;

import java.sql.SQLException;
import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
	AppointmentDoa appointmentDoa = new AppointmentDaoImpl();
	
	public Appointment getAppointmentById(String id) {
		try{
			return appointmentDoa.get(id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public List<Appointment> allRecords() {
		try {
			return appointmentDoa.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addAppointment(Appointment appointment) {
		try {
			return appointmentDoa.insert(appointment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateAppointment(Appointment appointment, String old_appointmentId) {
		try {
			return appointmentDoa.update(appointment, old_appointmentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteAppointment(Appointment appointment) {
		try {
			return appointmentDoa.delete(appointment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
