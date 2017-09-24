const APIV1 = '/api/v1'
const APIV2 = '/api/v2'

module.exports = {
  name: '项目名称',
  prefix: 'antdAdmin',
  footerText: '版权  © 2017 xxx',
  logo: '/logo.png',
  iconFontCSS: '/iconfont.css',
  iconFontJS: '/iconfont.js',
  CORS: [],
  openPages: ['/login'],
  apiPrefix: '/api/v1',
  APIV1,
  APIV2,
  api: {
    userLogin: `/rest/api/v1/User/login`,
    userLogout: `${APIV1}/user/logout`,
    userInfo: `${APIV1}/userInfo`,
    users: `${APIV1}/UserEntity`,
    posts: `${APIV1}/posts`,
    user: `/rest/api/v1/UserEntity/:id`,
    loginUser:`/rest/api/v1/User/info`,
    dashboard: `${APIV1}/dashboard`,
    menus: `${APIV1}/Menu`,
    weather: `${APIV1}/weather`,
    v1test: `${APIV1}/test`,
    v2test: `${APIV2}/test`,
  },
}
