import by.gsu.pmslab.MaterialUniform;
import by.gsu.pmslab.SubjectMaterialUniform;

public class Runner {
    public static void main(String[] args) {
        SubjectMaterialUniform wire = new SubjectMaterialUniform(MaterialUniform.STEEL,"Wire",0.03);

        System.out.println(wire);

        wire.setMaterial(MaterialUniform.COPPER);
        System.out.println("Copper mass = "+ wire.getMass());

        wire.setMaterial(MaterialUniform.STEEL);
        System.out.println(wire);
    }
}