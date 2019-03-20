package com.book.utils;

import java.text.SimpleDateFormat;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;

public class LoggerMgrImpl implements ILoggerMgr {
	
	private static volatile LoggerMgrImpl instance;
	private Level mLevel = Level.DEBUG;
	private LoggerMgrImpl() {
	}

	public static ILoggerMgr getInstance() {
		if (instance == null) {
			instance = new LoggerMgrImpl();
		}
		return instance;
	}
	
	private String createTag() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        }
        for (StackTraceElement st : sts) {
            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (st.getClassName().equals(Logger.class.getName())) {
                continue;
            }
            return st.getLineNumber() + ":" + st.getFileName();
        }
        return "";
    }

	@Override
	public void debug(String msg) {
		printerLog(Level.DEBUG, msg, (Throwable)null);
	}

	@Override
	public void debug(String msg, Throwable error) {
		printerLog(Level.DEBUG, msg, error);
	}

	@Override
	public void debug(String msg, Object... args) {
		printerLog(Level.DEBUG, msg, args);
	}

	@Override
	public void info(String msg) {
		printerLog(Level.INFO, msg, (Throwable)null);
	}

	@Override
	public void info(String msg, Throwable error) {
		printerLog(Level.INFO, msg, error);
		
	}

	@Override
	public void info(String msg, Object... args) {
		printerLog(Level.INFO, msg, args);
		
	}

	@Override
	public void warn(String msg) {
		printerLog(Level.WARN, msg, (Throwable)null);
	}

	@Override
	public void warn(String msg, Throwable error) {
		printerLog(Level.WARN, msg, error);
		
	}

	@Override
	public void warn(String msg, Object... args) {
		printerLog(Level.WARN, msg, args);
		
	}

	@Override
	public void error(String msg) {
		printerLog(Level.ERROR, msg, (Throwable)null);
		
	}

	@Override
	public void error(String msg, Throwable error) {
		printerLog(Level.ERROR, msg, error);
	}


	@Override
	public void error(String msg, Object... args) {
		printerLog(Level.ERROR, msg, args);
		
	}

	@Override
	public void setLevel(Level level) {
		this.mLevel = level;
	}

	@Override
	public Level getLevel() {
		return mLevel;
	}
	
	private void printerLog(Level level, String msg, Throwable error) {
		if(isOutputLog(level)) {
			String tag = createTag();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
			String time = sdf.format(System.currentTimeMillis());
			if(error != null) {
				msg = msg + error.getMessage();
			}
			if(level.equals(Level.DEBUG)) {
				System.out.println(String.format("%s\t%s\t%s", time, tag, msg));
			}else if(level.equals(Level.ERROR)) {
				System.err.println(String.format("%s\t%s\t%s", time, tag, msg));
			}else {
				System.out.println(String.format("<--%s-->%s\t%s\t%s", level, time, tag, msg));
			}
			
			if(error != null) {
				error.printStackTrace();
			}
		}
		
	}
	
	private void printerLog(Level level, String msg, Object... args) {
		if(isOutputLog(level)) {
			String tag = createTag();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
			String time = sdf.format(System.currentTimeMillis());
			if(level.equals(Level.DEBUG)) {
				System.out.println(String.format("%s\t%s\t%s", time, tag, msg, args));
			}else if(level.equals(Level.ERROR)) {
				System.err.println(String.format("%s\t%s\t%s", time, tag, msg, args));
			}else {
				System.out.println(String.format("<--%s-->%s\t%s\t%s", level, time, tag, msg, args));
			}
		}
		
	}
	
	private boolean isOutputLog(Level level) {
		if(this.mLevel.getValue() <= level.getValue()) {
			return true;
		}
		return false;
	}
	
}
