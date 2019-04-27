package by.gsu.pmslab;

public enum MaterialUniform {
    STEEL("Steel", 7850),
    COPPER("Cooper", 8500);
    private String materialName;
    private int density;

    MaterialUniform() {
        this.materialName = null;
        this.density = 0;
    }

    MaterialUniform(String materialName,int density){
        this.materialName = materialName;
        this.density = density;
    }

    public String getMaterialName(){
        return materialName;
    }
    public void setMaterialName(String materialName){
        this.materialName = materialName;
    }

    public int getDensity() {
        return density;
    }
    public void setDensity(int density) {
        this.density = density;
    }

    @Override
    public String toString(){
        return materialName+";"+density;
    }
}
