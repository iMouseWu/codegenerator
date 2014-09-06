package generator.inter;

import model.Context;

public interface Chain {

	boolean isNeedBuild();

	void setNeedBuild(boolean isNeed);

	void setNext(Chain chain);

	void doNext(Context context);

}
