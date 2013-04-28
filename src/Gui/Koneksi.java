/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.mongodb.Mongo;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author newbie
 */
public class Koneksi {
    
    public static Mongo mongo;
    
    static {
        try {
            mongo = new Mongo("localhost", 27017);
        } catch (UnknownHostException | MongoException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Database", "Error Koneksi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static Mongo getMongo(){
        return mongo;
    }
    
}
