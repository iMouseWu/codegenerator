package generator;

import generator.inter.Chain;

import java.util.List;

import model.Context;
import model.ModelBean;
import utils.DatebaseUtils;
import utils.Property;
import utils.constant.BuilderEnum;

public class Facade {

	public static void generatorCode() {
		Property property = Property.getInstance();
		List<ModelBean> list = DatebaseUtils.gainModelBean();
		for (ModelBean model : list) {
			Context context = new Context(model);
			Chain domianChain = BuilderFactory.createBuilder(BuilderEnum.BUILDER_DOMAIN);
			domianChain.setNeedBuild(property.getIsNeedDomain());

			Chain daoChain = BuilderFactory.createBuilder(BuilderEnum.BUILDER_DAO);
			daoChain.setNeedBuild(property.getIsNeedDao());

			Chain sqlChain = BuilderFactory.createBuilder(BuilderEnum.BUILDER_SQLMAPPER);
			sqlChain.setNeedBuild(property.getIsNeedSqlmapper());

			domianChain.setNext(daoChain);
			daoChain.setNext(sqlChain);
			domianChain.doNext(context);
		}
	}
}
