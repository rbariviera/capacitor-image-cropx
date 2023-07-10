import { WebPlugin } from '@capacitor/core';
import type { CropResult, ImageCropxPlugin } from './definitions';
export declare class ImageCropxPluginWeb extends WebPlugin implements ImageCropxPlugin {
    show(options: {
        source: string;
        width?: number;
        height?: number;
        ratio?: string;
        lock?: boolean;
    }): Promise<CropResult>;
}
