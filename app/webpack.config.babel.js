import webpack from 'webpack';
import HtmlWebpackPlugin from 'html-webpack-plugin'
import path from 'path';
import ExtractTextPlugin from 'extract-text-webpack-plugin'

const join = path.join.bind(path, __dirname);

export default function (isdev) {
    let filename = isdev=='dev' ? '[name].js':'[name]-[hash].js';
    let node_env = isdev=='dev' ? 'development':'production';
    let publicPath = isdev=='dev' ? '/dist/':'';
    let commonName = isdev=='dev' ? 'common.js':'common-[hash].js';
    let styleName = isdev=='dev' ? 'style.css':'style-[hash].css';

    return {
        entry: {
            app: [
                './index.js',
                'webpack-hot-middleware/client?name=[name]?reload=true'
            ],
            config: [
                './config.js'
            ]
        },
        output: {
            path: path.join(__dirname, 'dist'),
            filename: filename,
            chunkFilename:'js/[name].js',
            publicPath: publicPath
        },
        cache:true,
        module: {
            noParse: /node_modules\/(jquey|moment|chart\.js)/,
            loaders: [{
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                loader: ['babel-loader'],
            },{
                test: /\.(jpg|png|svg)$/,
                loader: "url-loader?limit=10000&name=images/[name].[ext]",
            },{
                test: /\.(sass|scss|css|less)$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: ['css-loader', 'sass-loader']
                }),
            },{
                test: /\/src\/routes\/([^\/]+\/?[^\/]+).js$/,
                loader: ['bundle-loader?lazy&name=[name]','babel-loader?presets=react']
            },]
        },
        resolve: {
            modules: [path.resolve(__dirname, 'node_modules')]
        },
        devtool: 'cheap-module-source-map',
        plugins: [
            new ExtractTextPlugin(styleName),
            new webpack.NoEmitOnErrorsPlugin(),
            new webpack.optimize.OccurrenceOrderPlugin(),
            new webpack.HotModuleReplacementPlugin(),
            new webpack.optimize.CommonsChunkPlugin({name: "common", filename:commonName}),
            new webpack.DefinePlugin({
                'process.env': {
                    NODE_ENV: JSON.stringify(node_env)
                }
            }),
            new HtmlWebpackPlugin({
                template: './index.html',
                filename: './index.html'
            }),
            new webpack.DllReferencePlugin({
                context: __dirname,
                manifest: require('./dist/manifest.json')
            }),
            function() {
                if (isdev=='dev') {
                    return
                }
                this.plugin("done", function (stats) {
                    let fs = require('fs');
                    var replaceInFile = function (filePath, toReplace, replacement) {
                        var replacer = function (match) {
                            console.log('Replacing in %s: %s => %s', filePath, match, replacement);
                            return replacement
                        };
                        var str = fs.readFileSync(filePath, 'utf8');
                        var out = str.replace(new RegExp(toReplace, 'g'), replacer);
                        fs.writeFileSync(filePath, out);
                    };
                    fs.readdirSync('./dist/').forEach(file => {
                        if (file.indexOf('vendor-') != -1) {
                            replaceInFile(path.join(__dirname, 'dist/index.html'),
                                'vendor.js',
                                file
                            );
                        }
                    })
                });
            }
        ]
    }
}