package generator.impl;

import freemarker.template.Template;
import generator.inter.Builder;
import generator.inter.Chain;

import java.io.IOException;

import model.Context;

public class SqlMapperBuilder extends Builder implements Chain {

	private Chain chain;
	private boolean isNeedBuild;

	@Override
	public Template builderTemplate() {
		Template template = null;
		try {
			template = initConfiguration().getTemplate("mybatisMapper.ftl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return template;
	}

	@Override
	public void builderFile(String content) {
		String filePath = getFilePath() + getClassName() + ".xml";
		writeFile(content, filePath);

	}

	@Override
	public void setNext(Chain chain) {
		this.chain = chain;
	}

	@Override
	public void doNext(Context context) {
		this.setModel(context.getModel());
		this.outputFile();
		// chain.doNext(context);
	}

	@Override
	public boolean isNeedBuild() {
		return this.isNeedBuild;
	}

	@Override
	public void setNeedBuild(boolean isNeed) {
		this.isNeedBuild = isNeed;
	}

}
