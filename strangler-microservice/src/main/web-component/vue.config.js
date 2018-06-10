const path = require('path')
const fs = require('fs')

const packageInfo = JSON.parse(fs.readFileSync(path.resolve(__dirname, 'package.json')))

module.exports = {
  css: {
    extract: false
  },
  configureWebpack: config => {
    // Configure custom bundle filename and disable vendor chunk creation
    config.output.filename = 'js/' + packageInfo.name + '-' + packageInfo.version + '.js'
    delete config.output.chunkFilename
    delete config.optimization.splitChunks
  }
}