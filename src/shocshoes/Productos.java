 
package shocshoes;

 
public class Productos {
    public String modelo;
    public int modeloSKU;
    public double talla;
    
    
    public Productos(String modelo, double talla, int modeloSKU) {
        this.modelo = modelo;
        this.talla = talla;
        this.modeloSKU = modeloSKU;
    }
    
    public Productos(int modeloSKU) {
        this.modeloSKU = modeloSKU;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }
    
    public int getmodeloSKU() {
        return modeloSKU;
    }

    public void setModeloSku(int modeloSKU) {
        this.modeloSKU = modeloSKU;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo + ", SKU: " + modeloSKU + ", Talla: " + talla;
    }
    
    
    
    
    
}
