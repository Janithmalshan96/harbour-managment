package lk.ijse.harbourmanagment.bo.custom.impl;

import lk.ijse.harbourmanagment.bo.custom.ManageOwnerBO;
import lk.ijse.harbourmanagment.dao.custom.ManageOwnerDAO;
import lk.ijse.harbourmanagment.dao.custom.impl.ManageOwnerDAOImpl;
import lk.ijse.harbourmanagment.dto.OwnerDTO;
import lk.ijse.harbourmanagment.entity.Owner;

import java.util.ArrayList;

public class ManageOwnerBOImpl implements ManageOwnerBO {

    private ManageOwnerDAO manageOwnerDAO=new ManageOwnerDAOImpl();

    @Override
    public boolean saveOwner() throws Exception {
        return false;
    }

    @Override
    public boolean updateOwner() throws Exception {
        return false;
    }

    @Override
    public boolean deleteOwner(String ID) throws Exception {
        return false;
    }

    @Override
    public OwnerDTO searchOwner(String ID) throws Exception {
        Owner search = manageOwnerDAO.search(ID);
        return new OwnerDTO(search.getOid(),search.getName(),search.getAddress(),search.getNic(),
                search.getContact());
    }

    @Override
    public ArrayList<OwnerDTO> getAllOwners() throws Exception {
        return null;
    }

    @Override
    public ArrayList<String> getAllOwner() throws Exception {
        return null;
    }
}
