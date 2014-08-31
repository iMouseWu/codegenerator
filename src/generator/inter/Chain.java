package generator.inter;

import model.Context;

public interface Chain {

	void setNext(Chain chain);

	void doNext(Context context);

}
