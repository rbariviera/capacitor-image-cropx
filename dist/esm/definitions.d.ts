export interface ImageCropxPlugin {
    show(options: {
        source: string;
        width?: number;
        height?: number;
        ratio?: string;
        lock?: boolean;
    }): Promise<CropResult>;
}
export interface CropResult {
    value: string;
}
