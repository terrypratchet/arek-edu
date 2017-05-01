package nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SciptEngingJava {

	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine  se = sem.getEngineByName("nashorn");

		Object result  = se.eval("");
	}

}
