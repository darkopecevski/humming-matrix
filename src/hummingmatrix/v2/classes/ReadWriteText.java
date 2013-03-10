/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hummingmatrix.v2.classes;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Ane
 */
public class ReadWriteText {


    public String filename;
    public File file;
    private static final String directory = "."+File.separator+"Matrici"+File.separator;
    
    public String apsolutna_verojatnost;
    public String apsolutna_verojatnost_print;
    public String verojatnost_na_ostanuvanje;
    public String verojatnost_na_premin;
    public String difuzija;
    public String verojatnost_na_distanca;
    public Object[][] distinctRows;
    public Map razlicniRedovi;

    public ReadWriteText() {

    }
    
    public ReadWriteText(String fileIn) {
        filename = fileIn;
        file = new File("."+File.separator+"Matrici"+File.separator+filename);
    }

    public boolean fileExists() {
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean createFile() {
        try {
            if (file.createNewFile()) {
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            return false;
        }

    }

    public boolean insertEmptyMatrix(String rowNum, String columnNum) {
        try {
            FileWriter writeToFile = new FileWriter(file);
            int rowN = Integer.parseInt(rowNum);
            int colN = Integer.parseInt(columnNum);
            int mXn = rowN * colN;
            writeToFile.write(rowN + "\r\n");
            writeToFile.write(colN + "\r\n");
            for (int i = 0; i < rowN; i++) {
                for (int j = 0; j < colN; j++) {
                    writeToFile.write("0", 0, 1);
                }
                writeToFile.write("\r\n");
            }
            writeToFile.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<String> textFiles(String directory) {
        List<String> textFiles = new ArrayList<String>();
        File dir = new File(directory);
        for (File files : dir.listFiles()) {
            if (files.getName().endsWith((".txt"))) {
                textFiles.add(files.getName());
            }
        }
        return textFiles;
    }
    
    public String[] listMatrices() {
        String[] listMatrices = {};
        List<String> textFiles = new ArrayList<String>();
        File dir = new File(directory);
        for (File files : dir.listFiles()) {
            if (files.getName().endsWith((".txt"))) {
                textFiles.add(files.getName());
            }
        }
        if (textFiles.size() > 0) {
            return textFiles.toArray(new String[textFiles.size()]);
        }
        return listMatrices;
    }
    

    public int getNumberOfRows(){
             FileReader matrixName;
        try {
            matrixName = new FileReader(file);
            BufferedReader bufRead = new BufferedReader(matrixName);
            String line;
            try {
                line = bufRead.readLine();
                int rowNum = Integer.parseInt(line);
                return rowNum;
            } catch (IOException ex) {
                Logger.getLogger(ReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
             return 0;
        }
    }

    public int getNumberOfColumns(){
             FileReader matrixName;
        try {
            matrixName = new FileReader(file);
            BufferedReader bufRead = new BufferedReader(matrixName);
            String line;
            try {
                line = bufRead.readLine();
                line = bufRead.readLine();
                int colNum = Integer.parseInt(line);
                return colNum;
            } catch (IOException ex) {
                Logger.getLogger(ReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
             return 0;
        }
    }

    public boolean saveTransposedMatrixToFile(File file, int[][] matrix) {
        try {
            FileWriter writeToFile = new FileWriter(file);
            int rowN = getNumberOfColumns();
            int colN = getNumberOfRows();
            writeToFile.write(rowN + "\r\n");
            writeToFile.write(colN + "\r\n");
            for (int i = 0; i < rowN; i++) {
                for (int j = 0; j < colN; j++) {
                    writeToFile.write(String.valueOf(matrix[i][j]), 0, 1);
                }
                writeToFile.write("\r\n");
            }
            writeToFile.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int[][] transposeRealMatrix() throws IOException {
        int[][] realMatrix = getRealMatrix();
        int numRows = getNumberOfRows();
        int numCols = getNumberOfColumns();
        int[][] transposeMatrix = new int[numCols][numRows];

        for (int i=0; i < numRows; i++) {
            for (int j=0; j < numCols; j++) {
                transposeMatrix[j][i] = realMatrix[i][j];
            }
        }
        return transposeMatrix;
    }

    public int[][] getRealMatrix()throws IOException{
         int[][] dare = new int[5][5];
        try {
        FileReader matrixName = new FileReader(file);
            BufferedReader bufRead = new BufferedReader(matrixName);
            String line;
            line = bufRead.readLine();
            int rowNum = Integer.parseInt(line);
            line = bufRead.readLine();
            int colNum = Integer.parseInt(line);
            
            int[][] realMatrix = new int[rowNum][colNum];
            line = bufRead.readLine();
            int row = 0;
            while (line != null){
                String matrixRow = line.toString();
                for (int i = 0; i < matrixRow.length(); i++) {
                    char c=matrixRow.charAt(i);
                    int b = Character.getNumericValue(c);
                    realMatrix[row][i] = b;
                }
                line = bufRead.readLine();
                row++;
            }


            bufRead.close();
            return realMatrix;
            } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
            return dare;
        }

    }

    public float[] calculateProbability(Object[][] matrix) {
        Object[] dare = new Object[1];
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        Object[] tmpArr = new Object[colNum];
        int[] prob = new int[rowNum];
        int[] rowStat = new int[rowNum];
        apsolutna_verojatnost = "";
        apsolutna_verojatnost_print = "";
        distinctRows = new Object[rowNum][colNum];
        razlicniRedovi = new HashMap();
        int br=0;
        int brojac = 0;
        for(int i = 0;i<rowNum;i++){
            Object[] tmpArr1 = new Object[colNum];
            boolean rowContained = false;
            for(int l = 0;l<rowStat.length;l++){
                if((i+1)==rowStat[l]){
                    rowContained=true;
                }
            }
            if(!rowContained){
                for(int j = 0;j<colNum;j++){
                    tmpArr1[j] = matrix[i][j];
                }
                distinctRows[brojac]=tmpArr1;
                razlicniRedovi.put(brojac, tmpArr1);
                brojac++;
                apsolutna_verojatnost += "P";
                apsolutna_verojatnost_print += "P";
                rowStat[br]=(i+1);
                br++;
                apsolutna_verojatnost+=(i+1);
                apsolutna_verojatnost_print+=(i+1);
            }
            prob[i] = 1;
            for(int j = 0;j<colNum;j++){
                tmpArr[j] = matrix[i][j];
            }
            for(int z = 0;z<rowNum;z++){
                boolean match = true;
                if(z==i){
                    continue;
                }
                for (int q = 0;q<colNum;q++) {
                    if(tmpArr[q]!=matrix[z][q]){
                        match = false;
                        break;
                    }
                }
                if(match){
                    prob[i]+=1;
                    boolean rowContained1 = false;
                    for (int l = 0; l < rowStat.length; l++) {
                        if ((z + 1) == rowStat[l]) {
                            rowContained1 = true;
                        }
                    }
                    if (!rowContained1) {
                        rowStat[br] = (z + 1);
                        apsolutna_verojatnost += ","+(z + 1);
                        apsolutna_verojatnost_print += ","+(z + 1);
                        br++;
                    }
                }
            }
            if(!rowContained){
                float p = (float) prob[i];
                float c = (float) rowNum;
                float r = p/c;
                String format = new DecimalFormat("0.000").format(r);
                apsolutna_verojatnost+="="+format+";<br>";
                apsolutna_verojatnost_print+="="+format+";\r\n";
            }
        }
        float[] probability = new float[rowNum];
        for(int k = 0;k<prob.length;k++){
            float p = (float) prob[k];
            float c = (float) rowNum;
            float r = p/c;
            probability[k] = r;
            //System.out.println("Row" + k + "Se povtoruva:" + prob[k]+". So verojatnost" + prob[k] + "/" + rowNum + "=" +(prob[k]/rowNum));
        }
        return probability;

    }
    public Object[][] getMatrixContent() throws IOException{
         Object[][] dare = new Object[5][5];
        try {
            FileReader matrixName = new FileReader(file);
            BufferedReader bufRead = new BufferedReader(matrixName);
            String line;
            line = bufRead.readLine();
            int rowNum = Integer.parseInt(line);
            line = bufRead.readLine();
            int colNum = Integer.parseInt(line);
            Object[][] matrix = new Object[rowNum][colNum];
            line = bufRead.readLine();
            int row = 0;
            while (line != null){
                String matrixRow = line.toString();
                for (int i = 0; i < matrixRow.length(); i++) {
                    char c=matrixRow.charAt(i);
                    int b = Character.getNumericValue(c);
                    if(b==0){
                        matrix[row][i] = null;

                    }else{
                        matrix[row][i] = b;
                    }
                }
                line = bufRead.readLine();
                row++;
            }


            bufRead.close();
            return matrix;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
            return dare;
        }
    }

    public void promeniJaMatricata(JTable table){
        try {
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
            FileWriter writeToFile = new FileWriter(file);
            writeToFile.write(rowNum + "\r\n");
            writeToFile.write(colNum + "\r\n");
            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    Object tb = table.getValueAt(i, j);
                    String tableValue;
                    if(tb!=null){
                        tableValue = table.getValueAt(i, j).toString();
                    }else{
                        tableValue="";
                    }
                    if("".equals(tableValue) || tableValue==null){
                        tableValue = "0";
                    }else{
                        int hlepInt = Integer.parseInt(tableValue);
                        if(hlepInt>1){
                            tableValue = "1";
                        }
                    }

                    writeToFile.write(tableValue, 0, 1);
                }
                writeToFile.write("\r\n");
            }
            writeToFile.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ZapisiRezultati(JTable table,String matrixN){
        try {
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
            String resultFileName = filename;
            FileWriter writeToFile = new FileWriter("."+File.separator+"Print"+File.separator+filename);
            
            writeToFile.write("Rezultati za matricata: "+matrixN+"\r\n");
            writeToFile.write("____________________________________________________________\r\n");
            writeToFile.write(" \r\n");
            writeToFile.write("Broj na redovi: "+rowNum + "\r\n");
            writeToFile.write("Broj na koloni: "+colNum + "\r\n");
            writeToFile.write("____________________________________________________________\r\n");
            writeToFile.write(" \r\n");
            writeToFile.write("Vlezna Matrica:\r\n");
            writeToFile.write(" \r\n");

            for (int i = 0; i < rowNum; i++) {
                int brupper = i+1;
                if(brupper<10){
                    writeToFile.write("00"+brupper+": ");
                }else if(brupper>=10 && brupper<100){
                    writeToFile.write("0"+brupper+": ");
                }else{
                    writeToFile.write(brupper+": ");
                }
                for (int j = 0; j < colNum; j++) {
                    Object tb = table.getValueAt(i, j);
                    String tableValue;
                    if(tb!=null){
                        tableValue = table.getValueAt(i, j).toString();
                    }else{
                        tableValue="";
                    }
                    if("".equals(tableValue) || tableValue==null){
                        tableValue = "0";
                    }else{
                        int hlepInt = Integer.parseInt(tableValue);
                        if(hlepInt>1){
                            tableValue = "1";
                        }
                    }

                    writeToFile.write(tableValue, 0, 1);
                }
                writeToFile.write("\r\n");
            }
            writeToFile.write("\r\n");
            writeToFile.write("____________________________________________________________\r\n");
            writeToFile.write("\r\n");
            writeToFile.write("Q Matrica:\r\n");
            writeToFile.write("\r\n");
            Object[][] qmatrica = presmetajQMatrica();
            float[] f = getKoeficienti();
            for (int i = 0; i < rowNum; i++) {
                int brupper = i+1;
                if(brupper<10){
                    writeToFile.write("00"+brupper+": ");
                }else if(brupper>=10 && brupper<100){
                    writeToFile.write("0"+brupper+": ");
                }else{
                    writeToFile.write(brupper+": ");
                }
                
                for (int j = 0; j < rowNum; j++) {

                    Object qb = qmatrica[i][j];
                    String tableQValue;
                    if(qb!=null){
                     tableQValue = new DecimalFormat("0.000").format(qb);
                     if("0".equals(tableQValue)){
                        tableQValue="0.000";
                     }
                    }else{

                        tableQValue=" ";
                    }
//                    if(i==j){
//                        tableQValue = new DecimalFormat("0.000").format(f[i]);
//                    }
                 writeToFile.write(tableQValue, 0, tableQValue.length());
                writeToFile.write(" ");
                }
                writeToFile.write("\r\n");
            }
            writeToFile.write("\r\n");
            writeToFile.write("____________________________________________________________\r\n");
            writeToFile.write("\r\n");
//            writeToFile.write("Коефициент на биомеханичка сличност на системот: ");
            writeToFile.write("Koeficient na celosna biomehanicka slicnost (KCBS): ");
            writeToFile.write("\r\n");
            writeToFile.write("Coefficient of full biomechanical similarity (CFBS): ");
            writeToFile.write("\r\n");
            writeToFile.write(koef1());
            writeToFile.write("\r\n");
//            writeToFile.write("Коефициент на соседна биомеханичка сличност:");
            writeToFile.write("Koeficient na sosedna biomehanicka slicnost (KSBS):");
            writeToFile.write("\r\n");
            writeToFile.write("Coefficient of neighboring biomechanical similarity (CNBS): ");
            writeToFile.write("\r\n");
            writeToFile.write(koef2());
            writeToFile.write("\r\n");
            writeToFile.write("Koeficienti na sila na biomehanicka povrzanost (KSBP):");
            writeToFile.write("\r\n");
            writeToFile.write("Coefficient of biomechanical connection force (CBCF):");
            writeToFile.write("\r\n");
            String ksbp;
            for (int i = 0; i < f.length; i++) {
                ksbp = new DecimalFormat("0.000").format(f[i]);
                writeToFile.write(i+1+":   "+ksbp);
                writeToFile.write("\r\n");
            }

            Object[][] matrix = getMatrixContent();
            float[] t = calculateProbability(matrix);
            writeToFile.write("\r\n");
            writeToFile.write("Apsolutna Verojatnost:");
            writeToFile.write("\r\n");
            writeToFile.write("Absolute Probability:");
            writeToFile.write("\r\n");
            writeToFile.write(apsolutna_verojatnost_print);
            writeToFile.write("\r\n");

            HashMap hm = verojatnostNaOdredenaSlicnost(qmatrica, t);
            String vos = convertVerojatnostNOS(hm);
            writeToFile.write("Verojatnost na odredena slicnost:");
            writeToFile.write("\r\n");
            writeToFile.write("Probability of certain affinity:");
            writeToFile.write("\r\n");
            writeToFile.write(vos);
            writeToFile.write("\r\n");
            writeToFile.write("Avto slicnost:");
            writeToFile.write("\r\n");
            writeToFile.write("Auto affinity:");
            writeToFile.write("\r\n");
            writeToFile.write(avtoSlicnost());





            writeToFile.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadWriteText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object[][] presmetajQMatrica() throws IOException{
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
        Object[][] qMatrix = new Object[rowNum][rowNum];
        int[][] realMatrix = getRealMatrix();
        int[][] bMatrix = getBMatrix(realMatrix);
        int[][] cMatrix = getCMatrix(realMatrix, bMatrix);
        float[][] dcMatrix = getDCMatrix(cMatrix);
        float[][] q1Matrix=getQ1Matrix(dcMatrix, cMatrix);
        float[][] qMatrixHelper=getQMatrix(dcMatrix, q1Matrix);
        
            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < rowNum; j++) {
                    float f = qMatrixHelper[i][j];
                    String format = new DecimalFormat("0.000").format(f);
                    f=Float.parseFloat(format);
                    if(j>i){
                        qMatrix[i][j]=null;
                    }else{
                        qMatrix[i][j]=f;
                    }
                }
            }
        return qMatrix;
    }

    public float[][] zemiQMatrica() throws IOException{
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
        float[][] qMatrix = new float[rowNum][rowNum];
        int[][] realMatrix = getRealMatrix();
        int[][] bMatrix = getBMatrix(realMatrix);
        int[][] cMatrix = getCMatrix(realMatrix, bMatrix);
        float[][] dcMatrix = getDCMatrix(cMatrix);
        float[][] q1Matrix=getQ1Matrix(dcMatrix, cMatrix);
        float[][] qMatrixHelper=getQMatrix(dcMatrix, q1Matrix);

            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < rowNum; j++) {
                    float f = qMatrixHelper[i][j];
                    String format = new DecimalFormat("0.000").format(f);
                    f=Float.parseFloat(format);
                    qMatrix[i][j]=f;
                }
            }
        return qMatrix;
    }

    public int[][] getBMatrix(int[][] realMatrix){
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
        int[][] bMatrix = new int[colNum][rowNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                bMatrix[j][i]=realMatrix[i][j];
            }
        }
        return bMatrix;
    }

    public float[][] getDCMatrix(int[][] cMatrix){
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
        float[][] dcMatrix = new float[rowNum][rowNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                dcMatrix[i][j]=0;
                if(i==j){
                    int sqr = cMatrix[i][j]*cMatrix[i][j];
                    float koren = (float) Math.sqrt(cMatrix[i][j]);
                    if(sqr>0){
                        float f = (float) (1.0 / koren);
                        dcMatrix[i][j]=f;
                    }
                }

            }
        }
        return dcMatrix;
    }

    public int[][] getCMatrix(int[][] realMatrix,int[][] bMatrix){
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
        int[][] cMatrix = new int[rowNum][rowNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                cMatrix[i][j]=0;
            }
        }
        for (int i = 0; i < rowNum; i++) {
            for (int k = 0; k < rowNum; k++) {
                for (int j = 0; j < colNum; j++) {
                    cMatrix[i][k]=cMatrix[i][k] + realMatrix[i][j]*bMatrix[j][k];
                }
            }
        }
        return cMatrix;
    }
    public float[][] getQ1Matrix(float[][] dcMatrix,int[][] cMatrix){
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
        float[][] q1Matrix = new float[rowNum][rowNum];
        for (int i = 0; i < rowNum; i++) {
            for (int k = 0; k < rowNum; k++) {
                 q1Matrix[i][k]=0;
                for (int j = 0; j < rowNum; j++) {
                    q1Matrix[i][k]=q1Matrix[i][k]+dcMatrix[i][j]*cMatrix[j][k];
                }
            }
        }
        return q1Matrix;
    }
    public float[][] getQMatrix(float[][] dcMatrix,float[][] q1Matrix){
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
        float[][] qMatrix = new float[rowNum][rowNum];
        for (int i = 0; i < rowNum; i++) {
            for (int k = 0; k < rowNum; k++) {
                qMatrix[i][k]=0;
                for (int j = 0; j < rowNum; j++) {
                    qMatrix[i][k]=qMatrix[i][k] + q1Matrix[i][j]*dcMatrix[j][k];
                }
            }
        }
        return qMatrix;
    }

    public String koef1() throws IOException{
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
        float[][] qMatrix = zemiQMatrica();
        float e = 0;
        for (int i = 0; i < rowNum-1; i++) {
            for (int j = 1+i; j < rowNum; j++) {
                e = e + qMatrix[j][i];
            }
        }
        float p = rowNum*(rowNum-1)/2;
        float k=0;
        if(p>0){
         k=e/p;
        }
        String koef = new DecimalFormat("0.000").format(k);
        return koef;
    }
    public String koef2() throws IOException{
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
        float[][] qMatrix = zemiQMatrica();
        float e = 0;
        for (int i = 0; i < rowNum-1; i++) {
            e = e + qMatrix[i+1][i];
        }
        float k=0;

         k=e/(rowNum-1);

        String koef = new DecimalFormat("0.000").format(k);
        return koef;
    }
    public String koef3() throws IOException{
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
        float[][] qMatrix = zemiQMatrica();
        float[] h = new float[rowNum];
        float[] f = new float[rowNum];
        for (int i = 0; i < rowNum; i++) {
            h[i]=0;
            for (int j = 0; j < rowNum; j++) {
                 h[i] = h[i]+qMatrix[j][i];
            }
            f[i] = (h[i]-1)/(rowNum-1);
        }
        
        String koef = "";
        Integer brojac=1;
        for (int i = 0; i < f.length; i++) {
             String format = new DecimalFormat("0.000").format(f[i]);
            koef =koef+" "+brojac.toString()+": "+format+"\n";
            brojac++;
        }
        return koef;
    }
    public float[] getKoeficienti() throws IOException{
        int rowNum = getNumberOfRows();
        int colNum = getNumberOfColumns();
        float[][] qMatrix = zemiQMatrica();
        float[] h = new float[rowNum];
        float[] f = new float[rowNum];
        for (int i = 0; i < rowNum; i++) {
            h[i]=0;
            for (int j = 0; j < rowNum; j++) {
                 h[i] = h[i]+qMatrix[j][i];
            }
            f[i] = (h[i]-1)/(rowNum-1);
        }

        String koef = "";
        Integer brojac=1;
        for (int i = 0; i < f.length; i++) {
            String format = new DecimalFormat("0.000").format(f[i]);
            koef =koef+" "+brojac.toString()+": "+format+"\n";
            brojac++;
        }
        return f;
    }

    public String apsolutnaVerojatnost(float[] matrix){
        String apVer = "";
        Integer br = 1;
        
        for(int i = 0; i<matrix.length; i++){
            String format = new DecimalFormat("0.000").format(matrix[i]);
            apVer = apVer + "P" + br.toString()+": " + format+"; ";
            br++;
        }
        return apVer;
    }

    public HashMap verojatnostNaOdredenaSlicnost(Object[][] qmatrix,float[] verojatnost){
        String vos = "";
        ArrayList arList = new ArrayList();
        HashMap probMap = new HashMap();
        for(int i = 0;i<qmatrix.length;i++){
            for(int j = 0;j<qmatrix[0].length;j++){
                if(j<=i){
                    Object curEl = qmatrix[i][j];
                    curEl = curEl.toString();
                    
                    if(!arList.contains(qmatrix[i][j])){
                        arList.add(qmatrix[i][j]);
                        System.out.println("____________________________________");
                        System.out.println("Element:"+qmatrix[i][j]);
                        float probability = 0;
                        for(int k = 0;k<qmatrix.length;k++){
                            for(int z = 0;z<qmatrix[0].length;z++){
                                if(z<=k){
                                    if(curEl.equals(qmatrix[k][z].toString())){
                                        probability = probability + 1;
                                    }
                                }
                            }
                        }
                        probability = probability/(((qmatrix.length*qmatrix.length-qmatrix.length)/2)+qmatrix.length);
                        probMap.put(curEl, probability);
                    }
                }
            }
        }
        return probMap;
    }

    public String convertVerojatnostNOS(HashMap verojatnost){
        String str = "";
        Set set = verojatnost.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            String format = new DecimalFormat("0.000").format(me.getValue());
            str = str + "P(q="+me.getKey()+")="+format+"\n";
        }
        
        return str;
    }

    public String getApsolutnaVerojatnost(){
        return apsolutna_verojatnost;
    }

    public String avtoSlicnost() throws IOException{
        float[][] qmatrix = zemiQMatrica();
        int qSize = qmatrix.length;
        float[] avtoSlicnost = new float[qSize];
        for(int i=0;i<qSize;i++){
            avtoSlicnost[i]=0;
            for(int j=i;j<qSize;j++){
                for(int z=0;z<qSize;z++){
                    if(z>j){
                        continue;
                    }
                    if((j-z)==i){
                        avtoSlicnost[i]+=qmatrix[j][z];
                    }

                }

            }
        }
        float[] realAvtoSl = new float[qSize];
        String str = "";
        for(int l=0;l<qSize;l++){
            realAvtoSl[l]= avtoSlicnost[l]/(qSize-l);
            String format = new DecimalFormat("0.000").format(realAvtoSl[l]);
            str = str + "As(q="+(l+1)+")="+format+"\n";
        }
        return str;
    }

    public void presmetajPremini(Object[][] matrix){
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        
        Set set = razlicniRedovi.entrySet();
        Iterator it = set.iterator();
        
        int[][] broj_sosedi = new int[razlicniRedovi.size()][razlicniRedovi.size()];
        
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            Integer key = (Integer)me.getKey();
            Object[] obj = (Object[])me.getValue();
            
            HashMap hm = new HashMap();
        
            int[] test = new int[razlicniRedovi.size()];
            for (int k = 0; k < rowNum; k++) {
                Object[] tmpArr = new Object[colNum];

                for (int j = 0; j < colNum; j++) {
                    tmpArr[j] = matrix[k][j];
                }
                if(Arrays.equals(obj, tmpArr)){
//                    test[key] +=1;
//                    broj_sosedi[key]=test;
//                    ss[key]+=1;
                    if(!daliEPosledenRed(k, rowNum)){
                        Object[] sosed = new Object[colNum];
                        for (int j = 0; j < colNum; j++) {
                            sosed[j] = matrix[k+1][j];
                        }
//                        if(Arrays.equals(obj, sosed)){
//                            continue;
//                        }
                        Set tmpSet = razlicniRedovi.entrySet();
                        Iterator tmpIt= tmpSet.iterator();
                        Integer sosedKey = -1;
                        while(tmpIt.hasNext()){
                            Map.Entry tmpMe = (Map.Entry)tmpIt.next();
                            Integer tmpKey = (Integer)tmpMe.getKey();
                            Object[] tmpObj = (Object[])tmpMe.getValue();
                            if(Arrays.equals(tmpObj, sosed)){
                                sosedKey = tmpKey;
                                break;
                            }
                        }
                        
                        if(hm.size()>0){
                            Set hmSet = hm.entrySet();
                            Iterator hmIt= hmSet.iterator();
                            boolean found = false;
                            while(hmIt.hasNext()){
                                Map.Entry hmMe = (Map.Entry)hmIt.next();
                                Integer hmKey = (Integer)hmMe.getKey();
                                Object[] hmObj = (Object[])hmMe.getValue();
                                if(Arrays.equals(hmObj, sosed)){
                                    test[sosedKey] +=1;
                                    broj_sosedi[key]=test;
//                                    broj_sosedi[key][sosedKey]+=1;
                                    found =true;
                                    break;
                                }
                                
                            }
                            if(!found){
                                hm.put(sosedKey, sosed);
                                test[sosedKey] +=1;
                                broj_sosedi[key]=test;
                            }
                        }else{
                            hm.put(sosedKey, sosed);
                            test[sosedKey] +=1;
                            broj_sosedi[key]=test;
//                            broj_sosedi[key][sosedKey]+=1;
                        }
                        
                    }
                }

            }
        }
        
        int dist = razlicniRedovi.size();
        int N = vrski_izmegju(broj_sosedi);
        verojatnost_na_ostanuvanje = "";
        verojatnost_na_premin = "";
        float v_premin_sum = 0;
        for(int p=0;p<dist;p++){
            //System.out.println("Sam vo sebe red:"+p+"-"+ss[p]);
            //System.out.println("red:"+p);
            for(int u=0;u<dist;u++){
                float v_ostan = 0;
                float v_premin = 0;
                int b = broj_sosedi[p][u];
                v_ostan = (float)b/N;
                v_premin =(float)(1 - v_ostan);
                v_premin_sum += v_premin;
                String format_ostan = new DecimalFormat("0.000").format(v_ostan);
                String format_premin = new DecimalFormat("0.000").format(v_premin);
                verojatnost_na_ostanuvanje+="P["+p+"]["+u+"] = "+format_ostan+"\n";
                verojatnost_na_premin+="P["+p+"]["+u+"] = "+format_premin+"\n";
            }
        }
        float difuz = 0;
        difuz = (float)v_premin_sum/(dist*dist);
        String format_difuz = new DecimalFormat("0.000").format(difuz);
        difuzija = format_difuz;
        System.out.println(verojatnost_na_premin);
        System.out.println("Difuzija: D = " + format_difuz);
    }

    public int vrski_izmegju(int[][] broj_sosedi){
        int dist = razlicniRedovi.size();
        int N = 0;
        for(int p=0;p<dist;p++){
            //System.out.println("Sam vo sebe red:"+p+"-"+ss[p]);
            //System.out.println("red:"+p);
            String distinct = "";
            for(int u=0;u<dist;u++){
                N+=broj_sosedi[p][u];
                distinct+="["+p+"]["+u+"] = "+broj_sosedi[p][u]+";";
            }
        }
        return N;
    }

    public boolean proveriIstiRedovi(Object[] red1, Object[] red2, int colNum) {
        boolean match = true;
        for (int q = 0; q < colNum; q++) {
            if (red1[q] != red2[q]) {
                match = false;
                break;
            }
        }
        return match;
    }
    /**
     * Proveruva dali konkreten red se pojavuva vo niza od redovi.
     * @return
     */
    public boolean proveriIstiRedoviVoNiza(Object[] red1, Object[][] allRows, int colNum){
        boolean match = false;
        if(allRows!=null){
            for(int n=0;n<allRows.length;n++){
                if(allRows[n]!=null){
                    if(proveriIstiRedovi(red1, allRows[n], colNum)){
                        match = true;
                        break;
                    }
                }
            }
        }
        return match;
    }
    public int proveriIstiSosediVoNiza(Object[] red1, Object[][] allRows, int colNum){
        boolean match = false;
        if(allRows!=null){
            for(int m=0;m<allRows.length;m++){
                if(allRows[m]!=null){
                    if(proveriIstiRedovi(red1, allRows[m], colNum)){
                        match = true;
                        return m;
                    }
                }
            }
        }
        return -1;
    }

    public boolean daliEPosledenRed(int currentRow, int nbrRows){
        if((currentRow+1)==nbrRows){
            return true;
        }
        return false;
    }

    public void verojatnostNaSosednaDistanca() throws IOException{
        float[][] qmatrix = zemiQMatrica();
        int qSize = qmatrix.length;
        Vector v = new Vector();
        for(int i = 1;i<qSize;i++){
            float curEl = 0;
            curEl = qmatrix[i][i-1];
            v.add(curEl);
        }
        verojatnost_na_distanca = "";
        Vector tmpV = new Vector();
        for(int j=0;j<v.size();j++){
            int br = 0;
            if(tmpV.contains(v.elementAt(j))){
                continue;
            }
            float elem = Float.parseFloat(v.elementAt(j).toString());
            for(int p=0;p<v.size();p++){
                if(v.elementAt(j).equals(v.elementAt(p))){
                    br++;
                }
            }
            tmpV.add(v.elementAt(j));
            

            float d = 1-elem;
            float v_distanca = (float)br/(qSize-1);
            String formatD = new DecimalFormat("0.000").format(d);
            String formatV = new DecimalFormat("0.000").format(v_distanca);
            verojatnost_na_distanca += "P("+formatD+")="+formatV+"\n";
        }
    }

    

}
