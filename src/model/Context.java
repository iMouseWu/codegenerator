package model;

public class Context {

	private ModelBean model;

	public Context(){
		super();
	}

	public Context(ModelBean model){
		this.model = model;
	}

	public ModelBean getModel() {
		return model;
	}

	public void setModel(ModelBean model) {
		this.model = model;
	}

}
