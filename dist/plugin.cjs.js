'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const ImageCropx = core.registerPlugin('ImageCropx', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.ImageCropxPluginWeb()),
});

class ImageCropxPluginWeb extends core.WebPlugin {
    async show(options) {
        return new Promise(() => {
            console.log('ImageCropxPlugin show options', options);
        });
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    ImageCropxPluginWeb: ImageCropxPluginWeb
});

exports.ImageCropx = ImageCropx;
//# sourceMappingURL=plugin.cjs.js.map
