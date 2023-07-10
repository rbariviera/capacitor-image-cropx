import { WebPlugin } from '@capacitor/core';
export class ImageCropxPluginWeb extends WebPlugin {
    async show(options) {
        return new Promise(() => {
            console.log('ImageCropxPlugin show options', options);
        });
    }
}
//# sourceMappingURL=web.js.map