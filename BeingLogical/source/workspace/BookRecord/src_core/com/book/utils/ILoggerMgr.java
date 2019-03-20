package com.book.utils;

public interface ILoggerMgr {
//	/**
//     * Priority constant for the println method; use Log.v.
//     */
//    public static final int VERBOSE = 2;
//
//    /**
//     * Priority constant for the println method; use Log.d.
//     */
//    public static final int DEBUG = 3;
//
//    /**
//     * Priority constant for the println method; use Log.i.
//     */
//    public static final int INFO = 4;
//
//    /**
//     * Priority constant for the println method; use Log.w.
//     */
//    public static final int WARN = 5;
//
//    /**
//     * Priority constant for the println method; use Log.e.
//     */
//    public static final int ERROR = 6;
//
//    /**
//     * Priority constant for the println method.
//     */
//    public static final int ASSERT = 7;

	enum Level{
		VERBOSE(2), DEBUG(3), INFO(4), WARN(5), ERROR(6), ASSERT(7);
		Level(int value){
			this.mValue = value;
		}
		private final int mValue;
		public int getValue() {
			return this.mValue;
		}
	};
	void debug(String msg);
	void debug(String msg, Throwable error);
	void debug(String msg, Object... args);
	void info(String msg);
	void info(String msg, Throwable error);
	void info(String msg, Object... args);
	void warn(String msg);
	void warn(String msg, Throwable error);
	void warn(String msg, Object... args);
	void error(String msg);
	void error(String msg, Throwable error);
	void error(String msg, Object... args);
	void setLevel(Level level);
	Level getLevel();
}
