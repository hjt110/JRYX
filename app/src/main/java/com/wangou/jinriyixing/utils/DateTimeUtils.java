package com.wangou.jinriyixing.utils;

import android.os.Build;
import android.text.TextUtils;
import android.text.format.Time;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.DST_OFFSET;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.ZONE_OFFSET;
import static java.util.Calendar.getInstance;

/**
 * 类名: DateTime
 * 描述: 日期处理工具
 *
 * @author ~若相惜
 * @version V1.0
 * @date 2014-7-6 上午12:13:31
 * @since JDK 1.6
 */
public class DateTimeUtils {
    public static final String DEFYYMMDD = "yy-M-d";
    public static final String DEFYMD = "yyyy-M-d";
    public static final String DEFYMDHMS = "yyyy-MM-dd HH:mm:ss";//yyyy-MM-dd kk:mm:ss
    public static final String DEFYMDHMS_NEW = "yyyy/M/d HH:mm:ss";//yyyy-MM-dd kk:mm:ss
    public static final String YMDHMS = "yyyy/M/d HH:mm:ss";
    public static final String DEFHMS = "HH:mm:ss";
    public static final String MMDD = "M/d";
    public static final String DEFYYYYM = "yyyy/M";
    public static final String DEFYYYYMD = "yyyy/M/d";
    public static final String CN_MMDD = "M月d日";
    public static final String CN_MDE = "M月d日 EEEE"; // 如：3月18日 星期六
    public static final String CN_MDE_YEAR = "yyyy/M/d EEEE"; // 如：3月18日 星期六

    public static Date getDateByFormat(String strDate, String format) {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = mSimpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 描述：Date类型转化为String类型.
     *
     * @param date   the date
     * @param format the format
     * @return String String类型日期时间
     */
    public static String getStringByFormat(Date date, String format) {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
        String strDate = null;
        try {
            strDate = mSimpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }

    /**
     * 描述：获取指定日期时间的字符串,用于导出想要的格式.
     *
     * @param strDate String形式的日期时间，必须为yyyy-MM-dd HH:mm:ss格式
     * @param format  输出格式化字符串，如："yyyy-MM-dd HH:mm:ss"
     * @return String 转换后的String类型的日期时间
     */
    public static String getStringByFormat(String strDate, String format) {
        return getStringByFormat(strDate, DEFYMD, format);
    }

    public static String getStringByFormat(String strDate, String oldformat, String newformat) {
        String mDateTime = null;
        try {
            Calendar c = new GregorianCalendar();
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(oldformat);
            c.setTime(mSimpleDateFormat.parse(strDate));
            SimpleDateFormat mSimpleDateFormat2 = new SimpleDateFormat(newformat);
            mDateTime = mSimpleDateFormat2.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDateTime;
    }

    /**
     * 获得指定格式的日期
     *
     * @param pattern 格式模板，为null，则为默认的格式
     * @param date    毫秒数
     * @return 符合格式的日期字符串
     */
    public static String getDate(String pattern, long date) {
        pattern = pattern == null ? "yyyy/MM/dd/HH/mm/ss" : pattern;
        return new SimpleDateFormat(pattern).format(new Date(date));
    }

    /**
     * 将一个double型的数四舍五入,以百分比的形式返回
     *
     * @param num       要格式化的 double的数
     * @param strFormat 格式模板 如果strFormat为null，默认为“#0.00%”，否则为传入的样式模板
     * @return 反回百分比的字符串
     */
    public static String getDouble4Format(double num, String strFormat) {
        strFormat = strFormat == null ? "#0.00%" : strFormat;
        DecimalFormat dFormat = new DecimalFormat(strFormat);
        String num2str = dFormat.format(num);
        return num2str;
    }


    /**
     * <p><B>方法:</B><br/> getTime </p><br/>
     * <p><B>描述:</B><br/> 获取运行时间</p>
     *
     * @param startTime
     * @return String    返回类型
     */
    public static String getTime(long startTime) {
        long a = System.currentTimeMillis() - startTime;
        Date date = new Date(a);
        return "00:" + new SimpleDateFormat("mm:ss").format(date);
    }

    public static String turnTime(long timemills) {
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
        Date date;
        try {
            date = sf.parse("00:00:00");
        } catch (ParseException e) {
            throw new RuntimeException("parse date err!");
        }
        date.setTime(date.getTime() + timemills);
        return sf.format(date);
    }

    public static String turnVideoTime(long timemills) {
        SimpleDateFormat sf = new SimpleDateFormat("mm:ss");
        Date date;
        try {
            date = sf.parse("00:00");
        } catch (ParseException e) {
            throw new RuntimeException("parse date err!");
        }
        date.setTime(date.getTime() + timemills);
        return sf.format(date);
    }

    /**
     * <p><B>方法:</B><br/> fileNameFromDate </p><br/>
     * <p><B>描述:</B><br/> 给文件命名</p>
     *
     * @return String    返回类型
     */
    public static String fileNameFromDate() {
        return getDate("yyyy-MM-dd-HH-mm-ss-SSS", System.currentTimeMillis());
    }


    /**
     * <p><B>方法:</B><br/> fileNameFromDate </p><br/>
     * <p><B>描述:</B><br/> 给文件命名</p>
     *
     * @return String    返回类型
     */
    public static String leaveTimeFromDate() {
        return getDate("yyyy-MM-dd HH:mm", System.currentTimeMillis());
    }

    public static long getStartTime() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(HOUR_OF_DAY, 0);
        currentDate.set(MINUTE, 0);
        currentDate.set(SECOND, 0);
        return currentDate.getTime().getTime();
    }

    public static long getEndTime() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(HOUR_OF_DAY, 23);
        currentDate.set(MINUTE, 59);
        currentDate.set(SECOND, 59);
        return currentDate.getTime().getTime();
    }

    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay, int num) {
        Calendar c = getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat(DEFYMD).parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        c.setTime(date);
        int day = c.get(DATE);
        c.set(DATE, day - num);

        String dayBefore = new SimpleDateFormat(DEFYMD).format(c.getTime());
        return dayBefore;
    }


    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat(DEFYMD).parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        c.setTime(date);
        int day = c.get(DATE);
        c.set(DATE, day + 1);

        String dayAfter = new SimpleDateFormat(DEFYMD).format(c.getTime());
        return dayAfter;
    }

    /**
     * <p>描述:当前日期一周中第几天</p>
     *
     * @param pTime 例如："2015-08-12"
     * @return 第几天
     */
    public static int dayForWeek(String pTime) {
        int dayForWeek = 1;
        try {
            SimpleDateFormat format = new SimpleDateFormat(DEFYMD);
            Calendar c = getInstance();
            c.setTime(format.parse(pTime));
            dayForWeek = 0;
            if (c.get(DAY_OF_WEEK) == Calendar.SUNDAY) {
                dayForWeek = 7;
            } else {
                dayForWeek = c.get(DAY_OF_WEEK) - 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dayForWeek;
    }

    /**
     * <p>描述:当前日期一月中第几天</p>
     *
     * @param pTime 例如："2015-08-12"
     * @return 第几天
     */
    public static int dayForMonth(String pTime) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(DEFYMD);
            Calendar c = getInstance();
            c.setTime(format.parse(pTime));
            int days = c.get(DAY_OF_MONTH);
            return days;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 获取指定日期所在月份的第几天
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */
    public static int getDayOfMonth(String date, String pattern) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            Calendar c = getInstance();
            c.setTime(format.parse(date));
            return c.get(DAY_OF_MONTH);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取指定时间的月份总共有几天
     *
     * @param date
     * @return
     */
    public static int getTotalDaysOfMonth(String date, String pattern) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            Calendar c = getInstance();
            c.setTime(format.parse(date));
            return c.getActualMaximum(Calendar.DATE);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 取得当前日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar calendar = getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.set(DAY_OF_WEEK, calendar.getFirstDayOfWeek()); // Sunday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); // Saturday
        return calendar.getTime();
    }

    public static int weeks = 0;

    // 获得当前日期与本周一相差的天数
    public static int getMondayPlus() {
        Calendar cd = getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }

    //获取当前日期是星期几 注：星期日是第一天
    public static int getCurrentWeek() {
        Calendar cd = getInstance();
        return cd.get(DAY_OF_WEEK);
    }

    public static String getPreviousMonday() {
        weeks--;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        Date monday = currentDate.getTime();
        String preMonday = getStringByFormat(monday, DEFYMD);
        return preMonday;
    }

    /**
     * <p>描述:获得上周星期一的日期</p>
     *
     * @return 设定文件
     */
    public static String getNextMonday() {
        weeks++;
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
        Date monday = currentDate.getTime();
        String preMonday = getStringByFormat(monday, DEFYMD);
        return preMonday;
    }

    /**
     * <p>描述:获得相应周的周日的日期</p>
     *
     * @return String
     */
    public static String getSunday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks + 6);
        Date monday = currentDate.getTime();
        String preMonday = getStringByFormat(monday, DEFYMD);
        return preMonday;
    }

    /**
     * <p>描述:求当前日期的上num个月的第一天</p>
     *
     * @param date 当前日期
     * @param num  0：表示当前月  num必须大于0  例：num:2 表示上两个月
     * @return 日期
     */
    public static Date getFirstDayOfMonth(Date date, int num) {
        Calendar calendar = getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(YEAR), calendar.get(MONTH) - num, 1);
        return calendar.getTime();
    }

    /**
     * <p>描述:求当前日期的下num个月的最后一天</p>
     *
     * @param date 当前日期
     * @param num  0：表示当前月  num必须大于0  例：num:2 表示上两个月
     * @return 日期
     */
    public static Date getLastDayOfMonth(Date date, int num) {
        Calendar calendar = getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(YEAR), calendar.get(MONTH) + num, 1);
        calendar.roll(DATE, -1);
        return calendar.getTime();
    }

    /**
     * 获取当前日期前num个月的最后一天
     *
     * @param date 当前日期
     * @param num  前num个月
     * @return
     */
    public static Date getLastDayOfPreviousMonth(Date date, int num) {
        Calendar calendar = getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(YEAR), calendar.get(MONTH) - num, 1);
        calendar.roll(DATE, -1);
        return calendar.getTime();
    }

    /**
     * <p>描述:获取一周内所有的日期</p>
     *
     * @param startdate 一周的起始日期
     * @param parent    "MM-dd"
     * @return List<String>
     */
    public static List<String> dateToWeek(String startdate, String parent) {
        List<String> list = new ArrayList<>();
        try {
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(DEFYMD);
            Date mdate = mSimpleDateFormat.parse(startdate);
            int b = mdate.getDay() - 1;
            Long fTime = mdate.getTime() - b * 24 * 3600000;
            for (int a = 0; a < 7; a++) {
                list.add(DateTimeUtils.getDate(parent, fTime + (a * 24 * 3600000)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 将UTC时间转换为本地时间
     *
     * @param utcTime
     * @param utcTimePatten
     * @param localTimePatten
     * @return 本地时间
     */
    public static String utc2Local(String utcTime, String utcTimePatten, String localTimePatten) {
        SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten);
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUTCDate = null;
        try {
            gpsUTCDate = utcFormater.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat localFormater = new SimpleDateFormat(localTimePatten);
        localFormater.setTimeZone(TimeZone.getDefault());
        assert gpsUTCDate != null;
        String localTime = localFormater.format(gpsUTCDate.getTime());
        return localTime;
    }


    /**
     * 将本地时间转换为UTC
     *
     * @param localTime
     * @param localTimePatten
     * @param utcTimePatten
     * @return UTC时间
     */
    public static String local2utc(String localTime, String localTimePatten, String utcTimePatten) {
        // 1、取得本地时间：
        Calendar cal = getInstance();
        cal.setTime(DateTimeUtils.getDateByFormat(localTime, localTimePatten));
        // 2、取得时间偏移量：
        int zoneOffset = cal.get(ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = cal.get(DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(YEAR);
        //int month = cal.get(Calendar.MONTH) + 1;
        int month = cal.get(MONTH);
        int day = cal.get(DAY_OF_MONTH);
        int hour = cal.get(HOUR_OF_DAY);
        int minute = cal.get(MINUTE);
        cal.set(year, month, day, hour, minute);
        return DateTimeUtils.getStringByFormat(cal.getTime(), utcTimePatten);
    }

    // 获得当天0点时间
    public static long getTimesmorning(Date date) {
        Calendar cal = getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.set(HOUR_OF_DAY, 0);
        cal.set(SECOND, 0);
        cal.set(MINUTE, 0);
        cal.set(MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    // 获得当天24点时间
    public static long getTimesnight(Date date) {
        Calendar cal = getInstance();
        cal.setTime(date);
        cal.set(HOUR_OF_DAY, 24);
        cal.set(SECOND, 0);
        cal.set(MINUTE, 0);
        cal.set(MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 转换本地指定的时间到utc时间
     *
     * @param mStartTime 本地起始时间
     * @param mEndTime   本地结束时间
     * @return utc时间数组
     */
    public static String[] local2utcArray(String mStartTime, String mEndTime) {
        final Date startDate = getDateByFormat(mStartTime, DEFYMD);
        final Date endDate = getDateByFormat(mEndTime, DEFYMD);
        final String start = getStringByFormat(new Date(getTimesmorning(startDate)), DEFYMDHMS);
        final String end = getStringByFormat(new Date(getTimesnight(endDate)), DEFYMDHMS);
        final String utcStartTime = local2utc(start, DEFYMDHMS, DEFYMDHMS);
        final String utcEndTime = local2utc(end, DEFYMDHMS, DEFYMDHMS);
        return new String[]{utcStartTime, utcEndTime};
    }

    /**
     * 获取utc时间与本地时区相差时间小时
     *
     * @return
     */
    public static int getTimeZoneRawOffset() {
        int time = TimeZone.getTimeZone(TimeZone.getDefault().getID()).getRawOffset();
        return time / (3600 * 1000);
    }

    /**
     * 得到本周周一
     *
     * @return yyyy-MM-dd
     */
    public static String getMondayOfThisWeek() {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(
                DateTimeUtils.DEFYMD);
        Calendar c = getInstance();
        int day_of_week = c.get(DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(DATE, -day_of_week + 1);
        return mSimpleDateFormat.format(c.getTime());
    }

    /**
     * 得到本周周日
     *
     * @return yyyy-MM-dd
     */
    public static String getSundayOfThisWeek() {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(
                DateTimeUtils.DEFYMD);
        Calendar c = getInstance();
        int day_of_week = c.get(DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(DATE, -day_of_week + 7);
        return mSimpleDateFormat.format(c.getTime());
    }

    public static String getNumTime(String datetime, int num, String format) {
        Date date = DateTimeUtils.getDateByFormat(datetime, format);
        long time = date.getTime() + num * 24 * 3600 * 1000;
        String day = DateTimeUtils.getStringByFormat(new Date(time), format);//23
        return day;
    }

    public static int getYear() {
        Time t = new Time(); // or Time t=new Time("GMT+8"); 加上Time Zone资料
        t.setToNow(); // 取得系统时间。
        int year = t.year;
        return year;
    }

    /*
     *获取日月
     */
    public static String getMonthDay() {
        Calendar c = getInstance();
        //int year = c.get(YEAR);
        int month = c.get(MONTH);
        int day = c.get(DAY_OF_MONTH);
        int month2 = month + 1;
        if (month2 < 10) {
            return "0" + month2 + "/" + day;
        } else {
            return month2 + "/" + day;
        }
    }

    /**
     * 描述：标准化日期时间类型的数据，不足两位的补0.
     *
     * @param dateTime 预格式的时间字符串，如:2012-3-2 12:2:20
     * @return String 格式化好的时间字符串，如:2012-03-20 12:02:20
     */
    public static String dateTimeFormat(String dateTime) {
        StringBuilder sb = new StringBuilder();
        try {
            if (TextUtils.isEmpty(dateTime)) {
                return null;
            }
            String[] dateAndTime = dateTime.split(" ");
            if (dateAndTime.length > 0) {
                for (String str : dateAndTime) {
                    if (str.contains("-")) {
                        String[] date = str.split("-");
                        for (int i = 0; i < date.length; i++) {
                            String str1 = date[i];
                            sb.append(strFormat2(str1));
                            if (i < date.length - 1) {
                                sb.append("-");
                            }
                        }
                    } else if (str.contains(":")) {
                        sb.append(" ");
                        String[] date = str.split(":");
                        for (int i = 0; i < date.length; i++) {
                            String str1 = date[i];
                            sb.append(strFormat2(str1));
                            if (i < date.length - 1) {
                                sb.append(":");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }

    /**
     * 描述：不足2个字符的在前面补“0”.
     *
     * @param str 指定的字符串
     * @return 至少2个字符的字符串
     */
    public static String strFormat2(String str) {
        try {
            if (str.length() <= 1) {
                str = "0" + str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 描述：判断是否是闰年()
     * <p>(year能被4整除 并且 不能被100整除) 或者 year能被400整除,则该年为闰年.
     *
     * @param year 年代（如2012）
     * @return boolean 是否为闰年
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    /**
     * 时间列表转换成时间戳
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return
     * @throws ParseException
     */
    public static long dataToTimestamp(int year, int month, int day, int hour, int minute, int second) throws
            ParseException {
        String time = dataToString(year, month, day, hour, minute, second);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(time);
        return date.getTime();
    }

    /**
     * 时间列表转换成字符串
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static String dataToString(int year, int month, int day, int hour, int minute, int second) {
        StringBuilder sb = new StringBuilder();
        if (year >= 2000) {
            sb.append(year).append("-");
        } else {
            sb.append("2016").append("-");
        }
        if (month >= 10) {
            sb.append(month).append("-");
        } else {
            sb.append("0").append(month).append("-");
        }
        if (day >= 10) {
            sb.append(day).append(" ");
        } else {
            sb.append("0").append(day).append(" ");
        }
        if (hour >= 10) {
            sb.append(hour).append(":");
        } else {
            sb.append("0").append(hour).append(":");
        }
        if (minute >= 10) {
            sb.append(minute).append(":");
        } else {
            sb.append("0").append(minute).append(":");
        }
        if (second >= 10) {
            sb.append(second);
        } else {
            sb.append("0").append(second);
        }
        return sb.toString();
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @param str
     * @param
     * @return
     */
    public static int differentDaysByMillisecond(String str) {
        Date date1 = getDateByFormat(str, DEFYMDHMS);
        Date date2 = new Date(System.currentTimeMillis());
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    /**
     * 判断2个时间差
     *
     * @param
     * @param
     * @return
     */
    public static String differentDaysByMillisecond(long time) {
        long dif = System.currentTimeMillis() - time;
        //oppo手机获取的时间多了24小时 品牌OPPO 型号OPPO A57
        if ("oppo".equalsIgnoreCase(Build.BRAND) && "OPPO A57".equalsIgnoreCase(Build.MODEL)) {
            dif = dif - 24 * 60 * 60 * 1000;
        }
        if (dif < 5 * 60 * 1000) {
            return "刚刚";
        } else if (dif < 60 * 60 * 1000) {
            return (int) dif / 1000 / 60 + "分钟前";
        } else if (dif < 24 * 60 * 60 * 1000) {
            return (int) dif / 1000 / 60 / 60 + "小时前";
        } else {
            return dif / 1000 / 60 / 60 / 24 + "天前";
        }
    }

    /**
     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
     */
    /** 日期字符串转时间戳 */
    public static Long string2Millis(String dateStr, String formatStr) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
            return simpleDateFormat.parse(dateStr).getTime();
        } catch (Exception e) {
            return 0L;
        }
    }
}
