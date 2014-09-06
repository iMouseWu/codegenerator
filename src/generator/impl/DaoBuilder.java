package generator.impl;

import java.io.IOException;

import utils.Property;
import model.Context;
import freemarker.template.Template;
import generator.inter.Builder;
import generator.inter.Chain;

public class DaoBuilder extends Builder implements Chain {

	private Chain chain;
	private boolean isNeedBuild;

	@Override
	public Template builderTemplate() {
		Template template = null;
		try {
			template = initConfiguration().getTemplate("dao.ftl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return template;
	}

	@Override
	public void builderFile(String content) {
		String filePath = getFilePath() + getClassName() + "DAO.java";
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
		return Property.getInstance().getDaoPackage();
	}

}
