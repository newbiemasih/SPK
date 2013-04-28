/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Implements;

import abstrak.Truncate;
import Corespk.CoreApps;
import Gui.Koneksi;
import Interface.Operation;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author newbie
 */
public class implementOperation extends Truncate implements Operation{
    
    private DBCollection collection;
    private DBObject query;
    
    public implementOperation(Mongo mongo) {
        collection = mongo.getDB("DBSpk").getCollection("Peminatan");
        query = new BasicDBObject();
    }

    @Override
    public void truncate() {
        collection.remove(query);
    }

    @Override
    public void simpan(CoreApps coreApps) throws MongoException {
        collection.save(coreApps);
    }

    @Override
    public void update(CoreApps coreApps) throws MongoException {
        query.put("noInduk", coreApps.getNik());
        collection.update(query, coreApps);
    }

    @Override
    public void hapus(String nik) throws MongoException {
        query.put("noInduk", nik);
        collection.remove(query);
    }

    @Override
    public List getAll() throws MongoException {
        List list = new ArrayList();
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            CoreApps murid = new CoreApps();
            BasicDBObject data = (BasicDBObject) cursor.next();
            
            murid.setNama(data.getString("nama"));
            murid.setNik(data.getString("nik"));
            murid.setKelas(data.getString("kelas"));
            
            //Materi IPS
            murid.setAkutansi(data.getDouble("akutansi"));
            murid.setGeografi(data.getDouble("geografi"));
            murid.setSosiologi(data.getDouble("sosiologi"));
            
            //Materi IPA
            murid.setFisika(data.getDouble("fisika"));
            murid.setKimia(data.getDouble("fisika"));
            murid.setBiolgi(data.getDouble("biologi"));
            
            murid.setMatematika(data.getDouble("matematika"));
            murid.setMinat(data.getString("minat"));
            murid.setHasilMinat(data.getString("hasilMinat"));
            list.add(murid);
        }
        return list;
    }
}
