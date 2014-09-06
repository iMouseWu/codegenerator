package generator.inter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.ModelBean;
import utils.FileUtils;
import utils.FreeMarkerUtils;
import utils.Property;
import freemarker.template.Configuration;
import freemarker.template.Template;

public abstract class Builder {

	private ModelBean model;
	private String filePath;

	public String getFilePath() {
		return Property.getInstance().getFilePath();
	}

	public String getClassName() {
		return model.getClassName();
	}

	public ModelBean getModel() {
		return model;
	}

	public void setModel(ModelBean model) {
		this.model = model;
	}

	public Configuration initConfiguration() {
		File file = new File("/resources/template");
		Configuration cfg = new Configuration();
		try {
			cfg.setDirectoryForTemplateLoading(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cfg;
	}

	public void writeFile(String content, String filePath) {
		try {
			if (FileUtils.createFile(filePath)) {
				FileWriter fileWriter = new FileWriter(filePath, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(content);
				bufferedWriter.close();
				fileWriter.close();
			} else {
				// TODO
				// logger.info("生成失败，文件已存在！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract Template builderTemplate();

	public abstract void builderFile(String content);

	public void outputFile() {
		Template template = builderTemplate();
		String content = FreeMarkerUtils.renderTemplate(template, model);
		builderFile(content);
	}
}
