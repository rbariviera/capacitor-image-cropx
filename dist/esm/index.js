import { registerPlugin } from '@capacitor/core';
const ImageCropx = registerPlugin('ImageCropx', {
    web: () => import('./web').then(m => new m.ImageCropxPluginWeb()),
});
export * from './definitions';
export { ImageCropx };
//# sourceMappingURL=index.js.map