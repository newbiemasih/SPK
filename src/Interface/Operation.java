/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Corespk.CoreApps;
import com.mongodb.MongoException;
import java.util.List;

/**
 *
 * @author newbie
 */
public interface Operation {
    
    public void simpan(CoreApps coreApps) throws MongoException;
    
    public void update(CoreApps coreApps) throws MongoException;
    
    public void hapus(String nik) throws MongoException;
    
    public List getAll() throws MongoException;
    
}
