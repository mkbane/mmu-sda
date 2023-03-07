public abstract class Accommodation {

    // 'bridge' to implementation
    protected MaterialsService materialType;
    
    // superclass of House, Flat
    public Accommodation(String plan) {
	System.out.println("...there was a plan to build a " + plan);
    }

    public abstract void build();

    public void setMaterialType(MaterialsService materialType) {
	this. materialType = materialType;
    }
}
