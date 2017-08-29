import express from 'express';
import webpack from 'webpack';
import webpackDevMiddleware from 'webpack-dev-middleware';
import webpackHotMiddleware from 'webpack-hot-middleware';
import webpackDevConfig from './webpack.config.babel';
import proxy from 'http-proxy-middleware';

const config = webpackDevConfig('dev');
const compiler = webpack(config);
const app = express();

app.use(express.static(config.output.path));
app.use(webpackDevMiddleware(compiler,{
    hot: true,
    publicPath: config.output.publicPath,
    noInfo: true,
    stats: {
        colors: true
    }
}));
app.use(webpackHotMiddleware(compiler));

app.use('/relax/rpc', proxy({
    target: 'http://172.17.160.228:9090/',
    ws: true,
}));

app.listen(3000, function (err) {
    if (err) {
        console.log(err)
    }else {
        console.log('Example app listening on port 3000!');
    }
});

