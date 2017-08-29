/**
 * Created by zhongfan on 2017/6/29.
 */
import cookie from 'react-cookie';

export default {

    login (username, password, success, failure) {
        setTimeout(() => {
            success()
        }, 1000)
    },

    logout(success, failure) {
        setTimeout(() => {
            success()
        }, 1000)
    }
}
