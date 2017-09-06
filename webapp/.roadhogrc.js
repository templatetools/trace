const path = require('path')
const { version } = require('./package.json')

const svgSpriteDirs = [
  path.resolve(__dirname, 'src/svg/'),
  require.resolve('antd').replace(/index\.js$/, '')
]

export default {
  entry : 'src/index.js',
  svgSpriteLoaderDirs : svgSpriteDirs,
  theme : "./theme.config.js",
  publicPath : `/${version}/`,
  outputPath : `./dist/${version}`,
  // 接口代理示例
  "proxy": {
    "/api/v1/weather": {
      "target": "https://api.seniverse.com/",
      "changeOrigin": true,
      "pathRewrite": { "^/api/v1/weather" : "/v3/weather" }
    },
    "/api/v1/UserEntity": {
      "target": "http://localhost:7890",
      "changeOrigin": true,
      "pathRewrite": { "^/api/v1/UserEntity" : "/trace/api/rest/v1/UserEntity" }
    },
    "/api/v1/Menu": {
      "target": "http://localhost:7890",
      "changeOrigin": true,
      "pathRewrite": { "^/api/v1/Menu" : "/trace/api/rest/v1/Menu" }
    },
    "/rest/api/v1": {
      "target": "http://localhost:7890",
      "changeOrigin": true,
      "pathRewrite": { "^/rest/api/v1" : "/trace/api/rest/v1" }
    }
    // "/api/v1/user": {
    //   "target": "http://localhost:7890",
    //   "changeOrigin": true,
    //   "pathRewrite": { "^/api/v1/user" : "/trace/api/rest/v1/UserEntity" }
    // }
  },
  env : {
    development: {
      extraBabelPlugins: [
        "dva-hmr",
        "transform-runtime",
        [
          "import", {
            "libraryName": "antd",
            "style": true
          }
        ]
      ]
    },
    production: {
      extraBabelPlugins: [
        "transform-runtime",
        [
          "import", {
            "libraryName": "antd",
            "style": true
          }
        ]
      ]
    }
  },
  dllPlugin : {
    exclude: ["babel-runtime"],
    include: ["dva/router", "dva/saga", "dva/fetch"]
  }
}
