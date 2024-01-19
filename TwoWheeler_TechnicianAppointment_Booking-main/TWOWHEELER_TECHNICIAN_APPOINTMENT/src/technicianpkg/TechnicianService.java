package technicianpkg;

import java.util.List;

public interface TechnicianService {
	Technician getTechnicianById(String id);
	List<Technician> allRecords();
	int addTechnician(Technician technician);
	int updateTechnician(Technician technician,String old_technicianId);
	int deleteTechnician(Technician technician);

}
