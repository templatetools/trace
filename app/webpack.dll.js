var path = require('path'),
    webpack = require('webpack'),
    // Bind join to the current path. You can change it:
    // path.join.bind(path, __dirname, 'app').
    join = path.join.bind(path, __dirname);

module.exports = function (isdev) {
    let vendorName = isdev=='dev' ? 'vendor.js':'vendor-[hash].js';
    let manifestName = isdev=='dev' ? './dist/manifest.json':'./dist/manifest-[hash].json';

    return {
        entry: {
            vendor: ['react', 'react-dom', 'react-router', 'react-weui', 'n-zepto', 'prop-types']
        },
        output: {
            path: path.join(__dirname, 'dist'),
            filename: vendorName,
            library: '[name]_[hash]',
        },
        plugins: [
            new webpack.DllPlugin({
                path: './dist/manifest.json',
                name: '[name]_[hash]',
                context: __dirname,
            }),
        ],
        resolve: {
            modules: ['node_modules']
        }
    }
}