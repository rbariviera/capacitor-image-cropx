var ImageCropx = (function (exports, core) {
    'use strict';

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

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
