package technicianpkg;

import java.sql.SQLException;
import java.util.List;

public class TechnicianServiceImpl implements TechnicianService {
	TechnicianDAO technicianDAO = new TechnicianDaoImpl();
	public Technician getTechnicianById(String id){
		try {
			return technicianDAO.get(id);
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return null;
	}

	public List<Technician> allRecords() {
		try 
		{
			return technicianDAO.getAll();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	public int addTechnician(Technician technician) {
		try 
		{
			return technicianDAO.insert(technician);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return 0;
	}

	public int updateTechnician(Technician technician,String old_technicianId) {
		try {
			return technicianDAO.update(technician,old_technicianId);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteTechnician(Technician technician) 
	{
		try {
			return technicianDAO.delete(technician);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	

}
