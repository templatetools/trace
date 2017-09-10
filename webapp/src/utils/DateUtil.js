/**
 * 日期格式化工具
 * Created by Jin on 2017/2/23.
 */
import Moment from 'moment'

export default {

    /**
     * 时间格式化 时间戳转年月日 时分秒
     * @param date
     * @returns {*}
     */
    defaultFormat(date) {
        var time = new Date(date).format("yyyy-MM-dd hh:mm:ss");

        return time;
    },
    /**
     * 时间格式化 时间戳转年月日 时分秒
     * @param date
     * @returns {*}
     */
    defaultFormateTime(date) {
        let da;
        da = new Date(date);
        let year = da.getFullYear()+'年';
        let month = da.getMonth()+1+'月';
        return year + month;
    },

    defaultFormatDate(date) {
        let time = new Date(date).getTime();

        return time;
    },

    dateStringFormat(timeInterval) {
        let now = new Date();
        let year = now.getFullYear();
        let time = now.getTime();
        let interval = (time - timeInterval)/1000;
        if (interval < 60) {
            return "刚刚"
        }else if(interval < 60 * 60){
            return Math.round(interval/60) + "分钟前"
        }else if(interval < 60 * 60 * 24){
            return Math.round(interval/3600) + "小时前"
        }else if(interval < 60 * 60 * 24 * 2){
            return "昨天"
        }else{
            now.setTime(timeInterval);
            if (year === now.getFullYear()){
                return this.dateFormat(now, "MM-dd")
            }else{
                return this.dateFormat(now, "yyyy-MM-dd")
            }
        }
    },

    datetimeFormat(m){
        let time = new Date();
        time.setTime(m);
        return this.dateFormat(time, "yyyy-MM-dd hh:mm:ss");
    },
    /**
     * 日期格式化
     * @param date 日期对象
     * @param fmt 指定格式
     * @returns {*} 格式化后的字符串
     */
    dateFormat(date, fmt) {

        if (typeof date === "string" || typeof date !== "object") {
            return;
        }

        let year = date.getFullYear();
        let month = date.getMonth() + 1;
        let day = date.getDate();
        let hour = date.getHours();
        let minute = date.getMinutes();
        let second = date.getSeconds();
        let weekDay = date.getDay();
        let ms = date.getMilliseconds();
        let weekDayString = "";

        if (weekDay === 1) {
            weekDayString = "星期一";
        } else if (weekDay === 2) {
            weekDayString = "星期二";
        } else if (weekDay === 3) {
            weekDayString = "星期三";
        } else if (weekDay === 4) {
            weekDayString = "星期四";
        } else if (weekDay === 5) {
            weekDayString = "星期五";
        } else if (weekDay === 6) {
            weekDayString = "星期六";
        } else if (weekDay === 7) {
            weekDayString = "星期日";
        }

        let v = fmt;

        //Year
        v = v.replace(/yyyy/g, year);
        v = v.replace(/YYYY/g, year);
        v = v.replace(/yy/g, (year + "").substring(2, 4));
        v = v.replace(/YY/g, (year + "").substring(2, 4));

        //Month
        let monthStr = ("0" + month);
        v = v.replace(/MM/g, monthStr.substring(monthStr.length - 2));

        //Day
        let dayStr = ("0" + day);
        v = v.replace(/dd/g, dayStr.substring(dayStr.length - 2));

        //hour
        let hourStr = ("0" + hour);
        v = v.replace(/HH/g, hourStr.substring(hourStr.length - 2));
        v = v.replace(/hh/g, hourStr.substring(hourStr.length - 2));

        //minute
        let minuteStr = ("0" + minute);
        v = v.replace(/mm/g, minuteStr.substring(minuteStr.length - 2));

        //Millisecond
        v = v.replace(/sss/g, ms);
        v = v.replace(/SSS/g, ms);

        //second
        let secondStr = ("0" + second);
        v = v.replace(/ss/g, secondStr.substring(secondStr.length - 2));
        v = v.replace(/SS/g, secondStr.substring(secondStr.length - 2));

        //weekDay
        v = v.replace(/E/g, weekDayString);

        return v;

    },

    /**
     * 根据传入的毫秒值，计算本月初的毫秒值
     * @param month 毫秒值
     * @returns {number}
     */
    getStartOfThisMonth(month) {
        return Moment.unix(month / 1000).startOf('month').unix() * 1000
    },

    /**
     * 根据传入的毫秒值，计算本月底的毫秒值
     * @param month 毫秒值
     * @returns {number}
     */
    getEndOfThisMonth(month) {
        return Moment.unix(month / 1000).endOf('month').unix() * 1000
    },

    /**
     * 获取本月份第一天0:00:00的毫秒值
     * @returns {number}
     */
    getStartByMonth() {
        return Moment().startOf('month').unix() * 1000
    },

    /**
     * 获取本月份最后一天23:59:59的毫秒值
     * @returns {number}
     */
    getEndByMonth() {
        return Moment().endOf('month').unix() * 1000
    }

}
