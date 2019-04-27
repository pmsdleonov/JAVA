package by.gsu.pmslab;

public class SubjectMaterialUniform {
    private String name;
    private MaterialUniform material;
    private double volume;

    public SubjectMaterialUniform(MaterialUniform material, String name, double volume){
        this.material = material;
        this.name = name;
        this.volume = volume;
    }

    public String getName(){
        return name;
    }


    public MaterialUniform getMaterial(){
        return material;
    }
    public void setMaterial(MaterialUniform material) {
        this.material = material;
    }


    public double getMass(){
        return volume * material.getDensity();
    }

    @Override
    public String toString(){
        return name+";"+material+";"+volume+";"+getMass();
    }
}