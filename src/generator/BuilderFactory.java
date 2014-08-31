package generator;

import generator.impl.DaoBuilder;
import generator.impl.DomainBuilder;
import generator.impl.SqlMapperBuilder;
import generator.inter.Chain;
import utils.constant.BuilderEnum;

public class BuilderFactory {

	public static Chain createBuilder(BuilderEnum builderEnum) {
		switch (builderEnum) {
			case BUILDER_DAO:
				return new DaoBuilder();
			case BUILDER_DOMAIN:
				return new DomainBuilder();
			case BUILDER_SQLMAPPER:
				return new SqlMapperBuilder();
			default:
				return null;
		}

	}
}
