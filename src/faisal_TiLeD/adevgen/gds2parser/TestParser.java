/*
 * TestParser.java
 *
 * Created on May 24, 2007, 12:30:35 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package faisal_TiLeD.adevgen.gds2parser;

import faisal_TiLeD.adevgen.objecthiererkey.GDSFile;
import faisal_TiLeD.adevgen.objecthiererkey.NewItemListener;
import faisal_TiLeD.adevgen.starter.GDSIIView;
import java.io.File;
import java.util.Hashtable;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Administrator
 */
public class TestParser implements NewItemListener{
    File file = null;
    GDSIIView src;
    GDSFile gdsfile;
    Hashtable<Integer, String> recname;
    public TestParser(GDSIIView src) {
        this.src = src;
        //gdsfile = new GDSFile();
        open();
        buildHash();
        gdsfile = new GDSFile();
        gdsfile.addNewItemListener(this);
        gdsfile.parse(file);
    }
    
    public TestParser(File file) {
        this.file = file;
        gdsfile = new GDSFile();
        gdsfile.parse(file);
    }
    
    public void open(){
        JFileChooser jfc = new JFileChooser();
        
        FileFilter fileFilter = new FileFilter() {
        public boolean accept(File f) {
            String fname = f.getName();
            if(fname.endsWith("gds"))
                return true;
            else
                return false;
        }
        public String getDescription() {
            return "GDSII File(*.gds)";
        }
    };
    
    jfc.setFileFilter(fileFilter);
    
        jfc.showOpenDialog(null);
        if (jfc.getSelectedFile() == null) {
            return;
        } else{
            file = jfc.getSelectedFile();
        }
    }
    
    public void pr(String str){
        //System.out.println(str);
        src.txtView.append(str + "\n");
    }
    
    public void buildHash(){
        recname = new Hashtable<Integer, String>();
        int code[] = {
            0x0002,0x0102,0x0206,0x0305,
            0x0400,0x0502,0x0606,0x0700,
            0x0800,0x0900,0x0A00,0x0B00,
            0x0C00,0x0D02,0x0E02,0x0F03,
            0x1003,0x1100,0x1206,0x1302,
            0x1500,0x1602,0x1701,0x1906,
            0x1A01,0x1B05,0x1C05,0x1F06,
            0x2006,0x2102,0x2202,0x2306,
            0x2601,0x2A02,0x2B02,0x2C06,
            0x2D00,0x2E02,0x2F03,0x3202,
            0x3302,0x3602,0x3706,0x3800};
        String mnemonic[] = {
            "HEADER",   "BGNLIB",   "LIBNAME",  "UNITS",
            "ENDLIB",   "BGNSTR",   "STRNAME",  "ENDSTR",
            "BOUNDARY", "PATH",     "SREF",     "AREF",
            "TEXT",     "LAYER",    "DATATYPE", "WIDTH",
            "XY",       "ENDEL",    "SNAME",    "COLROW",
            "NODE",     "TEXTTYPE", "PRESENTATION","STRING",
            "STRANS",   "MAG",      "ANGLE",    "REFLIBS",
            "FONTS",    "PATHTYPE", "GENERATIONS","ATTRTABLE",
            "ELFLAGS",  "NODETYPE", "PROPATTR", "PROPVALUE",
            "BOX",      "BOXTYPE",  "PLEX",     "TAPENUM",
            "TAPECODE", "FORMAT",   "MASK",     "ENDMASKS"};
        
        for (int i = 0; i < mnemonic.length; i++) {
            String string = mnemonic[i];
            recname.put(code[i], string);
        }
    }
    
    private String getMNemonic(int i){
        return recname.get(i);
    }

    public void newItem(String msg) {
        pr(msg);
    }
    
    
}
