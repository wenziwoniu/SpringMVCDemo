package net.spring.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 日期操作功能类.
 */
public final class DateUtils {

	/**
	 * 进行日期转换时支持的日期格式
	 */
	public static final String[] parsePatterns = { "yyyy/MM/dd", "yyyy-MM-dd",
			"yyyy-M-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss",
			"yyyy-MM-dd'T'HH:mm", "yyyy-MM-dd HH:mm:ss.SSS", "yyyy年MM月",
			"yyyy年MM月dd日" };

	/**
	 * 按照指定的日期格式常量数组定义的日期格式转化日期
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String dateStr) throws ParseException {
		return org.apache.commons.lang.time.DateUtils.parseDate(dateStr,
				parsePatterns);
	}

	/**
	 * 判断字符串是否是有效的日期， 格式"yyyy-MM-dd,yyyy-MM-d,yyyy-M-dd,yyyy-M-d
	 * "yyyy/MM/dd,yyyy/MM/d,yyyy/M/dd,yyyy/M/d" "yyyyMMdd"
	 * 
	 * @param date
	 *            日期字符串
	 * @return 是则返回true，否则返回false
	 */
	public static boolean isValidDate(String date) {
		if ((date == null) || (date.length() < 8)) {
			return false;
		}
		try {
			boolean result = false;
			SimpleDateFormat formatter;
			char dateSpace = date.charAt(4);
			String format[];
			if ((dateSpace == '-') || (dateSpace == '/')) {
				format = new String[4];
				String strDateSpace = Character.toString(dateSpace);
				format[0] = "yyyy" + strDateSpace + "MM" + strDateSpace + "dd";
				format[1] = "yyyy" + strDateSpace + "MM" + strDateSpace + "d";
				format[2] = "yyyy" + strDateSpace + "M" + strDateSpace + "dd";
				format[3] = "yyyy" + strDateSpace + "M" + strDateSpace + "d";
			} else {
				format = new String[1];
				format[0] = "yyyyMMdd";
			}

			for (int i = 0; i < format.length; i++) {
				String aFormat = format[i];
				formatter = new SimpleDateFormat(aFormat);
				formatter.setLenient(false);
				String tmp = formatter.format(formatter.parse(date));
				if (date.equals(tmp)) {
					result = true;
					break;
				}
			}
			return result;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否是有效的日期，格式"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param date
	 *            日期字符串
	 * @return 是则返回true，否则返回false
	 */
	public static boolean isValidTime(String date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			formatter.setLenient(false);
			formatter.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	/**
	 * 功能 : 将String类型的日期解析为指定格式的Date类型的日期
	 * 开发：zwwang 2015-5-13 下午5:04:07
	 * @param date
	 * @param formatType
	 * @return
	 * @throws ParseException
	 */
	public static Date parseString(String date, String formatType) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		return formatter.parse(formatter.format(parseDate(date)));
	}
	/**
	 * 功能 : 将日期解析为指定格式的Date类型的日期
	 * 开发：zwwang 2015-5-13 下午2:30:30
	 * @param date
	 * @param formatType
	 * @return
	 * @throws ParseException
	 */
	public static Date formatDate(Date date, String formatType) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
	    return formatter.parse(formatter.format(date));
	}
	
	/**
	 * 功能 : 将日期解析为指定格式的String类型值
	 * 开发：zwwang 2015-5-13 下午2:30:32
	 * @param date
	 * @param formatType
	 * @return
	 */
	public static String parseDate(Date date, String formatType) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
	    return formatter.format(date);
	}
	/**
	 * 功能 : 解析String类型的日期为指定格式的String类型
	 * 开发：zwwang 2015-5-13 下午5:06:07
	 * @param date
	 * @param formatType
	 * @return
	 * @throws ParseException
	 */
	public static String formatString(String date, String formatType) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		return formatter.format(parseDate(date));
	}
	/**
	 * 功能 : 将“yyyy年-M月”类型字符串转换为Date类型，其返回的日期为当月1号 开发：zwwang 2015-4-12 上午11:18:20
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseString(String dateStr) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年M月");
		return format.parse(dateStr);
	}
	/**
	 * 转换字符串为日期，格式"yyyy-MM-dd"
	 * 
	 * @param date
	 *            日期字符串
	 * @return 返回格式化的日期
	 */
	public static Date strToDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setLenient(false);
		return formatter.parse(date);
	}
	/**
	 * 转换字符串为日期，格式"yyyy/M/d"
	 * 
	 * @param date
	 *            日期字符串
	 * @return 返回格式化的日期
	 */
	public static Date yyyyMDstrToDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/M/d");
		formatter.setLenient(false);
		return formatter.parse(date);
	}
	/**
	 * 转换字符串为日期，格式"yyyy-MM-dd HH"
	 * 
	 * @param date
	 *            日期字符串
	 * @return 返回格式化的日期
	 */
	public static Date strToTimeH(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");
		formatter.setLenient(false);
		return formatter.parse(date);
	}
	/**
	 * 转换字符串为日期，格式"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param date
	 *            日期字符串
	 * @return 返回格式化的日期
	 */
	public static Date strToTime(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formatter.setLenient(false);
		return formatter.parse(date);
	}
	/**
	 * 转换日期为字符串，格式"yyyy-MM"
	 * 
	 * @param date
	 *            日期
	 * @return 返回格式化的日期(月份)字符串
	 */
	public static String dateToMonthStr(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		return formatter.format(date);
	}
	/**
	 * 转换日期为字符串，格式"yyyy-MM-dd"
	 * 
	 * @param date
	 *            日期
	 * @return 返回格式化的日期字符串
	 */
	public static String dateToStr(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	/**
	 * 转换日期为字符串，格式"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param date
	 *            日期
	 * @return 返回格式化的日期字符串
	 */
	public static String timeToStr(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}
	/**
	 * 取得现在的日期，格式"yyyy-MM-dd"
	 * 
	 * @return 返回日期
	 */
	public static Date getNowDate() {
		return new java.sql.Date(new java.util.Date().getTime());
	}
	/**
	 * 取得现在的日期，格式"yyyy-MM-dd"
	 * 
	 * @return 返回格式化的日期字符串
	 */
	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date Now = new Date();
		return formatter.format(Now);
	}
	/**
	 * 取得现在的日期，格式"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @return 返回格式化的日期字符串
	 */
	public static String getNow() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date Now = new Date();
		return formatter.format(Now);
	}
	/**
	 * 功能 : 将日期格式化为"yyyy年M月"格式 开发：zwwang 2015-4-22 上午11:35:22
	 * 
	 * @param time
	 * @return
	 */
	public static String formatDate(Date time) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年M月");
		return formatter.format(time);
	}
	/**
	 * 取得现在的时间，格式"HH:mm:ss"
	 * 
	 * @return 返回格式化的时间字符串
	 */
	public static String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date Now = new Date();
		return formatter.format(Now);
	}
	/**
	 * 取得年份，格式"yyyy"
	 * 
	 * @return 返回当前年份
	 */
	public static int getYear() {
		Date Now = new Date();
		return getYear(Now);
	}
	/**
	 * 取得月份
	 * 
	 * @return 返回当前月份
	 */
	public static int getMonth() {
		Date Now = new Date();
		return getMonth(Now);
	}
	/**
	 * 取得日期的年份，格式"yyyy"
	 * 
	 * @param date
	 *            日期
	 * @return 日期的年份
	 */
	public static int getYear(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return Integer.parseInt(formatter.format(date));
	}
	/**
	 * 取得日期的月份
	 * 
	 * @param date
	 *            日期
	 * @return 日期的月份
	 */
	public static int getMonth(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("M");
		return Integer.parseInt(formatter.format(date));
	}
	/**
	 * 取得某月的第一天
	 * 
	 * @param date
	 *            日期
	 * @return 日期的月份的第一天
	 */
	public static String getMonthFirstDay(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-01");
		return formatter.format(date);
	}
	/**
	 * 取得某年的第一天
	 * 
	 * @param date
	 *            日期
	 * @return 日期的月份的第一天
	 */
	public static String getYearFirstDay(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-01-01");
		return formatter.format(date);
	}
	/**
	 * 取得某年的最后一天
	 * 
	 * @param date
	 *            日期
	 * @return 日期的年份的最后一天
	 */
	public static String getYearMaxDay(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-12-31");
		return formatter.format(date);
	}
	/**
	 * 取得今天的日期数
	 * 
	 * @return 返回今天的日期数
	 */
	public static int getDay() {
		Date Now = new Date();
		return getDay(Now);
	}
	/**
	 * 取得日期的天数
	 * 
	 * @param date
	 *            日期
	 * @return 日期的天数
	 */
	public static int getDay(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("d");
		return Integer.parseInt(formatter.format(date));
	}
	/**
	 * 获得与某日期相隔几天的日期
	 * 
	 * @param date
	 *            指定的日期
	 * @param addCount
	 *            相隔的天数
	 * @return 返回的日期
	 */
	public static Date addDay(Date date, int addCount) throws ParseException {
		// Calendar cal = new GregorianCalendar();
		// 最好用Calendar.getInstance();
		// 因为有的地方，不是使用GregorianCalendar的。
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(strToDate(dateToStr(date)));
		calendar.add(Calendar.DATE, addCount);
		return calendar.getTime();
	}
	/**
	 * 获得与某日期相隔几月的日期
	 * 
	 * @param date
	 *            指定的日期
	 * @param addCount
	 *            相隔的月数
	 * @return 返回的日期
	 */
	public static Date addMonth(Date date, int addCount) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(strToDate(dateToStr(date)));
		calendar.add(Calendar.MONTH, addCount);
		return calendar.getTime();
	}
	/**
	 * 获得本周的第一天的日期
	 * 
	 * @return
	 */
	public static Date getCurWeekBegin() {
		Calendar cal = Calendar.getInstance();
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		cal.add(Calendar.DATE, -day_of_week + 1);
		return cal.getTime();
	}
	/**
	 * 获得本周的周末的日期
	 * 
	 * @return
	 */
	public static Date getCurWeekEnd() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getCurWeekBegin());
		cal.add(Calendar.DATE, 6);
		return cal.getTime();
	}
	/**
	 * 获得上周的第一天的日期
	 * 
	 * @return
	 */
	public static Date getPriorWeekBegin() {
		Calendar cal = Calendar.getInstance();
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		cal.add(Calendar.DATE, -day_of_week - 7 + 1);
		return cal.getTime();
	}
	/**
	 * 获得上周的周末的日期
	 * 
	 * @return
	 */
	public static Date getPriorWeekEnd() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getPriorWeekBegin());
		cal.add(Calendar.DATE, 6);
		return cal.getTime();
	}
	/**
	 * 获得本周的第一天的日期
	 * 
	 * @return
	 */
	public static Date getWeekBeginByDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		cal.add(Calendar.DATE, -day_of_week + 1);
		return cal.getTime();
	}
	/**
	 * 获得本周的周末的日期
	 * 
	 * @return
	 */
	public static Date getWeekEndByDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getWeekBeginByDate(date));
		cal.add(Calendar.DATE, 6);
		return cal.getTime();
	}
	/**
	 * 获得该日期的上周的第一天的日期
	 * 
	 * @return
	 */
	public static Date getPriorWeekBeginByDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		cal.add(Calendar.DATE, -day_of_week - 7 + 1);
		return cal.getTime();
	}
	/**
	 * 获得该日期的上周的最后一天的日期
	 * 
	 * @return
	 */
	public static Date getPriorWeekEndByDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getPriorWeekBeginByDate(date));
		cal.add(Calendar.DATE, 6);
		return cal.getTime();
	}
	/**
	 * 获得服务器所在日期的上月日期 例如当期日期为：Tue Apr 21 14:38:46 CST 2015 则返回日期为 ：Sat Mar 21
	 * 14:38:46 CST 2015
	 * 
	 * @return
	 */
	public static Date getPriorMonth() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}
	/**
	 * 获取指定日期的上月日期 例如指定日期为：Tue Apr 21 14:38:46 CST 2015 则返回日期为 ：Sat Mar 21
	 * 14:38:46 CST 2015
	 * 
	 * @return
	 */
	public static Date getPriorMonthByDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}
	/**
	 * 获取指定日期所在月份的第一天的最小日期 例如时间为："2014-02-06" 则返回值为 Fri Feb 01 00:00:00 CST 2014
	 * 
	 * @return
	 */
	public static Date getMonthMinTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		// 将小时至0
		cal.set(Calendar.HOUR_OF_DAY, 0);
		// 将分钟至0
		cal.set(Calendar.MINUTE, 0);
		// 将秒至0
		cal.set(Calendar.SECOND, 0);
		// 将毫秒至0
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	/**
	 * 获取指定日期所在月份的最后一天的最大日期 例如时间为："2014-02-06" 则返回值为 Fri Feb 28 23:59:59 CST
	 * 2014
	 * 
	 * @return
	 */
	public static Date getMonthMaxTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, maxDay);
		// 将小时至0
		cal.set(Calendar.HOUR_OF_DAY, 23);
		// 将分钟至0
		cal.set(Calendar.MINUTE, 59);
		// 将秒至0
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	/**
	 * 获取日期在当天的最小时间，例如时间为：2015-04-12(或者 2015-04-12 08:24:12) 则其当天最小时间为
	 * 2015-04-12 00:00:00
	 * 
	 * @return
	 */
	public static Date getDateMinTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 将小时至0
		cal.set(Calendar.HOUR_OF_DAY, 0);
		// 将分钟至0
		cal.set(Calendar.MINUTE, 0);
		// 将秒至0
		cal.set(Calendar.SECOND, 0);
		// 将毫秒至0
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	/**
	 * 获取日期在当天的最大时间，例如时间为：2015-04-12(或者 2015-04-12 08:24:12) 则其当天最大时间为
	 * 2015-04-12 23:59:59
	 * 
	 * @return
	 */
	public static Date getDateMaxTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 将小时至23
		cal.set(Calendar.HOUR_OF_DAY, 23);
		// 将分钟至59
		cal.set(Calendar.MINUTE, 59);
		// 将秒至59
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	/**
	 * 功能 : 日期之间相差的天数 开发：zwwang 2015-5-13 下午5:10:46
	 * 
	 * @param dateEnd
	 * @param dateStart
	 * @return
	 */
	public static Integer dayCount(Date dateEnd, Date dateStart) {
		long time = dateEnd.getTime() - dateStart.getTime();
		long num = time / (24 * 60 * 60 * 1000);
		return Integer.parseInt(String.valueOf(num));
	}
	/**
	 * 获取日期之间的月份差
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	public static int getMonthBetweenDate(Date beginDate, Date endDate)
			throws ParseException {
		Calendar calbegin = Calendar.getInstance();
		Calendar calend = Calendar.getInstance();
		calbegin.setTime(beginDate);
		calend.setTime(endDate);
		int m_begin = calbegin.get(Calendar.MONTH) + 1;
		int m_end = calend.get(Calendar.MONTH) + 1;
		int checkmonth = m_end - m_begin
				+ (calend.get(Calendar.YEAR) - calbegin.get(Calendar.YEAR))
				* 12;
		return checkmonth;
	}
}
