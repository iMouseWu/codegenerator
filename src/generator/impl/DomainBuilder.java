package generator.impl;

import freemarker.template.Template;
import generator.inter.Builder;
import generator.inter.Chain;

import java.io.IOException;

import utils.Property;
import model.Context;
import model.ModelBean;

public class DomainBuilder extends Builder implements Chain {

	// public ModelBean getMb() {
	// super.getMb().setPackageName(Property.getInstance().getDomainPackage());
	// return super.getMb();
	// }

	private Chain chain;
	private boolean isNeedBuild;

	@Override
	public Template builderTemplate() {
		Template template = null;
		try {
			template = initConfiguration().getTemplate("domain.ftl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return template;
	}

	@Override
	public void builderFile(String content) {
		String filePath = getFilePath() + getClassName() + "DO.java";
		writeFile(content, filePath);
	}

	@Override
	public void setNext(Chain chain) {
		this.chain = chain;

	}

	@Override
	public void doNext(Context context) {
		if (isNeedBuild()) {
			this.setModel(context.getModel());
			this.outputFile();
		}
		chain.doNext(context);
	}

	@Override
	public boolean isNeedBuild() {
		return this.isNeedBuild;
	}

	@Override
	public void setNeedBuild(boolean isNeed) {
		this.isNeedBuild = isNeed;
	}

	@Override
	public String getPackageName() {
		return Property.getInstance().getDomainPackage();
	}
}
