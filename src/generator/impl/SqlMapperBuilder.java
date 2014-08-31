package generator.impl;

import java.io.IOException;

import freemarker.template.Template;
import generator.inter.Builder;

public class SqlMapperBuilder extends Builder {

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

}
