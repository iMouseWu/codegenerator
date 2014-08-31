package generator.impl;

import freemarker.template.Template;
import generator.inter.Builder;

import java.io.IOException;

public class DomainBuilder extends Builder {

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
		String filePath = getFilePath() + getClassName() + ".java";
		writeFile(content, filePath);
	}
}
