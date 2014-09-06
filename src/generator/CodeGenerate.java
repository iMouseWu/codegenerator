/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package generator;

import generator.impl.DomainBuilder;
import generator.inter.Builder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.ModelBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.DatebaseUtils;
import utils.FileUtils;

public class CodeGenerate {

	private static Logger logger = LoggerFactory.getLogger(CodeGenerate.class);

	// public static void main(String[] args) throws Exception {
	//
	// // ========== ↓↓↓↓↓↓ 执行前请修改参数，谨慎执行。↓↓↓↓↓↓ ====================
	//
	// // 主要提供基本功能模块代码生成。
	// //
	// 目录生成结构：{packageName}/{moduleName}/{dao,entity,service,web}/{subModuleName}/{className}
	//
	// // packageName
	// //
	// 包名，这里如果更改包名，请在applicationContext.xml和srping-mvc.xml中配置base-package、packagesToScan属性，来指定多个（共4处需要修改）。
	// String packageName = "com.cy.test";
	// String classAuthor = "cy"; // 类作者，例：ThinkGem
	//
	// // 是否启用生成工具
	// Boolean isEnable = true;
	//
	// // ========== ↑↑↑↑↑↑ 执行前请修改参数，谨慎执行。↑↑↑↑↑↑ ====================
	//
	// if (!isEnable) {
	// logger.error("请启用代码生成工具，设置参数：isEnable = true");
	// return;
	// }
	//
	// // 获取文件分隔符
	// String separator = File.separator;
	// //
	// // // 获取工程路径
	// File projectPath = new DefaultResourceLoader().getResource("").getFile();
	// while (!new File(projectPath.getPath() + separator + "src" + separator +
	// "main").exists()) {
	// projectPath = projectPath.getParentFile();
	// }
	// logger.info("Project Path: {}", projectPath);
	//
	// // 模板文件路径
	// String tplPath = StringUtils.replace(projectPath +
	// "/src/main/java/com/cy/codegenerator/generator/template", "/",
	// separator);
	//
	// logger.info("Template Path: {}", tplPath);
	//
	// // Java文件路径
	// String javaPath = StringUtils.replaceEach(projectPath + "/src/main/java/"
	// + StringUtils.lowerCase(packageName), new String[] { "/", "." }, new
	// String[] { separator, separator });
	// logger.info("Java Path: {}", javaPath);
	// // 代码模板配置
	// Configuration cfg = new Configuration();
	// cfg.setDirectoryForTemplateLoading(new File(tplPath));
	//
	// // 定义模板变量
	// Map<String, Object> model = Maps.newHashMap();
	// ModelBean mb = DatabaseMetadata.selectModelBean("test",
	// "goods_product_sku");
	// mb.setPackageUrl("com.cy.test");
	// // 生成 Entity
	// Template template = cfg.getTemplate("domain.ftl");
	// model.put("modelBean", mb);
	// String content = FreeMarkerUtils.renderTemplate(template, model);
	// String filePath = "D:" + separator + "cy" + separator + mb.getClassName()
	// + ".java";
	// System.err.println(filePath);
	//
	// writeFile(content, filePath);
	// logger.info("domain: {}", filePath);
	// // 生成 Mapper
	// template = cfg.getTemplate("mybatisMapper.ftl");
	// content = FreeMarkerUtils.renderTemplate(template, model);
	// // System.err.println(content);
	// filePath = "D:" + separator + "cy" + separator + mb.getClassName() +
	// ".xml";
	// writeFile(content, filePath);
	// logger.info("Generate Success.");
	// }

	/**
	 * 将内容写入文件
	 * 
	 * @param content
	 * @param filePath
	 */
	public static void writeFile(String content, String filePath) {
		try {
			if (FileUtils.createFile(filePath)) {
				FileWriter fileWriter = new FileWriter(filePath, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(content);
				bufferedWriter.close();
				fileWriter.close();
			} else {
				logger.info("生成失败，文件已存在！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		Builder builder = new DomainBuilder();
		List<ModelBean> list = DatebaseUtils.gainModelBean();
		for (ModelBean model : list) {
			Map<String, Object> modelMap = new HashMap<String, Object>();
			modelMap.put("modelBean", model);
			builder.setModel(modelMap);
			builder.outputFile();
		}

		// String aString = new
		// DefaultResourceLoader().getResource("").getFile().getPath();
		// System.out.println(aString);
		// String b = System.getProperty("user.dir");
		// System.out.println(b);
		// G:\MyProject\codegenerator\resources\config.properties
		// String e =
		// "G:\\MyProject\\codegenerator\\resources\\config.properties";
		// File file = new File(e);
		// System.out.println(file.exists());
		// FileUtils.loadPropertiesByCurrentThread("G:\\MyProject\\codegenerator\\resources\\config.properties");

		// System.out.println(CodeGenerate.class.getResource("/resources/config.properties").getFile());

		// InputStream inp =
		// Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/config.properties");
		// System.out.println(inp);
	}
}
