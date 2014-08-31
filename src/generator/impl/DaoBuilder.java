package generator.impl;

import java.io.IOException;

import model.Context;
import freemarker.template.Template;
import generator.inter.Builder;
import generator.inter.Chain;

public class DaoBuilder extends Builder implements Chain {

	private Chain chain;

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
		String filePath = getFilePath() + getClassName() + ".java";
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
		chain.doNext(context);
	}

}
